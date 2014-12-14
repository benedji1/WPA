package cvut.semestralka.dto;

import java.util.List;

public class EmployeeDTO extends UserDTO {

    protected String address, position;
    protected List<Long> orders;

    public EmployeeDTO(String firstName, String lastName, String login, String address, String position, List<Long> orders, Long id) {
        super(firstName, lastName, id,login);
        this.address = address;
        this.position = position;
        this.orders = orders;
        this.roles = "EMPLOYEE";
    }

    public EmployeeDTO(String address, String position, String login, String firstName, String lastName) {
        super(firstName, lastName);
        this.address = address;
        this.position = position;
        this.login = login;
        this.roles = "EMPLOYEE";
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
