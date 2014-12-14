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
    protected Long filmID;
    protected Long actorID;
    protected Long directorID;

    public Long getDirectorID() {
        return directorID;
    }

    public void setDirectorID(Long directorID) {
        this.directorID = directorID;
    }

    public Long getActorID() {
        return actorID;
    }

    public void setActorID(Long actorID) {
        this.actorID = actorID;
    }

    public Long getFilmID() {
        return filmID;
    }

    public void setFilmID(Long filmID) {
        this.filmID = filmID;
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
        filmService.addActor(actorID, filmService.getById(filmID));
        return "/Employee/added?faces-redirect=true";
    }
    
    public String addDirectorToFilm() {
        filmService.addDirector(directorID, filmService.getById(filmID));
        return "/Employee/added?faces-redirect=true";
    }

}
