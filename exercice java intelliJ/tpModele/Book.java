package tpModele;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    private String titre;
    private String auteur;
    private int quantité;
    private String identifiant;
    private ArrayList<Book> listeBooks = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    private String REGEX_LETTRE = "^\\p{L}+$";
    private static final String REGEX_CHIFFRE = "^\\d+$";
    private static final String REGEX_ISBN = "^(\\d{9}[\\dX]|\\d{13})$";

    public ArrayList<Book> getlisteBooks(){
        return this.listeBooks;
    }

    public void setlisteBooks(ArrayList<Book> listeBooks) {
        this.listeBooks = listeBooks;
    }

    public Book(String titre, String auteur, int quantité, String identifiant) throws SaisieException {
        this.setTitre(titre);
        this.setAuteur(auteur);
        this.quantité = quantité;
        this.setIdentifiant(identifiant);

    }
    public ArrayList<Book> getListeBooks() {
        return listeBooks;
    }
    public void setListeBooks(ArrayList<Book> listeBooks) {
        this.listeBooks = listeBooks;
    }


    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) throws SaisieException {

        if (titre == null || !titre.matches(REGEX_LETTRE)) {
            throw new SaisieException("Erreur dans le titre ! Merci de corriger");
        } else {
            this.titre = titre.toUpperCase();
        }
    }

    public String getAuteur() {
        return this.auteur;
    }

    public void setAuteur(String auteur)throws SaisieException {

        if (auteur == null || !auteur.matches(REGEX_LETTRE)) {
            throw new SaisieException("Erreur dans l'auteur ! Merci de corriger");
        } else {
            this.auteur = auteur.toUpperCase();
        }
    }

    public int getQuantité() {
        return this.quantité;
    }

    public void setQuantité(int quantité)  throws SaisieException {
        if(quantité < 0) { // Par exemple, interdit les nombres négatifs
            throw new SaisieException("Erreur dans la quantité ! Merci de corriger");
        }
        this.quantité = quantité;
    }

    public String getIndentifiant() {
        return this.identifiant;
    }

    public void setIdentifiant(String identifiant)throws SaisieException {
        if(identifiant == null || !identifiant.matches(REGEX_ISBN)) {
            throw new SaisieException("ISBN invalide !");
        }
        this.identifiant = identifiant;
    }



    @Override
    public String toString() {
        return "Book [ titre= " + titre + " , auteur= " + auteur + " , quantité= " + quantité +
                " , identifiant= " + identifiant + "]";
    }




}
