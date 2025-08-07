package heritage;

public class TestPersonne {
    public static void main(String[] args) {
        Personne personne1 = new Personne("john" , "nancy");
        Student student1 = new Student("john" , "nancy" , 11000, 3, "informatique");
        Staff staff1 = new Staff( "john" , "nancy",  2500, "afpa");

        System.out.println (personne1);
        System.out.println (student1);
        System.out.println (staff1);
    }

}
