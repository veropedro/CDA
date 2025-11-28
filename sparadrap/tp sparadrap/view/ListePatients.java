package fr.afpa.pompey.cda22045.view;

import fr.afpa.pompey.cda22045.ExceptionPharma;
import fr.afpa.pompey.cda22045.modele.Client;
import fr.afpa.pompey.cda22045.modeleSwing.Livre;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;

public class ListePatients extends JFrame {

    private JPanel contentPane;
    private JTable tablePatients;
    private JScrollPane scrollPane;
    private ArrayList<Client> list;
    private Client selected;

    private final String[] headers = {
            "ID", "Nom", "Prénom", "Adresse", "Code Postal", "Ville",
            "Téléphone", "Email", "N° Sécu", "Date Naissance", "Mutuelle", "Médecin"
    };

    public ListePatients() {
        Dimension dimension = new Dimension(800, 700);

        this.setTitle("Liste des Patients");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setSize(dimension);

        this.setContentPane(contentPane);

        this.setResizable(false);

        this.setLocationRelativeTo(null);

        this.pack();

        // ⚠️ Initialisation de la liste + affichage
        creationTablePatients();
        setTablePatients(list, headers);

        tablePatients.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selected = selectedClient();
                if (selected != null) {
                    System.out.println(selected.toString());
                }
            }
        });

        this.setVisible(true);

        }

        // Exemple simple de création de clients pour tester */
        public void creationTablePatients() {
            list = new ArrayList<>();

            try {
                Client c1 = new Client(
                        1, "Dupont", "Marie", "10 rue A", "54000", "Nancy",
                        "0600000001", "marie@ex.fr",
                        "1234567890123", LocalDate.parse("1998-05-10"),
                        "MAAF", "Dr Martin");

                Client c2 = new Client(
                        2, "Durand", "Paul", "12 rue B", "54000", "Nancy",
                        "0600000002", "paul@ex.fr",
                        "2234567890123", LocalDate.parse("1995-08-20"),
                        "GMF", "Dr Leroy");

                list.add(c1);
                list.add(c2);

            } catch (ExceptionPharma e) {
                e.printStackTrace();
            }
        }

        private void setTablePatients(ArrayList<Client> clients, String[] columnNames) {

            String[][] data = new String[clients.size()][columnNames.length];

            for (int i = 0; i < clients.size(); i++) {
                Client c = clients.get(i);

                data[i][0] = String.valueOf(c.getId());
                data[i][1] = c.getNom();
                data[i][2] = c.getPrenom();
                data[i][3] = c.getAdresse();
                data[i][4] = c.getCodePostal();
                data[i][5] = c.getVille();
                data[i][6] = c.getTelephone();
                data[i][7] = c.getEmail();
                data[i][8] = c.getNumeroSecu();
                data[i][9] = String.valueOf(c.getDateNaissance());
                data[i][10] = c.getMutuelle();
                data[i][11] = c.getMedecinTraitant();
            }

             tablePatients.setModel(new DefaultTableModel(data, columnNames));
        }

        private Client selectedClient() {
            int selected = tablePatients.getSelectedRow();
            if (selected == -1) return null;

            int modelRow = tablePatients.convertRowIndexToModel(selected);
            DefaultTableModel model = (DefaultTableModel) tablePatients.getModel();

            try {
                int id = Integer.parseInt(model.getValueAt(modelRow, 0).toString());
                String nom = (String) model.getValueAt(modelRow, 1);
                String prenom = (String) model.getValueAt(modelRow, 2);
                String adresse = (String) model.getValueAt(modelRow, 3);
                String codePostal = (String) model.getValueAt(modelRow, 4);
                String ville = (String) model.getValueAt(modelRow, 5);
                String telephone = (String) model.getValueAt(modelRow, 6);
                String email = (String) model.getValueAt(modelRow, 7);
                String numeroSecu = (String) model.getValueAt(modelRow, 8);
                LocalDate dateNaissance = LocalDate.parse(model.getValueAt(modelRow, 9).toString());
                String mutuelle = (String) model.getValueAt(modelRow, 10);
                String medecin = (String) model.getValueAt(modelRow, 11);

                return new Client(id, nom, prenom, adresse, codePostal, ville,
                        telephone, email, numeroSecu, dateNaissance, mutuelle, medecin);

            } catch (ExceptionPharma e) {
                e.printStackTrace();
                return null;
            }
    }

    private void createUIComponents() {
        tablePatients = new JTable();  // ← crée réellement la JTable
        scrollPane = new JScrollPane(tablePatients);
    }
}
