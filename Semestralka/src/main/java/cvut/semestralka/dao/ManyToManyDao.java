package cvut.semestralka.dao;

import cvut.semestralka.bo.DomainEntity;
import java.util.List;

/**
 *
 * @author Koulas
 */
public class ManyToManyDao extends AbstractDao {

    private static ManyToManyDao mtmDao;

    public static ManyToManyDao getDao() {
        if (mtmDao == null) {
            mtmDao = new ManyToManyDao();
        }
        return mtmDao;
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
