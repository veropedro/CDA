package fr.afpa.pompey.cda22045.DAO;

import fr.afpa.pompey.cda22045.connectionBDD.Singleton;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Classe abstraite DAO
 * @param <T>
 */
public abstract class DAO<T> {

    /**
     * instance singleton de connexion vers la base de données
     */
    protected Connection connection;

    protected DAO() throws SQLException, IOException, ClassNotFoundException {
        this.connection = Singleton.getInstanceDB();
    }


    /**
     * Creation et persistance d'un objet T
     * @param entity
     * @return
     */
    public abstract T create(T entity) throws SQLException;

    /**
     * Mise à jour et persistance d'un objet T
     * @param entity
     * @return 1 for success 0 for error
     */
    public abstract boolean update(T entity) throws SQLException;

    /**
     * Suppression et persistance d'un objet T
     * @param pId
     * @return 1 for success 0 for error
     */
    public abstract boolean deleteById(Integer pId) throws SQLException;

    /**
     * Recherche par id
     * @param pId
     * @return l'objet T ciblé
     */
    public abstract T findById(Integer pId) throws SQLException;

    /**
     * recherche global
     * @return liste de tous les objets T
     */
    public abstract List<T> findAll() throws SQLException;

    /**
     * Methode de cloture de la connexion
     */
    public abstract void closeConnection() throws SQLException;

}
