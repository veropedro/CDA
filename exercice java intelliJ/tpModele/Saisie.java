package tpModele;
import java.util.Scanner;

public class Saisie {
    private static Scanner sc = new Scanner(System.in);

    public static int lireEntier() {
        return sc.nextInt();
    }

    public static String lireChaine() {
        // vider le buffer du sc
        sc.nextLine();
        return sc.nextLine();
    }
}

