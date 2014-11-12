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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jirka
 */
@Transactional
@Component
public class DirectorService extends AbstractService {

    @Transactional(readOnly = true)
    public List<DirectorDTO> getAllDirectors() {
        List<Director> directors = dao.getAll(Director.class);
        List<DirectorDTO> directorsDto = new ArrayList<DirectorDTO>();
        for (Director d : directors) {
            directorsDto.add(new DirectorDTO(d.getFirst_name(), d.getLast_name(), d.getId()));
        }
        return directorsDto;
    }

    public DirectorDTO addDirector(DirectorDTO directorDTO) {
        Director director = new Director();
        director.setFirst_name(directorDTO.getFirst_name());
        director.setLast_name(directorDTO.getLast_name());
        List<Film> films = new ArrayList<Film>();
        for (Long l : directorDTO.getFilms()) {
            films.add(dao.getById(l, Film.class));
        }
        director.setFilms(films);
        Director saved = dao.saveOrUpdate(director);
        return new DirectorDTO(saved.getFirst_name(), saved.getLast_name(), saved.getId());
    }

    public Long deleteDirector(DirectorDTO directorDTO) {
        return dao.remove(Director.class, directorDTO.getId());
    }


    /*
     dalsi metody...
     */
    public DirectorDTO addFilm(FilmDTO updated, Long directorId) {
        Director director = dao.getById(directorId, Director.class);
        List<Film> films = director.getFilms();
        films.add(dao.getById(updated.getId(), Film.class));
        director.setFilms(films);
        Director saved = dao.saveOrUpdate(director);
        return new DirectorDTO(saved.getFirst_name(), saved.getLast_name(), saved.getId());
    }
}
