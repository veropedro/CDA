package tpController;
import java.time.LocalDate;
import java.util.Scanner;
import tpModele.GestionAbonnés;
import tpModele.GestionPret;
import tpModele.GestionBook;


import tpModele.*;

public class MainTp {
    public static void main(String[] args) throws SaisieException {
        Scanner sc = new Scanner(System.in);

        // Création d’un objet "gestionnaire" de liste d’abonnés
        GestionAbonnés gestion  = new GestionAbonnés();


        // Création de quelques abonnés
        Abonné a1 =  new Abonné("pedro" , "vero", "pedro.vero@yahoo.fr"  , LocalDate.of(2025,8,19));
        Abonné a2 = new Abonné("fernando" , "nathan" , "fernando.nathan@yahoo.fr" ,  LocalDate.of(2025,7,3));
        Abonné a3 = new Abonné( "domingo" , "rachel", "domingo.rachel@hotmail.fr", LocalDate.of(2025,8,11));


        // Ajout des abonnés à la liste

        gestion.ajouterAbonné(a1);
        gestion.ajouterAbonné(a2);
        gestion.ajouterAbonné(a3);

        // Création d’un objet "gestionnaire" de liste d’abonnés
        GestionBook gestion2  = new GestionBook();

        // Création de quelques abonnés
        Book b1 = new Book("lepetitprince", "stexupery", 2, "9780306406157");
        Book b2 = new Book("lou", "julienNeel", 1, "9780306406158");

        // Ajout des livre à la liste
        gestion2.ajouterBook(b1);
        gestion2.ajouterBook(b2);

        System.out.println();


        // Création d’un objet "gestionnaire" de liste de pret
        GestionPret gestion3  = new GestionPret();

        // Création de quelques abonnés
        Pret p1 = new Pret(LocalDate.of(2025,8,19), a1, b1);
        Pret p2 = new Pret(LocalDate.of(2025,7,5), a2, b1);

        // Ajout des livre à la liste
        gestion3.ajouterPret(p1);
        gestion3.ajouterPret(p2);

        System.out.println();



        int choix;

        do {
            System.out.println("\n===== MENU BIBLIOTHÈQUE =====");
            System.out.println("1. Enregistrer un nouvel abonné");
            System.out.println("2. Enregistrer un nouveau livre");
            System.out.println("3. Enregistrer un nouveau prêt");
            System.out.println("4. Afficher la liste des abonnés");
            System.out.println("5. Afficher la liste des livres");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            choix = sc.nextInt();
            sc.nextLine(); // vider le buffer

            switch (choix) {
                case 1:
                    System.out.print("Nom : ");
                    String nom = sc.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = sc.nextLine();
                    System.out.print("Email : ");
                    String email = sc.nextLine();
                    System.out.print("Date inscription (yyyy-MM-dd) : ");
                    LocalDate dateInscription = LocalDate.parse(sc.nextLine());
                    gestion.ajouterAbonné(new Abonné(nom, prenom, email, dateInscription));
                    System.out.println("✅ Abonné enregistré !");
                    break;

                case 2:
                    System.out.print("Titre : ");
                    String titre = sc.nextLine();
                    System.out.print("Auteur : ");
                    String auteur = sc.nextLine();
                    System.out.print("Quantité : ");
                    int quantité = sc.nextInt();
                    sc.nextLine();
                    System.out.print("identifiant : ");
                    String identifiant = sc.nextLine();
                    gestion2.ajouterBook(new Book(titre, auteur, quantité, identifiant));
                    System.out.println("✅ Livre enregistré !");
                    break;

                case 3:
                    System.out.print("Nom abonné : ");
                    String nomAbonné = sc.nextLine();

                    Abonné abonné = gestion.rechercherAbonné(nomAbonné);

                    System.out.print("titre du livre : ");
                    String titreLivre = sc.nextLine();

                    Book book = gestion2.rechercherBook(titreLivre);

                    if (abonné != null && book != null) {
                        System.out.print("Date début prêt (yyyy-MM-dd) : ");
                        LocalDate dateDebutStr = LocalDate.parse(sc.nextLine());

                        Pret pret = new Pret(dateDebutStr, abonné, book);
                        gestion3.ajouterPret(pret);
                        System.out.println("✅ Prêt enregistré !");
                    } else {
                        System.out.println("⚠️ Abonné ou livre introuvable !");
                    }
                    break;

                case 4:
                    System.out.println();
                    System.out.println("Liste des abonnés:");
                    gestion.afficherAbonnés();

                    break;

                case 5:
                    System.out.println();
                    System.out.println("Liste des livres:");
                    gestion2.afficherBook(); break;

                case 0:
                    System.out.println("A bientot!");
                    break;

                default:
                    System.out.println("⚠️ Choix invalide !");
            }

        } while (choix != 0);

        sc.close();
    }
}