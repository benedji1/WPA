package cvut.semestralka.dto;

import cvut.semestralka.bo.Order;
import java.util.List;

public class EmployeeDTO extends UserDTO{
    protected String address, position;
    protected List<Long> orders;
    
    public EmployeeDTO(String first_name, String last_name, String address, String position, List<Long> orders) {
        super(first_name, last_name);
        this.address=address;
        this.position=position;
        this.orders=orders;
    }

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

    public List<Long> getOrders() {
        return orders;
    }

    public void setOrders(List<Long> orders) {
        this.orders = orders;
    }
    
}
