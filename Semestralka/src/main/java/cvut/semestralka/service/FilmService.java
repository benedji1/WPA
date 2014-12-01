/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.semestralka.service;

import cvut.semestralka.bo.Actor;
import cvut.semestralka.bo.Director;
import cvut.semestralka.bo.Film;
import cvut.semestralka.dto.FilmDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jirka
 */
@Component
public class FilmService extends AbstractService {
    
    @Autowired
    DirectorService directorService;
    @Autowired
    ActorService actorService;

    public List<FilmDTO> getAllFilms() {
        List<Film> films = genericDao.getAll(Film.class);
        List<FilmDTO> filmsDTO = new ArrayList<FilmDTO>();
        for (Film f : films) {
            filmsDTO.add(new FilmDTO(f.getRelease_year(), f.getTitle(), f.getId()));
        }
        return filmsDTO;
    }

    public Long saveFilm(FilmDTO filmDto) {
        Film film = new Film();
        film.setTitle(filmDto.getTitle());
        film.setRelease_year(filmDto.getRelease_year());
        Film saved = genericDao.saveOrUpdate(film);
        return saved.getId();
    }

    public Long deleteFilm(FilmDTO film) {
        return genericDao.remove(Film.class, film.getId());
    }

    public List<FilmDTO> getDirectorsFilms(Long directorId) {
        List<Film> films = genericDao.getByProperty("director", genericDao.getById(directorId, Director.class), Film.class);
        List<FilmDTO> filmsDto = new ArrayList<FilmDTO>();
        for (Film f : films) {
            filmsDto.add(new FilmDTO(f.getRelease_year(), f.getTitle(), f.getId()));
        }
        return filmsDto;
    }

    public List<FilmDTO> getActorsFilms(Long actorId) {
        List<Film> films = manyToManyDao.getActorFilms(actorId);  
        List<FilmDTO> fdtos = new ArrayList<FilmDTO>();
        for(Film f : films){
            fdtos.add(new FilmDTO(f.getRelease_year(), f.getTitle(), f.getId()));
        }
        return fdtos;
    }

    public List<FilmDTO> getFilmsInOrder(Long orderId) {
        List<Film> films = manyToManyDao.getOrderFilms(orderId);
        List<FilmDTO> fdtos = new ArrayList<FilmDTO>();
        for(Film f : films){
            fdtos.add(new FilmDTO(f.getRelease_year(), f.getTitle(), f.getId()));
        }
        return fdtos;
    }

    public FilmDTO addDirector(Long directorID, FilmDTO filmDto) {
        Director director = genericDao.getById(directorID, Director.class);
        Film film = genericDao.getById(filmDto.getId(), Film.class);
        if (film.getDirector() != null && film.getDirector() != director) {
            System.err.println("Film " + film.getTitle() + " allready has director " + director.getFirst_name() + " " + director.getLast_name());
            return new FilmDTO(film.getRelease_year(), film.getTitle(), film.getId());
        } else {
            film.setDirector(director);
            Film saved = genericDao.saveOrUpdate(film);
            FilmDTO updated = new FilmDTO(saved.getRelease_year(), saved.getTitle(), saved.getId());
            directorService.addFilm(updated, director.getId());
            return updated;
        }
    }

    public FilmDTO addActor(Long actorId, FilmDTO filmDto) {
        Actor actor = genericDao.getById(actorId, Actor.class);
        Film film = genericDao.getById(filmDto.getId(), Film.class);
        List<Actor> actors = film.getActors();
        if (actors.contains(actor)) {
            System.err.println("Film " + film.getTitle() + " allready has actor " + actor.getFirst_name() + " " + actor.getLast_name());
            return new FilmDTO(film.getRelease_year(), film.getTitle(), film.getId());
        } else {
            actors.add(actor);
            Film saved = genericDao.saveOrUpdate(film);
            FilmDTO updated = new FilmDTO(saved.getRelease_year(), saved.getTitle(), saved.getId());
            actorService.addFilm(updated, actor.getId());
            return updated;
        }
    }

    /*
     dalsi metody...
     */
}
