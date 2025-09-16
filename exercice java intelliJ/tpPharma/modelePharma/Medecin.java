package tpPharma.modelePharma;
import tpPharma.regexPharma.Regex;
import tpPharma.exceptionPharma.ExceptionPharma;

public class Medecin {
    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String telephone;
    private String email;
    private String numeroAgreement;

    public Medecin(String nom, String prenom, String adresse, String codePostal, String ville, String telephone ,
                  String email, String numeroAgreement){
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.telephone = telephone;
        this.email = email;
        this.numeroAgreement = numeroAgreement;

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

    public String getNumeroAgreement() {
        return numeroAgreement;
    }

    public void setNumeroAgreement(String numeroAgreement) throws ExceptionPharma {
        if (numeroAgreement == null || numeroAgreement.isEmpty()) {
            throw new ExceptionPharma("Numéro d'agrément invalide !");
        }
        this.numeroAgreement = numeroAgreement;
    }

    @Override
    public String toString() {
        return "Medecin [" +
                "nom: '" + nom + '\'' +
                ", prenom: '" + prenom + '\'' +
                ", adresse: '" + adresse + '\'' +
                ", codePostal: '" + codePostal + '\'' +
                ", ville: '" + ville + '\'' +
                ", telephone: '" + telephone + '\'' +
                ", email: '" + email + '\'' +
                ", numeroAgreement: '" + numeroAgreement + '\'' +
                ']';
    }
}
