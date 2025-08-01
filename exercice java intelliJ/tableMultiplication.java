import java.util.Scanner;

public class tableMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int LIGNES = 10;
        final int COLONNES = 10;
        int[][] tableau = new int[LIGNES][COLONNES];
        int x;
        int y;
        int produit;

        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                tableau[i][j] = i * j; // on fait un produit de i et j pour chaque indice
            }
        }

        System.out.println("Contenu du tableau 2D :");
        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                System.out.print(tableau[i][j] + "\t"); // "\t" = tabulation (espace)
            }
            System.out.println(); // saut de ligne après chaque ligne
        }
        System.out.println();


        String reponse;
        do {
            System.out.println("saisir la valeur entre 1 et 9: ");
            x = scanner.nextInt();

            System.out.println("saisir la valeur entre 1 et 9: ");
            y = scanner.nextInt();


            if (x < 1 || x > 9 || y < 1 || y > 9) {
                System.out.println("Les valeurs doivent être comprises entre 1 et 9.");
            } else {
                produit = tableau[x][y];
                System.out.println("Le résultat de " + x + " x " + y + " est " + produit);
            }

            System.out.println("Souhaitez vous encore un calcul?");
            scanner.nextLine(); // pour absorber le retour à la ligne restant
            reponse = scanner.nextLine().trim().toLowerCase();
        }while(reponse.equals("oui"));

        System.out.println("Merci d'avoir utilisé la table de multiplication !");
        scanner.close();

    }

}
