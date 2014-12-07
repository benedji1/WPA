package cvut.semestralka.presentation.beans;

import cvut.semestralka.dto.ActorDTO;
import cvut.semestralka.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Koulas
 */
@Component
@Scope(value="session")
public class AddActorBean {
    
    @Autowired
    ActorService actorService;
    
    private String firstName, lastName;

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
    
    public void addActor(){
        actorService.addActor(new ActorDTO(firstName, lastName));
    }
}
