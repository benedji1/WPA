/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.semestralka.validator;

import java.util.Calendar;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.springframework.stereotype.Component;

@Component 
public class YearValidator implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        if (o == null || "".equals(o)) {
            return;
        }

        Long l = Long.valueOf(String.valueOf(o));
        if (l < 1900) {
            throw new ValidatorException(new FacesMessage("Input value should be bigger then 1900", "the movie is too old."));
        }
        if (l > Calendar.getInstance().get(Calendar.YEAR)) {
            throw new ValidatorException(new FacesMessage("Input value should be less then Current Year","Release year is bigger than this year"));
        }
    }
    
}
