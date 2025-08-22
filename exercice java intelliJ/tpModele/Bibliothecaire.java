package tpModele;
import tpModele.Saisie;
import tpModele.Abonné;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;


public class Bibliothecaire {
    private String nom;
    private String prenom;
    private String identifiant;
    public Abonné abonné;
    static Scanner sc = new Scanner(System.in);

    private String REGEX_LETTRE = "^\\p{L}+$";
    private static final String REGEX_IDENTIFIANT = "^[a-zA-Z0-9]{3,15}$";
    private final String REGEX_EMAIL =
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private final String REGEX_DATE = "^\\d{4}-\\d{2}-\\d{2}$";

    public Bibliothecaire(String nom, String prenom, String identifiant) throws SaisieException {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setIdentifiant(identifiant);
    }

    public String getNom() {

        return this.nom;
    }

    public void setNom(String nom)  throws SaisieException {
        if (nom == null || !nom.matches(REGEX_LETTRE)) {
            throw new SaisieException("Erreur dans le nom ! Merci de corriger");
        } else {
            this.nom = nom.toUpperCase();
        }
    }

    public String getPrenom() {

        return this.prenom;
    }

    public void setPrenom(String prenom) throws SaisieException {

        if (prenom == null || !prenom.matches(REGEX_LETTRE)) {
            throw new SaisieException("Erreur dans le prenom ! Merci de corriger");
        } else {
            this.prenom = prenom.toUpperCase();
        }
    }

    public String getIdentifiant() {

        return this.identifiant;
    }

    public void setIdentifiant(String identifiant)throws SaisieException {
        if (identifiant == null || !identifiant.matches(REGEX_IDENTIFIANT)) {
            throw new SaisieException("Identifiant invalide ! Il doit contenir 3 à 15 lettres ou chiffres.");
        }
        this.identifiant = identifiant;
    }

    @Override
    public String toString() {
        return "Bibliothecaire [ nom= " + nom + " , prenom= " + prenom + " , identifiant= " + identifiant + "]";
    }


    //saisie d'un nouvel abonné par bibliothecaire, dans la liste deja existante gestion
    public void saisieAbonné(GestionAbonnés gestion) throws SaisieException {

        System.out.println("saisie d'un nouvel abonné?");
        boolean erreur = true;

        String nom = "";
        do {
            System.out.println("veillez saisir le nom :");
            nom = sc.nextLine();
            if (!nom.matches(REGEX_LETTRE)) {
                System.err.println("La nom est incorrecte ! merci de resaisir");
            } else {
                erreur = false;
            }
        } while (erreur);
        erreur = true;

        System.out.println();

        String prenom = "";
        do {
            System.out.println("veillez saisir le prenom :");
            prenom = sc.nextLine();
            if (!prenom.matches(REGEX_LETTRE)) {
                System.err.println("La prenom est incorrecte ! merci de resaisir");
            } else {
                erreur = false;
            }
        } while (erreur);
        erreur = true;

        System.out.println();

        String email;
        do {
            System.out.println("veillez saisir l'email :");
            email = sc.nextLine();
            if (!email.matches(REGEX_EMAIL)) {
                System.err.println("L'email est incorrecte ! merci de resaisir");
            } else {
                erreur = false;
            }
        } while (erreur);
        erreur = true;


        System.out.println();

        LocalDate dateInscription;
        do {
            System.out.println("veillez saisir la date inscription (format : yyyy-MM-dd) : ");
            String date = sc.nextLine();
            dateInscription = LocalDate.parse(date);
            if (!date.matches(REGEX_DATE)) {
                System.err.println("La date inscription est incorrecte ! merci de resaisir");
            } else {
                erreur = false;
            }
        } while (erreur);

        erreur = true;

        Abonné nouvelAbonné = new Abonné(nom, prenom, email, dateInscription);

        // Ajout à la liste globale
        gestion.ajouterAbonné(nouvelAbonné);

        System.out.println("Abonné ajouté avec succès !");
    }


    //--------------------------

    //saisie d'un nouveau titre par bibliothecaire, dans la liste deja existante gestion
    public void saisieBooks(GestionBook gestion2) throws SaisieException {

        System.out.println("saisie d'un nouvel livre?");
        boolean erreur = true;

        String titre = "";
        do {
            System.out.println("veillez saisir le titre :");
            titre = sc.nextLine();
            if (!titre.matches(REGEX_LETTRE)) {
                System.err.println("La titre est incorrecte ! merci de resaisir");
            } else {
                erreur = false;
            }
        } while (erreur);
        erreur = true;

        System.out.println();

        String auteur = "";
        do {
            System.out.println("veillez saisir l'auteur :");
            auteur = sc.nextLine();
            if (!auteur.matches(REGEX_LETTRE)) {
                System.err.println("L'auteur est incorrecte ! merci de resaisir");
            } else {
                erreur = false;
            }
        } while (erreur);
        erreur = true;

        System.out.println();

        int quantité = 0;
        do {
            System.out.println("Veuillez saisir la quantité :");
            String saisie = sc.nextLine(); // on lit d'abord en String
            if (!saisie.matches("^\\d+$")) { // regex pour uniquement des chiffres
                System.err.println("La quantité est incorrecte ! Merci de resaisir");
            } else {
                quantité = Integer.parseInt(saisie); // conversion en int
                erreur = false;
            }
        } while (erreur);


        System.out.println();

        String identifiant;
        do {
            System.out.println("veillez saisir l'identifiant :");
            identifiant = sc.nextLine();
            if (!identifiant.matches(REGEX_IDENTIFIANT)) {
                System.err.println("L'identifiant est incorrecte ! merci de resaisir");
            } else {
                erreur = false;
            }
        } while (erreur);
        erreur = true;

        Book nouveauBook = new Book(titre, auteur, quantité, identifiant);

        // Ajout à la liste globale
        gestion2.ajouterBook(nouveauBook);

        System.out.println("Abonné ajouté avec succès !");
    }



}
