import java.util.Scanner;

public class puissance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x;
        double y;
        double resultat;

        System.out.println("saisir la valeur de x : ");
        x = scanner.nextInt();

        System.out.println("saisir la valeur de y : ");
        y = scanner.nextInt();

        if(y == 0){
            System.out.println("Le resultat est 1");
        }
        else if(x == 0){
            System.out.println("Le resultat est 0");
        }
        else if(y!=0 && x!=0) {
            resultat = Math.pow(x, y);
            System.out.println("Le resultat est " + resultat);
        }
        scanner.close();
    }



}
