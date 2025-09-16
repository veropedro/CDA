package tpPharma.controleurPharma;
import java.util.List;

import tpBibli.vue.console.VueConsole;
import tpPharma.modelePharma.*;
import tpPharma.exceptionPharma.ExceptionPharma;
import tpPharma.vuePharma.VuePharma;
import java.util.ArrayList;
import java.util.Stack;

import java.time.LocalDate;
import static tpPharma.vuePharma.VuePharma.choisirMedecin;

public class MainPharma {
    public static void main(String[] args) throws ExceptionPharma {

        // Création de quelques clients
        Client c1 = new Client("pedro", "vero", "3 avenue general leclerc", "54000",
                "nancy", "0650368754", "pvero@h.fr", "1 84 12 54 123 456 78",
                LocalDate.of(1999, 3, 13), "harmonie", "sandrine Wagner");

        Client c2 = new Client("Durand", "Marie", "12 rue des Fleurs", "54000",
                "Nancy", "0612457896", "marie.durand@mail.fr", "285076512345612",
                LocalDate.of(1985, 7, 25), "Maif Santé", "Luc Martin");

        Client c3 = new Client("Bernard", "Julien", "45 boulevard de la République", "54000",
                "Nancy", "0678593214", "julien.bernard@mail.fr", "184021012345634",
                LocalDate.of(1990, 2, 10), "MGEN", "Claire Dupuis");

        Client c4 = new Client("Nguyen", "Sophie", "8 avenue de la Liberté", "54000",
                "Nancy", "0625478963", "sophie.nguyen@mail.fr", "285031212345698",
                LocalDate.of(2000, 12, 5), "Allianz", "Paul Leclerc");

        Client c5 = new Client("Rodriguez", "Carlos", "27 rue Victor Hugo", "54000",
                "Nancy", "0645789652", "carlos.rodriguez@mail.fr", "184111212345677",
                LocalDate.of(1978, 11, 12), "AXA Santé", "Marie Dubois");


        GestionClient gestionClient = new GestionClient();

        gestionClient.ajouterClient(c1);
        gestionClient.ajouterClient(c2);
        gestionClient.ajouterClient(c3);
        gestionClient.ajouterClient(c4);
        gestionClient.ajouterClient(c5);


        // Création de quelques medecins

        Medecin m1 = new Medecin("Wagner", "Sandrine", "12 rue Saint-Jean", "54000", "Nancy", "0612345678", "sandrine.wagner@mail.fr", "AG12345");
        Medecin m2 = new Medecin("Martin", "Luc", "5 avenue Poincaré", "54000", "Nancy", "0623456789", "luc.martin@mail.fr", "AG23456");
        Medecin m3 = new Medecin("Dupuis", "Claire", "8 rue Rives de Meurthe", "54000", "Nancy", "0634567890", "claire.dupuis@mail.fr", "AG34567");
        Medecin m4 = new Medecin("Leclerc", "Paul", "3 boulevard Victor Hugo", "54000", "Nancy", "0645678901", "paul.leclerc@mail.fr", "AG45678");
        Medecin m5 = new Medecin("Dubois", "Marie", "27 rue du Général Leclerc", "54000", "Nancy", "0656789012", "marie.dubois@mail.fr", "AG56789");


        // Ajout dans GestionMedecin

        GestionMedecin gestionMedecin = new GestionMedecin();

        gestionMedecin.ajouterMedecin(m1);
        gestionMedecin.ajouterMedecin(m2);
        gestionMedecin.ajouterMedecin(m3);
        gestionMedecin.ajouterMedecin(m4);
        gestionMedecin.ajouterMedecin(m5);


        // Ajout de Médicaments

        Medicament med1 = new Medicament("Paracetamol", "Antalgique", 4.5, LocalDate.of(2020, 1, 15), 100);
        Medicament med2 = new Medicament("Ibuprofen", "Anti-inflammatoire", 5.0, LocalDate.of(2021, 5, 10), 50);
        Medicament med3 = new Medicament("Amoxicilline", "Antibiotique", 8.0, LocalDate.of(2019, 8, 20), 75);
        Medicament med4 = new Medicament("Cetirizine", "Antihistaminique", 6.5, LocalDate.of(2022, 3, 5), 40);
        Medicament med5 = new Medicament("Omeprazole", "Antiacide", 7.5, LocalDate.of(2021, 11, 12), 60);


        // Ajout dans la liste
        GestionMedicament gestionMedicament = new GestionMedicament();

        gestionMedicament.ajouterMedicament(med1);
        gestionMedicament.ajouterMedicament(med2);
        gestionMedicament.ajouterMedicament(med3);
        gestionMedicament.ajouterMedicament(med4);
        gestionMedicament.ajouterMedicament(med5);


        // Ajout de Mutuelles
        Mutuelle mu1 = new Mutuelle("Harmonie", "12 rue de Paris", "54000", "Nancy", "0383456789", "contact@harmonie.fr", "54", 80);
        Mutuelle mu2 = new Mutuelle("MGEN", "5 boulevard Victor Hugo", "67000", "Strasbourg", "0389123456", "contact@mgen.fr", "67", 90);
        Mutuelle mu3 = new Mutuelle("Allianz", "8 avenue Foch", "68100", "Mulhouse", "0387654321", "contact@allianz.fr", "68", 85);
        Mutuelle mu4 = new Mutuelle("AXA", "27 rue du Général Leclerc", "51100", "Reims", "0323456789", "contact@axa.fr", "51", 75);
        Mutuelle mu5 = new Mutuelle("MAIF", "15 rue des Jardins", "57000", "Metz", "0334567890", "contact@maif.fr", "57", 80);

        // Ajout dans la liste
        GestionMutuelle gestionMutuelle = new GestionMutuelle();

        gestionMutuelle.ajouterMutuelle(mu1);
        gestionMutuelle.ajouterMutuelle(mu2);
        gestionMutuelle.ajouterMutuelle(mu3);
        gestionMutuelle.ajouterMutuelle(mu4);
        gestionMutuelle.ajouterMutuelle(mu5);


        // Ajout d'ordonnances:
        Ordonnance o1 = new Ordonnance("2025-03-01", m1, c1, new ArrayList<>(List.of(med1, med4)));
        Ordonnance o2 = new Ordonnance("2025-03-05", m2, c2, new ArrayList<>(List.of(med2)));
        Ordonnance o3 = new Ordonnance("2025-03-10", m1, c2, new ArrayList<>(List.of(med3, med1)));
        Ordonnance o4 = new Ordonnance("2025-03-15", m2, c1, new ArrayList<>(List.of(med2, med4)));
        Ordonnance o5 = new Ordonnance("2025-03-20", m1, c1, new ArrayList<>(List.of(med1, med2, med3)));
        Ordonnance o6 = new Ordonnance("2025-03-25", m2, c2, new ArrayList<>(List.of(med4)));

        // Ajouter les 6 ordonnances
        GestionOrdonnance gestionOrdonnance = new GestionOrdonnance();
        gestionOrdonnance.ajouterOrdonnance(o1);
        gestionOrdonnance.ajouterOrdonnance(o2);
        gestionOrdonnance.ajouterOrdonnance(o3);
        gestionOrdonnance.ajouterOrdonnance(o4);
        gestionOrdonnance.ajouterOrdonnance(o5);
        gestionOrdonnance.ajouterOrdonnance(o6);



        ArrayList<Medicament> listeMedocDirect = new ArrayList<>();
        listeMedocDirect.add(med1);

        ArrayList<Medicament> listeMedocOrdonnance = new ArrayList<>();
        listeMedocOrdonnance.add(med1);
        listeMedocOrdonnance.add(med2);


        //  Création de la gestion des achats direct
        GestionAchat gestionAchat = new GestionAchat();
        Achat achatDirect1 = new Achat(LocalDate.of(2021, 6, 15), c1, listeMedocDirect,
                false, null);
        Achat achatDirect2 = new Achat(LocalDate.of(2025, 9, 3), c4, listeMedocDirect,
                false, null);

        gestionAchat.ajouterAchat(achatDirect1);
        gestionAchat.ajouterAchat(achatDirect2);


        // Achat via ordonnance
        Achat achatOrdonnance1 = new Achat(LocalDate.of(2023, 8, 5), c2, listeMedocOrdonnance,
                true, m2);
        Achat achatOrdonnance2 = new Achat(LocalDate.of(2025, 8, 30), c3, listeMedocOrdonnance,
                true, m1);

        gestionAchat.ajouterAchat(achatOrdonnance1);
        gestionAchat.ajouterAchat(achatOrdonnance2);


        Stack<Runnable> historique = new Stack<>();

        int choix;

        do {
            choix = VuePharma.affichageMenu();

            // contrôleur
            switch (choix) {
                case 1: // Achats
                    historique.push(() -> {
                        // Quand on revient en arrière, on réaffiche le menu principal
                        VuePharma.affichageMessage("⬅️ Retour au menu principal");
                    });

                    int sousChoix = VuePharma.affichageSousMenuAchat();
                    switch (sousChoix) {
                        case 1: // achat sans ordonnance
                            Client nouveauClient = VuePharma.saisieClient();
                            gestionClient.ajouterClient(nouveauClient);

                            ArrayList<Medicament> achatMedicaments = VuePharma.saisieListeMedicaments();
                            gestionAchat.ajouterAchat(
                                    new Achat(VuePharma.getDateAchat(), nouveauClient, achatMedicaments, false, null)
                            );
                            VuePharma.affichageMessage("✅ Achat effectué !");
                            break;

                        case 2: // achat avec ordonnance
                            Client nouveauClient2 = VuePharma.saisieClient();
                            ArrayList<Medicament> achatMedicaments2 = VuePharma.saisieListeMedicaments();
                            Medecin medecinChoisi = choisirMedecin(gestionMedecin);

                            gestionAchat.ajouterAchat(
                                    new Achat(VuePharma.getDateAchat(), nouveauClient2, achatMedicaments2, true, medecinChoisi)
                            );
                            VuePharma.affichageMessage("✅ Achat effectué !");
                            break;

                        case 3: // retour
                            if (!historique.isEmpty()) {
                                historique.pop().run();
                            } else {
                                VuePharma.affichageMessage("⚠️ Pas de page précédente !");
                            }
                            break;
                        case 0: // quitter
                            VuePharma.affichageMessage("👋 Retour au menu principal!");
                            break;

                        default:
                            VuePharma.affichageMessage("⚠️ Choix invalide !");
                    }
                    break;


                case 2: // Liste des achats
                    historique.push(() -> {
                        try {
                            gestionAchat.afficherAchat();
                        } catch (ExceptionPharma e) {
                            throw new RuntimeException(e);
                        }
                    });
                    int sousChoixAchat2 = VuePharma.affichageSousMenuAchat2();

                    switch (sousChoixAchat2) {
                        case 1:   //liste des achats
                            VuePharma.affichageMessage("Liste des achats :");
                            gestionAchat.afficherAchat();
                            break;

                        case 2:   //selectionner un achat precis
                            VuePharma.selectionnerAchat(gestionAchat);
                            break;
                        case 3: // retour
                            if (!historique.isEmpty()) {
                                historique.pop().run();
                            } else {
                                VuePharma.affichageMessage("⚠️ Pas de page précédente !");
                            }
                            break;
                        case 0: // quitter
                            VuePharma.affichageMessage("👋 Retour au menu principal!");
                            break;

                        default:
                            VuePharma.affichageMessage("⚠️ Choix invalide !");
                    }
                    break;


                case 3: // Liste des médecins
                    historique.push(() -> {
                        try {
                            gestionMedecin.afficherMedecin();
                        } catch (ExceptionPharma e) {
                            throw new RuntimeException(e);
                        }
                    });
                    int sousChoixMedecin = VuePharma.affichageSousMenuMedecin();

                    switch (sousChoixMedecin) {
                        case 1: // liste medecins
                            VuePharma.affichageMessage("Liste des medecins :");
                            gestionMedecin.afficherMedecin();
                            break;

                        case 2: // modifier medecin
                            VuePharma.modifierMedecin(gestionMedecin);
                            break;

                        case 3: // supprimer medecin
                            VuePharma.supprimerMedecin(gestionMedecin);
                            break;

                        case 4: // nouveau medecin
                            Medecin nouveauMedecin3 = VuePharma.saisieMedecin();
                            gestionMedecin.ajouterMedecin(nouveauMedecin3);
                            break;

                        case 5: // afficher un medecin précis
                            VuePharma.selectionnerMedecin(gestionMedecin);
                            break;

                        case 6: // afficher historique d'ordonnances d'un medecin
                            VuePharma.afficherOrdonnanceMedecin(gestionOrdonnance);
                            break;

                        case 7: // retour
                            if (!historique.isEmpty()) {
                                historique.pop().run();
                            } else {
                                VuePharma.affichageMessage("⚠️ Pas de page précédente !");
                            }
                            break;

                        case 0:
                            VuePharma.affichageMessage("👋 À bientôt !");
                            break;

                        default:
                            VuePharma.affichageMessage("⚠️ Choix invalide !");
                    }
                    break;

                case 4: // Gestion clients
                    historique.push(() -> {
                        try {
                            gestionClient.afficherClient();
                        } catch (ExceptionPharma e) {
                            throw new RuntimeException(e);
                        }
                    });
                    int sousChoixClient = VuePharma.affichageSousMenuClient();

                    switch (sousChoixClient) {
                        case 1: // liste clients
                            VuePharma.affichageMessage("Liste des clients :");
                            gestionClient.afficherClient();
                            break;

                        case 2: // modifier client
                            VuePharma.modifierClient(gestionClient);
                            break;

                        case 3: // supprimer client
                            VuePharma.supprimerClient(gestionClient);
                            break;

                        case 4: // nouveau client
                            Client nouveauClient3 = VuePharma.saisieClient();
                            gestionClient.ajouterClient(nouveauClient3);
                            break;

                        case 5: // afficher un client précis
                            VuePharma.selectionnerClient(gestionClient);
                            break;

                        case 6: // retour
                            if (!historique.isEmpty()) {
                                historique.pop().run();
                            } else {
                                VuePharma.affichageMessage("⚠️ Pas de page précédente !");
                            }
                            break;

                        case 0:
                            VuePharma.affichageMessage("👋 À bientôt !");
                            break;

                        default:
                            VuePharma.affichageMessage("⚠️ Choix invalide !");
                    }
                    break;

                case 5: //consulter les ordonnances
                    historique.push(() -> {
                        try {
                            gestionAchat.afficherAchat();
                        } catch (ExceptionPharma e) {
                            throw new RuntimeException(e);
                        }
                    });
                    int sousChoixOrdonnance = VuePharma. affichageSousMenuOrdonnance();

                    switch (sousChoixOrdonnance) {
                        case 1:   //liste des Ordonnances
                            VuePharma.affichageMessage("Liste des achats :");
                            gestionOrdonnance.afficherOrdonnance ();
                            break;

                        case 2:   //selectionner une Ordonnance precise
                           // VuePharma.selectionnerOrdonnance (gestionOrdonnance);
                            break;
                        case 3: // retour
                            if (!historique.isEmpty()) {
                                historique.pop().run();
                            } else {
                                VuePharma.affichageMessage("⚠️ Pas de page précédente !");
                            }
                            break;
                        case 0: // quitter
                            VuePharma.affichageMessage("👋 Retour au menu principal!");
                            break;

                        default:
                            VuePharma.affichageMessage("⚠️ Choix invalide !");
                    }
                    break;



                case 6: // retour global
                    if (!historique.isEmpty()) {
                        historique.pop().run();
                    } else {
                        VuePharma.affichageMessage("⚠️ Pas de page précédente !");
                    }
                    break;

                case 0: // quitter
                    VuePharma.affichageMessage("👋 À bientôt !");
                    break;

                default:
                    VuePharma.affichageMessage("⚠️ Choix invalide !");
            }

        } while (choix != 0);

        VueConsole.close();
    }
}
