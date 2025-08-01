import java.util.Scanner;

public class factorielletantque {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int resultat = 1;
        int count;
        int nombre;

        System.out.println("Saisis un entier !");
        nombre = scanner.nextInt();

        // Cas particulier pour 0 et 1
        if (nombre == 0 || nombre == 1) {
            System.out.println("La factorielle de " + nombre + " est 1");
        } else {
            count = nombre;

            while (count > 1) {
                resultat *= count;
                count--;
            }

            System.out.println("La factorielle de " + nombre + " est " + resultat);
        }

        scanner.close();
    }
}