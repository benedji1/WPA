/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.semestralka.presentation.beans;

import javax.faces.context.FacesContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session")
public class NewEmployee {

    public String adminCheck() {
        if(Login.isAdmin){
            return "is_admin";
        }
        return "not_admin";
    }
}
