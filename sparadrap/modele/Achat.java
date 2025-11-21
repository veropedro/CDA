package fr.afpa.pompey.cda22045.modele;

import fr.afpa.pompey.cda22045.ExceptionPharma;
import fr.afpa.pompey.cda22045.Regex;
import fr.afpa.pompey.cda22045.modele.GestionMedicament;
import fr.afpa.pompey.cda22045.DAO.MedicamentDAO;
import java.time.LocalDate;
import java.util.ArrayList;


public class Achat {
    int id;
    private LocalDate dateAchat;
    private Client client;
    private ArrayList<Medicament> medicamentsAchete;
    private boolean achatParOrdonnance;
    private Medecin medecin; // null si achat direct


    public Achat(int id, LocalDate dateAchat, Client client, ArrayList<Medicament> medicaments, boolean achatParOrdonnance, Medecin medecin) throws ExceptionPharma {
        this.setId(id);
        this.setDateAchat(dateAchat);
        this.setClient(client);
        this.setMedicamentsAchete(medicaments);
        this.setAchatParOrdonnance(achatParOrdonnance);
        this.setMedecin(medecin);
    }


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

    public LocalDate getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(LocalDate dateAchat) throws ExceptionPharma {
        // Vérification avec regex : format attendu yyyy-MM-dd
        if (!Regex.isValid(String.valueOf(dateAchat), Regex.DATE)) {
            throw new ExceptionPharma("Erreur dans la date ! Format attendu : yyyy-MM-dd");
        }
        this.dateAchat = dateAchat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) throws ExceptionPharma {
        if (client == null) {
            throw new ExceptionPharma("Le client ne peut pas être nul !");
        }
        this.client = client;
    }

    public ArrayList<Medicament> getMedicaments() {
        return medicamentsAchete;
    }

    public void setMedicamentsAchete(ArrayList<Medicament> medicamentsAchete) throws ExceptionPharma {
        if (medicamentsAchete == null || medicamentsAchete.isEmpty()) {
            throw new ExceptionPharma("La liste des médicaments achetés ne peut pas être vide !");
        }
        this.medicamentsAchete = medicamentsAchete;
    }


    public boolean isAchatParOrdonnance() {
        return achatParOrdonnance;
    }

    public void setAchatParOrdonnance(boolean achatParOrdonnance) {
        // Si on indique "achat par ordonnance = true" mais qu'aucun médecin n'est défini → incohérent
        if (achatParOrdonnance && this.medecin == null) {
            throw new IllegalArgumentException(
                    "Un achat par ordonnance nécessite un médecin valide."
            );
        }

        this.achatParOrdonnance = achatParOrdonnance;
    }



    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) throws ExceptionPharma {
        if (medecin == null) {
            throw new ExceptionPharma("Le médecin ne peut pas être nul !");
        }
        this.medecin = medecin;
    }

    @Override
    public String toString() {
        return "Achat [Date=" + dateAchat +
                ", Client=" + client.getNom() + " " + client.getPrenom() +
                ", Par ordonnance=" + (achatParOrdonnance ? "Oui" : "Non") +
                (achatParOrdonnance && medecin != null ? ", Médecin=" + medecin.getNom() + " " + medecin.getPrenom() : "") +
                ", Médicaments=" + medicamentsAchete.size() + "]";
    }
}

