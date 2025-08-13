package geographie;

public class Capitale extends Ville{
    public int nbHab;


    public Capitale(String nom , int nbHab) {
        super (nom);
        if (nbHab < 0) {
            System.out.println ("Un nombre d'habitant doit être positif");
            this.nbHab = -1;
        }else{
            this.nbHab = nbHab;
        }
    }

    public String getnbHab() {
        return Integer.toString(this.nbHab);
    }
    public void setnbHab(int nbHab) {
        if (nbHab <= 0 ) {
            System.out.println ("Un nombre d'habitant doit être positif et la modification n'a pas été prise en compte.");
        }
    }
    @Override
    public String toString() {
        if(nbHab == -1 || nbHab == 0){
            return super.toString() + ", nbHab : inconnu " ;
        }else{
            return super.toString() + ", nbHab : " + this.nbHab;
        }
    }
}
