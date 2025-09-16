package tpPharma.testPharma;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tpPharma.exceptionPharma.ExceptionPharma;
import tpBibli.exception.SaisieException;
import tpPharma.modelePharma.Client;
import tpPharma.modelePharma.GestionClient;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GestionClientTest {


    GestionClient gestionClient;
    Client client;

    @BeforeEach
    void setUp() {
        gestionClient = new GestionClient();

        try {
            client = new Client("Dupont", "Jean", "10 rue de Test", "54000", "Nancy",
                    "0612345678", "jean.dupont@test.fr", "123456789012345", LocalDate.of(1990, 1, 1),
                    "MutuelleTest", "Dr Test");
        } catch (ExceptionPharma e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    void tearDown() {
    }

    // ---------- AJOUTER CLIENT ----------
    @Test
    void ajouterClientSuccess() throws ExceptionPharma {
        gestionClient.ajouterClient(client);
        assertTrue(gestionClient.getAllClients().contains(client));
    }

    @Test
    void ajouterClientFail() throws ExceptionPharma {
        gestionClient.ajouterClient(client);

        ExceptionPharma exception = assertThrows(ExceptionPharma.class, () -> {
            gestionClient.ajouterClient(client);
        });

        assertEquals("Le client existe déjà !", exception.getMessage());
    }

    // ---------- GET ALL CLIENTS ----------
    @Test
    void getAllClientsTest() throws ExceptionPharma {
        gestionClient.ajouterClient(client);
        assertTrue(gestionClient.getAllClients().contains(client));
    }

    // ---------- GET CLIENT BY NUMERO SECU ----------
    @Test
    void getClientByNumeroSecuSuccess() throws ExceptionPharma {
        gestionClient.ajouterClient(client);
        Client c = gestionClient.getClientByNumeroSecu(client.getNumeroSecu());
        assertEquals(client, c);
    }

    @Test
    void getClientByNumeroSecuFail() {
        Exception exception = assertThrows(Exception.class, () -> {
            gestionClient.getClientByNumeroSecu("123456789012345");
        });
        assertEquals("Le client n'existe pas !", exception.getMessage());
    }


    // ---------- DELETE CLIENT ----------
    @Test
    void deleteClientSuccess() throws ExceptionPharma {
        // Arrange : créer un client de test
        String numeroSecu = "123456789012345";
        Client client = new Client("Dupont", "Jean","15 rue Modif", "54000", "Nancy",
                "0612345678", "jean.dupont@test.fr", "123456789012345", LocalDate.of(1990, 1, 1),
                "MutuelleTest", "Dr Test");
        gestionClient.ajouterClient(client);

        // Act : supprimer le client
        gestionClient.deleteClient(numeroSecu);

        // Assert : vérifier que le client n'est plus dans la liste
        assertFalse(
                gestionClient.getAllClients().stream()
                        .anyMatch(c -> c.getNumeroSecu().equals(numeroSecu))
        );
    }

    @Test
    void deleteClientFail() {
        // Arrange : un numéro de sécu qui n'existe pas dans la base
        String numeroSecu = "123456789012345";

        // Act + Assert : on attend une ExceptionPharma avec un message précis
        ExceptionPharma exception = assertThrows(
                ExceptionPharma.class,
                () -> gestionClient.deleteClient(numeroSecu)
        );

        assertEquals("Le client n'existe pas !", exception.getMessage());
    }


    // ---------- AFFICHER CLIENT ----------
    @Test
    void afficherClientSucess() throws ExceptionPharma {
        // On crée un client et on l'ajoute
        Client client = new Client(
                "Dupont", "Jean", "15 rue Modif", "54000", "Nancy",
                "0612345678", "jean.dupont@test.fr",
                "123456789012345", LocalDate.of(1990, 1, 1),
                "MutuelleTest", "Dr Test"
        );
        gestionClient.ajouterClient(client);

        // On vérifie que la méthode afficherClient ne lance aucune erreur
        assertDoesNotThrow(() -> gestionClient.afficherClient());
    }


    @Test
    void afficherClientFail() {
        // On vérifie qu'une erreur est levée si la liste de clients est vide
        ExceptionPharma exception = assertThrows(
                ExceptionPharma.class,
                () -> gestionClient.afficherClient()
        );

        assertEquals("Aucun client à afficher !", exception.getMessage());
    }
}

