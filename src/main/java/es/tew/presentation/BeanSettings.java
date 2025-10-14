package es.tew.presentation;

import java.io.Serializable;
import java.util.Locale;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.inject.Named;

@Named("settings")
@SessionScoped
public class BeanSettings implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private static final Locale ENGLISH = new Locale("en");
    private static final Locale SPANISH = new Locale("es");
    
    private Locale locale = new Locale("es");
    
    public Locale getLocale() {
        return locale;
    }
    
    public String getLanguage() {
        return locale.getLanguage();
    }
    
    public void setSpanish(ActionEvent event) {
        locale = SPANISH;
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
    
    public void setEnglish(ActionEvent event) {
        locale = ENGLISH;
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
}