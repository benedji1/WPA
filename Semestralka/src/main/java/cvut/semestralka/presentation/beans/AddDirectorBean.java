package cvut.semestralka.presentation.beans;

import cvut.semestralka.dto.DirectorDTO;
import cvut.semestralka.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Koulas
 */
@Component
@Scope(value="session")
public class AddDirectorBean {
    
    @Autowired
    DirectorService directorService;
    
    protected String firstName, lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String addDirector(){
        directorService.addDirector(new DirectorDTO(firstName, lastName));
        return "/Employee/added?faces-redirect=true";
    }
}
