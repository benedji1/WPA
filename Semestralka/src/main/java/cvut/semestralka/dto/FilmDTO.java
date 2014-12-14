package cvut.semestralka.dto;

import java.util.List;

/**
 *
 * @author Koulas
 */
public class FilmDTO extends AbstractDTO {

    protected Integer releaseYear;
    protected String title;
    protected List<Long> orders;
    protected List<Long> actors;

    public FilmDTO(Integer releaseYear, String title, Long id) {
        this.releaseYear = releaseYear;
        this.title = title;
        this.id = id;
    }

    public FilmDTO(Integer releaseYear, String title) {
        this.releaseYear = releaseYear;
        this.title = title;
    }
    

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer release_year) {
        this.releaseYear = release_year;
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
