package cvut.semestralka.bo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@IdClass(FilmId.class)
public class Film implements Serializable{
    
    @Id
    protected Integer release_year;
    
    @Id
    protected String title;
    
    @ManyToMany()
    @JoinTable(name="order_film", 
            joinColumns = {@JoinColumn(name="id_order", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="id_film", referencedColumnName = "id")})
    protected List<Order> order;
    
    @ManyToMany(targetEntity = Actor.class, mappedBy = "films")
    protected List<Actor> actors;
    
    @ManyToOne
    @JoinColumn(name="id_director")
    protected Director director;

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

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
}
