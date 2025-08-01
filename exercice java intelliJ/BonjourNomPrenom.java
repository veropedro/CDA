import java.util.Scanner;

public class BonjourNomPrenom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("entrez votre prenom");
        String prenom = scanner.nextLine();

        System.out.println("entrez votre nom");
        String nom = scanner.nextLine();

        System.out.println("Bonjour " + prenom + ", votre nom est " + nom + ".");

        scanner.close();
    }
}