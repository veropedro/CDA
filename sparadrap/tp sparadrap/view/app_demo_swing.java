package fr.afpa.pompey.cda22045.view;

public class app_demo_swing {

    public static void main(String[] args) {
        app_demo_swing app_demo_swing = new app_demo_swing();
        app_demo_swing.start();
    }
    private void start() {
        BookEditor bookEditor = new BookEditor();
        bookEditor.setVisible(true);
    }
}
