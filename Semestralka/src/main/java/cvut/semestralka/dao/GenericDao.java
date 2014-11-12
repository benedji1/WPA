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
import org.springframework.stereotype.Component;

/**
 *
 * @author Koulas
 */
@Component("genericDao")
public class GenericDao extends AbstractDao {


    public <E> List<E> getAll(Class<E> clazz) {
        return getEntityManager().createQuery("select e from " + clazz.getSimpleName() + " e").getResultList();
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
            getEntityManager().remove(entity);
        }
    }

    public <E> Long remove(Class<E> clazz, Long id) {
        E entity = findBy(clazz, id);
        if (entity == null) {
            return -1L;
        } else {
            getEntityManager().remove(entity);
            return id;
        }
    }

    public <E> E findBy(Class<E> clazz, Long id) {
        return getEntityManager().find(clazz, id);
    }

    public <E> List<E> getByProperty(String property, Object value, Class<E> clazz) {
        String queryString = "SELECT e FROM " + clazz.getSimpleName() + " e WHERE e." + property + " = :value";
        return getEntityManager().createQuery(queryString).setParameter("value", value).getResultList();
    }

    public <E> E getById(Long id, Class<E> clazz) {
        return (E) ((Session) getEntityManager().getDelegate()).load(clazz, id);
    }

}
