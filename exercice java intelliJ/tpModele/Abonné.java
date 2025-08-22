package tpModele;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Abonné {
    private String nom;
    private String prenom;
    private String email;
    private LocalDate dateInscription;
    private ArrayList<Abonné> listeAbonnés = new ArrayList<>();

    private final String REGEX_EMAIL =
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    private String REGEX_LETTRE = "^\\p{L}+$";

    // ✅ Regex : format "yyyy-MM-dd" (ex: 2025-08-19)
    private final String REGEX_DATE = "^\\d{4}-\\d{2}-\\d{2}$";


    public Abonné(String nom, String prenom, String email, LocalDate dateInscription) throws SaisieException {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setEmail(email);
        this.dateInscription = dateInscription;
    }
    public ArrayList<Abonné> getListeAbonnés(){
        return listeAbonnés;
    }

    public void setListeAbonnés(ArrayList<Abonné> listeAbonnés) {
        this.listeAbonnés = listeAbonnés;
    }

    public String getNom() {
        return this.nom;
    }
    public void setNom(String nom) throws SaisieException {

        if (nom == null || !nom.matches(REGEX_LETTRE)) {
            throw new SaisieException("Erreur dans le nom ! Merci de corriger");
        } else {
            this.nom = nom;
        }
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) throws SaisieException {

        if (prenom == null || !prenom.matches(REGEX_LETTRE)) {
            throw new SaisieException("Erreur dans le prenom ! Merci de corriger");
        } else {
            this.prenom = prenom.toUpperCase();
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email)  throws SaisieException {
        if(email == null || !email.matches(REGEX_EMAIL)){
            throw new SaisieException("Erreur dans l'email ! Merci de corriger");
        } else {
            this.email = email;
        }
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(String dateStr) throws SaisieException {
        // Vérifie la forme avec regex
        if (dateStr == null || !dateStr.matches(REGEX_DATE)) {
            throw new SaisieException("Erreur dans la date ! Format attendu : yyyy-MM-dd");
        }

        // Vérifie que la date existe vraiment
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.dateInscription = LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            throw new SaisieException("Date invalide (jour ou mois inexistant)");
        }
    }


    @Override
    public String toString() {
        return "Abonné[ nom= " + nom + " , prenom= " + prenom + " , email= " + email +
                " , dateInscription= " + dateInscription + "]";
    }


}
