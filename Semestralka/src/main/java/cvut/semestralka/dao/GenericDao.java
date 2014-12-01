package cvut.semestralka.dao;

import cvut.semestralka.bo.DomainEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.stereotype.Component;

/**
 *
 * @author Koulas
 */
@Component("genericDao")
public class GenericDao {

    @Autowired
    protected EntityManagerFactory entityManagerfactory;

    protected EntityManager getEntityManager() {
        return EntityManagerFactoryUtils.getTransactionalEntityManager(entityManagerfactory); //entity manager with @Transactional support
    }

    public GenericDao() {
    }

    public <E> List<E> getAll(Class<E> clazz) {
        EntityManager manager = getEntityManager();
        if (entityManagerfactory == null) {
            throw new NullPointerException("factory is null !!");
        }
        if(manager == null){
            throw  new NullPointerException("manager is null !!");
        }
        Query query = manager.createQuery("select e from " + clazz.getSimpleName() + " e");
        return query.getResultList();
    }

    public <E extends DomainEntity> E saveOrUpdate(E instance) {
        if (instance.getId() == null) {
            getEntityManager().persist(instance);
        } else {
            getEntityManager().merge(instance);
        }
        return instance;
    }

    public <E> void removeAll(Class<E> clazz) {
        List<E> entities = getAll(clazz);
        for (E entity : entities) {
            remove(clazz, ((DomainEntity) entity).getId());
        }
    }

    public <E> Long remove(Class<E> clazz, Long id) {
        getEntityManager().remove(getById(id, clazz));
        return id;
    }

    public <E> List<E> getByProperty(String property, Object value, Class<E> clazz) {
        String queryString = "SELECT e FROM " + clazz.getSimpleName() + " e WHERE e." + property + " = :value";
        return getEntityManager().createQuery(queryString).setParameter("value", value).getResultList();
    }

    public <E> E getById(Long id, Class<E> clazz) {
        return getEntityManager().find(clazz, id);
    }
}
