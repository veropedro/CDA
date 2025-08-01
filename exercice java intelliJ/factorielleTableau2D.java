import java.util.Scanner;

public class factorielleTableau2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] tableau = new int[2][10];
        int i;
        int j;
        int count = 1 ;
        int factorielle;



        for (i = 0; i < 10; i++) {             //C’est une boucle qui se répète 10 fois. i prend les valeurs : 0, 1, 2, ..., jusqu'à 9.
            tableau[0][i] = count;
            count = count + 1;

            factorielle = 1;

            for (j = 1; j <= tableau[0][i]; j++) {    //j sert uniquement à répéter les multiplications de 1 jusqu'à ce nombre (1 × 2 × 3 × 4 × 5)
                factorielle = factorielle * j;       //tableau[0][i] contient le nombre dont on veut calculer la factorielle (ex. : 5)
                tableau[1][i] = factorielle;}
        }

        // exemple :
        // compteur = 3 → on met 3 dans tableau[0][2]
        //On calcule 3! = 1 × 2 × 3 = 6
        //On met 6 dans tableau[1][2] => 1 est la 2e ligne du tableau et 2, l'indice 2 de la 1er ligne donc 3


        for (i = 0; i < 2; i++) {
            for (j = 0; j < 10; j++) {
                System.out.printf("%10d", tableau[i][j]);
            }
            System.out.println();
        }


    }
}
