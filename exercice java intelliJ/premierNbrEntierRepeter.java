import java.util.Scanner;

public class premierNbrEntierRepeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 1;
        int resultat = 0;
        int nombre;

        //afficher un message et demande de saisie
        System.out.println("entrez un nombre entier!");
        nombre = scanner.nextInt();

        do {
            resultat = resultat + count;
            count = count + 1;
        }
        while (count <= nombre);

        System.out.println("le resultat avec tant que : "+ resultat);
    }
}
