package fr.afpa.pompey.cda22045.modeleSwing;
import java.util.Date;

public class Pret {
    private Integer id_livre;
    private Integer id_abonne;
    private Date date;
    private int dureeMax;

    public Pret(int id_livre, int id_abonne, Date date, int dureeMax) {
        this.setId_livre(id_livre);
        this.setId_abonne(id_abonne);
        this.setDate(date);
        this.setDureeMax(dureeMax);
    }

    public int getId_livre() {
        return id_livre;
    }

    public void setId_livre(int id_livre) {
        this.id_livre = id_livre;
    }

    public int getId_abonne() {
        return id_abonne;
    }

    public void setId_abonne(int id_abonne) {
        this.id_abonne = id_abonne;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDureeMax() {
        return dureeMax;
    }

    public void setDureeMax(int dureeMax) {
        this.dureeMax = dureeMax;
    }
}
