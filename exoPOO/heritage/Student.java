package heritage;

public class Student extends Personne {
    public int frais;
    public int annee;
    public String programme;

    public Student(String nom, String adresse, int frais, int annee , String programme) {
        super (nom, adresse);
        this.frais = frais;
        this.annee = annee;
        this.programme = programme;
    }

    @Override
    public String toString() {
        return super.toString() + ", frais : " + frais + ", annee : " + annee + ", programme : " + programme ;
    }


}
