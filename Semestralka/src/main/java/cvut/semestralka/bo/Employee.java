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
public class Employee extends User{
    
    protected String address;
    protected String position;
    
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
}
