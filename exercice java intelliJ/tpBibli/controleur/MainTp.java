package tpBibli.controleur;
import java.time.LocalDate;

import tpBibli.modele.GestionAbonnés;
import tpBibli.modele.GestionPret;
import tpBibli.modele.GestionBook;


import tpBibli.exception.SaisieException;
import tpBibli.modele.Abonne;
import tpBibli.modele.Book;
import tpBibli.modele.Pret;
import tpBibli.vue.console.VueConsole;

public class MainTp {
    public static void main(String[] args) throws SaisieException {


        // Création d’un objet "gestionnaire" de liste d’abonnés
        GestionAbonnés gestion  = new GestionAbonnés();


        // Création de quelques abonnés
        Abonne a1 =  new Abonne("pedro" , "vero", "pedro.vero@yahoo.fr"  , LocalDate.of(2025,8,19));
        Abonne a2 = new Abonne("fernando" , "nathan" , "fernando.nathan@yahoo.fr" ,  LocalDate.of(2025,7,3));
        Abonne a3 = new Abonne( "domingo" , "rachel", "domingo.rachel@hotmail.fr", LocalDate.of(2025,8,11));


        // Ajout des abonnés à la liste

        gestion.ajouterAbonné(a1);
        gestion.ajouterAbonné(a2);
        gestion.ajouterAbonné(a3);

        // Création d’un objet "gestionnaire" de liste de livre
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


            choix = VueConsole.affichageMenu();

                        // controleur
            switch (choix) {
                case 1:
                    VueConsole.affichageSaisieCreationAbonne();
                    gestion.ajouterAbonné(new Abonne(VueConsole.getNom(), VueConsole.getPrenom(), VueConsole.getEmail(), VueConsole.getDateInscription()));
                    VueConsole.affichageMessage("✅ Abonné enregistré !");
                    break;

                case 2:
                    VueConsole.affichageSaisieCreationBook();
                    gestion2.ajouterBook(new Book(VueConsole.getTitre(), VueConsole.getAuteur(), VueConsole.getQuantite(), VueConsole.getIdentifiant()));
                    VueConsole.affichageMessage("✅ Livre enregistré !");
                    break;

                case 3:
                    VueConsole.affichageSaisieCreationPretAbo();
                    Abonne abonne = gestion.rechercherAbonné(VueConsole.getNomAbonne());


                    VueConsole.affichageSaisieCreationPretLivre();
                    Book book = gestion2.rechercherBook(VueConsole.getTitreLivre());

                    if (abonne != null && book != null) {
                        VueConsole.affichageMessage("Date début prêt (yyyy-MM-dd) : ");
                        VueConsole.saisieDate();

                        gestion3.ajouterPret(new Pret(Pret.getDateDebut(), abonne, book));
                        VueConsole.affichageMessage("✅ Prêt enregistré !");
                    } else {
                        VueConsole.affichageMessage("⚠️ Abonné ou livre introuvable !");
                    }
                    break;

                case 4:
                    System.out.println();
                    VueConsole.affichageMessage("Liste des abonnés:");
                    gestion.afficherAbonnés();

                    break;

                case 5:
                    System.out.println();
                    VueConsole.affichageMessage("Liste des livres:");
                    gestion2.afficherBook(); break;

                case 0:
                    VueConsole.affichageMessage("A bientot!");
                    break;

                default:
                    VueConsole.affichageMessage("⚠️ Choix invalide !");
            }

        } while (choix != 0);

        VueConsole.close();

    }
}