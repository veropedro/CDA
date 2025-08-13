package vue.controller.modele;

public class Voleur extends Personnage {
    private int pdh;// point de

    public Voleur(String nom, String race,  String classe, int niveau, int pdv,  int pdh) {
        super(nom, race, classe, niveau, pdv);
        setPdh(pdh);
    }

    public int getPdh() {
        return this.pdh;
    }
    public void setPdh(int pdh) {
        this.pdh = pdh;
    }

    @Override
    public String toString() {
        return super.toString() + ", point de force : " + this.getPdh() ;
    }

}

