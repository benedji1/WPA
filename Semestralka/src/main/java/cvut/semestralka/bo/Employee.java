package cvut.semestralka.bo;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("Employee")
@Table(name="employee")
public class Employee extends Person{
    
    protected String address;
    protected String position;
    protected String login;
    protected String password;
    
    @OneToMany(targetEntity = Orders.class, mappedBy="employee")
    @OrderBy("id_employee DESC")
    protected List<Orders> orders;
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
