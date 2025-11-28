package fr.afpa.pompey.cda22045.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import fr.afpa.pompey.cda22045.view.FenetrePatient;

public class Sparadrap extends JFrame {
    private JPanel contentPane;
    private JButton patientButton;
    private JButton medecinButton;
    private JButton medicamentButton;
    private JButton ordonnanceButton;
    private JButton mutuelleButton;
    private JButton achatButton;
    private JTextField accueil;

    public  Sparadrap() {
        Dimension dimension = new Dimension(800, 700);
        this.setTitle("Accueil");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.getContentPane().setBackground(Color.WHITE);
        this.getContentPane().setForeground(Color.GREEN);
        this.setContentPane(contentPane);

        this.pack();

        Color vertClair = new Color(204, 255, 204); // LightGreen

        this.getContentPane().setBackground(vertClair);
        patientButton.setBackground(vertClair);
        patientButton.setOpaque(true);


        patientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FenetrePatient();  // Ouvre la nouvelle fenêtre
            }
        });
    }
}
