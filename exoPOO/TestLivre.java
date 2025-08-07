package exoPOO;

public class TestLivre {
    public static void main(String[] args) {
        Livre livre1 = new Livre("petitPrince", "stExupery", 150 , 18.90);
        Livre livre2 = new Livre("laFemmeDeMenage" , "freidaMcFadden" , 180 , 14.80);
        Livre livre3 = new Livre();
        Livre livre4 = new Livre( "lou!", "julienNeel");

        livre1.afficheToi();
        livre2.afficheToi();

        int nbPagesTotal = livre1.getNbPages() + livre2.getNbPages();
        System.out.println("Nombre total de pages : " + nbPagesTotal);
        System.out.println();

        livre3.afficheToi();
        livre4.afficheToi();

    }
}
