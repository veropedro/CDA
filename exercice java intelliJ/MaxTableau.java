import java.util.Random;

public class MaxTableau {
    public static void main(String[] args) {

        final int taille = 10;
        int[] tableau = new int[taille];
        Random rand = new Random();

        // Remplissage aléatoire du tableau
        for (int i = 0; i < taille; i++) {
            tableau[i] = rand.nextInt(101);
        }

        // Recherche de la valeur maximal
        int maxi = tableau[0];
        for (int i = 1; i < taille; i++) {
            if (tableau[i] > maxi) {
                maxi = tableau[i];
            }
        }

        // Affichage du contenu du tableau
        System.out.println("contenu du tableau : ");
        for (int nombre : tableau) {
            System.out.print(nombre + "|");
        }

        // Affichage de la valeur maximale
        System.out.println("\nL'entier maxi dans le tableau est " + maxi);

    }
}


