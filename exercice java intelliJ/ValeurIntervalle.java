import java.util.Scanner;

public class ValeurIntervalle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nombre;

        System.out.println("Entrez un nombre entre 10 et 20?");
        nombre = scanner.nextInt();

        while (nombre < 10 || nombre > 20) {
            if (nombre < 10) {
                System.out.println("Plus grand");
            } else if (nombre > 20) {
                System.out.println("Plus petit");
            }
            System.out.println("Retente ta chance?");
            nombre = scanner.nextInt();

        }
        System.out.println("Gagné!");
        scanner.close();


    }
}