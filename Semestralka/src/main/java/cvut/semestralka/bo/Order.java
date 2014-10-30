package cvut.semestralka.bo;

import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

public class Order extends DomainEntity{
    
    @ManyToOne
    @JoinColumn(name="id_employee")
    protected Employee employee;
        
    @ManyToOne
    @JoinColumn(name="id_customer")
    protected Customer customer;
    
    @ManyToMany(targetEntity = Film.class, mappedBy = "order")
    protected List<Film> films;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
