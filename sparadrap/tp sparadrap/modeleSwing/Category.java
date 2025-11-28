package fr.afpa.pompey.cda22045.modeleSwing;

public class Category {

    private int id;
    private String label;

    public int getId() { return id; }
    public String getLabel() { return label; }

    @Override
    public String toString() {
        return label; // Ce qui sera affiché dans la JComboBox
    }
}
