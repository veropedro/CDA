package fr.afpa.pompey.cda22045.modele;
import fr.afpa.pompey.cda22045.ExceptionPharma;
import fr.afpa.pompey.cda22045.Regex;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class Client extends Personne{
    private String numeroSecu;
    private LocalDate dateNaissance;
    private String mutuelle;
    private String medecinTraitant;


    public Client(
            int id, String nom, String prenom, String adresse, String codePostal, String ville,
            String telephone, String email,
            String numeroSecu, LocalDate dateNaissance, String mutuelle, String medecinTraitant
    ) throws ExceptionPharma {

        super(id, nom, prenom, adresse, codePostal, ville, telephone, email);

        this.setNumeroSecu(numeroSecu);
        this.setDateNaissance(String.valueOf(dateNaissance));
        this.setMutuelle(mutuelle);
        this.setMedecinTraitant(medecinTraitant);
    }


    public String getNumeroSecu() {
        return this.numeroSecu;
    }

    public void setNumeroSecu(String numeroSecu)throws ExceptionPharma {

        if (numeroSecu == null || numeroSecu.trim().isEmpty()) {
            throw new ExceptionPharma("Erreur dans le numero de securité sociale ! Merci de corriger");
        }
        this.numeroSecu = numeroSecu;
    }

    public Date getDateNaissance() {
        return this.dateNaissance;
    }

    public void setDateNaissance(String dateStr) throws ExceptionPharma {
        // 1) Protéger contre null ou vide
        if (dateStr == null || dateStr.trim().isEmpty()) {
            throw new ExceptionPharma("Erreur dans la date ! Format attendu : yyyy-MM-dd");
        }

        // 2) Essayer de parser au format ISO (yyyy-MM-dd)
        try {
            LocalDate date = LocalDate.parse(dateStr); // ISO par défaut
            this.dateNaissance = date;
        } catch (DateTimeParseException e) {
            // 3) Si le format est mauvais, renvoyer ton exception avec le bon message
            throw new ExceptionPharma("Erreur dans la date ! Format attendu : yyyy-MM-dd");
        }
    }

    public String getMutuelle() {
        return this.mutuelle;
    }

    public void setMutuelle(String mutuelle) throws ExceptionPharma {

        if (!Regex.isValid(mutuelle, Regex.LETTRE)) {
            throw new ExceptionPharma("Erreur dans la mutuelle ! Merci de corriger");
        }
        this.mutuelle = mutuelle;
    }

    public String getMedecinTraitant() {
        return this.medecinTraitant;
    }

    public void setMedecinTraitant(String medecin) throws ExceptionPharma {

        if (medecin == null || medecin.trim().isEmpty()) {
            throw new ExceptionPharma("Erreur dans le medecin traitant ! Merci de corriger");
        }
        this.medecinTraitant = medecin; // ✅ on enregistre le médecin

    }

}
