package cvut.semestralka.dto;

import cvut.semestralka.bo.Film;
import java.util.List;

public class DirectorDTO extends PersonDTO {

    protected List<Long> films;

    public DirectorDTO(String first_name, String last_name, Long id) {
        super(first_name, last_name);
        this.id = id;
    }
    
    public DirectorDTO(String first_name, String last_name){
        super(first_name, last_name);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public List<Long> getFilms() {
        return films;
    }

    public void setFilms(List<Long> films) {
        this.films = films;
    }
}
