package cvut.semestralka.dto;

import cvut.semestralka.bo.Film;
import java.util.List;

public class OrderDTO extends AbstractDTO {

    protected Long employee;
    protected Long customer;
    protected List<Long> films;

    public OrderDTO(Long id) {
        this.id = id;
    }
    
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

    public List<Long> getFilms() {
        return films;
    }

    public void setFilms(List<Long> films) {
        this.films = films;
    }
}
