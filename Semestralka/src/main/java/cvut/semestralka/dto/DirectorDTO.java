package cvut.semestralka.dto;

import cvut.semestralka.bo.Film;
import java.util.List;

public class DirectorDTO extends PersonDTO {

    protected List<Long> films;

    public DirectorDTO(String first_name, String last_name, Long id) {
        super(first_name, last_name);
        this.id = id;
    }

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

    public List<Long> getFilms() {
        return films;
    }

    public void setFilms(List<Long> films) {
        this.films = films;
    }
}
