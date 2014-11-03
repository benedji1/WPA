package cvut.semestralka.bo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@Entity
@NamedQueries({
    @NamedQuery(name = "getActorFilms", query = "select film from Film film inner join film.actors actor where actor.id = :value"),
    @NamedQuery(name = "getOrderFilms", query = "select film from Film film inner join film.orders o where o.id = :value")})
public class Film extends DomainEntity {

    protected String title;
    protected Integer release_year;

    @ManyToMany(targetEntity = Orders.class, mappedBy = "films")
    protected List<Orders> orders;

    @ManyToMany(targetEntity = Actor.class, mappedBy = "films")
    protected List<Actor> actors;

    @ManyToOne
    @JoinColumn(name = "id_director")
    protected Director director;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Integer release_year) {
        this.release_year = release_year;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
