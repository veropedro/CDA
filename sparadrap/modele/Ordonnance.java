package fr.afpa.pompey.cda22045.modele;
import fr.afpa.pompey.cda22045.ExceptionPharma;
import fr.afpa.pompey.cda22045.Regex;

import java.util.ArrayList;

public class Ordonnance {
    // ✅ Attributs de l'ordonnance
    private int id;
    private String dateOrdonnance;                // Date de l'ordonnance
    private Medecin medecin;                      // Référence vers un objet Médecin
    private Client client;                        // Référence vers un objet Client
    private ArrayList<Medicament> medicamentsPrescrits; // Liste des médicaments prescrits dans l'ordonnance

    // ✅ Constructeur
    public Ordonnance(int id, String dateOrdonnance, Medecin medecin, Client client, ArrayList<Medicament> medicamentsPrescrits)
            throws ExceptionPharma {
        this.setId(id);
        this.setDateOrdonnance(dateOrdonnance);
        this.setMedecin(medecin);
        this.setClient(client);
        this.setMedicamentsPrescrits(medicamentsPrescrits);
    }

    // ✅ Getter et Setter : dateOrdonnance
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


    public String getDateOrdonnance() {
        return dateOrdonnance;
    }

    public void setDateOrdonnance(String dateOrdonnance) throws ExceptionPharma {
        // Vérification avec regex : format attendu yyyy-MM-dd
        if (!Regex.isValid(dateOrdonnance, Regex.DATE)) {
            throw new ExceptionPharma("Erreur dans la date ! Format attendu : yyyy-MM-dd");
        }
        this.dateOrdonnance = dateOrdonnance;
    }

    // ✅ Getter et Setter : medecin
    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) throws ExceptionPharma {
        if (medecin == null) {
            throw new ExceptionPharma("Le médecin ne peut pas être nul !");
        }
        this.medecin = medecin;
    }

    // ✅ Getter et Setter : client
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) throws ExceptionPharma {
        if (client == null) {
            throw new ExceptionPharma("Le client ne peut pas être nul !");
        }
        this.client = client;
    }

    // ✅ Getter et Setter : medicamentsPrescrits
    public ArrayList<Medicament> getMedicamentsPrescrits() {
        return medicamentsPrescrits;
    }

    public void setMedicamentsPrescrits(ArrayList<Medicament> medicamentsPrescrits) throws ExceptionPharma {
        if (medicamentsPrescrits == null || medicamentsPrescrits.isEmpty()) {
            throw new ExceptionPharma("La liste des médicaments prescrits ne peut pas être vide !");
        }
        this.medicamentsPrescrits = medicamentsPrescrits;
    }

    // ✅ Méthode pour ajouter un médicament à l’ordonnance
    public void ajouterMedicament(Medicament medicament) throws ExceptionPharma {
        if (medicament == null) {
            throw new ExceptionPharma("Impossible d'ajouter un médicament nul !");
        }
        this.medicamentsPrescrits.add(medicament);
    }

    // ✅ Méthode pour supprimer un médicament de l’ordonnance
    public void supprimerMedicament(Medicament medicament) throws ExceptionPharma {
        if (!this.medicamentsPrescrits.remove(medicament)) {
            throw new ExceptionPharma("Le médicament à supprimer n'existe pas dans l'ordonnance !");
        }
    }

    @Override
    public String toString() {
        return "Ordonnance [" +
                "dateOrdonnance: '" + dateOrdonnance + '\'' +
                ", medecin: " + medecin +
                ", client: " + client +
                ", medicamentsPrescrits: " + medicamentsPrescrits +
                ']';
    }
}

