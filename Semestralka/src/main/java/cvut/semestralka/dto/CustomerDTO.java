package cvut.semestralka.dto;

import cvut.semestralka.bo.Orders;
import java.util.List;

public class CustomerDTO extends PersonDTO {

    protected String email, login;
    protected List<Long> orders;

    public CustomerDTO(String first_name, String last_name, String login, String email, Long id) {
        super(first_name, last_name, id);
        this.email = email;
        this.login=login;
    }

    public CustomerDTO(String first_name, String last_name, String login, String email) {
        super(first_name, last_name);
        this.email = email;
        this.login=login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
