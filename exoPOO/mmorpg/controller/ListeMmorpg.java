package vue.controller;
import java.util.ArrayList;
import java.util.Scanner;

import vue.controller.modele.Voleur;
import vue.controller.modele.Guerrier;
import vue.controller.modele.Soigneur;


public class ListeMmorpg {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Voleur> voleurs = new ArrayList<>();
    private ArrayList<Guerrier> guerriers = new ArrayList<>();
    private ArrayList<Soigneur> soigneurs = new ArrayList<>();




    public ListeMmorpg() {
        voleurs.add(new Voleur("shadow", "voleur", "humain", 1, 100 ,1));
        voleurs.add(new Voleur("night", "voleur", "humain", 3, 100 ,10));

        guerriers.add(new Guerrier("Sacha", "guerrier", "humain", 1, 100, 1));
        guerriers.add(new Guerrier("thor", "guerrier", "humain", 2, 80, 5));

        soigneurs.add(new Soigneur("Mia", "soigneur", "humain", 1, 100, 1));
        soigneurs.add(new Soigneur("Ares", "soigneur", "humain", 1, 100, 1));


    }
    public ArrayList<Voleur> getVoleurs() {
        return voleurs;
    }
    public ArrayList<Guerrier> getGuerriers() {
        return guerriers;
    }
    public ArrayList<Soigneur> getSoigneurs() {
        return soigneurs;
    }

    public void ajouterPersonnage(String nom, String classe, String race, int niveau, int pdv, int stat) {
        switch (classe) {
            case "voleur":
                voleurs.add(new Voleur(nom, classe, race, niveau, pdv, stat));
                break;
            case "guerrier":
                guerriers.add(new Guerrier(nom, classe, race, niveau, pdv, stat));
                break;
            case "soigneur":
                soigneurs.add(new Soigneur(nom, classe, race, niveau, pdv, stat));
                break;
            default:
                System.out.println("Classe inconnue !");
        }
    }



}
