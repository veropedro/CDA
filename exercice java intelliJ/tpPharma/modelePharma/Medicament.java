package tpPharma.modelePharma;
import tpPharma.exceptionPharma.ExceptionPharma;
import tpPharma.regexPharma.Regex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Medicament {
    private String nom;
    private String categorie;
    private double  prix;
    private LocalDate dateService;
    private int quantite;

    public Medicament(String nom, String categorie, double  prix, LocalDate dateService, int quantite){
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.dateService = dateService;
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws ExceptionPharma {

        if (!Regex.isValid(nom, Regex.LETTRE)) {
            throw new ExceptionPharma("Erreur dans le nom ! Merci de corriger");
        }
        this.nom = nom;
    }

    public String getCategorie() {
        return  this.categorie;
    }

    public void setCategorie(String categorie) throws ExceptionPharma {

        if (!Regex.isValid(categorie, Regex.LETTRE)) {
            throw new ExceptionPharma("Erreur dans la categorie ! Merci de corriger");
        }
        this.categorie = categorie;
    }

    public double getPrix() {
        return  this.prix;
    }

    public void setPrix(double prix) throws ExceptionPharma {
        if (prix < 0) {
            throw new ExceptionPharma("Le prix ne peut pas être négative !");
        }
        this.prix = prix;
    }

    public LocalDate getDateService() {
        return  this.dateService;
    }

    public void setDateService(String dateStr) throws ExceptionPharma {
        // Vérifie la forme avec regex
        if (!Regex.isValid(String.valueOf(dateStr), Regex.DATE)) {
            throw new ExceptionPharma("Erreur dans la date ! Format attendu : yyyy-MM-dd");
        }

        // Vérifie que la date existe vraiment
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.dateService = LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            throw new ExceptionPharma("Date invalide (jour ou mois inexistant)");
        }
    }

    public int getQuantite() {
        return this.quantite;
    }

    public void setQuantite(int quantite) throws ExceptionPharma {
        if (quantite < 0) {
            throw new ExceptionPharma("La quantité ne peut pas être négative !");
        }
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Medicament [" +
                "nom: '" + nom + '\'' +
                ", categorie: '" + categorie + '\'' +
                ", prix: " + prix +
                ", dateService: " + dateService +
                ", quantite: " + quantite +
                ']';
    }
}
