/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.semestralka.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;

/**
 *
 * @author Koulas
 */
public abstract class AbstractDao {
    @Autowired
    protected EntityManagerFactory entityManagerfactory;

  
    protected EntityManager getEntityManager() {
       return EntityManagerFactoryUtils.getTransactionalEntityManager(entityManagerfactory);
    }
}
