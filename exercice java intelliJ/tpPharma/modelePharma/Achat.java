package tpPharma.modelePharma;
import java.time.LocalDate;
import java.util.ArrayList;


public class Achat {
    private LocalDate dateAchat;
    private Client client;
    private ArrayList<Medicament> medicamentsAchete;
    private boolean achatParOrdonnance;
    private Medecin medecin; // null si achat direct


    public Achat(LocalDate dateAchat, Client client, ArrayList<Medicament> medicaments, boolean achatParOrdonnance, Medecin medecin) {
        this.dateAchat = dateAchat;
        this.client = client;
        this.medicamentsAchete = medicaments;
        this.achatParOrdonnance = achatParOrdonnance;
        this.medecin = medecin;
    }


    public LocalDate getDateAchat() {
        return dateAchat;
    }

    public Client getClient() {
        return client;
    }

    public ArrayList<Medicament> getMedicaments() {
        return medicamentsAchete;
    }

    public boolean isAchatParOrdonnance() {
        return achatParOrdonnance;
    }

    public Medecin getMedecin() {
        return medecin;
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

