package geometry;

public class Cercle {
    private Point centre;
    private double rayon;

    public Cercle(Point centre, double rayon) {
        this.centre = centre;
        this.rayon = rayon;
    }

    public double perimetre() {
        return 2 * Math.PI * rayon;
    }

    public double surface() {
        return Math.PI * rayon * rayon;
    }

    public void testAppartenance(Point p) {
        double dx = p.abscisse - centre.abscisse;
        double dy = p.ordonnee - centre.ordonnee;
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance <= rayon) {
            System.out.println("Le point appartient au cercle.");
        } else {
            System.out.println("Le point n'appartient pas au cercle.");
        }
    }

    public void afficher() {
        System.out.println("Centre : (" + centre.abscisse + ", " + centre.ordonnee + ")");
        System.out.println("Rayon : " + rayon);
        System.out.println("Périmètre : " + perimetre());
        System.out.println("Surface : " + surface());
    }
}
