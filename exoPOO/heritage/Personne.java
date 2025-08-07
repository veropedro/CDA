package heritage;

public class Personne {
    public String nom;
    public String adresse;

    public Personne(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Nom : " + nom + ", Adresse : " + adresse;
    }
}
