package geographie;

public class Ville {
    public String nom;

    public Ville(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    @Override
    public String toString() {
        return "Nom : " + nom;
    }
}
