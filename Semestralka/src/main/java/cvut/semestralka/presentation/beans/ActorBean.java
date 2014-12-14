/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.semestralka.presentation.beans;

import cvut.semestralka.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jirka
 */
@Component
@Scope(value = "session")
public class ActorBean {
    @Autowired
    protected ActorService as;
    
    protected Long ActorId;

    public Long getActorId() {
        return ActorId;
    }

    public void setActorId(Long ActorId) {
        this.ActorId = ActorId;
    }

    public String showFilms(Long id) {
        this.ActorId = id;
        return "/Employee/actorsFilms?faces-redirect=true";
    }
    public String deleteActor(Long id){
        this.ActorId = id;
        return "/Employee/deleteActor?faces-redirect=true";
    }
    public String removeActor(){
        as.deleteActor(ActorId);
        return "/MainPage?faces-redirect=true";
    }
}
