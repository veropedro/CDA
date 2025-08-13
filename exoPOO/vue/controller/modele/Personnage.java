package vue.controller.modele;

public class Personnage {
    private String nom;
    private String race;
    private String classe;
    private int niveau;
    private int pdv;

    public Personnage(String nom, String race, String classe, int niveau, int pdv) {
        this.nom = nom;
        this.race = race;
        this.classe = classe;
        this.niveau = niveau;
        this.pdv = pdv;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRace() {
        return this.race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getClasse() {
        return this.classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getNiveau() {
        return this.niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getPdv() {
        return this.pdv;
    }

    public void setPdv(int pdv) {
        this.pdv = pdv;
    }
    @Override
    public String toString() {
        return "nom : " + nom + ", race : " + race + ", classe : " + classe + ", niveau : " + niveau + ", pdv : " + pdv;
    }
}
