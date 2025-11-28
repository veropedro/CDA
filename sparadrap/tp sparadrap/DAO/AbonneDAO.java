package fr.afpa.pompey.cda22045.DAO;
import fr.afpa.pompey.cda22045.connectionBDD.Singleton;
import fr.afpa.pompey.cda22045.modeleSwing.Abonne;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AbonneDAO extends DAO<Abonne> {

    public AbonneDAO() throws SQLException, IOException, ClassNotFoundException {
    }

    @Override
    public Abonne create(Abonne entity) throws SQLException {
        String insertIntoAbonne = "INSERT INTO Abonne(nom, prenom) VALUES(?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                insertIntoAbonne,
                PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, entity.getNom());
            preparedStatement.setString(2, entity.getPrenom());

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
    public boolean update(Abonne entity) throws SQLException {

        String updateAbonne = "UPDATE Abonne SET nom = ?, prenom = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateAbonne)) {

            preparedStatement.setString(1, entity.getNom());
            preparedStatement.setString(2, entity.getPrenom());
            preparedStatement.setInt(3, entity.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        }
    }

    @Override
    public boolean deleteById(Integer id) throws SQLException {

        String deleteAbonne = "DELETE FROM Abonne WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteAbonne)) {

            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        }
    }

    @Override
    public Abonne findById(Integer pId) throws SQLException {

        String selectById = "SELECT * FROM abonne WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectById)) {

            preparedStatement.setInt(1, pId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Abonne abonne = new Abonne();
                    abonne.setId(resultSet.getInt("id"));
                    abonne.setNom(resultSet.getString("nom"));
                    abonne.setPrenom(resultSet.getString("prenom"));

                    return abonne;
                }
            }
        }
        return null;
    }

    @Override
    public List<Abonne> findAll() throws SQLException {

        String select = "select * from abonne";

        List<Abonne> abonnes = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(select);){

            while (resultSet.next()) {

                // utilisation du resultSet pour récuperer les valeurs de chaques colonnes ciblées par le nom
                Integer numab = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");

                Abonne abonne = new Abonne(numab, nom, prenom);

                abonnes.add(abonne);
            }
        }
        return abonnes;
    }

    public Abonne findByName(String pName) throws SQLException {

        String selectById = "SELECT * FROM abonne WHERE nom like ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectById)) {

            preparedStatement.setString(1, pName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Abonne abonne = new Abonne();
                    abonne.setId(resultSet.getInt("id"));
                    abonne.setNom(resultSet.getString("nom"));
                    abonne.setPrenom(resultSet.getString("prenom"));

                    return abonne;
                }
            }
        }
        return null;
    }

    @Override
    public void closeConnection() throws SQLException {
        Singleton.closeInstanceDB();
    }
}
