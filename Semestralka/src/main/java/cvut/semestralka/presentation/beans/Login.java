package cvut.semestralka.presentation.beans;

import cvut.semestralka.service.CustomerService;
import cvut.semestralka.service.EmployeeService;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Koulas
 */
@Component
@Scope(value = "session")
public class Login {

    protected String login, password, user;
    protected boolean logged = false;
    @Autowired
    private AuthenticationManager authenticationManager;
    
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
       Authentication request = new UsernamePasswordAuthenticationToken(login, password);
        try {
            Authentication result = authenticationManager.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);
        } catch (org.springframework.security.core.AuthenticationException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Invalid credentials!", "The username/password combination is not valid."));
            return "Login/login";
        }
        return "/MainPage?faces-redirect=true";
    }

    
    public String logout(){
        SecurityContextHolder.getContext().setAuthentication(null);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        return "index?faces-redirect=true";
    }

}
