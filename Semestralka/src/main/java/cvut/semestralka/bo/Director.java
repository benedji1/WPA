package cvut.semestralka.bo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Director extends Person{   
    @OneToMany(targetEntity = Film.class, mappedBy = "director", cascade = CascadeType.REMOVE)
    @OrderBy("title DESC")
    protected List<Film> films;

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
    
    
}
