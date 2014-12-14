package cvut.semestralka.bo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OrderBy;

@Entity
@NamedQueries({
    @NamedQuery(name = "getActorFilms", query = "select film from Film film inner join film.actors actor where actor.id = :value"),
    @NamedQuery(name = "getOrderFilms", query = "select film from Film film inner join film.orders o where o.id = :value")})
public class Film extends DomainEntity {

    protected String title;
    protected Integer release_year;

    @ManyToMany
    @JoinTable(name="order_film", 
            joinColumns = {@JoinColumn(name="id_order", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="id_film", referencedColumnName = "id")})
    @OrderBy("id_customer DESC")
    protected List<Orders> orders;

    @ManyToMany
    @JoinTable(name = "actor_film", joinColumns = {
        @JoinColumn(name = "id_actor", referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "id_film", referencedColumnName = "id")})
    @OrderBy("last_name DESC")
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
