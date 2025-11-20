package fr.afpa.pompey.cda22045;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.ConsoleHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;


public class  MonLogger {

    private static final Logger logger = Logger.getLogger(MonLogger.class.getName());

    public static void main(String[] args) {

        try {
            // ⚡ Désactiver la propagation vers le parent pour éviter le double affichage
            logger.setUseParentHandlers(false);

            // Handler pour le fichier (chemin complet ou relatif)
            FileHandler fileHandler = new FileHandler(
                    "C:\\Users\\USER\\IdeaProjects\\sparadrap\\tpPharma\\mon_log.log", true
            );
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.ALL); // Tous les niveaux seront enregistrés dans le fichier

            // Handler pour la console
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.INFO); // Affiche INFO et plus grave
            consoleHandler.setFormatter(new SimpleFormatter());

            // Ajouter les handlers au logger
            logger.addHandler(fileHandler);
            logger.addHandler(consoleHandler);

            // Définir le niveau minimum du logger
            logger.setLevel(Level.ALL);

            // Exemples de logs
            logger.severe("Message CRITIQUE");
            logger.warning("Message WARNING");
            logger.info("Message INFO");
            logger.fine("Message FINE (DEBUG)");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
