package fr.afpa.pompey.cda22045.modele;

import fr.afpa.pompey.cda22045.ExceptionPharma;
import fr.afpa.pompey.cda22045.Regex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.ConsoleHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;
import java.io.IOException;

public class Medicament {

    private String nom;
    private String categorie;
    private double prix;
    private LocalDate dateService;
    private int quantite;

    // Logger spécifique à cette classe
    private static final Logger logger = Logger.getLogger(Medicament.class.getName());

    static {
        try {
            logger.setUseParentHandlers(false); // Évite double affichage

            // Handler fichier
            FileHandler fileHandler = new FileHandler(
                    "C:\\Users\\USER\\IdeaProjects\\sparadrap\\tpPharma\\medicament_log.log", true
            );
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.ALL);

            // Handler console
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new SimpleFormatter());
            consoleHandler.setLevel(Level.INFO);

            logger.addHandler(fileHandler);
            logger.addHandler(consoleHandler);
            logger.setLevel(Level.ALL);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Medicament(String nom, String categorie, double prix, LocalDate dateService, int quantite){
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.dateService = dateService;
        this.quantite = quantite;

        logger.info("Création du médicament : " + this.toString());
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws ExceptionPharma {
        if (!Regex.isValid(nom, Regex.LETTRE)) {
            logger.warning("Nom invalide tenté : " + nom);
            throw new ExceptionPharma("Erreur dans le nom ! Merci de corriger");
        }
        this.nom = nom;
        logger.info("Nom modifié : " + nom);
    }

    public String getCategorie() {
        return this.categorie;
    }

    public void setCategorie(String categorie) throws ExceptionPharma {
        if (!Regex.isValid(categorie, Regex.LETTRE)) {
            logger.warning("Categorie invalide tenté : " + categorie);
            throw new ExceptionPharma("Erreur dans la categorie ! Merci de corriger");
        }
        this.categorie = categorie;
        logger.info("Categorie modifiée : " + categorie);
    }

    public double getPrix() {
        return this.prix;
    }

    public void setPrix(double prix) throws ExceptionPharma {
        if (prix < 0) {
            logger.warning("Prix négatif tenté : " + prix);
            throw new ExceptionPharma("Le prix ne peut pas être négative !");
        }
        this.prix = prix;
        logger.info("Prix modifié : " + prix);
    }

    public LocalDate getDateService() {
        return this.dateService;
    }

    public void setDateService(String dateStr) throws ExceptionPharma {
        if (!Regex.isValid(dateStr, Regex.DATE)) {
            logger.warning("Date invalide tentée (regex) : " + dateStr);
            throw new ExceptionPharma("Erreur dans la date ! Format attendu : yyyy-MM-dd");
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.dateService = LocalDate.parse(dateStr, formatter);
            logger.info("DateService modifiée : " + dateStr);
        } catch (DateTimeParseException e) {
            logger.severe("Date invalide (jour ou mois inexistant) : " + dateStr);
            throw new ExceptionPharma("Date invalide (jour ou mois inexistant)");
        }
    }

    public int getQuantite() {
        return this.quantite;
    }

    public void setQuantite(int quantite) throws ExceptionPharma {
        if (quantite < 0) {
            logger.warning("Quantité négative tentée : " + quantite);
            throw new ExceptionPharma("La quantité ne peut pas être négative !");
        }
        this.quantite = quantite;
        logger.info("Quantité modifiée : " + quantite);
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

