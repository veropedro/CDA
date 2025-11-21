package fr.afpa.pompey.cda22045.modele;
import fr.afpa.pompey.cda22045.ExceptionPharma;
import fr.afpa.pompey.cda22045.Regex;


public class Medecin extends Personne{
    private String numeroAgreement;

    public Medecin(
            int id, String nom, String prenom, String adresse, String codePostal, String ville,
        String telephone, String email, String numeroAgreement
        ) throws ExceptionPharma {

            super(id, nom, prenom, adresse, codePostal, ville, telephone, email);

            this.setNumeroAgreement(numeroAgreement);
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

}
