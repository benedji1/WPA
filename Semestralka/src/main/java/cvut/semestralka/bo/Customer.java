/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cvut.semestralka.bo;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 *
 * @author Koulas
 */
@Entity
@DiscriminatorValue("Customer")
@Table(name="customer")
public class Customer extends User{
    
    protected String email;
    
    @OneToMany(targetEntity = Orders.class, mappedBy="customer")
    @OrderBy("id_customer DESC")
    protected List<Orders> orders;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
