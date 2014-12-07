/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.semestralka.conventer;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.springframework.stereotype.Component;

@Component
public class YearConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return Integer.parseInt(string);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return (o != null)?o.toString():"";
    }
    
}
