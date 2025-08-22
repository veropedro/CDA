package tpModele;

public class GestionBibliotheque {
    private GestionAbonnés gestionAbonnés = new GestionAbonnés();
    private GestionBook gestionBook = new GestionBook();
    private GestionPret gestionPret = new GestionPret();

    public GestionAbonnés gestionAbonnés() {
        return gestionAbonnés;
    }

    public GestionBook getGestionBook() {
        return gestionBook;
    }

    public GestionPret getGestionPret() {
        return gestionPret;
    }
}