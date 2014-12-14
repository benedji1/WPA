/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.semestralka.presentation.beans;

import cvut.semestralka.service.DirectorService;
import cvut.semestralka.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jirka
 */
@Component
@Scope(value = "session")
public class OrderBean {

    @Autowired
    protected OrderService os;

    protected Long orderID;

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }


    public String showFilms(Long id) {
        this.orderID = id;
        return "/Employee/directorFilms?faces-redirect=true";
    }

}
