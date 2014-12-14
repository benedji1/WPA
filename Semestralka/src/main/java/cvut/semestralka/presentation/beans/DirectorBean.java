/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.semestralka.presentation.beans;

import cvut.semestralka.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jirka
 */
@Component
@Scope(value = "session")
public class DirectorBean {

    @Autowired
    protected DirectorService ds;

    protected Long directorID;

    public Long getDirectorID() {
        return directorID;
    }

    public void setDirectorID(Long directorID) {
        this.directorID = directorID;
    }

    public String showFilms(Long id) {
        this.directorID = id;
        return "/Employee/directorFilms?faces-redirect=true";
    }

    public String deleteDirector(Long id) {
        this.directorID = id;
        return "/Employee/deleteDirector?faces-redirect=true";
    }

    public String removeDireector() {
        ds.deleteDirector(directorID);
        return "/MainPage?faces-redirect=true";
    }
}
