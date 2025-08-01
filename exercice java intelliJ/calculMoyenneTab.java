import java.util.Random;

public class calculMoyenneTab {
    public static void main(String[] args) {

        final int TAILLE = 10;
        int[] tableau = new int[TAILLE];
        Random rand = new Random();

        // Remplissage aléatoire du tableau
        for (int i = 0; i < TAILLE; i++) {
            tableau[i] = rand.nextInt(101);
        }

        // Recherche de la moyenne
        int somme = 0;
        for (int i = 0; i < TAILLE; i++) {
                somme = somme + tableau[i];
        }
        int moyenne = somme / TAILLE;

        // Affichage du contenu du tableau
        System.out.println("contenu du tableau : ");
        for (int nombre : tableau) {
            System.out.print(nombre + "|");
        }

        // Affichage de la valeur maximale
        System.out.println("\nLa moyenne des valeurs entieres dans le tableau est " + moyenne);

    }
}

