package vue.controller.modele;

public class Soigneur extends Personnage {
    private int pdm;// point de magie

    public Soigneur(String nom, String race,  String classe, int niveau, int pdv,  int pdm) {
        super(nom, race, classe, niveau, pdv);
        setPdm(pdm);
    }

    public int getPdm() {
        return this.pdm;
    }
    public void setPdm(int pdm) {
        this.pdm = pdm;
    }

    @Override
    public String toString() {
        return super.toString() + ", point de magie : " + this.getPdm() ;
    }
}
