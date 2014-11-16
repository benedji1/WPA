/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.semestralka.service;

import cvut.semestralka.bo.Actor;
import cvut.semestralka.bo.Film;
import cvut.semestralka.dto.ActorDTO;
import cvut.semestralka.dto.FilmDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jirka
 */
public class ActorService extends AbstractService {

    private static ActorService actorService;

    public static ActorService getActorService() {
        if (actorService == null) {
            actorService = new ActorService();
        }
        return actorService;
    }

    public List<ActorDTO> getAllActors() {
        List<Actor> actors = dao.getAll(Actor.class);
        List<ActorDTO> actorsDto = new ArrayList<ActorDTO>();
        for (Actor a : actors) {
            actorsDto.add(new ActorDTO(a.getFirst_name(), a.getLast_name(), a.getId()));
        }
        return actorsDto;
    }

    public Long addActor(ActorDTO actorDto) {
        Actor actor = new Actor();
        actor.setFirst_name(actorDto.getFirst_name());
        actor.setLast_name(actorDto.getLast_name());
        Actor added = dao.saveOrUpdate(actor);
        return added.getId();
    }

    public Long deleteActor(ActorDTO actorDTO) {
        return dao.remove(Actor.class, actorDTO.getId());
    }

    public List<ActorDTO> getAllActorsFromFilm(Long filmId) {
       List<Actor> actors = mdao.getFilmActors(filmId); 
       List<ActorDTO> adtos = new ArrayList<ActorDTO>();      
       for(Actor a : actors){
           adtos.add(new ActorDTO(a.getFirst_name(), a.getLast_name(), a.getId()));
       }    
       return adtos;
    }

    public ActorDTO addFilm(FilmDTO updated, Long actorId) {
        Actor actor = dao.getById(actorId, Actor.class);
        List<Film> films = actor.getFilms();
        films.add(dao.getById(updated.getId(), Film.class));
        actor.setFilms(films);
        Actor saved = dao.saveOrUpdate(actor);
        return new ActorDTO(saved.getFirst_name(), saved.getLast_name(), saved.getId());
    }

    /*
     dalsi metody...
     */
}
