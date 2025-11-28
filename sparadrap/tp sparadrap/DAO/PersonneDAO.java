package fr.afpa.pompey.cda22045.DAO;

import fr.afpa.pompey.cda22045.modele.Personne;
import fr.afpa.pompey.cda22045.ExceptionPharma;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;


public class PersonneDAO extends DAO<Personne> {

    public PersonneDAO() throws SQLException, IOException, ClassNotFoundException {
        super();
    }

    @Override
    public Personne create(Personne entity) throws SQLException {
        String sql = "INSERT INTO Personne(nom, prenom, adresse, codePostal, ville, telephone, email) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, entity.getNom());
            ps.setString(2, entity.getPrenom());
            ps.setString(3, entity.getAdresse());
            ps.setString(4, entity.getCodePostal());
            ps.setString(5, entity.getVille());
            ps.setString(6, entity.getTelephone());
            ps.setString(7, entity.getEmail());

            ps.executeUpdate();

            // Récupération de l'id généré
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int newId = rs.getInt(1);
                    entity.setId(newId);
                }
            }
        }

        return entity;
    }

    @Override
    public boolean update(Personne entity) throws SQLException {
        String sql = "UPDATE Personne SET nom=?, prenom=?, adresse=?, codePostal=?, ville=?, telephone=?, email=? WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, entity.getNom());
            ps.setString(2, entity.getPrenom());
            ps.setString(3, entity.getAdresse());
            ps.setString(4, entity.getCodePostal());
            ps.setString(5, entity.getVille());
            ps.setString(6, entity.getTelephone());
            ps.setString(7, entity.getEmail());
            ps.setInt(8, entity.getId());

            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deleteById(Integer id) throws SQLException {
        String sql = "DELETE FROM Personne WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Personne findById(Integer id) throws SQLException {
        String sql = "SELECT * FROM Personne WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToPersonne(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Personne> findAll() throws SQLException {
        String sql = "SELECT * FROM Personne";
        List<Personne> personnes = new ArrayList<>();

        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                personnes.add(mapResultSetToPersonne(rs));
            }
        }
        return personnes;
    }

    @Override
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    // 🔥 Méthode interne pour mapper un ResultSet → Personne (avec gestion ExceptionPharma)
    private Personne mapResultSetToPersonne(ResultSet rs) throws SQLException {
        try {
            return new Personne(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("adresse"),
                    rs.getString("codePostal"),
                    rs.getString("ville"),
                    rs.getString("telephone"),
                    rs.getString("email")
            );
        } catch (ExceptionPharma e) {
            throw new SQLException("Erreur lors du mapping Personne : " + e.getMessage(), e);
        }
    }
}