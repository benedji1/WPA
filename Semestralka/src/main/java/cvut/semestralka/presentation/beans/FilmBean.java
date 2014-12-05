package cvut.semestralka.presentation.beans;

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
@Scope(value="session")
public class FilmBean {
    
    @Autowired
    FilmService filmService;
    
    protected Integer release_year;
    protected String title;

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
    
    public void addFilm(){
        filmService.saveFilm(new FilmDTO(release_year, title));
    }
}
