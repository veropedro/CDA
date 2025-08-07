package heritage;

public class Staff extends Personne {
    public int pay;
    public String school;

    public Staff(String nom, String adresse, int pay, String school) {
        super(nom, adresse);
        this.pay = pay;
        this.school = school;
    }

    @Override
    public String toString() {
        return super.toString() + ", pay : " + pay + ", school : " + school ;
    }
}
