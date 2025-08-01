import java.util.Scanner;

public class calculatrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double operande1;
        double operande2;
        char operateur;
        double resultat = 0;
        boolean continuer = true;

        while (continuer) {
            // System.out.println(le menu et obtenir l'opération
            System.out.println("Choisissez une opération : +, -, *, /");
            operateur = scanner.nextLine().charAt(0);


            // Vérifier que l'opérateur est valide
            if (operateur != '+' && operateur != '*' && operateur != '/' && operateur != '-') {
                System.out.println("Opérateur invalide. Veuillez entrer un opérateur valide.");
                continue;
            }

            // Saisie des opérandes
            System.out.println("Entrez le premier opérande (nombre réel) : ");
            if (!scanner.hasNextDouble()) {  // (verifie si c'est bien une decimal)
                System.out.println("Le premier opérande est invalide. Veuillez entrer un opérande valide.");
                scanner.nextLine();
                continue;
            }
            operande1 = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Entrez le second opérande (nombre réel) : ");
            if (!scanner.hasNextDouble()) {   // (verifie si c'est bien une decimal)
                System.out.println("Le second opérande est invalide. Veuillez entrer un opérande valide.");
                scanner.nextLine();
                continue;
            }
            operande2 = scanner.nextDouble();
            scanner.nextLine();


            //calcul resultat
            switch (operateur) {
                case '+':
                    resultat = operande1 + operande2;
                    break;
                case '-':
                    resultat = operande1 - operande2;
                    break;
                case '*':
                    resultat = operande1 * operande2;
                    break;
                case '/':
                    if (operande2 == 0) {
                        System.out.println("Erreur : Division par zéro.");
                        continue;
                    } else {
                        resultat = operande1 / operande2;
                        break;
                    }
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    continue;
            }


            // System.out.println(le résultat
            System.out.println("Le résultat de "+ operande1 + " " + operateur + " " + operande2 + " est : " + resultat);


        }

    }
}
