package fr.afpa.pompey.cda22045.connectionBDD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class App_Singleton {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        App_Singleton app_singleton = new App_Singleton();
        // avec singleton
        App_Singleton.testConnectionWithSingleton();
    }

    private static void testConnectionWithSingleton() {
        try {
            Connection con1 = Singleton.getInstanceDB();
            Connection con2 = Singleton.getInstanceDB();

            System.out.println("Connexion 1 : " + con1);
            System.out.println("Connexion 2 : " + con2);
            System.out.println("Même connexion ? " + (con1 == con2));

            Singleton.closeInstanceDB();
            System.out.println("Connexion fermée");

        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

