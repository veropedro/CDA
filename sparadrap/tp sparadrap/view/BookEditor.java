package fr.afpa.pompey.cda22045.view;
import fr.afpa.pompey.cda22045.modeleSwing.Abonne;
import fr.afpa.pompey.cda22045.modeleSwing.Genre;
import fr.afpa.pompey.cda22045.modeleSwing.Livre;
import fr.afpa.pompey.cda22045.DAO.AbonneDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class BookEditor extends JFrame {


    private JPanel contentPane;
    private JTextField bookNameTextField;
    private JTextField authorNameTextField;
    private JComboBox genreComboBox;
    private JCheckBox isTakenCheckBox;
    private JButton validerButton;
    private JButton annulerButton;

    public BookEditor() {

        this.setTitle("Book Editor");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setContentPane(contentPane);

        this.setResizable(false);

        this.setLocationRelativeTo(null);

        this.pack();

        setComboBox();

        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validForm();
            }
        });
        annulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });
    }

    private void setComboBox() {

        this.genreComboBox.removeAllItems();
        for (Genre genre : Genre.values()) {
            genreComboBox.addItem(genre);
        }
        this.genreComboBox.setSelectedIndex(-1);

    }

    private void resetForm() {
        this.bookNameTextField.setText("");
        this.authorNameTextField.setText("");
        this.genreComboBox.setSelectedIndex(-1);
        this.isTakenCheckBox.setSelected(false);
    }

    private void validForm() {

        String bookName = this.bookNameTextField.getText();
        String authorName = this.authorNameTextField.getText();
        String genre = this.genreComboBox.getSelectedItem().toString();
        boolean isTaken = this.isTakenCheckBox.isSelected();

        Abonne abo = new Abonne(bookName, authorName);
        AbonneDAO abonneDAO = null;
        try {
            abonneDAO = new AbonneDAO();
            abo = abonneDAO.create(abo);
            System.out.println(abo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        Livre livre = new Livre(bookName, authorName, isTaken, genre);

        //TODO : persister la données BDD // liste
        System.out.println(livre);

    }

}
