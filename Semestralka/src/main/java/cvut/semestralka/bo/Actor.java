package cvut.semestralka.bo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OrderBy;

@Entity
@NamedQuery(name = "getFilmActors", query = "select actor from Actor actor inner join actor.films film where film.id = :value")
public class Actor extends Person {

    @ManyToMany(targetEntity = Film.class, mappedBy = "actors",fetch=FetchType.EAGER,cascade = CascadeType.MERGE)
    @OrderBy("title DESC")
    protected List<Film> films;

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

}
