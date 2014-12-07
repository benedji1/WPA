package cvut.semestralka.presentation.beans;

import cvut.semestralka.dto.ActorDTO;
import cvut.semestralka.service.ActorService;
import java.util.List;
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
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void addActor(){
        actorService.addActor(new ActorDTO(firstName, lastName));
    }
    
    public void deleteActor(Long id){
        actorService.deleteActor(id);
    }
    
    public List<ActorDTO> getAllActors(){
        return actorService.getAllActors();
    }
    
    public List<ActorDTO> getAllActorsFilms(Long id){
        return actorService.getAllActorsFromFilm(id);
    }
}
