package cvut.semestralka.bo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "getFilmOrders",query = "select o from Orders o inner join o.films film where film.id = :value")
@Table(name="orders")
public class Orders extends DomainEntity{
    
    @ManyToOne
    @JoinColumn(name="id_employee")
    protected Employee employee;
        
    @ManyToOne
    @JoinColumn(name="id_customer")
    protected Customer customer;
    
    @ManyToMany
    @JoinTable(name="order_film", 
            joinColumns = {@JoinColumn(name="id_order", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="id_film", referencedColumnName = "id")})
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
