// EXO 2 JAVA POO voiture
public class Voiture {
    private String marque;
    private Double prix;

    public Voiture() {
        this.marque = "inconnue";
        this.prix = prix;
    }

    public String getMarque(){
        return marque;
    }
    public void setMarque(String marque){
        this.marque = marque;
    }

    public double getPrix(){
        return prix;
    }
    public void setPrix(double prix){
        this.prix = prix;
    }

    public void afficher() {
        System.out.println("Marque: " + this.marque);
        System.out.println("Prix: " + this.prix);
    }
}
