package fr.afpa.pompey.cda22045.DAO;

import fr.afpa.pompey.cda22045.ExceptionPharma;
import fr.afpa.pompey.cda22045.modele.Achat;
import fr.afpa.pompey.cda22045.modele.Client;
import fr.afpa.pompey.cda22045.modele.Medecin;
import fr.afpa.pompey.cda22045.modele.Medicament;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AchatDAO extends DAO<Achat> {
    private ClientDAO clientDAO;
    private MedecinDAO medecinDAO;
    private MedicamentDAO medicamentDAO;

    public AchatDAO() throws SQLException, IOException, ClassNotFoundException {
        super(); // initialise connection
        clientDAO = new ClientDAO();
        medecinDAO = new MedecinDAO();
        medicamentDAO = new MedicamentDAO();
    }

    @Override
    public Achat create(Achat entity) throws SQLException {
        String sql = "INSERT INTO Achat(dateAchat, client_id, achatParOrdonnance, medecin_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setDate(1, Date.valueOf(entity.getDateAchat()));
            ps.setInt(2, entity.getClient().getId());
            ps.setBoolean(3, entity.isAchatParOrdonnance());
            if (entity.isAchatParOrdonnance() && entity.getMedecin() != null) {
                ps.setInt(4, entity.getMedecin().getId());
            } else {
                ps.setNull(4, Types.INTEGER);
            }

            ps.executeUpdate();

            int achatId;
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    achatId = rs.getInt(1);
                    insertMedicaments(achatId, entity.getMedicaments());
                } else {
                    throw new SQLException("Erreur lors de la récupération de l'ID de l'achat.");
                }
            }

            return entity;
        }
    }

    private void insertMedicaments(int achatId, ArrayList<Medicament> medicaments) throws SQLException {
        String sql = "INSERT INTO Achat_Medicament(achat_id, medicament_id) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            for (Medicament m : medicaments) {
                ps.setInt(1, achatId);
                ps.setInt(2, m.getId());
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    @Override
    public boolean update(Achat entity) throws SQLException {
        String sql = "UPDATE Achat SET dateAchat=?, client_id=?, achatParOrdonnance=?, medecin_id=? WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(entity.getDateAchat()));
            ps.setInt(2, entity.getClient().getId());
            ps.setBoolean(3, entity.isAchatParOrdonnance());
            if (entity.isAchatParOrdonnance() && entity.getMedecin() != null) {
                ps.setInt(4, entity.getMedecin().getId());
            } else {
                ps.setNull(4, Types.INTEGER);
            }
            ps.setInt(5, entity.getClient().getId()); // Ici il faudrait l'id de l'achat, à stocker dans Achat

            boolean updated = ps.executeUpdate() > 0;
            if (updated) {
                deleteMedicaments(entity.getClient().getId()); // pareil, utiliser id de l'achat
                insertMedicaments(entity.getClient().getId(), entity.getMedicaments());
            }
            return updated;
        }
    }

    private void deleteMedicaments(int achatId) throws SQLException {
        String sql = "DELETE FROM Achat_Medicament WHERE achat_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, achatId);
            ps.executeUpdate();
        }
    }

    @Override
    public boolean deleteById(Integer id) throws SQLException {
        deleteMedicaments(id);
        String sql = "DELETE FROM Achat WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Achat findById(Integer id) throws SQLException {
        String sql = "SELECT * FROM Achat WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToAchat(rs);
                }
            } catch (ExceptionPharma e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public List<Achat> findAll() throws SQLException {
        String sql = "SELECT * FROM Achat";
        List<Achat> achats = new ArrayList<>();
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                achats.add(mapResultSetToAchat(rs));
            }
        } catch (ExceptionPharma e) {
            throw new RuntimeException(e);
        }
        return achats;
    }

    @Override
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    private Achat mapResultSetToAchat(ResultSet rs) throws SQLException, ExceptionPharma {
        int clientId = rs.getInt("client_id");
        Client client = clientDAO.findById(clientId);

        Medecin medecin = null;
        int medId = rs.getInt("medecin_id");
        if (!rs.wasNull()) {
            medecin = medecinDAO.findById(medId);
        }

        ArrayList<Medicament> medicaments = getMedicamentsByAchat(rs.getInt("id"));

        return new Achat(
                rs.getInt("id"),
                rs.getDate("dateAchat").toLocalDate(),
                client,
                medicaments,
                rs.getBoolean("achatParOrdonnance"),
                medecin
        );
    }

    private ArrayList<Medicament> getMedicamentsByAchat(int achatId) throws SQLException {
        String sql = "SELECT m.* FROM Medicament m " +
                "JOIN Achat_Medicament am ON m.idMedicament = am.medicament_id " +
                "WHERE am.achat_id=?";
        ArrayList<Medicament> medicaments = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, achatId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    medicaments.add(medicamentDAO.mapResultSetToMedicament(rs));
                }
            } catch (ExceptionPharma e) {
                throw new RuntimeException(e);
            }
        }
        return medicaments;
    }
}
