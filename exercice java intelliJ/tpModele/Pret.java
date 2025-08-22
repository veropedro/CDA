package tpModele;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Pret {
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Abonné abonné;
    private Book book;

    // ✅ Regex : format "yyyy-MM-dd" (ex: 2025-08-19)
    private final String REGEX_DATE = "^\\d{4}-\\d{2}-\\d{2}$";


    public Pret(LocalDate dateDebut, Abonné abonné, Book book) {
        this.dateDebut = dateDebut;
        this.dateFin = dateDebut.plusDays(7);
        this.abonné = abonné;
        this.book = book;

    }

    public LocalDate getDateDebut() {
        return this.dateDebut;
    }

    public void setDateDebut(String dateStr) throws SaisieException {
        // Vérifie la forme avec regex
        if (dateStr == null || !dateStr.matches(REGEX_DATE)) {
            throw new SaisieException("Erreur dans la date ! Format attendu : yyyy-MM-dd");
        }

        // Vérifie que la date existe vraiment
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.dateDebut = LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            throw new SaisieException("Date invalide (jour ou mois inexistant)");
        }
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "Prêt de '" + book.getTitre() + "' à " + abonné.getNom() + " " + abonné.getPrenom() +
                " [Début = " + dateDebut + ", Fin = " + dateFin + "]";
    }

}
