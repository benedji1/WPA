package cvut.semestralka.dto;

import cvut.semestralka.bo.Orders;
import java.util.List;

public class CustomerDTO extends UserDTO {

    protected String email;
    protected List<Long> orders;

    public CustomerDTO(String first_name, String last_name, String email, Long id) {
        super(first_name, last_name, id);
        this.email = email;
    }

    public CustomerDTO(String email, String first_name, String last_name) {
        super(first_name, last_name);
        this.email = email;
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getOrders() {
        return orders;
    }

    public void setOrders(List<Long> orders) {
        this.orders = orders;
    }
}
