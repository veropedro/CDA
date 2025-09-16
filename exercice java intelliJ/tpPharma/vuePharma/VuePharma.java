package tpPharma.vuePharma;
import tpPharma.exceptionPharma.ExceptionPharma;
import tpPharma.modelePharma.*;
import tpPharma.regexPharma.Regex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class VuePharma {
    private static  Scanner sc = new Scanner(System.in);

    private static String nom, prenom, ville, adresse, codePostal, email,telephone, client ,medicamentsAchete , categorie,
            medecin, medecinTraitant, numeroSecu, mutuelle, numeroAgreement;
    private static double prix;
    private static int quantite;
    private static LocalDate dateService, dateAchat, dateNaissance;



    public static String getNumeroAgreement() {
        return numeroAgreement;
    }

    public static String getNom() {
        return nom;
    }

    public static String getCategorie() {
        return categorie;
    }

    public static double  getPrix() {
        return prix;
    }

    public static int getQuantite() {
        return quantite;
    }

    public static LocalDate getDateService() {
        return dateService;
    }

    public static LocalDate getDateAchat() {
        return dateAchat;
    }

    public static String getClient() {
        return client;
    }

    public static String getMedicamentsAchete() {
        return medicamentsAchete;
    }

    public static String getMedecin() {
        return medecin;
    }

    public static String getEmail() {
        return email;
    }

    public static String getTelephone() {
        return telephone;
    }

    public static String getMutuelle() {
        return mutuelle;
    }

    public static LocalDate getDateNaissance() {
        return dateNaissance;
    }


    public static String getNumeroSecu() {
        return numeroSecu;
    }

    public static int affichageMenu() {

        // vue
        System.out.println("\n===== MENU BIBLIOTHÈQUE =====");
        System.out.println("1. Effectuer un achat");
        System.out.println("2. Consulter l'historique des achats");
        System.out.println("3. Consulter les médecins");
        System.out.println("4. Consulter les clients");
        System.out.println("5. Consulter les ordonnances");
        System.out.println("6. Précèdent");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");

        int choix = sc.nextInt();
        sc.nextLine(); // vider le buffer
        return choix; // vider le buffer

    }

    public static int affichageSousMenuAchat() {

        // vue
        System.out.println("\n=== Achat ===");
        System.out.println("1. Achat direct");
        System.out.println("2. Achat via ordonnance");
        System.out.println("3. Précèdent");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");

        int choix = sc.nextInt();
        sc.nextLine(); // vider le buffer
        return choix; // vider le buffer

    }

    public static int affichageSousMenuAchat2() {

        // vue
        System.out.println("\n=== Historique des achats ===");
        System.out.println("1. Liste des achats");
        System.out.println("2. Selectionner un achat");
        System.out.println("3. Précèdent");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");

        int choix = sc.nextInt();
        sc.nextLine(); // vider le buffer
        return choix; // vider le buffer

    }



    public static int affichageSousMenuClient() {

        // vue
        System.out.println("\n=== Client ===");
        System.out.println("1. Liste des clients");
        System.out.println("2. Modification des informations du client");
        System.out.println("3. Supprimer un client");
        System.out.println("4. Créer un nouveau client");
        System.out.println("5. Selectionner un client");
        System.out.println("6. Précèdent");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");

        int choix = sc.nextInt();
        sc.nextLine(); // vider le buffer
        return choix; // vider le buffer

    }

    public static int affichageSousMenuMedecin() {

        // vue
        System.out.println("\n=== Medecin ===");
        System.out.println("1. Liste des medecins");
        System.out.println("2. Modification des informations du medecins");
        System.out.println("3. Supprimer un medecins");
        System.out.println("4. Créer un nouveau medecins");
        System.out.println("5. Selectionner un medecins");
        System.out.println("6. historique des ordonnances d'un medecin");
        System.out.println("7. Précèdent");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");

        int choix = sc.nextInt();
        sc.nextLine(); // vider le buffer
        return choix; // vider le buffer

    }

    public static int affichageSousMenuOrdonnance() {

        // vue
        System.out.println("\n=== Ordonnance ===");
        System.out.println("1. liste des ordonnances");
        System.out.println("2. Selectionner une ordonnance");
        System.out.println("3. Précèdent");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");

        int choix = sc.nextInt();
        sc.nextLine(); // vider le buffer
        return choix; // vider le buffer

    }

    public static void affichageMessage(String message ) {
        System.out.println(message);
    }


    //Comme un achat peut contenir plusieurs médicaments, tu demandes à l’utilisateur combien il veut en ajouter
    public static ArrayList<Medicament> saisieListeMedicaments() {
        ArrayList<Medicament> liste = new ArrayList<>();
        int nb = 0;

        // Saisie défensive du nombre de médicaments
        do {
            System.out.print("Combien de médicaments voulez-vous acheter ? ");
            String input = sc.nextLine().trim();
            try {
                nb = Integer.parseInt(input);
                if (nb <= 0) {
                    System.out.println("⚠️ Le nombre doit être positif !");
                    nb = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrée invalide ! Veuillez entrer un nombre entier.");
                nb = 0;
            }
        } while (nb <= 0);

        // Saisie des médicaments
        for (int i = 0; i < nb; i++) {
            System.out.println("\n➡️ Médicament n°" + (i + 1));
            liste.add(saisieMedicament()); // on appelle la méthode défensive existante
        }

        return liste;
    }

    public static Medicament saisieMedicament() {

        do {
            System.out.print("Nom : ");
            nom = sc.nextLine().trim();
            if (!Regex.isValid(nom, Regex.LETTRE)) {
                System.out.println("⚠️ Nom invalide ! Merci d'utiliser uniquement des lettres.");
                nom = "";
            }
        } while (nom.isEmpty());

        do {
            System.out.print("Catégorie : ");
            categorie = sc.nextLine().trim();
            if (!Regex.isValid(categorie, Regex.LETTRE)) {
                System.out.println("⚠️ Categorie invalide ! Merci d'utiliser uniquement des lettres.");
                categorie = "";
            }
        } while (categorie.isEmpty());

        // Prix
        do {
            System.out.print("Prix (ex : 1.1) : ");
            String input = sc.nextLine().trim();
            try {
                prix = Double.parseDouble(input);
                if (prix < 0) {
                    System.out.println("⚠️ Le prix ne peut pas être négatif !");
                    prix = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Prix invalide !");
                prix = -1;
            }
        } while (prix < 0);

        // Date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        do {
            System.out.print("Date de mise en service (yyyy-MM-dd) : ");
            String input = sc.nextLine().trim();
            try {
                dateService = LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("⚠️ Date invalide !");
                dateService = null;
            }
        } while (dateService == null);

        // Quantité
        do {
            System.out.print("Quantité : ");
            String input = sc.nextLine().trim();
            try {
                quantite = Integer.parseInt(input);
                if (quantite < 0) {
                    System.out.println("⚠️ La quantité ne peut pas être négative !");
                    quantite = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Quantité invalide !");
                quantite = -1;
            }
        } while (quantite < 0);

        return new Medicament(nom, categorie, prix, dateService, quantite);
    }

    public static void selectionnerAchat(GestionAchat gestionAchat) throws ExceptionPharma {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez le numéro de sécurité sociale du client : ");
        String numSecu = sc.nextLine();

        // Récupérer tous les achats de ce client
        ArrayList<Achat> achatsClient = gestionAchat.getAchatsParClient(numSecu);

        if (achatsClient.isEmpty()) {
            System.out.println("⚠️ Aucun achat trouvé pour ce client.");
            return;
        }

        // Si plusieurs achats, on demande lequel afficher
        System.out.println("Le client a " + achatsClient.size() + " achat(s).");
        for (int i = 0; i < achatsClient.size(); i++) {
            Achat a = achatsClient.get(i);
            System.out.println((i + 1) + ". Achat du " + a.getDateAchat() +
                    " - " + a.getMedicaments().size() + " médicament(s)" +
                    (a.isAchatParOrdonnance() ? " (Avec ordonnance)" : " (Sans ordonnance)"));
        }

        int choix = -1;
        do {
            System.out.print("Sélectionnez le numéro de l'achat à afficher : ");
            try {
                choix = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrée invalide, veuillez entrer un nombre.");
                continue;
            }
        } while (choix < 1 || choix > achatsClient.size());

        Achat achat = achatsClient.get(choix - 1);

        // Affichage des détails de l'achat
        System.out.println();
        System.out.println("---- Détails de l'achat ----");
        System.out.println("Date : " + achat.getDateAchat());
        System.out.println("Client : " + achat.getClient().getNom() + " " + achat.getClient().getPrenom());
        System.out.println("Par ordonnance : " + (achat.isAchatParOrdonnance() ? "Oui" : "Non"));
        if (achat.isAchatParOrdonnance() && achat.getMedecin() != null) {
            System.out.println("Médecin : " + achat.getMedecin().getNom() + " " + achat.getMedecin().getPrenom());
        }
        System.out.println();
        System.out.println("Médicaments :");
        for (Medicament m : achat.getMedicaments()) {
            System.out.println(m.getNom() + "(" + m.getCategorie() + ") \n Prix : " + m.getPrix() + "€ \n Qté : " + m.getQuantite());
        }
        System.out.println("----------------------------");
    }

    public static void afficherOrdonnanceMedecin(GestionOrdonnance gestionOrdonnance) throws ExceptionPharma {

        System.out.print("De quel medecin voulez-vous voir l'historique des ordonnances? ");
        String numeroAgreement = sc.nextLine();

        // Affiche tous les ordonnances de ce medecin
        gestionOrdonnance.afficherOrdonnanceParMedecin(numeroAgreement);
    }



    public static void affichageSaisieAchat() {
        System.out.print("la date d'achat (yyyy-MM-dd) : ");
        dateAchat = LocalDate.parse(sc.nextLine());
        System.out.print("client : ");
        client = sc.nextLine();
        System.out.print("medicament acheté : ");
        medicamentsAchete = sc.nextLine();
        System.out.print("medecin : ");
        medecin = sc.nextLine();
    }

    public static Client saisieClient() throws ExceptionPharma {
        System.out.println("Informations du client : ");
        // Nom
        do {
            System.out.print("Nom : ");
            nom = sc.nextLine().trim();
            if (!Regex.isValid(nom, Regex.LETTRE)) {
                System.out.println("⚠️ Nom invalide ! Merci d'utiliser uniquement des lettres.");
                nom = "";
            }
        } while (nom.isEmpty());

        // Prénom
        do {
            System.out.print("Prénom : ");
            prenom = sc.nextLine().trim();
            if (!Regex.isValid(prenom, Regex.LETTRE)) {
                System.out.println("⚠️ Prénom invalide ! Merci d'utiliser uniquement des lettres.");
                prenom = "";
            }
        } while (prenom.isEmpty());

        // Adresse (pas de regex stricte, juste non vide)
        do {
            System.out.print("Adresse : ");
            adresse = sc.nextLine().trim();
            if (adresse.isEmpty()) {
                System.out.println("⚠️ L'adresse ne peut pas être vide !");
            }
        } while (adresse.isEmpty());

        // Code postal
        do {
            System.out.print("Code postal : ");
            codePostal = sc.nextLine().trim();
            if (!Regex.isValid(codePostal, Regex.CODE_POSTAL)) {
                System.out.println("⚠️ Code postal invalide ! (Exemple : 54000)");
                codePostal = "";
            }
        } while (codePostal.isEmpty());

        // Ville
        do {
            System.out.print("Ville : ");
            ville = sc.nextLine().trim();
            if (!Regex.isValid(ville, Regex.LETTRE)) {
                System.out.println("⚠️ Ville invalide ! Merci d'utiliser uniquement des lettres.");
                ville = "";
            }
        } while (ville.isEmpty());

        // Téléphone
        do {
            System.out.print("Téléphone : ");
            telephone = sc.nextLine().trim();
            if (!Regex.isValid(telephone, Regex.TELEPHONE)) {
                System.out.println("⚠️ Téléphone invalide ! Format attendu : 0612345678");
                telephone = "";
            }
        } while (telephone.isEmpty());

        // Email
        do {
            System.out.print("Email : ");
            email = sc.nextLine().trim();
            if (!Regex.isValid(email, Regex.EMAIL)) {
                System.out.println("⚠️ Email invalide ! Exemple : exemple@mail.com");
                email = "";
            }
        } while (email.isEmpty());

        // Numéro de sécurité sociale
        do {
            System.out.print("Numéro de sécurité sociale : ");
            numeroSecu = sc.nextLine().trim();
            if (!Regex.isValid(numeroSecu, Regex.SECURITE_SOCIALE)) {
                System.out.println("⚠️ Numéro de sécurité sociale invalide ! Format attendu : 15 chiffres valides.");
                numeroSecu = "";
            }
        } while (numeroSecu.isEmpty());

        // Date de naissance
        while (true) {
            System.out.print("Date de naissance (yyyy-MM-dd) : ");
            String saisieDate = sc.nextLine().trim();

            if (!Regex.isValid(saisieDate, Regex.DATE)) {
                System.out.println("⚠️ Format invalide ! Exemple attendu : 2000-12-05");
                continue;
            }

            try {
                dateNaissance = LocalDate.parse(saisieDate);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("⚠️ Date invalide (jour ou mois incorrect)");
            }
        }

        // Mutuelle
        do {
            System.out.print("Nom mutuelle : ");
            mutuelle = sc.nextLine().trim();
            if (!Regex.isValid(mutuelle, Regex.LETTRE)) {
                System.out.println("⚠️ Nom de mutuelle invalide !");
                mutuelle = "";
            }
        } while (mutuelle.isEmpty());

        // Médecin traitant
        do {
            System.out.print("Médecin traitant : ");
            medecinTraitant = sc.nextLine().trim();
            if (!Regex.isValid(medecinTraitant, Regex.LETTRE)) {
                System.out.println("⚠️ Nom du médecin invalide !");
                medecinTraitant = "";
            }
        } while (medecinTraitant.isEmpty());

        return new Client(
                nom, prenom, adresse, codePostal, ville, telephone,
                email, numeroSecu, dateNaissance, mutuelle, medecinTraitant
        );
    }


    public static void supprimerClient(GestionClient gestionClient) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez le numéro de sécurité sociale du client à supprimer : ");
        String numSecu = sc.nextLine();

        try {
            gestionClient.deleteClient(numSecu);
            System.out.println("✅ Client supprimé !");
        } catch (ExceptionPharma e) {
            System.out.println("⚠️Impossible de supprimer le client : ce numéro de sécurité sociale n'existe pas. " + e.getMessage());
        }
    }


    public static void modifierClient(GestionClient gestionClient) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez le numéro de sécurité sociale du client à modifier : ");
        String numSecu = sc.nextLine();

        try {
            // Récupérer le client existant
            Client clientExistant = gestionClient.getClientByNumeroSecu(numSecu);

            System.out.println("Saisir les nouvelles informations (laisser vide pour ne pas changer) :");

            // Nom
            String nom; // Déclaration d'une variable de type chaîne pour stocker le nom

            do { // Faire…tant que
                System.out.print("Nom (" + clientExistant.getNom() + ") : ");
                // Affiche "Nom (valeur actuelle) : " pour inviter l'utilisateur à saisir

                nom = sc.nextLine().trim();
                // Lire la ligne saisie par l'utilisateur et enlever les espaces au début et à la fin

                if (!nom.isEmpty() && !Regex.isValid(nom, Regex.LETTRE)) {
                    // Si la saisie n'est pas vide ET que le nom n'est pas valide (contient autre chose que des lettres)

                    System.out.println("⚠️ Nom invalide ! Utilisez uniquement des lettres.");
                    // Affiche un message d'erreur

                    nom = null; // Met nom à null pour forcer la ré-saisie
                }
            } while (nom == null);
             // Répète la saisie tant que nom est null (c'est-à-dire tant qu'il y a une erreur)

            if (!nom.isEmpty()) clientExistant.setNom(nom);
            // Si l'utilisateur a saisi quelque chose, mettre à jour le nom du client existant


            // Prénom
            String prenom;
            do {
                System.out.print("Prénom (" + clientExistant.getPrenom() + ") : ");
                prenom = sc.nextLine().trim();
                if (!prenom.isEmpty() && !Regex.isValid(prenom, Regex.LETTRE)) {
                    System.out.println("⚠️ Prénom invalide ! Utilisez uniquement des lettres.");
                    prenom = null;
                }
            } while (prenom == null);
            if (!prenom.isEmpty()) clientExistant.setPrenom(prenom);

            // Adresse
            System.out.print("Adresse (" + clientExistant.getAdresse() + ") : ");
            String adresse = sc.nextLine();
            if (!adresse.isEmpty()) clientExistant.setAdresse(adresse);

            // Code postal
            String codePostal;
            do {
                System.out.print("Code postal (" + clientExistant.getCodePostal() + ") : ");
                codePostal = sc.nextLine().trim();
                if (!codePostal.isEmpty() && !Regex.isValid(codePostal, Regex.CODE_POSTAL)) {
                    System.out.println("⚠️ Code postal invalide !");
                    codePostal = null;
                }
            } while (codePostal == null);
            if (!codePostal.isEmpty()) clientExistant.setCodePostal(codePostal);

            // Ville
            String ville;
            do {
                System.out.print("Ville (" + clientExistant.getVille() + ") : ");
                ville = sc.nextLine().trim();
                if (!ville.isEmpty() && !Regex.isValid(ville, Regex.LETTRE)) {
                    System.out.println("⚠️ Ville invalide ! Utilisez uniquement des lettres.");
                    ville = null;
                }
            } while (ville == null);
            if (!ville.isEmpty()) clientExistant.setVille(ville);

            // Téléphone
            String telephone;
            do {
                System.out.print("Téléphone (" + clientExistant.getTelephone() + ") : ");
                telephone = sc.nextLine().trim();
                if (!telephone.isEmpty() && !Regex.isValid(telephone, Regex.TELEPHONE)) {
                    System.out.println("⚠️ Téléphone invalide !");
                    telephone = null;
                }
            } while (telephone == null);
            if (!telephone.isEmpty()) clientExistant.setTelephone(telephone);

            // Email
            String email;
            do {
                System.out.print("Email (" + clientExistant.getEmail() + ") : ");
                email = sc.nextLine().trim();
                if (!email.isEmpty() && !Regex.isValid(email, Regex.EMAIL)) {
                    System.out.println("⚠️ Email invalide !");
                    email = null;
                }
            } while (email == null);
            if (!email.isEmpty()) clientExistant.setEmail(email);

            // Date de naissance
            LocalDate dateNaissance = null;
            do {
                System.out.print("Date de naissance (" + clientExistant.getDateNaissance() + ") yyyy-MM-dd : ");
                String input = sc.nextLine().trim();
                if (input.isEmpty()) break; // pas de modification
                try {
                    dateNaissance = LocalDate.parse(input);
                } catch (DateTimeParseException e) {
                    System.out.println("⚠️ Date invalide !");
                }
            } while (dateNaissance == null);
            if (dateNaissance != null) clientExistant.setDateNaissance(String.valueOf(dateNaissance));

            // Mutuelle
            System.out.print("Mutuelle (" + clientExistant.getMutuelle() + ") : ");
            String mutuelle = sc.nextLine();
            if (!mutuelle.isEmpty()) clientExistant.setMutuelle(mutuelle);

            // Médecin traitant
            System.out.print("Médecin traitant (" + clientExistant.getMedecinTraitant() + ") : ");
            String medecin = sc.nextLine();
            if (!medecin.isEmpty()) clientExistant.setMedecinTraitant(medecin);

            System.out.println("✅ Client mis à jour avec succès !");

        } catch (ExceptionPharma e) {
            System.out.println("⚠️ Impossible de modifier le client : " + e.getMessage());
        }
    }

    public static void selectionnerClient(GestionClient gestionClient) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez le numéro de sécurité sociale du client à afficher : ");
        String numSecu = sc.nextLine();

        try {
            // Récupérer le client correspondant
            Client client = gestionClient.getClientByNumeroSecu(numSecu);

            // Afficher uniquement les informations de ce client
            System.out.println("---- Informations du client ----");
            System.out.println("Nom : " + client.getNom());
            System.out.println("Prénom : " + client.getPrenom());
            System.out.println("Adresse : " + client.getAdresse());
            System.out.println("Code postal : " + client.getCodePostal());
            System.out.println("Ville : " + client.getVille());
            System.out.println("Téléphone : " + client.getTelephone());
            System.out.println("Email : " + client.getEmail());
            System.out.println("Numéro de sécurité sociale : " + client.getNumeroSecu());
            System.out.println("Date de naissance : " + client.getDateNaissance());
            System.out.println("Mutuelle : " + client.getMutuelle());
            System.out.println("Médecin traitant : " + client.getMedecinTraitant());
            System.out.println("-------------------------------");

        } catch (ExceptionPharma e) {
            System.out.println("⚠️ Aucun client trouvé avec ce numéro de sécurité sociale.");
        }
    }

    // Création de la méthode choisirMedecin
    public static Medecin choisirMedecin(GestionMedecin gestionMedecin) {
        ArrayList<Medecin> medecins = gestionMedecin.getMedecins();

        if (medecins.isEmpty()) {
            System.out.println("⚠️ Aucun médecin disponible !");
            return null;
        }

        System.out.println("Sélectionnez un médecin :");
        for (int i = 0; i < medecins.size(); i++) {
            Medecin m = medecins.get(i);
            System.out.println((i + 1) + ". " + m.getNom() + " " + m.getPrenom());
        }

        System.out.print("Votre choix : ");
        int choix = sc.nextInt();
        sc.nextLine(); // consommer le retour chariot

        if (choix < 1 || choix > medecins.size()) {
            System.out.println("⚠️ Choix invalide, aucun médecin sélectionné.");
            return null;
        }

        return medecins.get(choix - 1);
    }


    public static Medecin saisieMedecin() throws ExceptionPharma {
        System.out.println("Informations du médecin : ");
        // Nom
        do {
            System.out.print("Nom : ");
            nom = sc.nextLine().trim();
            if (!Regex.isValid(nom, Regex.LETTRE)) {
                System.out.println("⚠️ Nom invalide ! Merci d'utiliser uniquement des lettres.");
                nom = "";
            }
        } while (nom.isEmpty());

        // Prénom
        do {
            System.out.print("Prénom : ");
            prenom = sc.nextLine().trim();
            if (!Regex.isValid(prenom, Regex.LETTRE)) {
                System.out.println("⚠️ Prénom invalide ! Merci d'utiliser uniquement des lettres.");
                prenom = "";
            }
        } while (prenom.isEmpty());

        // Adresse
        do {
            System.out.print("Adresse : ");
            adresse = sc.nextLine().trim();
            if (adresse.isEmpty()) {
                System.out.println("⚠️ L'adresse ne peut pas être vide !");
            }
        } while (adresse.isEmpty());

        // Code postal
        do {
            System.out.print("Code postal : ");
            codePostal = sc.nextLine().trim();
            if (!Regex.isValid(codePostal, Regex.CODE_POSTAL)) {
                System.out.println("⚠️ Code postal invalide ! (Exemple : 54000)");
                codePostal = "";
            }
        } while (codePostal.isEmpty());

        // Ville
        do {
            System.out.print("Ville : ");
            ville = sc.nextLine().trim();
            if (!Regex.isValid(ville, Regex.LETTRE)) {
                System.out.println("⚠️ Ville invalide ! Merci d'utiliser uniquement des lettres.");
                ville = "";
            }
        } while (ville.isEmpty());

        // Téléphone
        do {
            System.out.print("Téléphone : ");
            telephone = sc.nextLine().trim();
            if (!Regex.isValid(telephone, Regex.TELEPHONE)) {
                System.out.println("⚠️ Téléphone invalide ! Format attendu : 0612345678");
                telephone = "";
            }
        } while (telephone.isEmpty());

        // Email
        do {
            System.out.print("Email : ");
            email = sc.nextLine().trim();
            if (!Regex.isValid(email, Regex.EMAIL)) {
                System.out.println("⚠️ Email invalide ! Exemple : exemple@mail.com");
                email = "";
            }
        } while (email.isEmpty());

        // Numéro d’agrément
        do {
            System.out.print("Numéro d'agrément : ");
            numeroAgreement = sc.nextLine().trim();
            if (numeroAgreement.isEmpty()) {
                System.out.println("⚠️ Numéro d'agrément invalide !");
            }
        } while (numeroAgreement.isEmpty());

        return new Medecin(
                nom, prenom, adresse, codePostal, ville,
                telephone, email, numeroAgreement
        );
    }
    public static void selectionnerMedecin(GestionMedecin gestionMedecin) {

        System.out.print("Entrez le numéro d'agrément du médecin à afficher : ");
        String numAgreement = sc.nextLine();

        try {
            // Récupérer le médecin correspondant
            Medecin medecin = gestionMedecin.getMedecinByNumeroAgreement(numAgreement);

            // Afficher uniquement les informations de ce médecin
            System.out.println("---- Informations du médecin ----");
            System.out.println("Nom : " + medecin.getNom());
            System.out.println("Prénom : " + medecin.getPrenom());
            System.out.println("Adresse : " + medecin.getAdresse());
            System.out.println("Code postal : " + medecin.getCodePostal());
            System.out.println("Ville : " + medecin.getVille());
            System.out.println("Téléphone : " + medecin.getTelephone());
            System.out.println("Email : " + medecin.getEmail());
            System.out.println("Numéro d'agrément : " + medecin.getNumeroAgreement());
            System.out.println("-------------------------------");

        } catch (ExceptionPharma e) {
            System.out.println("⚠️ Aucun médecin trouvé avec ce numéro d'agrément.");
        }
    }

    public static void modifierMedecin(GestionMedecin gestionMedecin) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez le numéro d'agrément du médecin à modifier : ");
        String numAgreement = sc.nextLine();

        try {
            // Récupérer le médecin existant
            Medecin medecinExistant = gestionMedecin.getMedecinByNumeroAgreement(numAgreement);

            System.out.println("Saisir les nouvelles informations (laisser vide pour ne pas changer) :");

            // Nom
            String nom;
            do {
                System.out.print("Nom (" + medecinExistant.getNom() + ") : ");
                nom = sc.nextLine().trim();
                if (!nom.isEmpty() && !Regex.isValid(nom, Regex.LETTRE)) {
                    System.out.println("⚠️ Nom invalide ! Utilisez uniquement des lettres.");
                    nom = null;
                }
            } while (nom == null);
            if (!nom.isEmpty()) medecinExistant.setNom(nom);

            // Prénom
            String prenom;
            do {
                System.out.print("Prénom (" + medecinExistant.getPrenom() + ") : ");
                prenom = sc.nextLine().trim();
                if (!prenom.isEmpty() && !Regex.isValid(prenom, Regex.LETTRE)) {
                    System.out.println("⚠️ Prénom invalide ! Utilisez uniquement des lettres.");
                    prenom = null;
                }
            } while (prenom == null);
            if (!prenom.isEmpty()) medecinExistant.setPrenom(prenom);

            // Adresse
            String adresse;
            do {
                System.out.print("Adresse (" + medecinExistant.getAdresse() + ") : ");
                adresse = sc.nextLine().trim();
                if (!adresse.isEmpty() && adresse.length() < 5) {
                    System.out.println("⚠️ Adresse invalide !");
                    adresse = null;
                }
            } while (adresse == null);
            if (!adresse.isEmpty()) medecinExistant.setAdresse(adresse);

            // Code postal
            String codePostal;
            do {
                System.out.print("Code postal (" + medecinExistant.getCodePostal() + ") : ");
                codePostal = sc.nextLine().trim();
                if (!codePostal.isEmpty() && !Regex.isValid(codePostal, Regex.CODE_POSTAL)) {
                    System.out.println("⚠️ Code postal invalide !");
                    codePostal = null;
                }
            } while (codePostal == null);
            if (!codePostal.isEmpty()) medecinExistant.setCodePostal(codePostal);

            // Ville
            String ville;
            do {
                System.out.print("Ville (" + medecinExistant.getVille() + ") : ");
                ville = sc.nextLine().trim();
                if (!ville.isEmpty() && !Regex.isValid(ville, Regex.LETTRE)) {
                    System.out.println("⚠️ Ville invalide ! Utilisez uniquement des lettres.");
                    ville = null;
                }
            } while (ville == null);
            if (!ville.isEmpty()) medecinExistant.setVille(ville);

            // Téléphone
            String telephone;
            do {
                System.out.print("Téléphone (" + medecinExistant.getTelephone() + ") : ");
                telephone = sc.nextLine().trim();
                if (!telephone.isEmpty() && !Regex.isValid(telephone, Regex.TELEPHONE)) {
                    System.out.println("⚠️ Téléphone invalide ! Format attendu : 0612345678");
                    telephone = null;
                }
            } while (telephone == null);
            if (!telephone.isEmpty()) medecinExistant.setTelephone(telephone);

            // Email
            String email;
            do {
                System.out.print("Email (" + medecinExistant.getEmail() + ") : ");
                email = sc.nextLine().trim();
                if (!email.isEmpty() && !Regex.isValid(email, Regex.EMAIL)) {
                    System.out.println("⚠️ Email invalide ! Exemple : exemple@mail.com");
                    email = null;
                }
            } while (email == null);
            if (!email.isEmpty()) medecinExistant.setEmail(email);

            // Numéro d’agrément
            String agreement;
            do {
                System.out.print("Numéro d’agrément (" + medecinExistant.getNumeroAgreement() + ") : ");
                agreement = sc.nextLine().trim();
                if (!agreement.isEmpty() && agreement.length() < 5) {
                    System.out.println("⚠️ Numéro d’agrément invalide !");
                    agreement = null;
                }
            } while (agreement == null);
            if (!agreement.isEmpty()) medecinExistant.setNumeroAgreement(agreement);

            System.out.println("✅ Médecin mis à jour avec succès !");

        } catch (ExceptionPharma e) {
            System.out.println("⚠️ Impossible de modifier le médecin : " + e.getMessage());
        }
    }

    public static void supprimerMedecin(GestionMedecin gestionMedecin) {

        System.out.print("Entrez le numéro d’agrément du médecin à supprimer : ");
        String numAgreement = sc.nextLine();

        try {
            gestionMedecin.deleteMedecin(numAgreement);
            System.out.println("✅ Médecin supprimé !");
        } catch (ExceptionPharma e) {
            System.out.println("⚠️ Impossible de supprimer le médecin : ce numéro d’agrément n’existe pas. " + e.getMessage());
        }
    }


}
