package cvut.semestralka.service;

import cvut.semestralka.dao.GenericDao;
import cvut.semestralka.dao.ManyToManyDao;
import javax.ejb.BeforeCompletion;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

/**
 *
 * @author Koulas
 */
public class AbstractServiceTest{
    private EntityManagerFactory entityManagerFactory;
    private EntityManager manager;
    private EntityTransaction transaction;
    
    public AbstractServiceTest() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit");
    }
    
    @Before
    public void setUp() throws Exception {
        this.manager = entityManagerFactory.createEntityManager();
        transaction = manager.getTransaction();
        transaction.begin();
    }
    
    @After
    public void after(){
        transaction.rollback();
    } 
    
}
