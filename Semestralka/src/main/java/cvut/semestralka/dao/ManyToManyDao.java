package cvut.semestralka.dao;

import cvut.semestralka.bo.DomainEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.stereotype.Component;

/**
 *
 * @author Koulas
 */
@Component("manyToManyDao")
public class ManyToManyDao {

    @Autowired
    protected EntityManagerFactory entityManagerfactory;

    protected EntityManager getEntityManager() {
        return EntityManagerFactoryUtils.getTransactionalEntityManager(entityManagerfactory); //entity manager with @Transactional support
    }

    // vrati vsechny herce kteri hraji ve silmu s id idFilm
    public <E> List<E> getFilmActors(Long idFilm) {
        return getEntityManager().createNamedQuery("getFilmActors").setParameter("value", idFilm).getResultList();
    }

    // vrati vsechny filmy ve kterych hraje herec s id idActor
    public <E> List<E> getActorFilms(Long idActor) {
        return getEntityManager().createNamedQuery("getActorFilms").setParameter("value", idActor).getResultList();
    }

    // vrati filmy ktere byly v objednavce s id idOrder
    public <E> List<E> getOrderFilms(Long idOrder) {
        return getEntityManager().createNamedQuery("getOrderFilms").setParameter("value", idOrder).getResultList();
    }

    // vrati objednavky ktere obsahuji film idFilm
    public <E> List<E> getFilmOrders(Long idFilm) {
        return getEntityManager().createNamedQuery("getFilmOrders").setParameter("value", idFilm).getResultList();
    }
}
