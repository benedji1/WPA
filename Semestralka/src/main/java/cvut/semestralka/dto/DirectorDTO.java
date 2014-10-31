package cvut.semestralka.dto;

import cvut.semestralka.bo.Film;
import java.util.List;

public class DirectorDTO extends AbstractDTO{
    protected String first_name, last_name;
    protected List<FilmDTO> films;

    public DirectorDTO(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
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

    public List<FilmDTO> getFilms() {
        return films;
    }

    public void setFilms(List<FilmDTO> films) {
        this.films = films;
    }
}
