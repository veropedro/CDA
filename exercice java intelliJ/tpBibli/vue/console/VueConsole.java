package tpBibli.vue.console;

import java.time.LocalDate;
import java.util.Scanner;

public class VueConsole {

    private static  Scanner sc = new Scanner(System.in);

    private static String nom, prenom, email , titre, auteur , identifiant ,nomAbonne ,titreLivre;
    private static int quantite;
    private static LocalDate dateInscription;

    public static String getNom() {
        return nom;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPrenom() {
        return prenom;
    }

    public static LocalDate getDateInscription() {
        return dateInscription;
    }

    public static String getTitre() {
        return titre;
    }

    public static String getAuteur() {
        return auteur;
    }

    public static String getIdentifiant() {
        return identifiant;
    }

    public static int getQuantite() {
        return quantite;
    }

    public static String getNomAbonne() {
        return nomAbonne;
    }

    public static String getTitreLivre() {
        return titreLivre;
    }



    public static int affichageMenu() {

        // vue
        System.out.println("\n===== MENU BIBLIOTHÈQUE =====");
        System.out.println("1. Enregistrer un nouvel abonné");
        System.out.println("2. Enregistrer un nouveau livre");
        System.out.println("3. Enregistrer un nouveau prêt");
        System.out.println("4. Afficher la liste des abonnés");
        System.out.println("5. Afficher la liste des livres");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");

        int choix = sc.nextInt();
        sc.nextLine(); // vider le buffer
        return choix; // vider le buffer

    }

    public static void affichageSaisieCreationAbonne() {
        System.out.print("Nom : ");
        nom = sc.nextLine();
        System.out.print("Prénom : ");
        prenom = sc.nextLine();
        System.out.print("Email : ");
        email = sc.nextLine();
        System.out.print("Date inscription (yyyy-MM-dd) : ");
        dateInscription = LocalDate.parse(sc.nextLine());
    }

    public static void affichageMessage(String message ) {
        System.out.println(message);
    }

    public static void close() {
        sc.close();
    }
    public static void affichageSaisieCreationBook() {

        System.out.print("Titre : ");
        titre = sc.nextLine();
        System.out.print("Auteur : ");
        auteur = sc.nextLine();
        System.out.print("Quantité : ");
        quantite = sc.nextInt();
        sc.nextLine();
        System.out.print("identifiant : ");
        identifiant = sc.nextLine();

    }

    public static void affichageSaisieCreationPretAbo() {

        System.out.print("Nom abonné : ");
        nomAbonne = sc.nextLine();

    }
    public static void affichageSaisieCreationPretLivre() {

        System.out.print("titre du livre : ");
        titreLivre = sc.nextLine();
    }

    public static void saisieDate() {
        LocalDate dateDebutStr = LocalDate.parse(sc.nextLine());
    }




}
