import java.util.Scanner;

public class factorielleTableau2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int resultat = 1;
        int count;
        int nombre;
        final int LIGNES = 2;
        final int COLONNES = 10;
        int[][] tableau = new int[LIGNES][COLONNES];
        int x;
        int y;


        if (jdcount == 0 || count == 1) {
            System.out.println("la factorielle de " + count + " est " + resultat);
        } else {
            for (int i = 0; i < LIGNES; i++) {
                System.out.print(i + "|");
            }
            for (int i = 0; i < LIGNES; i++) {
                for (int j = 0; j < COLONNES; j++)
                resultat = resultat * i;
            }

        }
        System.out.println();

        System.out.println("saisie un entier!");
        nombre = scanner.nextInt();

        count = nombre;


    }
}





















