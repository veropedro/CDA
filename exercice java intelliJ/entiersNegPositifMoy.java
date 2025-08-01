import java.util.Scanner;

public class entiersNegPositifMoy {
    public static void main(String[] args) {

        final int TAILLE = 10;
        int[] tableau = new int[TAILLE];
        Scanner scanner = new Scanner(System.in);
        int nombrePositifs = 0;
        int sommePositifs = 0;
        int nombreNegatifs = 0;
        int sommeNegatifs = 0;
        int nombreNuls = 0;
        double moyennePositifs = 0;
        double moyenneNegatifs = 0;

        //saisie de nombre a mettre dans le tableau et affichage tableau
        for (int i = 0; i < TAILLE; i++) {
            System.out.println("Entrez un entier (positif, negatif ou nul) ");
            tableau[i] = scanner.nextInt();}

            //affichage tableau
            System.out.println("Contenu du tableau :");
            for (int nombre : tableau) {
                System.out.print(nombre + "|");
            }
            System.out.println();

        //calculer nbr positif, negatif ou nul
        for (int i = 0; i < TAILLE; i++) {
            if (tableau[i] > 0) {
                nombrePositifs = nombrePositifs + 1;
                sommePositifs = sommePositifs + tableau[i];}

            else if (tableau[i] < 0) {
                nombreNegatifs = nombreNegatifs + 1;
                sommeNegatifs = sommeNegatifs + tableau[i];}

            else if (tableau[i] == 0) {
                nombreNuls = nombreNuls + 1;}

        }
        // Calculer les moyennes
        if (nombrePositifs > 0) {
            moyennePositifs = (double) sommePositifs / nombrePositifs;}
        else {
            moyennePositifs = 0;}

        if (nombreNegatifs > 0) {
            moyenneNegatifs = (double) sommeNegatifs / nombreNegatifs;}
        else {
        moyenneNegatifs = 0;}

        System.out.println("La moyenne des "+ nombrePositifs + " entiers positifs est: " + moyennePositifs);
        System.out.println("La moyenne des "+ nombreNegatifs + " entiers négatifs est: " + moyenneNegatifs);
        System.out.println("Il y a "+ nombreNuls + " valeurs nulles");


        scanner.close();

    }
}