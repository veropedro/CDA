package fr.afpa.pompey.cda22045.modeleSwing;

public class Abonne {
    private Integer id;
    private String nom;
    private String prenom;

    public Abonne(Integer numab, String nom, String prenom) {
        this.setId(numab);
        this.setNom(nom);
        this.setPrenom(prenom);
    }

    public Abonne(String nom, String prenom) {
        this.setNom(nom);
        this.setPrenom(prenom);
    }

    public Abonne() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Abonne{" +
                "numab= " + id +
                ", nom= '" + nom + '\'' +
                ", prenom= '" + prenom + '\'' +
                '}';
    }
}
