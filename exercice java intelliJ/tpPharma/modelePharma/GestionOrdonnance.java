package tpPharma.modelePharma;
import tpPharma.exceptionPharma.ExceptionPharma;

import java.util.ArrayList;
import java.util.Optional;

public class GestionOrdonnance {

    private ArrayList<Ordonnance> ordonnances;

    public GestionOrdonnance() {
        this.ordonnances = new ArrayList<>();
    }

    // CREATE : Ajouter une ordonnance
    public void ajouterOrdonnance(Ordonnance ordonnance) throws ExceptionPharma {
        if (ordonnance == null) {
            throw new ExceptionPharma("Ordonnance nulle impossible à ajouter !");
        }

        // Vérifier si l'ordonnance existe déjà (même date et même client)
        for (Ordonnance o : ordonnances) {
            if (o.getDateOrdonnance().equals(ordonnance.getDateOrdonnance()) &&
                    o.getClient().getNumeroSecu().equals(ordonnance.getClient().getNumeroSecu())) {
                throw new ExceptionPharma("Cette ordonnance existe déjà !");
            }
        }

        ordonnances.add(ordonnance);
    }

    // READ : Récupérer toutes les ordonnances
    public ArrayList<Ordonnance> getAllOrdonnances() {
        return new ArrayList<>(ordonnances); // renvoyer une copie pour protéger la liste interne
    }

    // READ : Récupérer une ordonnance par date et client
    public Ordonnance getOrdonnanceByDateAndClient(String date, String numSecuClient) throws ExceptionPharma {
        if (date == null || date.isEmpty() || numSecuClient == null || numSecuClient.isEmpty()) {
            throw new IllegalArgumentException("La date et le numéro de sécu ne peuvent pas être vides !");
        }

        for (Ordonnance o : ordonnances) {
            if (o.getDateOrdonnance().equals(date) &&
                    o.getClient().getNumeroSecu().equals(numSecuClient)) {
                return o;
            }
        }

        throw new ExceptionPharma("Ordonnance non trouvée !");
    }

    // READ : Afficher toutes les ordonnances d’un médecin
    public void afficherOrdonnanceParMedecin(String numeroAgreement) throws ExceptionPharma {
        if (ordonnances.isEmpty()) {
            throw new ExceptionPharma("⚠️ Aucune ordonnance enregistrée !");
        }

        boolean found = false;
        int i = 0;

        do {
            Ordonnance ordonnance = ordonnances.get(i);

            if (ordonnance.getMedecin().getNumeroAgreement().equals(numeroAgreement)) {
                System.out.println(ordonnance);
                found = true;
            }

            i++;
        } while (i < ordonnances.size());

        if (!found) {
            throw new ExceptionPharma("⚠️ Aucune ordonnance trouvée pour ce médecin !");
        }
    }

    // UPDATE : Modifier une ordonnance existante
    public void updateOrdonnance(String date, String numSecuClient, Ordonnance ordonnanceMiseAJour) throws ExceptionPharma {
        if (ordonnanceMiseAJour == null) {
            throw new IllegalArgumentException("L’ordonnance mise à jour ne peut pas être nulle !");
        }

        Ordonnance ordonnanceExist = getOrdonnanceByDateAndClient(date, numSecuClient);

        ordonnanceExist.setDateOrdonnance(ordonnanceMiseAJour.getDateOrdonnance());
        ordonnanceExist.setMedecin(ordonnanceMiseAJour.getMedecin());
        ordonnanceExist.setClient(ordonnanceMiseAJour.getClient());
        ordonnanceExist.setMedicamentsPrescrits(ordonnanceMiseAJour.getMedicamentsPrescrits());
    }

    // DELETE : Supprimer une ordonnance
    public void deleteOrdonnance(String date, String numSecuClient) throws ExceptionPharma {
        Ordonnance ordonnance = getOrdonnanceByDateAndClient(date, numSecuClient);
        ordonnances.remove(ordonnance);
    }

    // AFFICHAGE : Afficher toutes les ordonnances
    public void afficherOrdonnance() throws ExceptionPharma {
        if (ordonnances.isEmpty()) {
            throw new ExceptionPharma("⚠️ Aucune ordonnance enregistrée !");
        }

        for (Ordonnance o : ordonnances) {
            System.out.println(o);
        }
    }
}




