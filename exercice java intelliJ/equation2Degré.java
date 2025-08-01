import java.util.Scanner;

public class equation2Degré {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a;
        int b;
        int c;
        double delta;
        float resultat;
        double resultat1;
        double resultat2;

        System.out.println("saisir la valeur de a : ");
        a = scanner.nextInt();

        System.out.println("saisir la valeur de b : ");
        b = scanner.nextInt();

        System.out.println("saisir la valeur de c : ");
        c = scanner.nextInt();

        delta = (b*b) - (4*a*c);

        if(delta<0){
            System.out.println("il n'a pas de solution pour cette equation");
        }
        else if (delta==0){
            resultat = -b/(2*a);
            System.out.println("il y a une seule solution pour cette equation");
            resultat = scanner.nextInt();
        }
        else if (delta>0) {
            System.out.println("il y a 2 solutions pour cette equation");
            resultat1 = (-b + Math.sqrt(delta)) / (2 * a);
            resultat2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println(resultat1 + " et " + resultat2);
        }
        scanner.close();
    }
}
