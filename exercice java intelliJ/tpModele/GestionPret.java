package tpModele;

import java.util.ArrayList;

public class GestionPret {
    private ArrayList<Pret> listePrets = new ArrayList<>();

    // CREATE (ajout d'un prêt)
    public void ajouterPret(Pret z) {
        listePrets.add(z);
    }

    // READ (recherche d'un prêt par date début au format yyyy-MM-dd)
    public Pret rechercherPret(String dateDebutStr) {
        for (Pret z : listePrets) {
            if (z.getDateDebut().toString().equals(dateDebutStr)) {
                return z;
            }
        }
        return null;
    }

    // UPDATE (mise à jour de la date début d'un prêt)
    public boolean updatePret(String ancienneDateStr, String nouvelleDateStr) {
        for (Pret z : listePrets) {
            if (z.getDateDebut().toString().equals(ancienneDateStr)) {
                try {
                    z.setDateDebut(nouvelleDateStr); // setDateDebut défensif avec regex
                    return true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Erreur de saisie : " + e.getMessage());
                    return false;
                } catch (SaisieException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return false;
    }

    // DELETE (suppression d'un prêt par date début)
    public boolean deletePret(String dateDebutStr) {
        for (Pret z : listePrets) {
            if (z.getDateDebut().toString().equals(dateDebutStr)) {
                listePrets.remove(z);
                return true;
            }
        }
        return false;
    }

    // Afficher tous les prêts
    public void afficherPret() {
        for (Pret z : listePrets) {
            System.out.println(z);
        }
    }
}
