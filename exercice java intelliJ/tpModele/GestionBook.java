package tpModele;

import java.util.ArrayList;

public class GestionBook {
    private static ArrayList<Book> listeBooks = new ArrayList<>();

    // CREATE de la methode CRUD
    public void ajouterBook( Book y) {
        listeBooks.add(y);
    }

    // READ de la methode CRUD
    public Book rechercherBook(String titre) {
        for (Book y : listeBooks) {                   // recherche d'un Book par son nom
            if (y.getTitre().equalsIgnoreCase(titre)) {
                return y; // si le nom correspond, on retourne l'Book trouvé
            }
        }
        return null; // si aucun Book n'a ce nom
    }

    // UPDATE de la methode CRUD
    public boolean updateBook(String titre, String nouveauTitre) throws SaisieException {
        for (Book y : listeBooks) {
            if (y.getTitre().equalsIgnoreCase(titre)) {
                y.setTitre(nouveauTitre); // Met à jour le nom de l’Book trouvé
                return true;          // Mise à jour réussie
            }
        }
        return false; // Aucun Book trouvé avec ce nom
    }

    // DELETE de la methode CRUD
    public boolean deleteBook(String titre) {
        for (Book y : listeBooks) {
            if (y.getTitre().equalsIgnoreCase(titre)) {
                listeBooks.remove(y); // Supprime le Book trouvé
                return true;            // Suppression réussie
            }
        }
        return false; // Aucun Book trouvé avec ce nom
    }

    public void afficherBook() {            //affiche la liste des Books
        for (Book y : listeBooks) {
            System.out.println(y);
        }
    }
}
