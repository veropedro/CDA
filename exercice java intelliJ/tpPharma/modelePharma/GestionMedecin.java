package tpPharma.modelePharma;
import tpPharma.modelePharma.Medecin;
import tpPharma.exceptionPharma.ExceptionPharma;

import java.util.ArrayList;
import java.util.Optional;


public class GestionMedecin {
    private ArrayList<Medecin> medecins;

    public GestionMedecin() {
        this.medecins = new ArrayList<>();
    }

    public ArrayList<Medecin> getMedecins() {
        return medecins;
    }

    // CREATE : Ajouter un médecin
    public void ajouterMedecin(Medecin medecin) throws ExceptionPharma {
        if (medecin == null) {
            throw new ExceptionPharma("Médecin nul impossible à ajouter !");
        }

        // Vérifier si le médecin existe déjà par numéro d'agrément
        for (Medecin m : medecins) {
            if (m.getNumeroAgreement().equals(medecin.getNumeroAgreement())) {
                throw new ExceptionPharma("Le médecin existe déjà !");
            }
        }

        medecins.add(medecin);
    }

    // READ : Récupérer tous les médecins
    public ArrayList<Medecin> getAllMedecins() {
        return new ArrayList<>(medecins); // renvoyer une copie pour protéger la liste interne
    }

    // READ : Récupérer un médecin par numéro d'agrément
    public Medecin getMedecinByNumeroAgreement(String numeroAgreement) throws ExceptionPharma {
        if (numeroAgreement == null || numeroAgreement.isEmpty()) {
            throw new IllegalArgumentException("Le numéro d'agrément ne peut pas être vide !");
        }

        for (Medecin m : medecins) {
            if (m.getNumeroAgreement().equals(numeroAgreement)) {
                return m;
            }
        }

        throw new ExceptionPharma("Médecin non trouvé !");
    }

    // UPDATE : Modifier un médecin existant par numéro d'agrément
    public void updateMedecin(String numeroAgreement, Medecin medecinMisAJour) throws ExceptionPharma {
        if (medecinMisAJour == null) {
            throw new IllegalArgumentException("Le médecin mis à jour ne peut pas être nul !");
        }

        Medecin medecinExist = getMedecinByNumeroAgreement(numeroAgreement);

        medecinExist.setNom(medecinMisAJour.getNom());
        medecinExist.setPrenom(medecinMisAJour.getPrenom());
        medecinExist.setAdresse(medecinMisAJour.getAdresse());
        medecinExist.setCodePostal(medecinMisAJour.getCodePostal());
        medecinExist.setVille(medecinMisAJour.getVille());
        medecinExist.setTelephone(medecinMisAJour.getTelephone());
        medecinExist.setEmail(medecinMisAJour.getEmail());
        medecinExist.setNumeroAgreement(medecinMisAJour.getNumeroAgreement());
    }

    // DELETE : Supprimer un médecin par numéro d'agrément
    public void deleteMedecin(String numeroAgreement) throws ExceptionPharma {
        Medecin medecin = getMedecinByNumeroAgreement(numeroAgreement);
        medecins.remove(medecin);
    }

    // Afficher tous les médecins
    public void afficherMedecin() throws ExceptionPharma {
        if (medecins.isEmpty()) {
            throw new ExceptionPharma("Aucun médecin à afficher !");
        }

        for (Medecin m : medecins) {
            System.out.println(m);
        }
    }
}

