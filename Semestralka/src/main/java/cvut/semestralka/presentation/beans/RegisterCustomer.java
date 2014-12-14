package cvut.semestralka.presentation.beans;

import cvut.semestralka.dto.CustomerDTO;
import cvut.semestralka.dto.EmployeeDTO;
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
@Scope(value="request")
public class RegisterCustomer {
    protected String first_name, last_name, email, login, password;
    
    @Autowired
    protected CustomerService customerService;
    @Autowired
    protected EmployeeService emplService;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public String registerCustomer(){
        CustomerDTO cdto = new CustomerDTO(first_name, last_name, login, email);
        for(CustomerDTO c : customerService.getAllCustomers()){
            if(c.getLogin().equals(cdto.getLogin())){
                return "bad_login";
            }
        }
        for(EmployeeDTO e : emplService.getAllEmployees()){
            if(e.getLogin().equals(login)){
                return "bad_login";
            }
        }
        customerService.addCustomer(cdto, password);
        return "success";
    }
}
