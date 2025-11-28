package fr.afpa.pompey.cda22045.modeleSwing;

public class Livre {
    private Integer id;
    private String titre;
    private String auteur;
    private int quantite;
    private boolean isActive;
    private String genre;

    public Livre(String titre, String auteur, boolean isActive, String genre) {
        this.setTitre(titre);
        this.setAuteur(auteur);
        this.setActive(isActive);
        this.setGenre(genre);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return this.getTitre() + " - " + this.getAuteur();
    }

}
