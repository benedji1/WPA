package cvut.semestralka.dto;

import cvut.semestralka.bo.Film;
import java.util.List;

public class OrderDTO extends AbstractDTO {

    protected Long employee;
    protected Long customer;
    protected List<FilmDTO> films;

    public Long getEmployee() {
        return employee;
    }

    public void setEmployee(Long employee) {
        this.employee = employee;
    }

    public Long getCustomer() {
        return customer;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
    }

    public List<FilmDTO> getFilms() {
        return films;
    }

    public void setFilms(List<FilmDTO> films) {
        this.films = films;
    }
}
