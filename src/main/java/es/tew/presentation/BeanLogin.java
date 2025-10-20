package es.tew.presentation;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import es.tew.business.UserService;
import es.tew.infrastructure.ServiceFactory;
import es.tew.model.User;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named("beanLogin")
@SessionScoped
public class BeanLogin implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private final UserService userService = ServiceFactory.getUserService();
    private User user = new User();
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public void iniciaUser() {
        user = new User();
    }
    
    public String login() {
        try {
            Optional<User> fromService = userService.verify(user);
            if (fromService.isEmpty()) {
                FacesContext jsfCtx = FacesContext.getCurrentInstance();
                ResourceBundle bundle = jsfCtx.getApplication().getResourceBundle(jsfCtx, "msgs");
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    bundle.getString("login_error"), null);
                jsfCtx.addMessage(null, msg);
                return "login";
            }
            user = fromService.get();
            Map<String, Object> session = 
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            session.put("LOGGEDIN_USER", user);
            return "exito";
        } catch (Exception e) {
            return "error";
        }
    }
    
    public String logout() {
        try {
            Map<String, Object> session = 
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            session.put("LOGGEDIN_USER", null);
            return "exito";
        } catch (Exception e) {
            return "error";
        }
    }
    
    public boolean isLogged() {
        Map<String, Object> session = 
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        return session.getOrDefault("LOGGEDIN_USER", null) != null;
    }
}