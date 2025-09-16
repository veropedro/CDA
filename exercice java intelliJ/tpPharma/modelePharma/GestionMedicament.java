package tpPharma.modelePharma;
import tpPharma.exceptionPharma.ExceptionPharma;

import java.util.ArrayList;
import java.util.Optional;

public class GestionMedicament {
    private ArrayList<Medicament> medicaments;

    public GestionMedicament() {
        this.medicaments = new ArrayList<>();
    }

    // CREATE : Ajouter un médicament
    public void ajouterMedicament(Medicament medicament) throws ExceptionPharma {
        if (medicament == null) {
            throw new ExceptionPharma("Médicament nul impossible à ajouter !");
        }

        // Vérifier si le médicament existe déjà par nom (insensible à la casse)
        for (Medicament m : medicaments) {
            if (m.getNom().equalsIgnoreCase(medicament.getNom())) {
                throw new ExceptionPharma("Le médicament existe déjà !");
            }
        }

        medicaments.add(medicament);
    }

    // READ : Récupérer tous les médicaments
    public ArrayList<Medicament> getAllMedicaments() {
        return new ArrayList<>(medicaments); // renvoyer une copie pour protéger la liste interne
    }

    // READ : Récupérer un médicament par nom
    public Medicament getMedicamentByNom(String nom) throws ExceptionPharma {
        if (nom == null || nom.isEmpty()) {
            throw new IllegalArgumentException("Le nom du médicament ne peut pas être vide !");
        }

        for (Medicament m : medicaments) {
            if (m.getNom().equalsIgnoreCase(nom)) {
                return m;
            }
        }

        throw new ExceptionPharma("Médicament non trouvé !");
    }

    // UPDATE : Modifier un médicament existant par nom
    public void updateMedicament(String nom, Medicament medicamentMisAJour) throws ExceptionPharma {
        if (medicamentMisAJour == null) {
            throw new IllegalArgumentException("Le médicament mis à jour ne peut pas être nul !");
        }

        Medicament medicamentExist = getMedicamentByNom(nom);

        medicamentExist.setNom(medicamentMisAJour.getNom());
        medicamentExist.setCategorie(medicamentMisAJour.getCategorie());
        medicamentExist.setPrix(medicamentMisAJour.getPrix());
        medicamentExist.setDateService(medicamentMisAJour.getDateService().toString());
        medicamentExist.setQuantite(medicamentMisAJour.getQuantite());
    }

    // DELETE : Supprimer un médicament par nom
    public void deleteMedicament(String nom) throws ExceptionPharma {
        Medicament medicament = getMedicamentByNom(nom);
        medicaments.remove(medicament);
    }

    // Afficher tous les médicaments
    public void afficherMedicament() throws ExceptionPharma {
        if (medicaments.isEmpty()) {
            throw new ExceptionPharma("Aucun médicament à afficher !");
        }

        for (Medicament med : medicaments) {
            System.out.println(med);
        }
    }
}

