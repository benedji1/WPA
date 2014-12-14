package cvut.semestralka.service;

import cvut.semestralka.bo.Actor;
import cvut.semestralka.bo.Film;
import cvut.semestralka.dto.ActorDTO;
import cvut.semestralka.dto.FilmDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jirka
 */
@Component
public class ActorService extends AbstractService {

    public List<ActorDTO> getAllActors() {
        List<Actor> actors = genericDao.getAll(Actor.class);
        List<ActorDTO> actorsDto = new ArrayList<ActorDTO>();
        for (Actor a : actors) {
            actorsDto.add(new ActorDTO(a.getFirstName(), a.getLastName(), a.getId()));
        }
        return actorsDto;
    }

    public Long addActor(ActorDTO actorDto) {
        Actor actor = new Actor();
        actor.setFirstName(actorDto.getFirstName());
        actor.setLastName(actorDto.getLastName());
        Actor added = genericDao.saveOrUpdate(actor);
        if (added == null) {
            throw new NullPointerException("added is null");
        }
        return added.getId();
    }

    public Long deleteActor(ActorDTO actorDTO) {
        return genericDao.remove(Actor.class, actorDTO.getId());
    }

    public Long deleteActor(Long id) {
        return genericDao.remove(Actor.class, id);
    }

    public List<ActorDTO> getAllActorsFromFilm(Long filmId) {
        List<Actor> actors = manyToManyDao.getFilmActors(filmId);
        List<ActorDTO> adtos = new ArrayList<ActorDTO>();
        for (Actor a : actors) {
            adtos.add(new ActorDTO(a.getFirstName(), a.getLastName(), a.getId()));
        }
        return adtos;
    }

    public ActorDTO addFilm(FilmDTO updated, Long actorId) {
        Actor actor = genericDao.getById(actorId, Actor.class);
        List<Film> films = actor.getFilms();
        films.add(genericDao.getById(updated.getId(), Film.class));
        actor.setFilms(films);
        Actor saved = genericDao.saveOrUpdate(actor);
        return new ActorDTO(saved.getFirstName(), saved.getLastName(), saved.getId());
    }

    public String getActorName(Long actorId) {
        Actor actor = genericDao.getById(actorId, Actor.class);
        return actor.getFirstName() + " " + actor.getLastName();
    }

/*    public void removeFilm(Long filmID, Long actorID) {
        Actor actor = genericDao.getById(actorID, Actor.class);
        List<Film> films = actor.getFilms();
        Film f = genericDao.getById(filmID, Film.class);
        films.remove(f);
        actor.setFilms(films);
        genericDao.saveOrUpdate(actor);
    }*/

}
