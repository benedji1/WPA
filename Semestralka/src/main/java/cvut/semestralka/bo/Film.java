package cvut.semestralka.bo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Film extends DomainEntity{
    
    String title;
    Integer release_year;
    
    @ManyToMany(targetEntity = Order.class, mappedBy = "films")
    protected List<Order> orders;
    
    @ManyToMany(targetEntity = Actor.class, mappedBy = "films")
    protected List<Actor> actors;
    
    @ManyToOne
    @JoinColumn(name="id_director")
    protected Director director;

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


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
