package exoPOO;

// EXO 1 JAVA POO compte bancaire
public class Compte {
    public double solde;

    public Compte(double solde) {
        this.solde = solde;
    }

    public void deposer(double montant) {
        double nouveauSolde = this.solde + montant;
        this.solde = nouveauSolde;
        System.out.println("Dépôt de " + montant + " € effectué.");
    }

    public void retirer(double montant) {
        double nouveauSolde = this.solde - montant;
        this.solde = nouveauSolde;
        System.out.println("Retrait de " + montant + " € effectué.");
    }

    public void afficher() {
        System.out.println("Solde actuel : " + this.solde + " €");
    }
}















