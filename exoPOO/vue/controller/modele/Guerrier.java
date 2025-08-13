package vue.controller.modele;

public class Guerrier extends Personnage {
    private int pdf;// point de force

    public Guerrier(String nom, String race,  String classe, int niveau, int pdv,  int pdf) {
        super(nom, race, classe, niveau, pdv);
        setPdf(pdf);
    }

    public int getPdf() {
        return this.pdf;
    }
    public void setPdf(int pdf) {
        this.pdf = pdf;
    }

    @Override
    public String toString() {
        return super.toString() + ", point de force : " + this.getPdf() ;
    }

}
