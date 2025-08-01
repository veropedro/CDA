import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class rechercheDichotomique {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int x;
        final int TAILLE = 10;
        int[] tableau = new int[TAILLE];
        int indiceBas = 0;
        int indiceHaut = tableau[TAILLE-1];
        int indiceMilieu = (indiceHaut + indiceBas) / 2;
        boolean trouvé = false;

        for (int i = 0; i < TAILLE ; i++) {
            tableau[i] = rand.nextInt(101);}

            Arrays.sort(tableau);

            System.out.println("contenu du tableau : ");
            for (int nombre : tableau) {
            System.out.print(nombre + "|");
        }

            System.out.println("\nSaisir la valeur de x : ");
            x = scanner.nextInt();


            while (trouvé == false && indiceBas <= indiceHaut) {
                if (x < tableau[indiceMilieu]) {
                    indiceHaut = indiceMilieu - 1;

                } else if (x > tableau[indiceMilieu]) {
                    indiceBas = indiceMilieu + 1;
                } else {
                    trouvé = true;
                }
            }

            if (trouvé == true) {
                System.out.println( "\n" + x + "se trouve au rang" + "dans le tableau");
            } else if (trouvé == false) {
                System.out.println("\n-1");
            }

    }
}


