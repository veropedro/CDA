package tpPharma.modelePharma;
import tpPharma.modelePharma.Client;
import tpPharma.exceptionPharma.ExceptionPharma;
import java.util.ArrayList;
import java.util.Optional;

public class  GestionClient {
    private static ArrayList<Client> clients;

    public GestionClient() {
        this.clients = new ArrayList<>();
    }

    // CREATE : Ajouter un client
    public void ajouterClient(Client client) throws ExceptionPharma {
        // Vérifie que le client n'est pas nul
        if (client == null) {
            throw new IllegalArgumentException("Le client ne peut pas être null !");
        }

        // Vérifie si un client avec le même numéro de sécu existe déjà
        for (Client c : clients) {
            if (c.getNumeroSecu().equals(client.getNumeroSecu())) {
                throw new ExceptionPharma("Le client existe déjà !");
            }
        }

        // Ajoute le client à la liste
        clients.add(client);
    }

    // READ : Récupérer tous les clients
    public ArrayList<Client> getAllClients() {
        return clients;
    }

    // READ : Récupérer un client par numéro de sécurité sociale
    public Client getClientByNumeroSecu(String numeroSecu) throws ExceptionPharma {
        Optional<Client> client = clients.stream()
                .filter(c -> c.getNumeroSecu().equals(numeroSecu))
                .findFirst();

        if (client.isPresent()) {
            return client.get();
        } else {
            throw new ExceptionPharma("Le client n'existe pas !");
        }
    }


    // DELETE : Supprimer un client par numéro de sécurité sociale
    public void deleteClient(String numeroSecu) throws ExceptionPharma {
        // Vérifier que le numéro de sécu n'est pas nul ou vide
        if (numeroSecu == null || numeroSecu.isEmpty()) {
            throw new IllegalArgumentException("Le numéro de sécurité sociale ne peut pas être vide !");
        }

        // Chercher le client correspondant
        Client client = getClientByNumeroSecu(numeroSecu);

        // Vérifier que le client existe
        if (client == null) {
            throw new ExceptionPharma("Le client n'existe pas !");
        }

        // Supprimer le client
        clients.remove(client);
    }

    public void afficherClient() throws ExceptionPharma {            //affiche la liste des abonnés
        if (clients == null || clients.isEmpty()) {
            throw new ExceptionPharma("Aucun client à afficher !");
        }
        for (Client c : clients) {
            System.out.println(c);
        }
    }
}


