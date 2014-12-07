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

    protected String login, password, user, actualLoginMessage = "Login";
    protected boolean logged = false;

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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String login() {
        if (user.equals("employee") && loginEmployee()) {
            actualLoginMessage = "Logged as " + login;
            logged = true;
            return "employee_login_success";
        } else if (user.equals("customer") && loginCustomer()) {
            actualLoginMessage = "Logged as " + login;
            logged = true;
            return "customer_login_success";
        }
        
        return "login_fail";
    }

    public String gotoUserPage() {
        if (logged && loginEmployee()) {
            return "/Employee/employeeMainPage.xhtml";
        }
        if(logged && loginCustomer()){
            return "/Customer/customerMainPage.xhtml";
        }
        else return "/Login/login.xhtml";
    }
    
    public String logout(){
        logged=false;
        actualLoginMessage="Login";
        return "/index.xhtml";
    }

    private boolean loginEmployee() {
        return employeeService.employeeExists(login, password);
    }

    private boolean loginCustomer() {
        return customerService.customerExists(login, password);
    }

    public String getActualLoginMessage() {
        return actualLoginMessage;
    }

    public void setActualLoginMessage(String actualLoginMessage) {
        this.actualLoginMessage = actualLoginMessage;
    }
}
