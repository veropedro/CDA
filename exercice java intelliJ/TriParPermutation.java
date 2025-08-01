import java.util.Scanner;

public class TriParPermutation {

    // Fonction qui trie un tableau entier par permutation (tri à bulles)
    public static void triParPermutation(int[] tableau) {
        int n = tableau.length;
        boolean permut;
        do {
            permut = false;
            for (int i = 0; i < n - 1; i++) {
                if (tableau[i] > tableau[i + 1]) {
                    // échange
                    int temp = tableau[i];
                    tableau[i] = tableau[i + 1];
                    tableau[i + 1] = temp;
                    permut = true;
                }
            }
            n--; // optimisation : la plus grande valeur est déjà à la fin
        } while (permut);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Combien d'entiers voulez-vous saisir ?");
        int taille = scanner.nextInt();

        int[] tableau = new int[taille];

        // Saisie des éléments du tableau
        for (int i = 0; i < taille; i++) {
            System.out.print("Entrez l'entier " + (i + 1) + " : ");
            tableau[i] = scanner.nextInt();
        }

        // Affichage du tableau non trié
        System.out.println("Tableau non trié :");
        for (int valeur : tableau) {
            System.out.print(valeur + " ");
        }
        System.out.println();


        // Appel de la fonction de tri
        triParPermutation(tableau);

        // Affichage du tableau trié
        System.out.println("Tableau trié :");
        for (int valeur : tableau) {
            System.out.print(valeur + " ");
        }
        System.out.println();

        scanner.close();
    }
}






