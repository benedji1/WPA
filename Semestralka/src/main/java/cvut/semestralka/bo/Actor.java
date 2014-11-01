package cvut.semestralka.bo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Actor extends DomainEntity{
    protected String first_name, last_name;
    
    @ManyToMany
    @JoinTable(name="actor_film", joinColumns={@JoinColumn(name="id_actor", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="id_film", referencedColumnName = "id")})
    protected List<Film> films;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
    
    
}
