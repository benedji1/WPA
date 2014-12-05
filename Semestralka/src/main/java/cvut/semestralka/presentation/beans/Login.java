package cvut.semestralka.presentation.beans;

import cvut.semestralka.service.CustomerService;
import cvut.semestralka.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Koulas
 */
@Component
@Scope(value = "session")
public class Login {

    protected String login, password, user;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CustomerService customerService;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String login() {
        if (user.equals("employee") && loginEmployee()) {
            return "employee_login_success";
        } else if (user.equals("customer") && loginCustomer()) {
            return "customer_login_success";
        }
        return "login_fail";
    }

    private boolean loginEmployee() {
        return employeeService.employeeExists(login, password);
    }

    private boolean loginCustomer() {
        return customerService.customerExists(login, password);
    }
}
