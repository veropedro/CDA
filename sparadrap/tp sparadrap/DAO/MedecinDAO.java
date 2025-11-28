package fr.afpa.pompey.cda22045.DAO;
import fr.afpa.pompey.cda22045.ExceptionPharma;
import fr.afpa.pompey.cda22045.modele.Medecin;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedecinDAO extends DAO<Medecin> {
    public MedecinDAO() throws SQLException, IOException, ClassNotFoundException {
        super(); // initialise connection via DAO
    }

    @Override
    public Medecin create(Medecin entity) throws SQLException {
        String insertIntoMedecin = "INSERT INTO Medecin(nom, prenom, adresse, codePostal, ville, telephone, email, " +
                "numeroAgreement) VALUES(?, ? , ?, ? , ? , ? , ? , ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                insertIntoMedecin,
                PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, entity.getNom());
            preparedStatement.setString(2, entity.getPrenom());
            preparedStatement.setString(3, entity.getAdresse());
            preparedStatement.setString(4, entity.getCodePostal());
            preparedStatement.setString(5, entity.getVille());
            preparedStatement.setString(6, entity.getTelephone());
            preparedStatement.setString(7, entity.getEmail());
            preparedStatement.setString(8, entity.getNumeroAgreement());

            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    entity.setId(resultSet.getInt(1));
                }
            }
            return entity;
        }
    }

    @Override
    public boolean update(Medecin entity) throws SQLException {
        String sql = "UPDATE Medecin SET nom=?, prenom=?, adresse=?, codePostal=?, ville=?, telephone=?, email=?, " +
                "numeroAgreement=? WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, entity.getNom());
            ps.setString(2, entity.getPrenom());
            ps.setString(3, entity.getAdresse());
            ps.setString(4, entity.getCodePostal());
            ps.setString(5, entity.getVille());
            ps.setString(6, entity.getTelephone());
            ps.setString(7, entity.getEmail());
            ps.setString(8, entity.getNumeroAgreement());
            ps.setInt(9, entity.getId());

            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deleteById(Integer pId) throws SQLException {
        String sql = "DELETE FROM Medecin WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, pId);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Medecin findById(Integer pId) throws SQLException {
        String sql = "SELECT * FROM Medecin WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, pId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToMedecin(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Medecin> findAll() throws SQLException {
        String sql = "SELECT * FROM Medecin";
        List<Medecin> medecins = new ArrayList<>();
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                medecins.add(mapResultSetToMedecin(rs));
            }
        }
        return medecins;
    }

    @Override
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }


    private Medecin mapResultSetToMedecin(ResultSet rs) throws SQLException {
        try {
            return new Medecin(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("adresse"),
                    rs.getString("codePostal"),
                    rs.getString("ville"),
                    rs.getString("telephone"),
                    rs.getString("email"),
                    rs.getString("numeroAgreement")
            );
        } catch (ExceptionPharma e) {
            throw new SQLException("Erreur lors de la création du médecin", e);
        }
    }
}

