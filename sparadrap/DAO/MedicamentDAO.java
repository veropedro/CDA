package fr.afpa.pompey.cda22045.DAO;


import fr.afpa.pompey.cda22045.ExceptionPharma;
import fr.afpa.pompey.cda22045.modele.Medicament;
import fr.afpa.pompey.cda22045.connectionBDD.Singleton;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MedicamentDAO extends DAO<Medicament> {

    public MedicamentDAO() throws SQLException, IOException, ClassNotFoundException {
        super(); // initialise la connexion
    }

    @Override
    public Medicament create(Medicament entity) throws SQLException {
        String sql = "INSERT INTO MEDICAMENT(medoc_nom, medoc_categorie, medoc_prix, medoc_dateMiseService, medoc_quantite) " +
                "VALUES(?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, entity.getNom());
            ps.setString(2, entity.getCategorie());
            ps.setDouble(3, entity.getPrix());
            ps.setDate(4, Date.valueOf(entity.getDateService()));
            ps.setInt(5, entity.getQuantite());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    entity.setId(rs.getInt(1)); // ID généré par la base
                }
            }
            return entity;
        }
    }

    @Override
    public boolean update(Medicament entity) throws SQLException {
        String sql = "UPDATE MEDICAMENT SET medoc_nom=?, medoc_categorie=?, medoc_prix=?, medoc_dateMiseService=?, medoc_quantite=? " +
                "WHERE idMedicament=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, entity.getNom());
            ps.setString(2, entity.getCategorie());
            ps.setDouble(3, entity.getPrix());
            ps.setDate(4, Date.valueOf(entity.getDateService()));
            ps.setInt(5, entity.getQuantite());
            ps.setInt(6, entity.getId());

            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deleteById(Integer id) throws SQLException {
        String sql = "DELETE FROM MEDICAMENT WHERE idMedicament=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Medicament findById(Integer id) throws SQLException {
        String sql = "SELECT * FROM MEDICAMENT WHERE idMedicament=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToMedicament(rs);
                }
            } catch (ExceptionPharma e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public List<Medicament> findAll() throws SQLException {
        String sql = "SELECT * FROM MEDICAMENT";
        List<Medicament> medicaments = new ArrayList<>();
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                medicaments.add(mapResultSetToMedicament(rs));
            }
        } catch (ExceptionPharma e) {
            throw new RuntimeException(e);
        }
        return medicaments;
    }

    @Override
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    // Méthode de mapping ResultSet → Medicament
    public Medicament mapResultSetToMedicament(ResultSet rs) throws SQLException, ExceptionPharma {
        return new Medicament(
                rs.getInt("idMedicament"),
                rs.getString("medoc_nom"),
                rs.getString("medoc_categorie"),
                rs.getDouble("medoc_prix"),
                rs.getDate("medoc_dateMiseService").toLocalDate(),
                rs.getInt("medoc_quantite")
        );
    }
}


