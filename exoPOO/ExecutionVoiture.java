//suite EXO 2 JAVA POO voiture
public class ExecutionVoiture {
    public static void main(String[] args) {
        // Création d'une instance (objet) de Voiture
        Voiture maVoiture = new Voiture();

        // On modifie ses attributs grâce aux setters
        maVoiture.setMarque("citroen");
        maVoiture.setPrix(5000);

        // On affiche les infos
        maVoiture.afficher();
    }
}
