package es.tew.business;

import java.util.List;
import es.tew.model.Alumno;

public interface AlumnoService {
    List<Alumno> getAlumnos();
    void saveAlumno(Alumno alumno);
    void updateAlumno(Alumno alumno);
    void deleteAlumno(int id);
}
