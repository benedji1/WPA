/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.semestralka.lang;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
 
@ManagedBean(name="language")
@SessionScoped
public class LanguageBean implements Serializable{
 
	private static final long serialVersionUID = 1L;
 
	private String localeCode;
 
	private static Map<String,String> locals;
	static{
		locals = new LinkedHashMap<String,String>();
		locals.put("English", "en"); 
		locals.put("Czech", "cs_CZ");
	}
 
	public Map<String, String> getCountriesInMap() {
		return locals;
	}
 
 
	public String getLocaleCode() {
		return localeCode;
	}
 
 
	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}
 
	//value change event listener
	public void countryLocaleCodeChanged(ValueChangeEvent e){
 
		String newLocaleValue = e.getNewValue().toString();
 
		//loop country map to compare the locale code
                for (Map.Entry<String, String> entry : locals.entrySet()) {
 
        	   if(entry.getValue().toString().equals(newLocaleValue)){
 
        		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(newLocaleValue));
 
        	  }
               }
	}
 
}