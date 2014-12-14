package cvut.semestralka.dto;

public abstract class UserDTO extends PersonDTO{
    
    protected String login;
    protected String roles;

    public UserDTO(String first_name, String last_name, Long id, String login) {
        super(first_name, last_name, id);
        this.login = login;
    }

    public UserDTO(String first_name, String last_name) {
       super(first_name, last_name);
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;    }

    
}
