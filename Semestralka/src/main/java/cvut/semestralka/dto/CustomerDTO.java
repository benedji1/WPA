package cvut.semestralka.dto;

import cvut.semestralka.bo.Order;
import java.util.List;

public class CustomerDTO extends UserDTO{
    
    protected String email;
    protected String password;
    protected List<Long> orders;

    public CustomerDTO(String first_name, String last_name, String email, String password) {
        super(first_name, last_name);
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Long> getOrders() {
        return orders;
    }

    public void setOrders(List<Long> orders) {
        this.orders = orders;
    }
}