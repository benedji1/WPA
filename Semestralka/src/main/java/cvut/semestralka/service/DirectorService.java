/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.semestralka.service;

import cvut.semestralka.bo.Director;
import cvut.semestralka.bo.Film;
import cvut.semestralka.dto.DirectorDTO;
import cvut.semestralka.dto.FilmDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jirka
 */
@Component
public class DirectorService extends AbstractService {

    public List<DirectorDTO> getAllDirectors() {
        List<Director> directors = genericDao.getAll(Director.class);
        List<DirectorDTO> directorsDto = new ArrayList<DirectorDTO>();
        for (Director d : directors) {
            directorsDto.add(new DirectorDTO(d.getFirstName(), d.getLastName(), d.getId()));
        }
        return directorsDto;
    }

    public DirectorDTO addDirector(DirectorDTO directorDTO) {
        Director director = new Director();
        director.setFirstName(directorDTO.getFirst_name());
        director.setLastName(directorDTO.getLast_name());
        
        List<Film> films = new ArrayList<Film>();
        
        if (directorDTO.getFilms() != null) {
            for (Long l : directorDTO.getFilms()) {
                films.add(genericDao.getById(l, Film.class));
            }
        }
        director.setFilms(films);
        Director saved = genericDao.saveOrUpdate(director);
        return new DirectorDTO(saved.getFirstName(), saved.getLastName(), saved.getId());
    }

    public Long deleteDirector(DirectorDTO directorDTO) {
        return genericDao.remove(Director.class, directorDTO.getId());
    }


    /*
     dalsi metody...
     */
    public DirectorDTO addFilm(FilmDTO updated, Long directorId) {
        Director director = genericDao.getById(directorId, Director.class);
        List<Film> films = director.getFilms();
        films.add(genericDao.getById(updated.getId(), Film.class));
        director.setFilms(films);
        Director saved = genericDao.saveOrUpdate(director);
        return new DirectorDTO(saved.getFirstName(), saved.getLastName(), saved.getId());
    }
}
