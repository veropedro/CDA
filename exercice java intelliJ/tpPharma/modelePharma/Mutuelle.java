package tpPharma.modelePharma;
import tpPharma.regexPharma.Regex;
import tpPharma.exceptionPharma.ExceptionPharma;

public class Mutuelle {
    private String nom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String telephone;
    private String email;
    private String departement;
    private double tauxRemboursement; // en pourcentage

    public Mutuelle(String nom, String adresse, String codePostal, String ville, String telephone,
                    String email, String departement, double tauxRemboursement) {
        this.nom = nom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.telephone = telephone;
        this.email = email;
        this.departement = departement;
        this.tauxRemboursement = tauxRemboursement;
    }

    // ---------- GETTERS ET SETTERS ----------

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws ExceptionPharma {
        if (!Regex.isValid(nom, Regex.LETTRE)) {
            throw new ExceptionPharma("Erreur dans le nom de la mutuelle !");
        }
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) throws ExceptionPharma {
        if (adresse == null || adresse.isEmpty()) {
            throw new ExceptionPharma("Erreur dans l'adresse !");
        }
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) throws ExceptionPharma {
        if (!Regex.isValid(codePostal, Regex.CODE_POSTAL)) {
            throw new ExceptionPharma("Erreur dans le code postal !");
        }
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) throws ExceptionPharma {
        if (!Regex.isValid(ville, Regex.LETTRE)) {
            throw new ExceptionPharma("Erreur dans la ville !");
        }
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) throws ExceptionPharma {
        if (!Regex.isValid(telephone, Regex.TELEPHONE)) {
            throw new ExceptionPharma("Erreur dans le numéro de téléphone !");
        }
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws ExceptionPharma {
        if (!Regex.isValid(email, Regex.EMAIL)) {
            throw new ExceptionPharma("Erreur dans l'email !");
        }
        this.email = email;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) throws ExceptionPharma {
        if (!Regex.isValid(departement, Regex.LETTRE)) {
            throw new ExceptionPharma("Erreur dans le département !");
        }
        this.departement = departement;
    }

    public double getTauxRemboursement() {
        return tauxRemboursement;
    }

    public void setTauxRemboursement(double tauxRemboursement) throws ExceptionPharma {
        if (tauxRemboursement < 0 || tauxRemboursement > 100) {
            throw new ExceptionPharma("Le taux de remboursement doit être entre 0 et 100%");
        }
        this.tauxRemboursement = tauxRemboursement;
    }

    @Override
    public String toString() {
        return "Mutuelle [" +
                "nom: '" + nom + '\'' +
                ", adresse: '" + adresse + '\'' +
                ", codePostal: '" + codePostal + '\'' +
                ", ville: '" + ville + '\'' +
                ", telephone: '" + telephone + '\'' +
                ", email: '" + email + '\'' +
                ", departement: '" + departement + '\'' +
                ", tauxRemboursement: " + tauxRemboursement +
                ']';
    }
}

