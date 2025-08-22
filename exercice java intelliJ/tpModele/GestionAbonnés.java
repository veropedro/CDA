package tpModele;
import java.util.ArrayList;

public class GestionAbonnés {
    private ArrayList<Abonné> listeAbonnés = new ArrayList<>();


    // CREATE de la methode CRUD
    public void ajouterAbonné( Abonné x) {
        listeAbonnés.add(x);
    }

    // READ de la methode CRUD
    public Abonné rechercherAbonné(String nom) {
        for (Abonné x : listeAbonnés) {                   // recherche d'un abonné par son nom
            if (x.getNom().equalsIgnoreCase(nom)) {
                return x; // si le nom correspond, on retourne l'abonné trouvé
            }
        }
        return null; // si aucun abonné n'a ce nom
    }

    // UPDATE de la methode CRUD
    public boolean updateAbonné(String nom, String nouveauNom) {
        for (Abonné x : listeAbonnés) {
            if (x.getNom().equalsIgnoreCase(nom)) {
                try {
                    x.setNom(nouveauNom); // Met à jour le nom de l’abonné trouvé
                } catch (SaisieException e) {
                    throw new RuntimeException(e);
                }
                return true;          // Mise à jour réussie
            }
        }
        return false; // Aucun abonné trouvé avec ce nom
    }

    // DELETE de la methode CRUD
    public boolean deleteAbonné(String nom) {
        for (Abonné x : listeAbonnés) {
            if (x.getNom().equalsIgnoreCase(nom)) {
                listeAbonnés.remove(x); // Supprime l’abonné trouvé
                return true;            // Suppression réussie
            }
        }
        return false; // Aucun abonné trouvé avec ce nom
    }

    public void afficherAbonnés() {            //affiche la liste des abonnés
        for (Abonné x : listeAbonnés) {
            System.out.println(x);
        }
    }

}
