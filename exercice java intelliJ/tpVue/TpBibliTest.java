package tpVue;
import java.time.LocalDate;

import tpModele.Abonné;
import tpModele.Bibliothecaire;

import tpModele.*;

public class TpBibliTest {
    public static void main(String[] args) throws SaisieException {
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

        System.out.println("Liste des abonnés:");
        gestion.afficherAbonnés();

        System.out.println();
        System.out.println("Mise à jour de la liste des abonnés:");
        gestion.deleteAbonné("pedro");
        gestion.afficherAbonnés();

        System.out.println();
        Bibliothecaire biblio = new Bibliothecaire("pierre", "marine", "pm1");
        biblio.saisieAbonné(gestion);

        System.out.println();
        System.out.println("Mise à jour de la liste des abonnés:");
        gestion.afficherAbonnés();



        //-------------------------------


        // Création d’un objet "gestionnaire" de liste d’abonnés
        GestionBook gestion2  = new GestionBook();

        // Création de quelques abonnés
        Book b1 = new Book("lepetitprince", "stexupery", 2, "9780306406157");
        Book b2 = new Book("lou", "julienNeel", 1, "9780306406158");

        // Ajout des livre à la liste
        gestion2.ajouterBook(b1);
        gestion2.ajouterBook(b2);

        System.out.println();

        System.out.println("Liste des livres:");
        gestion2.afficherBook();


        //-------------------------------


        // Création d’un objet "gestionnaire" de liste de pret
        GestionPret gestion3  = new GestionPret();

        // Création de quelques abonnés
        Pret p1 = new Pret(LocalDate.of(2025,8,19), a1, b1);
        Pret p2 = new Pret(LocalDate.of(2025,7,5), a2, b1);

        // Ajout des livre à la liste
        gestion3.ajouterPret(p1);
        gestion3.ajouterPret(p2);

        System.out.println();

        System.out.println("Liste des prets:");
        gestion3.afficherPret();




    }

}
