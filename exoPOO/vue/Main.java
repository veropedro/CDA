package vue;

import vue.controller.ListeMmorpg;
import vue.controller.modele.Guerrier;
import vue.controller.modele.Soigneur;
import vue.controller.modele.Voleur;
import java.util.Scanner;
import vue.controller.modele.Groupe;
import java.time.LocalDate;



public class Main {
    private Scanner scanner = new Scanner(System.in);

    public String demanderNom() {
        System.out.print("Nom du personnage : ");
        return scanner.nextLine();
    }

    public String demanderRace() {
        System.out.print("Race du personnage : ");
        return scanner.nextLine();
    }

    public String demanderClasse() {
        System.out.print("Classe (guerrier / voleur / soigneur) : ");
        return scanner.nextLine().toLowerCase();
    }

    public int demanderNiveau() {
        System.out.print("Niveau : ");
        return scanner.nextInt();
    }

    public int demanderPdv() {
        System.out.print("Points de vie : ");
        return scanner.nextInt();
    }

    public int demanderStat() {
        System.out.print("Stat spéciale : ");
        return scanner.nextInt();
    }



    public static void main(String[] args) {
        ListeMmorpg liste = new ListeMmorpg();
        Main vue = new Main();
        Groupe monGroupe = new Groupe("les Heros");


        // Ajouter des personnages au groupe
        monGroupe.ajouterGuerrier(new Guerrier("Paf", "Elfe", "guerrier", 1, 100, 1));
        monGroupe.ajouterSoigneur(new Soigneur("Mickey", "Gnome", "soigneur", 2, 100, 2));
        monGroupe.setDate(LocalDate.of(2025, 8, 13));


        // Afficher le groupe
        System.out.println("Groupe : " + monGroupe.getNom());
        monGroupe.afficherGuerriers();
        monGroupe.afficherSoigneurs();
        System.out.println("Date de l'événement : " + monGroupe.getDate());
        System.out.println();

        // Exemple simple : on demande un personnage à l'utilisateur et on l'ajoute
        String nom = vue.demanderNom();
        String race = vue.demanderRace();
        String classe = vue.demanderClasse();
        int niveau = vue.demanderNiveau();
        int pdv = vue.demanderPdv();
        int stat = vue.demanderStat();

        liste.ajouterPersonnage(nom, classe, race, niveau, pdv, stat);

        System.out.println("\n=== Voleurs ===");
        for (Voleur v : liste.getVoleurs()) {
            System.out.println(v);
        }
        System.out.println("\n=== Guerriers ===");
        for (Guerrier g : liste.getGuerriers()) {
            System.out.println(g);
        }
        System.out.println("\n=== Soigneurs ===");
        for (Soigneur s : liste.getSoigneurs()) {
            System.out.println(s);
        }

    }
}
