package tpPharma.modelePharma;
import tpPharma.exceptionPharma.ExceptionPharma;

import java.util.ArrayList;
import java.util.Optional;

public class GestionMutuelle {
    private ArrayList<Mutuelle> mutuelles;

    public GestionMutuelle() {
        this.mutuelles = new ArrayList<>();
    }

    // CREATE : Ajouter une mutuelle
    public void ajouterMutuelle(Mutuelle mutuelle) throws ExceptionPharma {
        if (mutuelle == null) {
            throw new ExceptionPharma("Mutuelle nulle impossible à ajouter !");
        }

        // Vérifier si la mutuelle existe déjà par nom (insensible à la casse)
        for (Mutuelle m : mutuelles) {
            if (m.getNom().equalsIgnoreCase(mutuelle.getNom())) {
                throw new ExceptionPharma("La mutuelle existe déjà !");
            }
        }

        mutuelles.add(mutuelle);
    }

    // READ : Récupérer toutes les mutuelles
    public ArrayList<Mutuelle> getAllMutuelles() {
        return new ArrayList<>(mutuelles); // renvoyer une copie pour protéger la liste interne
    }

    // READ : Récupérer une mutuelle par nom
    public Mutuelle getMutuelleByNom(String nom) throws ExceptionPharma {
        if (nom == null || nom.isEmpty()) {
            throw new IllegalArgumentException("Le nom de la mutuelle ne peut pas être vide !");
        }

        for (Mutuelle m : mutuelles) {
            if (m.getNom().equalsIgnoreCase(nom)) {
                return m;
            }
        }

        throw new ExceptionPharma("Mutuelle non trouvée !");
    }

    // UPDATE : Modifier une mutuelle existante par nom
    public void updateMutuelle(String nom, Mutuelle mutuelleMisAJour) throws ExceptionPharma {
        if (mutuelleMisAJour == null) {
            throw new IllegalArgumentException("La mutuelle mise à jour ne peut pas être nulle !");
        }

        Mutuelle mutuelleExist = getMutuelleByNom(nom);

        mutuelleExist.setNom(mutuelleMisAJour.getNom());
        mutuelleExist.setAdresse(mutuelleMisAJour.getAdresse());
        mutuelleExist.setCodePostal(mutuelleMisAJour.getCodePostal());
        mutuelleExist.setVille(mutuelleMisAJour.getVille());
        mutuelleExist.setTelephone(mutuelleMisAJour.getTelephone());
        mutuelleExist.setEmail(mutuelleMisAJour.getEmail());
        mutuelleExist.setDepartement(mutuelleMisAJour.getDepartement());
        mutuelleExist.setTauxRemboursement(mutuelleMisAJour.getTauxRemboursement());
    }

    // DELETE : Supprimer une mutuelle par nom
    public void deleteMutuelle(String nom) throws ExceptionPharma {
        Mutuelle mutuelle = getMutuelleByNom(nom);
        mutuelles.remove(mutuelle);
    }

    // Afficher toutes les mutuelles
    public void afficherMutuelle() throws ExceptionPharma {
        if (mutuelles.isEmpty()) {
            throw new ExceptionPharma("Aucune mutuelle à afficher !");
        }

        for (Mutuelle mu : mutuelles) {
            System.out.println(mu);
        }
    }
}


