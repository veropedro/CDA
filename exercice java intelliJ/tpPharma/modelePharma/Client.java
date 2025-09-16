package tpPharma.modelePharma;
import tpPharma.exceptionPharma.ExceptionPharma;
import tpPharma.regexPharma.Regex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Client {
    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String telephone;
    private String email;
    private String numeroSecu;
    private LocalDate dateNaissance;
    private String mutuelle;
    private String medecinTraitant;


    public Client(String nom, String prenom, String adresse, String codePostal, String ville, String telephone ,
                  String email, String numeroSecu, LocalDate dateNaissance, String mutuelle, String medecinTraitant) throws ExceptionPharma {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.telephone = telephone;
        this.email = email;
        this.numeroSecu = numeroSecu;
        this.dateNaissance = dateNaissance;
        this.mutuelle = mutuelle;
        this.medecinTraitant = medecinTraitant;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) throws ExceptionPharma {

        if (!Regex.isValid(nom, Regex.LETTRE)) {
            throw new ExceptionPharma("Erreur dans le nom ! Merci de corriger");
        }
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) throws ExceptionPharma {

        if (!Regex.isValid(prenom, Regex.LETTRE)) {
            throw new ExceptionPharma("Erreur dans le prenom ! Merci de corriger");
        }
        this.prenom = prenom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) throws ExceptionPharma{
        if (adresse == null || adresse.isEmpty()) {
            throw new ExceptionPharma("Erreur dans l'adresse ! Merci de corriger");
        }
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return this.codePostal;
    }

    public void setCodePostal(String codePostal) throws ExceptionPharma {

        if (!Regex.isValid(codePostal, Regex.CODE_POSTAL)) {
            throw new ExceptionPharma("Erreur dans le code postal ! Merci de corriger");
        }
        this.codePostal = codePostal;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville)  throws ExceptionPharma {

        if (!Regex.isValid(ville, Regex.LETTRE)) {
            throw new ExceptionPharma("Erreur dans la ville ! Merci de corriger");
        }
        this.ville = ville;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) throws ExceptionPharma {

        if (!Regex.isValid(telephone, Regex.TELEPHONE)) {
            throw new ExceptionPharma("Erreur dans le numéro de telephone ! Merci de corriger");
        }
        this.telephone = telephone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email)  throws ExceptionPharma {
        if (!Regex.isValid(email, Regex.EMAIL)) {
            throw new ExceptionPharma("Erreur dans l'email ! Merci de corriger");
        }
        this.email = email;
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

    public LocalDate getDateNaissance() {
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
    @Override
    public String toString() {
        return "Client [" +
                "nom: '" + nom + '\'' +
                ", prenom: '" + prenom + '\'' +
                ", adresse: '" + adresse + '\'' +
                ", codePostal: '" + codePostal + '\'' +
                ", ville: '" + ville + '\'' +
                ", telephone: '" + telephone + '\'' +
                ", email: '" + email + '\'' +
                ", numeroSecu: '" + numeroSecu + '\'' +
                ", dateNaissance: " + dateNaissance +
                ", mutuelle: '" + mutuelle + '\'' +
                ", medecinTraitant: '" + medecinTraitant + '\'' +
                ']';
    }

}
