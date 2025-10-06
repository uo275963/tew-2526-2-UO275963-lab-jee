package es.tew.presentation;

import java.io.Serializable;
import java.util.List;

import es.tew.business.AlumnoService;
import es.tew.infrastructure.ServiceFactory;
import es.tew.model.Alumno;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("beanAlumnos")
@SessionScoped
public class BeanAlumnos implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private final AlumnoService alumnoService = ServiceFactory.getAlumnoService();
    private List<Alumno> alumnos;
    private Alumno alumno;
    
    public void iniciaAlumno() {
        alumno = new Alumno();
    }
    
    public String listado() {
        try {
            alumnos = alumnoService.getAlumnos();
            return "exito";
        } catch (Exception e) {
            e.printStackTrace();
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
            return "error";
        }
    }
    
    public String baja() {
        try {
            alumnoService.deleteAlumno(alumno.getId());
            return listado();
        } catch (Exception e) {
            e.printStackTrace();
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