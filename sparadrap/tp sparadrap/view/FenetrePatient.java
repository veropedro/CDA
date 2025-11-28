package fr.afpa.pompey.cda22045.view;


import fr.afpa.pompey.cda22045.ExceptionPharma;
import fr.afpa.pompey.cda22045.modele.Client;
import fr.afpa.pompey.cda22045.modele.GestionClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetrePatient extends JFrame {

    private JPanel contentPane;
    private JButton listeDesClientsButton;
    private JButton modiferUnPatientButton;
    private JButton creerPatientButton;
    private JButton modifierPatientButton;
    private JButton supprimerPatientButton;
    private JButton annulerButton;
    private JButton supprimerUnPatientButton;
    private JButton creerUnNouveauPatientButton;
    private JButton detailsClientButton;
    //List<Personne> clients = new ArrayList<>();

    public FenetrePatient() {
        Dimension dimension = new Dimension(800, 700);

        this.setTitle("Patients");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setSize(dimension);

        // PANEL INITIALISÉ
        contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout());
        this.setContentPane(contentPane);

        // Initialisation GestionClient
        GestionClient gestionClient = new GestionClient();

        // Création de quelques clients fictifs
        try {
            Client c1 = new Client(1, "Dupont", "Marie", "10 rue A", "54000", "Nancy",
                    "0600000001", "marie@ex.fr",
                    "1234567890123", java.time.LocalDate.parse("1998-05-10"),
                    "MAAF", "Dr Martin");

            Client c2 = new Client(2, "Durand", "Paul", "12 rue B", "54000", "Nancy",
                    "0600000002", "paul@ex.fr",
                    "2234567890123", java.time.LocalDate.parse("1995-08-20"),
                    "GMF", "Dr Leroy");

            gestionClient.ajouterClient(c1);
            gestionClient.ajouterClient(c2);
        } catch (ExceptionPharma e) {
            e.printStackTrace();
        }

        // BOUTONS
        listeDesClientsButton = new JButton("Liste des patients");
        creerPatientButton = new JButton("Créer patient");
        modifierPatientButton = new JButton("Modifier patient");
        supprimerPatientButton = new JButton("Supprimer patient");
        annulerButton = new JButton("Fermer");


        contentPane.add(listeDesClientsButton);
        contentPane.add(creerPatientButton);
        contentPane.add(modifierPatientButton);
        contentPane.add(supprimerPatientButton);
        contentPane.add(annulerButton);
        contentPane.add(detailsClientButton);

        this.pack();
        this.setVisible(true);

        listeDesClientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new ListePatients().setVisible(true);;  // ouvre la liste des patients
            }
        });

        creerUnNouveauPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        modiferUnPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        supprimerUnPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        detailsClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DetailsPatient(gestionClient).setVisible(true); // ouvre une fenetre details patient
            }
        });
        annulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(annulerButton);
                currentFrame.dispose(); // Ferme la fenêtre
            }
        });


    }
}
