package cvut.semestralka.dto;

import java.util.List;

/**
 *
 * @author Koulas
 */
public class FilmDTO extends AbstractDTO {

    protected Integer release_year;
    protected String title;
    protected List<Long> orders;
    protected List<Long> actors;

    public FilmDTO(Integer release_year, String title, Long id) {
        this.release_year = release_year;
        this.title = title;
        this.id = id;
    }

    public FilmDTO(Integer release_year, String title) {
        this.release_year = release_year;
        this.title = title;
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

    public List<Long> getOrders() {
        return orders;
    }

    public void setOrders(List<Long> orders) {
        this.orders = orders;
    }

    public List<Long> getActors() {
        return actors;
    }

    public void setActors(List<Long> actors) {
        this.actors = actors;
    }
}
