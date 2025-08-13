package vue.controller.modele;
import java.time.LocalDate;
import java.util.ArrayList;

public class Groupe {
    private String nom;
    private ArrayList<Guerrier> guerriers = new ArrayList<>();
    private ArrayList<Soigneur> soigneurs = new ArrayList<>();
    private LocalDate date;

    public Groupe(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }

    public LocalDate getDate() {
        return this.date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void ajouterGuerrier(Guerrier g) {
        guerriers.add(g);
    }

    public void ajouterSoigneur(Soigneur s) {
        soigneurs.add(s);
    }

    public void afficherGuerriers() {
        for (Guerrier g : guerriers) {
            System.out.println(g);
        }
    }

    public void afficherSoigneurs() {
        for (Soigneur s : soigneurs) {
            System.out.println(s);
        }
    }
}
