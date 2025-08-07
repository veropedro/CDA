package exoPOO;

import geometry.Point;
import geometry.Cercle;

public class TestCercle {
    public static void main(String[] args) {
        Point centre = new Point(0, 0);
        Cercle monCercle = new Cercle(centre, 5);

        Point p = new Point(3, 4); // distance = 5
        monCercle.afficher();
        monCercle.testAppartenance(p);
    }

}
