package fr.afpa.pompey.cda22045.DAO;
import fr.afpa.pompey.cda22045.ExceptionPharma;
import fr.afpa.pompey.cda22045.Regex;

import fr.afpa.pompey.cda22045.modele.Mutuelle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class MutuelleDAO extends DAO<Mutuelle> {
    public MutuelleDAO() throws SQLException, IOException, ClassNotFoundException {
    }

    @Override
    public Mutuelle create(Mutuelle entity) throws SQLException {
        String sql = "INSERT INTO Mutuelle(nom, adresse, codePostal, ville, telephone, email, departement, tauxRemboursement) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, entity.getNom());
            ps.setString(2, entity.getAdresse());
            ps.setString(3, entity.getCodePostal());
            ps.setString(4, entity.getVille());
            ps.setString(5, entity.getTelephone());
            ps.setString(6, entity.getEmail());
            ps.setString(7, entity.getDepartement());
            ps.setDouble(8, entity.getTauxRemboursement());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    // si Mutuelle avait un ID, on le set ici
                    // entity.setId(rs.getInt(1));
                }
            }
            return entity;
        }
    }

    @Override
    public boolean update(Mutuelle entity) throws SQLException {
        String sql = "UPDATE Mutuelle SET nom=?, adresse=?, codePostal=?, ville=?, telephone=?, email=?, departement=?, tauxRemboursement=? " +
                "WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, entity.getNom());
            ps.setString(2, entity.getAdresse());
            ps.setString(3, entity.getCodePostal());
            ps.setString(4, entity.getVille());
            ps.setString(5, entity.getTelephone());
            ps.setString(6, entity.getEmail());
            ps.setString(7, entity.getDepartement());
            ps.setDouble(8, entity.getTauxRemboursement());
            ps.setInt(9, entity.getId()); // si Mutuelle avait un champ id

            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deleteById(Integer id) throws SQLException {
        String sql = "DELETE FROM Mutuelle WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Mutuelle findById(Integer id) throws SQLException {
        String sql = "SELECT * FROM Mutuelle WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToMutuelle(rs);
                }
            } catch (ExceptionPharma e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public List<Mutuelle> findAll() throws SQLException {
        String sql = "SELECT * FROM Mutuelle";
        List<Mutuelle> mutuelles = new ArrayList<>();
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                mutuelles.add(mapResultSetToMutuelle(rs));
            }
        } catch (ExceptionPharma e) {
            throw new RuntimeException(e);
        }
        return mutuelles;
    }

    @Override
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    private Mutuelle mapResultSetToMutuelle(ResultSet rs) throws SQLException, ExceptionPharma {
        return new Mutuelle(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("adresse"),
                rs.getString("codePostal"),
                rs.getString("ville"),
                rs.getString("telephone"),
                rs.getString("email"),
                rs.getString("departement"),
                rs.getDouble("tauxRemboursement")
        );
    }
}
