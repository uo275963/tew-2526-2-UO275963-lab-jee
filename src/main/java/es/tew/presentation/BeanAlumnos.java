package es.tew.presentation;

import java.io.Serializable;
import java.util.List;

import es.tew.business.AlumnoService;
import es.tew.infrastructure.ServiceFactory;
import es.tew.model.Alumno;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("beanAlumnos")
@SessionScoped
public class BeanAlumnos implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private final AlumnoService alumnoService = ServiceFactory.getAlumnoService();
    private List<Alumno> alumnos;
    private Alumno alumno;
    
    @Inject
    private BeanError beanError;
    
    @PostConstruct
    public void init() {
        alumno = new Alumno();
        // Inicializar la lista de alumnos para que la tabla se muestre correctamente
        try {
            alumnos = alumnoService.getAlumnos();
        } catch (Exception e) {
            // Si falla, la lista quedará vacía
            e.printStackTrace();
        }
    }
    
    public void iniciaAlumno() {
        alumno = new Alumno();
    }
    
    private void registrarError(Exception e) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String metodo = stackTrace[2].getMethodName() + "()";
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String vistaOrigen = facesContext.getViewRoot().getViewId();
        
        beanError.setError(
            vistaOrigen,
            this.getClass().getSimpleName(),
            metodo,
            e.getMessage() != null ? e.getMessage() : "Error en la operación: " + e.getClass().getSimpleName()
        );
    }
    
    public String listado() {
        try {
            alumnos = alumnoService.getAlumnos();
            return "exito";
        } catch (Exception e) {
            e.printStackTrace();
            registrarError(e);
            return "error";
        }
    }
    
    public String salva() {
        try {
            if (alumno.getId() == -1) {
                alumnoService.saveAlumno(alumno);
            } else {
                alumnoService.updateAlumno(alumno);
            }
            return listado();
        } catch (Exception e) {
            e.printStackTrace();
            registrarError(e);
            return "error";
        }
    }
    
    public String baja() {
        try {
            alumnoService.deleteAlumno(alumno.getId());
            return listado();
        } catch (Exception e) {
            e.printStackTrace();
            registrarError(e);
            return "error";
        }
    }
    
    // Getters y Setters
    public List<Alumno> getAlumnos() {
        return alumnos;
    }
    
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    public Alumno getAlumno() {
        return alumno;
    }
    
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}