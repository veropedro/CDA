package fr.afpa.pompey.cda22045.modele;
import fr.afpa.pompey.cda22045.ExceptionPharma;
import fr.afpa.pompey.cda22045.Regex;

public class Mutuelle {
    private int id;
    private String nom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String telephone;
    private String email;
    private String departement;
    private double tauxRemboursement; // en pourcentage

    public Mutuelle(int id, String nom, String adresse, String codePostal, String ville, String telephone,
                    String email, String departement, double tauxRemboursement) throws ExceptionPharma {
        this.setId(id);
        this.setNom(nom);
        this.setAdresse(adresse);
        this.setCodePostal(codePostal);
        this.setVille(ville);
        this.setTelephone(telephone);
        this.setEmail(email);
        this.setDepartement(departement);
        this.setTauxRemboursement(tauxRemboursement);
    }


    // ---------- GETTERS ET SETTERS ----------


    public int getId() {return this.id; }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("L'id doit être strictement positif.");
        }

        // Si ton id est déjà défini, on empêche de le modifier
        if (this.id != 0) {
            throw new IllegalStateException("L'id ne peut pas être modifié une fois défini.");
        }

        this.id = id;
    }

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

