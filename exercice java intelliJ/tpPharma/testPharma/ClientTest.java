package tpPharma.testPharma;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tpPharma.exceptionPharma.ExceptionPharma;
import tpPharma.modelePharma.Client;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import tpBibli.exception.SaisieException;

import java.text.ParseException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClientTest {

    Client client;

    @BeforeEach
    void setUp() {
        try {
            client = new Client("Dupont", "Jean", "10 rue de Test", "54000", "Nancy",
                    "0612345678", "jean.dupont@test.fr", "1234567890123", LocalDate.of(1990, 1, 1),
                    "MutuelleTest", "DrTest");
        } catch (ExceptionPharma e) {
            throw new RuntimeException(e);
        }
    }

    // ---------- Nom ----------
    @Test
    void setNomSuccess() throws ExceptionPharma {
        client.setNom("Durand");
        assertEquals("Durand", client.getNom());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void setNomFail(String nom) {
        ExceptionPharma exception = assertThrows(ExceptionPharma.class, () -> {
            client.setNom(nom);
        });
        assertEquals("Erreur dans le nom ! Merci de corriger", exception.getMessage());
    }

    // ---------- Prénom ----------
    @Test
    void setPrenomSuccess() throws ExceptionPharma {
        client.setPrenom("Vero");
        assertEquals("Vero", client.getPrenom());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void setPrenomFail(String prenom) {
        ExceptionPharma exception = assertThrows(ExceptionPharma.class, () -> {
            client.setPrenom(prenom);
        });
        assertEquals("Erreur dans le prenom ! Merci de corriger", exception.getMessage());
    }

    // ---------- Adresse ----------
    @Test
    void setAdresseSuccess() throws ExceptionPharma {
        client.setAdresse("15 rue Exemple");
        assertEquals("15 rue Exemple", client.getAdresse());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void setAdresseFail(String adresse) {
        ExceptionPharma exception = assertThrows(ExceptionPharma.class, () -> {
            client.setAdresse(adresse);
        });
        assertEquals("Erreur dans l'adresse ! Merci de corriger", exception.getMessage());
    }

    // ---------- Code postal ----------
    @Test
    void setCodePostalSuccess() throws ExceptionPharma {
        client.setCodePostal("75000");
        assertEquals("75000", client.getCodePostal());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void setCodePostalFail(String codePostal) {
        ExceptionPharma exception = assertThrows(ExceptionPharma.class, () -> {
            client.setCodePostal(codePostal);
        });
        assertEquals("Erreur dans le code postal ! Merci de corriger", exception.getMessage());
    }

    // ---------- Ville ----------
    @Test
    void setVilleSuccess() throws ExceptionPharma {
        client.setVille("Paris");
        assertEquals("Paris", client.getVille());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void setVilleFail(String ville) {
        ExceptionPharma exception = assertThrows(ExceptionPharma.class, () -> {
            client.setVille(ville);
        });
        assertEquals("Erreur dans la ville ! Merci de corriger", exception.getMessage());
    }

    // ---------- Téléphone ----------
    @Test
    void setTelephoneSuccess() throws ExceptionPharma {
        client.setTelephone("0611223344");
        assertEquals("0611223344", client.getTelephone());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void setTelephoneFail(String telephone) {
        ExceptionPharma exception = assertThrows(ExceptionPharma.class, () -> {
            client.setTelephone(telephone);
        });
        assertEquals("Erreur dans le numéro de telephone ! Merci de corriger", exception.getMessage());
    }

    // ---------- Email ----------
    @Test
    void setEmailSuccess() throws ExceptionPharma {
        client.setEmail("test@example.com");
        assertEquals("test@example.com", client.getEmail());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void setEmailFail(String email) {
        ExceptionPharma exception = assertThrows(ExceptionPharma.class, () -> {
            client.setEmail(email);
        });
        assertEquals("Erreur dans l'email ! Merci de corriger", exception.getMessage());
    }

    // ---------- Numéro de sécurité sociale ----------
    @Test
    void setNumeroSecuSuccess() throws ExceptionPharma {
        client.setNumeroSecu("9876543210987");
        assertEquals("9876543210987", client.getNumeroSecu());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void setNumeroSecuFail(String numeroSecu) {
        ExceptionPharma exception = assertThrows(ExceptionPharma.class, () -> {
            client.setNumeroSecu(numeroSecu);
        });
        assertEquals("Erreur dans le numero de securité sociale ! Merci de corriger", exception.getMessage());
    }

    // ---------- Date de naissance ----------
    @Test
    void setDateNaissanceSuccess() throws ExceptionPharma {
        client.setDateNaissance("2000-01-01");
        assertEquals(LocalDate.of(2000, 1, 1), client.getDateNaissance());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void setDateNaissanceFail(String dateStr) throws ExceptionPharma {
        ExceptionPharma exception = assertThrows(ExceptionPharma.class, () -> {
            client.setDateNaissance(dateStr);
        });
        assertEquals("Erreur dans la date ! Format attendu : yyyy-MM-dd", exception.getMessage());
    }

    // ---------- Mutuelle ----------
    @Test
    void setMutuelleSuccess() throws ExceptionPharma {
        client.setMutuelle("MutuellePlus");
        assertEquals("MutuellePlus", client.getMutuelle());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void setMutuelleFail(String mutuelle) {
        ExceptionPharma exception = assertThrows(ExceptionPharma.class, () -> {
            client.setMutuelle(mutuelle);
        });
        assertEquals("Erreur dans la mutuelle ! Merci de corriger", exception.getMessage());
    }

    // ---------- Médecin traitant ----------
    @Test
    void setMedecinTraitantSuccess() throws ExceptionPharma {
        client.setMedecinTraitant("Dr Martin");
        assertEquals("Dr Martin", client.getMedecinTraitant());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void setMedecinTraitantFail(String medecin) {
        ExceptionPharma exception = assertThrows(ExceptionPharma.class, () -> {
            client.setMedecinTraitant(medecin);
        });
        assertEquals("Erreur dans le medecin traitant ! Merci de corriger", exception.getMessage());
    }

}
