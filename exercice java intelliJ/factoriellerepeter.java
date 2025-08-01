import java.util.Scanner;

public class factoriellerepeter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int resultat = 1;
        int count;
        int nombre;

        System.out.println("saisie un entier!");
        nombre = scanner.nextInt();

        count = nombre;

        while (count == 0 || count == 1)
        {
            System.out.println("la factorielle de " + count + " est " + resultat);
            return;
        }
        do {
            resultat = resultat * count;
            count--;
        }
        while (count > 1);
        System.out.println("la factorielle de " + nombre + " est " + resultat);

        scanner.close();
    }

}

