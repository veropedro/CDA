package exoPOO;

//EXO 3 JAVA POO rectangle
public class Rectangle {
    double longeur;
    double largeur;
    double surface = 0;
    double perimetre = 0;

    public Rectangle(double longeur, double largeur){
        this.longeur = longeur;
        this.largeur = largeur;
    }
    public void surface(){
        surface = longeur * largeur;
    }
    public void perimetre(){
        perimetre = 2 * (longeur + largeur);
    }
    public void afficher(){
        System.out.println("Surface : " + surface + "\nPerimetre : " + perimetre);
    }

}
