/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.semestralka.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Koulas
 */
public abstract class AbstractDao {

    protected static EntityManagerFactory factory;

    protected static EntityManagerFactory getFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("persistence_unit");
        }
        return factory;
    }

    protected static EntityManager getEntityManager() {
        return getFactory().createEntityManager();
    }
}
