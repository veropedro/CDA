package fr.afpa.pompey.cda22045.view;
import fr.afpa.pompey.cda22045.modele.Client;
import fr.afpa.pompey.cda22045.modele.GestionClient;
import fr.afpa.pompey.cda22045.view.ListePatients;

import javax.swing.*;
import java.awt.*;

public class DetailsPatient extends JFrame {
    private final GestionClient gestionClient;
    private JPanel contentPane;
    private JComboBox rechercheClientsCombo;
    private JTextField nom;
    private JTextField prenom;
    private JTextField adresse;
    private JTextField codePostal;
    private JTextField ville;
    private JTextField telephone;
    private JTextField email;
    private JTextField numeroSecu;
    private JTextField dateNaissance;
    private JTextField mutuelle;
    private JTextField medecinTraitant;

    public DetailsPatient(GestionClient gestionClient) {
        Dimension dimension = new Dimension(800, 700);

        this.gestionClient = gestionClient;
        this.setTitle("Details du patients");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setSize(dimension);


        // PANEL INITIALISÉ
        contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout());
        this.setContentPane(contentPane);



        // BOUTONS

// 1️⃣ Remplir la JComboBox avec les clients

        rechercheClientsCombo.removeAllItems(); // vider avant de recharger
        for (Client c : gestionClient.getAllClients()) {
            rechercheClientsCombo.addItem(c); // affichage grâce au toString() de Client
        }

// 2️⃣ ActionListener pour récupérer le client sélectionné
        rechercheClientsCombo.addActionListener(e -> {
            Client clientSelectionne = (Client) rechercheClientsCombo.getSelectedItem();
            if (clientSelectionne != null) {
                // Afficher les informations dans les champs existants
                nom.setText(clientSelectionne.getNom());
                prenom.setText(clientSelectionne.getPrenom());
                adresse.setText(clientSelectionne.getAdresse());
                codePostal.setText(clientSelectionne.getCodePostal());
                ville.setText(clientSelectionne.getVille());
                telephone.setText(clientSelectionne.getTelephone());
                email.setText(clientSelectionne.getEmail());
                numeroSecu.setText(clientSelectionne.getNumeroSecu());
                dateNaissance.setText(String.valueOf(clientSelectionne.getDateNaissance()));
                mutuelle.setText(clientSelectionne.getMutuelle());
                medecinTraitant.setText(clientSelectionne.getMedecinTraitant());
            }
        });

    }
}


