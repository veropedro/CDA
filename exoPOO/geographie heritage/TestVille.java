package geographie;

public class TestVille {
    public static void main(String[] args) {
        Ville v = new Ville("Nancy");
        Capitale c = new Capitale ( "Nancy" , 100000);

        System.out.println(v);
        System.out.println(c);
    }
}
