package cvut.semestralka.presentation.beans;

import cvut.semestralka.dto.ActorDTO;
import cvut.semestralka.dto.FilmDTO;
import cvut.semestralka.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Koulas
 */
@Component
@Scope(value = "session")
public class AddFilmBean {

    @Autowired
    FilmService filmService;

    protected Integer release_year;
    protected String title;
    protected ActorDTO actorDTO;
    protected FilmDTO filmDTO;

    public ActorDTO getActorDTO() {
        return actorDTO;
    }

    public void setActorDTO(ActorDTO actorDTO) {
        this.actorDTO = actorDTO;
    }

    public FilmDTO getFilmDTO() {
        return filmDTO;
    }

    public void setFilmDTO(FilmDTO filmDTO) {
        this.filmDTO = filmDTO;
    }

    public Integer getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Integer release_year) {
        this.release_year = release_year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addFilm() {
        filmService.saveFilm(new FilmDTO(release_year, title));
    }

    public String addActorToFilm() {
        System.out.println(filmDTO.getId());
        //filmService.addActor(actorID, filmService.getById(filmID));
        return "/Employee/added?faces-redirect=true";
    }

}
