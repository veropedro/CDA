package fr.afpa.pompey.cda22045.DAO;

import fr.afpa.pompey.cda22045.modele.Ordonnance;
import fr.afpa.pompey.cda22045.modele.Medecin;
import fr.afpa.pompey.cda22045.modele.Client;
import fr.afpa.pompey.cda22045.modele.Medicament;
import fr.afpa.pompey.cda22045.ExceptionPharma;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class OrdonnanceDAO extends DAO<Ordonnance> {

    private MedecinDAO medecinDAO;
    private ClientDAO clientDAO;
    private MedicamentDAO medicamentDAO;

    public OrdonnanceDAO() throws SQLException, IOException, ClassNotFoundException {
        medecinDAO = new MedecinDAO();
        clientDAO = new ClientDAO();
        medicamentDAO = new MedicamentDAO();
    }

    @Override
    public Ordonnance create(Ordonnance entity) throws SQLException {
        String sql = "INSERT INTO Ordonnance(dateOrdonnance, medecin_id, client_id) VALUES (?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, entity.getDateOrdonnance());
            ps.setInt(2, entity.getMedecin().getId());
            ps.setInt(3, entity.getClient().getId());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int ordonnanceId = rs.getInt(1);
                    // Insérer les médicaments dans la table de jointure
                    insertMedicaments(ordonnanceId, entity.getMedicamentsPrescrits());
                }
            }
            return entity;
        }
    }

    private void insertMedicaments(int ordonnanceId, ArrayList<Medicament> medicaments) throws SQLException {
        String sql = "INSERT INTO Ordonnance_Medicament(ordonnance_id, medicament_id) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            for (Medicament m : medicaments) {
                ps.setInt(1, ordonnanceId);
                ps.setInt(2, m.getId());
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    @Override
    public boolean update(Ordonnance entity) throws SQLException {
        String sql = "UPDATE Ordonnance SET dateOrdonnance=?, medecin_id=?, client_id=? WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, entity.getDateOrdonnance());
            ps.setInt(2, entity.getMedecin().getId());
            ps.setInt(3, entity.getClient().getId());
            ps.setInt(4, entity.getId());

            boolean updated = ps.executeUpdate() > 0;

            if (updated) {
                // Supprimer les anciens médicaments et réinsérer les nouveaux
                deleteMedicaments(entity.getId());
                insertMedicaments(entity.getId(), entity.getMedicamentsPrescrits());
            }
            return updated;
        }
    }

    private void deleteMedicaments(int ordonnanceId) throws SQLException {
        String sql = "DELETE FROM Ordonnance_Medicament WHERE ordonnance_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, ordonnanceId);
            ps.executeUpdate();
        }
    }

    @Override
    public boolean deleteById(Integer id) throws SQLException {
        deleteMedicaments(id); // supprimer d'abord les relations
        String sql = "DELETE FROM Ordonnance WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Ordonnance findById(Integer id) throws SQLException {
        String sql = "SELECT * FROM Ordonnance WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToOrdonnance(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Ordonnance> findAll() throws SQLException {
        String sql = "SELECT * FROM Ordonnance";
        List<Ordonnance> ordonnances = new ArrayList<>();
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                ordonnances.add(mapResultSetToOrdonnance(rs));
            }
        }
        return ordonnances;
    }

    @Override
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    private Ordonnance mapResultSetToOrdonnance(ResultSet rs) throws SQLException {
        try {
            int medecinId = rs.getInt("medecin_id");
            int clientId = rs.getInt("client_id");
            Medecin medecin = medecinDAO.findById(medecinId);
            Client client = clientDAO.findById(clientId);
            ArrayList<Medicament> medicaments = getMedicamentsByOrdonnance(rs.getInt("id"));

            return new Ordonnance (
                    rs.getInt("id"),
                    rs.getString("dateOrdonnance"),
                    medecin,
                    client,
                    medicaments
            );
        } catch (ExceptionPharma e) {
            throw new SQLException("Erreur lors de la création de l'ordonnance", e);
        }
    }

    private ArrayList<Medicament> getMedicamentsByOrdonnance(int ordonnanceId) throws SQLException {
        String sql = "SELECT m.* FROM Medicament m " +
                "JOIN Ordonnance_Medicament om ON m.id = om.medicament_id " +
                "WHERE om.ordonnance_id=?";
        ArrayList<Medicament> medicaments = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, ordonnanceId);
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
