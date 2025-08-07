package exoPOO;

public class Livre {
    private String titre, auteur;
    private int nbPages;
    private double prix;
    boolean prixFixe = false;


    //constructeur a 3 parametres
    public Livre(String titre, String auteur, int nbPages , double prix) {
        this.titre = titre;
        this.auteur = auteur;
        this.nbPages = nbPages;
        setPrix(prix);
    }

    //constructeur a 2 parametres
    public Livre (String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
        this.nbPages = 300;
        this.prix = 17.90;

    }

    //constructeur sans parametre
    public Livre() {
        this.titre = "Titre inconnu";
        this.auteur = "Auteur inconnu";
        this.nbPages = 300;
        this.prix = 18.80;
    }

    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        if (!prixFixe){                 // !condition → si la condition n’est pas vraie donc si le prix n'est pas fixé
            this.prix = prix;           // ✅ On fixe le prix
            this.prixFixe = true;       // ✅ On indique qu'il est maintenant bloqué
        }else {
            System.out.println("Erreur : le prix ne peut etre changé.");
        }

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

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        if (nbPages > 0) {
            this.nbPages = nbPages;
        }else {
            System.out.println("Erreur : le nombre de pages doit être strictement positif.");
        }
    }


    public void afficheToi() {
        System.out.println("auteur : " + auteur + "\ntitre : " + titre + "\nnombre de pages : " + nbPages + "\nprix : " + prix);
        System.out.println();
    }


}
