import java.util.Scanner;

public class factoriellePour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int resultat = 1;
        int count;
        int nombre;

        System.out.println("saisie un entier!");
        nombre = scanner.nextInt();

        count = nombre;

        if (count == 0 || count == 1) {
            System.out.println("la factorielle de " + count + " est " + resultat);
            }else {
                for ( int i = 2; i <= count; i++ )
                    resultat = resultat * i ;

                }
                System.out.println("la factorielle de " + count + " est " + resultat);
    }
}
