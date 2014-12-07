package cvut.semestralka.dto;

import java.util.List;

public class EmployeeDTO extends PersonDTO {

    protected String address, position, login;
    protected List<Long> orders;

    public EmployeeDTO(String first_name, String last_name, String login, String address, String position, List<Long> orders, Long id) {
        super(first_name, last_name, id);
        this.address = address;
        this.position = position;
        this.orders = orders;
        this.login=login;
    }

    public EmployeeDTO(String address, String position, String login, String first_name, String last_name) {
        super(first_name, last_name);
        this.address = address;
        this.position = position;
        this.login = login;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
