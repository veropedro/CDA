package fr.afpa.pompey.cda22045.view;

import fr.afpa.pompey.cda22045.modeleSwing.Genre;
import fr.afpa.pompey.cda22045.modeleSwing.Livre;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class ListLivres extends JFrame {
    private JPanel contentPane;
    private JTable ListLivresTable;
    private JScrollPane scrollPane;

    private Livre selected;
    private ArrayList<Livre> list;
    private String[] headers = {"Titre", "Auteur", "Dispo", "Genre"};


    public ListLivres() {
        Dimension dimension = new Dimension(800, 700);

        // ajout du titre à la fenetre
        this.setTitle("Biblio_demo");
        // ajout d'un icone
        // Mise en place de l'action de la croix par défaut
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // taille de la fenetre
        this.setSize(dimension);
        // ajout du contentPa ne à la fenetre
        this.setContentPane(contentPane);
        // redimensionnement interdit
        this.setResizable(false);
        // Set the frame location to the center of the screen
        this.setLocationRelativeTo(null);
        // création de la fenêtre
        this.pack();

        creationListLivres();
        setLivresTable(list, headers);

        ListLivresTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selected = selectedLivre();
                System.out.printf(selected.toString());
            }
        });

        ListLivresTable.addMouseListener(new MouseAdapter() {
        });
        scrollPane.addComponentListener(new ComponentAdapter() {
        });
    }

    private void creationListLivres() {
        Livre liv1 = new Livre("Toto1", "Jbe", false, Genre.BD.toString());
        Livre liv2 = new Livre("Toto2", "Jbe", false, Genre.BD.toString());
        Livre liv3 = new Livre("Toto3", "Jbe", false, Genre.BD.toString());
        Livre liv4 = new Livre("Toto4", "Jbe", false, Genre.BD.toString());
        list = new ArrayList<>();
        list.add(liv1);
        list.add(liv2);
        list.add(liv3);
        list.add(liv4);
    }

    /**
     * Methode de basique mais qui marche
     * @param livres
     * @param columnNames
     */
    private void setLivresTable(ArrayList<Livre> livres, String[]  columnNames) {

        // construction de la matrice pour remplir la table
        String[][] data = new String[livres.size()][columnNames.length];

        for (int i = 0; i < livres.size(); i++) {
            data[i][0] = livres.get(i).getTitre();
            data[i][1] = livres.get(i).getAuteur();
            data[i][2] = livres.get(i).getGenre();
            data[i][3] = String.valueOf(livres.get(i).isActive());
        }

        this.ListLivresTable.setModel(new DefaultTableModel(data, columnNames));

    }

    /**
     * Methode pour selection un element de la table
     * @return
     */
    private Livre selectedLivre() {
        int selected = ListLivresTable.getSelectedRow();
        if (selected == -1) return null; // aucune ligne sélectionnée

        int modelRow = ListLivresTable.convertRowIndexToModel(selected);
        DefaultTableModel model = (DefaultTableModel) ListLivresTable.getModel();

        String titre = (String) model.getValueAt(modelRow, 0);
        String auteur = (String) model.getValueAt(modelRow, 1);
        String genre = (String) model.getValueAt(modelRow, 2);
        boolean active = Boolean.parseBoolean(model.getValueAt(modelRow, 3).toString());

        return new Livre(titre, auteur, active, genre);
    }
}


