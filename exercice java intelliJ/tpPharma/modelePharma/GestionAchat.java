package tpPharma.modelePharma;
import tpPharma.exceptionPharma.ExceptionPharma;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestionAchat {


    // ====================== LISTE DES ACHATS ======================
    private ArrayList<Achat> achats; // Liste qui stocke tous les achats

    // Constructeur : initialise la liste vide
    public GestionAchat() {
        this.achats = new ArrayList<>();
    }


    // Ajouter un achat
    public void ajouterAchat(Achat achat) throws ExceptionPharma {
        if (achat == null) {
            throw new ExceptionPharma("Impossible d'ajouter un achat nul !");
        }

        // Vérifier que l'achat n'existe pas déjà dans la liste
        if (achats.contains(achat)) {
            throw new ExceptionPharma("Cet achat existe déjà !");
        }

        achats.add(achat);
    }

    // Retourner tous les achats
    public ArrayList<Achat> getAchats() {
        return new ArrayList<>(achats); // renvoyer une copie pour protéger la liste originale
    }

    // Retourner les achats d'un client précis
    public ArrayList<Achat> getAchatsParClient(String numeroSecu) throws ExceptionPharma {
        if (numeroSecu == null || numeroSecu.isEmpty()) {
            throw new IllegalArgumentException("Le numéro de sécu ne peut pas être vide !");
        }

        ArrayList<Achat> resultat = new ArrayList<>();
        for (Achat a : achats) {
            if (a.getClient().getNumeroSecu().equals(numeroSecu)) {
                resultat.add(a);
            }
        }

        if (resultat.isEmpty()) {
            throw new ExceptionPharma("Aucun achat trouvé pour ce client !");
        }

        return resultat;
    }

    // Supprimer un achat
    public void supprimerAchat(Achat achat) throws ExceptionPharma {
        if (achat == null) {
            throw new ExceptionPharma("Impossible de supprimer un achat nul !");
        }

        if (!achats.remove(achat)) {
            throw new ExceptionPharma("L'achat n'existe pas !");
        }
    }

    // Afficher tous les achats
    public void afficherAchat() throws ExceptionPharma {
        if (achats.isEmpty()) {
            throw new ExceptionPharma("Aucun achat à afficher !");
        }

        for (Achat a : achats) {
            System.out.println(a);
        }
    }
}