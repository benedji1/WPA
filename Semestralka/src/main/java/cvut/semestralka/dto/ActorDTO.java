package cvut.semestralka.dto;

import cvut.semestralka.bo.Film;
import java.util.List;

/**
 *
 * @author Koulas
 */
public class ActorDTO extends PersonDTO {
    protected List<Long> films;

    public ActorDTO(String firstName, String lastName, Long id) {
        super(firstName, lastName);
        this.id = id;
    }

    public ActorDTO(String firstName, String lastName) {
        super(firstName, lastName);
    }
    

    public List<Long> getFilms() {
        return films;
    }

    public void setFilms(List<Long> films) {
        this.films = films;
    }
}
