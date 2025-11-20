package fr.afpa.pompey.cda22045.DAO;


import fr.afpa.pompey.cda22045.modele.Medicament;
import fr.afpa.pompey.cda22045.connectionBDD.Singleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.time.LocalDate;

public class MedicamentDAO {

    // CREATE - Ajouter un médicament
    public static void ajouterMedicament(Medicament m) {

        // Vérification avant insertion
        if (existe(m.getNom())) {
            System.out.println("⚠️ Médicament déjà présent, insertion annulée.");
            return;
        }

        String sql = "INSERT INTO MEDICAMENT(medoc_nom, medoc_description, medoc_prix, medoc_date_expiration, medoc_quantite) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Singleton.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, m.getNom());
            ps.setString(2, m.getCategorie());
            ps.setDouble(3, m.getPrix());
            ps.setDate(4, Date.valueOf(m.getDateService()));
            ps.setInt(5, m.getQuantite());

            ps.executeUpdate();
            System.out.println("Médicament ajouté avec succès.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static boolean existe(String nom) {
        String sql = "SELECT COUNT(*) FROM medicament WHERE medoc_nom = ?";

        try (Connection conn = Singleton.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0; // si COUNT > 0 → existe
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // en cas de problème, on dit que ça n'existe pas
    }


    // READ - Lister tous les médicaments
    public static ArrayList<Medicament> listerMedicaments() {
        ArrayList<Medicament> liste = new ArrayList<>();
        String sql = "SELECT * FROM MEDICAMENT";

        try (Connection conn = Singleton.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Medicament m = new Medicament(
                        rs.getString("medoc_nom"),
                        rs.getString("medoc_categorie"),
                        rs.getDouble("medoc_prix"),
                        rs.getDate("medoc_dateMiseService").toLocalDate(),
                        rs.getInt("medoc_quantite")
                );
                liste.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return liste;
    }

    // Afficher tous les médicaments
    public static void afficherMedicaments() {
        ArrayList<Medicament> liste = listerMedicaments();
        System.out.println("Liste des médicaments :");
        for (Medicament m : liste) {
            System.out.println(m);
        }
    }

    // UPDATE - Modifier tous les champs d'un médicament
    public static void modifierMedicament(int id, Medicament nouveau) {
        String sql = "UPDATE MEDICAMENT SET medoc_nom = ?, medoc_categorie = ?, medoc_prix = ?, medoc_dateMiseService = ?, medoc_quantite = ? WHERE idMedicament = ?";

        try (Connection conn = Singleton.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nouveau.getNom());
            ps.setString(2, nouveau.getCategorie());
            ps.setDouble(3, nouveau.getPrix());
            ps.setDate(4, Date.valueOf(nouveau.getDateService()));
            ps.setInt(5, nouveau.getQuantite());
            ps.setInt(6, id);

            ps.executeUpdate();
            System.out.println("✅ Médicament modifié !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE - Supprimer un médicament
    public static void supprimerMedicament(int id) {
        String sql = "DELETE FROM MEDICAMENT WHERE idMedicament = ?";

        try (Connection conn = Singleton.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("🗑️ Médicament supprimé !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // MAIN - Exemple d'utilisation
    public static void main(String[] args) {

        // Ajouter un médicament
        Medicament m = new Medicament("Doliprane", "Antidouleur", 3.50,
                LocalDate.of(2025, 1, 1), 20);
        ajouterMedicament(m);

        // Lister
        afficherMedicaments();

        // Modifier
        Medicament mModifie = new Medicament("Paracetamol", "Antidouleur", 4.20,
                LocalDate.of(2025, 1, 1), 25);
        modifierMedicament(1, mModifie);


    }
}


