package tpPharma.swingPharma;
import swing.testswing;
import tpPharma.exceptionPharma.ExceptionPharma;
import tpPharma.modelePharma.Client;
import tpPharma.modelePharma.GestionClient;
import tpPharma.modelePharma.Medecin;
import tpPharma.modelePharma.Achat;
import tpPharma.modelePharma.Mutuelle;
import tpPharma.modelePharma.Ordonnance;
import tpPharma.modelePharma.Medicament;
import tpBibli.exception.SaisieException;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SwingPharma {

    private ArrayList<Client> clients;
    private ArrayList<Medecin> medecins;
    private ArrayList<Achat> achats;
    private ArrayList<Medicament> medicaments;
    private ArrayList<Ordonnance> ordonnances;
    private ArrayList<Mutuelle> mutuelles;


    // Définissez le frame
    JFrame frame = new JFrame();             // creation d'une fenetre
    JPanel panel = new JPanel();


    //creation constructeur pour pouvoir utiser les listes
    public SwingPharma(ArrayList<Client> clients, ArrayList<Medecin> medecins, ArrayList<Achat> achats, ArrayList<Medicament> medicaments,
                       ArrayList<Ordonnance>ordonnances , ArrayList<Mutuelle> mutuelles) throws ExceptionPharma {
        this.clients = clients;
        this.medecins = medecins;
        this.achats = achats;
        this.medicaments = medicaments;
        this.ordonnances = ordonnances;
        this.mutuelles = mutuelles;

        // ----------------------
        // Ajout des clients
        // ----------------------
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

        this.clients.add(c1);
        this.clients.add(c2);
        this.clients.add(c3);
        this.clients.add(c4);
        this.clients.add(c5);

        // ----------------------
        // Ajout des médecins
        // ----------------------
        Medecin m1 = new Medecin("Wagner", "Sandrine", "12 rue Saint-Jean", "54000", "Nancy", "0612345678", "sandrine.wagner@mail.fr", "AG12345");
        Medecin m2 = new Medecin("Martin", "Luc", "5 avenue Poincaré", "54000", "Nancy", "0623456789", "luc.martin@mail.fr", "AG23456");
        Medecin m3 = new Medecin("Dupuis", "Claire", "8 rue Rives de Meurthe", "54000", "Nancy", "0634567890", "claire.dupuis@mail.fr", "AG34567");
        Medecin m4 = new Medecin("Leclerc", "Paul", "3 boulevard Victor Hugo", "54000", "Nancy", "0645678901", "paul.leclerc@mail.fr", "AG45678");
        Medecin m5 = new Medecin("Dubois", "Marie", "27 rue du Général Leclerc", "54000", "Nancy", "0656789012", "marie.dubois@mail.fr", "AG56789");

        this.medecins.add(m1);
        this.medecins.add(m2);
        this.medecins.add(m3);
        this.medecins.add(m4);
        this.medecins.add(m5);

        // ----------------------
        // Ajout des médicaments
        // ----------------------
        Medicament med1 = new Medicament("Paracetamol", "Antalgique", 4.5, LocalDate.of(2020, 1, 15), 100);
        Medicament med2 = new Medicament("Ibuprofen", "Anti-inflammatoire", 5.0, LocalDate.of(2021, 5, 10), 50);
        Medicament med3 = new Medicament("Amoxicilline", "Antibiotique", 8.0, LocalDate.of(2019, 8, 20), 75);
        Medicament med4 = new Medicament("Cetirizine", "Antihistaminique", 6.5, LocalDate.of(2022, 3, 5), 40);
        Medicament med5 = new Medicament("Omeprazole", "Antiacide", 7.5, LocalDate.of(2021, 11, 12), 60);

        this.medicaments.add(med1);
        this.medicaments.add(med2);
        this.medicaments.add(med3);
        this.medicaments.add(med4);
        this.medicaments.add(med5);

        // ----------------------
        // Ajout des mutuelles
        // ----------------------
        Mutuelle mu1 = new Mutuelle("Harmonie", "12 rue de Paris", "54000", "Nancy", "0383456789", "contact@harmonie.fr", "54", 80);
        Mutuelle mu2 = new Mutuelle("MGEN", "5 boulevard Victor Hugo", "67000", "Strasbourg", "0389123456", "contact@mgen.fr", "67", 90);
        Mutuelle mu3 = new Mutuelle("Allianz", "8 avenue Foch", "68100", "Mulhouse", "0387654321", "contact@allianz.fr", "68", 85);
        Mutuelle mu4 = new Mutuelle("AXA", "27 rue du Général Leclerc", "51100", "Reims", "0323456789", "contact@axa.fr", "51", 75);
        Mutuelle mu5 = new Mutuelle("MAIF", "15 rue des Jardins", "57000", "Metz", "0334567890", "contact@maif.fr", "57", 80);

        this.mutuelles.add(mu1);
        this.mutuelles.add(mu2);
        this.mutuelles.add(mu3);
        this.mutuelles.add(mu4);
        this.mutuelles.add(mu5);

        // ----------------------
        // Ajout des ordonnances
        // ----------------------
        Ordonnance o1 = new Ordonnance("2025-03-01", m1, c1, new ArrayList<>(List.of(med1, med4)));
        Ordonnance o2 = new Ordonnance("2025-03-05", m2, c2, new ArrayList<>(List.of(med2)));
        Ordonnance o3 = new Ordonnance("2025-03-10", m1, c2, new ArrayList<>(List.of(med3, med1)));
        Ordonnance o4 = new Ordonnance("2025-03-15", m2, c1, new ArrayList<>(List.of(med2, med4)));
        Ordonnance o5 = new Ordonnance("2025-03-20", m1, c1, new ArrayList<>(List.of(med1, med2, med3)));
        Ordonnance o6 = new Ordonnance("2025-03-25", m2, c2, new ArrayList<>(List.of(med4)));

        this.ordonnances.add(o1);
        this.ordonnances.add(o2);
        this.ordonnances.add(o3);
        this.ordonnances.add(o4);
        this.ordonnances.add(o5);
        this.ordonnances.add(o6);

        // ----------------------
        // Ajout des achats
        // ----------------------
        ArrayList<Medicament> listeMedocDirect = new ArrayList<>();
        listeMedocDirect.add(med1);

        ArrayList<Medicament> listeMedocOrdonnance = new ArrayList<>();
        listeMedocOrdonnance.add(med1);
        listeMedocOrdonnance.add(med2);

        Achat achatDirect1 = new Achat(LocalDate.of(2021, 6, 15), c1, listeMedocDirect, false, null);
        Achat achatDirect2 = new Achat(LocalDate.of(2025, 9, 3), c4, listeMedocDirect, false, null);

        Achat achatOrdonnance1 = new Achat(LocalDate.of(2023, 8, 5), c2, listeMedocOrdonnance, true, m2);
        Achat achatOrdonnance2 = new Achat(LocalDate.of(2025, 8, 30), c3, listeMedocOrdonnance, true, m1);

        this.achats.add(achatDirect1);
        this.achats.add(achatDirect2);
        this.achats.add(achatOrdonnance1);
        this.achats.add(achatOrdonnance2);

        // -------------------------------
        // Partie graphique (Swing)
        // -------------------------------


        frame.setTitle("Gestion de la pharmacie !");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        //la fermeture de la fenêtre, ferme le programme
        frame.setLocationRelativeTo(null);                           //Centre la fenêtre sur l’écran

        // Création du panel principal
        panel = new JPanel();
        panel.setLayout(new BorderLayout());             //gestionnaire de disposition, qui divise en north, south, center, east et west
        frame.add(panel);
        JLabel label = new JLabel("Bienvenue dans la pharmacie!", JLabel.CENTER);    //affiche du texte
        frame.add(label);
        frame.setVisible(true);



        String[] elements = {   "MENU BIBLIOTHÈQUE" ,
                                "1. Effectuer un achat",
                                "2. Consulter l'historique des achats",
                                "3. Consulter les médecins",
                                "4. Consulter les clients",
                                "5. Consulter les ordonnances",
                                "6. Précèdent",
                                "0. Quitter"};

        JComboBox comboBox = new JComboBox(elements);
        panel.add(comboBox, BorderLayout.NORTH);
        frame.add(comboBox, BorderLayout.NORTH);
        frame.setVisible(true);




    //    comboBox.addActionListener(e -> {
      //      try {
    //            GestionClient.ajouterClient(c1);
     //       } catch (ExceptionPharma ex) {
     //           throw new RuntimeException(ex);
//}
     //   });

     //   frame.setVisible(true);



    }






    public static void main(String[] args) {
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Medecin> medecins = new ArrayList<>();
        ArrayList<Achat> achats = new ArrayList<>();
        ArrayList<Medicament> medicaments = new ArrayList<>();
        ArrayList<Ordonnance> ordonnances = new ArrayList<>();
        ArrayList<Mutuelle> mutuelles = new ArrayList<>();

        try {
            new SwingPharma(clients, medecins, achats, medicaments, ordonnances, mutuelles);
        } catch (ExceptionPharma e) {
            e.printStackTrace();
        }
    }
}

