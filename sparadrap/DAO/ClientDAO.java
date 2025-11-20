package fr.afpa.pompey.cda22045.DAO;
import fr.afpa.pompey.cda22045.ExceptionPharma;
import fr.afpa.pompey.cda22045.connectionBDD.Singleton;
import fr.afpa.pompey.cda22045.modele.Client;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends DAO<Client> {

    public ClientDAO() throws SQLException, IOException, ClassNotFoundException {
        super(); // initialise connection via DAO
    }


    @Override
    public Client create(Client entity) throws SQLException {
        String insertIntoClient = "INSERT INTO Client(nom, prenom, adresse, codePostal, ville, telephone, email, " +
                "numeroSecu, dateNaissance, mutuelle, medecinTraitant) VALUES(?, ? , ?, ? ,?, ? ,?, ? ,?, ? ,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                insertIntoClient,
                PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, entity.getNom());
            preparedStatement.setString(2, entity.getPrenom());
            preparedStatement.setString(3, entity.getAdresse());
            preparedStatement.setString(4, entity.getCodePostal());
            preparedStatement.setString(5, entity.getVille());
            preparedStatement.setString(6, entity.getTelephone());
            preparedStatement.setString(7, entity.getEmail());
            preparedStatement.setString(8, entity.getNumeroSecu());
            preparedStatement.setDate(9, entity.getDateNaissance());
            preparedStatement.setString(10, entity.getMutuelle());
            preparedStatement.setString(11, entity.getMedecinTraitant());

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
    public boolean update(Client entity) throws SQLException {
        String sql = "UPDATE Client SET nom=?, prenom=?, adresse=?, codePostal=?, ville=?, telephone=?, email=?, " +
                "numeroSecu=?, dateNaissance=?, mutuelle=?, medecinTraitant=? WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, entity.getNom());
            ps.setString(2, entity.getPrenom());
            ps.setString(3, entity.getAdresse());
            ps.setString(4, entity.getCodePostal());
            ps.setString(5, entity.getVille());
            ps.setString(6, entity.getTelephone());
            ps.setString(7, entity.getEmail());
            ps.setString(8, entity.getNumeroSecu());
            ps.setDate(9, entity.getDateNaissance());
            ps.setString(10, entity.getMutuelle());
            ps.setString(11, entity.getMedecinTraitant());
            ps.setInt(12, entity.getId());

            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deleteById(Integer pId) throws SQLException {
        String sql = "DELETE FROM Client WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, pId);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Client findById(Integer pId) throws SQLException {
        String sql = "SELECT * FROM Client WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, pId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToClient(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Client> findAll() throws SQLException {
        String sql = "SELECT * FROM Client";
        List<Client> clients = new ArrayList<>();
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                clients.add(mapResultSetToClient(rs));
            }
        }
        return clients;
    }

    @Override
    public void closeConnection() throws SQLException {

    }

    // méthode utilitaire pour créer un Client à partir d'un ResultSet
    private Client mapResultSetToClient(ResultSet rs) throws SQLException {
        try {
            return new Client(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("adresse"),
                    rs.getString("codePostal"),
                    rs.getString("ville"),
                    rs.getString("telephone"),
                    rs.getString("email"),
                    rs.getString("numeroSecu"),
                    rs.getDate("dateNaissance").toLocalDate(),
                    rs.getString("mutuelle"),
                    rs.getString("medecinTraitant")
            );
        } catch (ExceptionPharma e) {
            throw new SQLException("Erreur lors de la création de l'objet Client depuis la BDD", e);
        }
    }
}

