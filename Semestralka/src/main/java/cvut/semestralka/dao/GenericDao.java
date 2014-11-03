/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.semestralka.dao;

import cvut.semestralka.bo.DomainEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author Koulas
 */
public class GenericDao extends AbstractDao{

    private static GenericDao genericDao;

    private GenericDao() {
    }

    public static GenericDao getDao() {
        if (genericDao == null) {
            genericDao = new GenericDao();
        }
        return genericDao;
    }

    public <E> List<E> getAll(Class<E> clazz) {
        List<E> entities = getEntityManager().createQuery("select e from " + clazz.getSimpleName() + " e").getResultList();
        return entities;
    }

    public <E extends DomainEntity> E saveOrUpdate(E instance) {
        if (instance.getId() == null) {
            this.save(instance);
        } else {
            this.update(instance);
        }
        return instance;
    }

    public <E> E save(E instance) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();

        manager.persist(instance);

        manager.getTransaction().commit();
        manager.close();

        return instance;
    }

    public <E> E update(E instance) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();

        manager.merge(instance);

        manager.getTransaction().commit();
        manager.close();

        return instance;
    }

    public <E> void removeAll(Class<E> clazz) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();

        List<E> entities = getAll(clazz);

        for (E entity : entities) {
            manager.remove(entity);
        }

        manager.getTransaction().commit();
    }

    public <E> Long remove(Class<E> clazz, Long id) {
        E entity = findBy(clazz, "id", id.toString());
        EntityManager manager = getEntityManager();

        manager.getTransaction().begin();
        manager.remove(entity);
        manager.getTransaction().commit();
        manager.close();

        return id;
    }

    public <E> E findBy(Class<E> clazz, String attrName, String attrVal) {
        EntityManager em = getFactory().createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(clazz);
        Root<E> c = cq.from(clazz);
        ParameterExpression<String> param = cb.parameter(String.class);
        cq.select(c).where(cb.equal(c.get(attrName), param));

        TypedQuery<E> q = em.createQuery(cq);
        q.setParameter(param, attrVal);
        List<E> list = q.getResultList();
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (list.size() > 1) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.WARNING, "A query with unique attribute returned not unique result!");
            return null;
        }
        return list.get(0);
    }

    public <E> List<E> getByProperty(String property, Object value, Class<E> clazz) {
        String queryString = "SELECT e FROM " + clazz.getSimpleName()+ " e WHERE e." + property + " = :value";
        return getEntityManager().createQuery(queryString).setParameter("value", value).getResultList();
    }

    public <E> E getById(Long id, Class<E> clazz) {
        return (E) ((Session) getEntityManager().getDelegate()).load(clazz, id);
    }
    
}
