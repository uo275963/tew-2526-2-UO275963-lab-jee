package es.tew.persistence;

import java.util.List;

import es.tew.model.Alumno;

public interface AlumnoDAO {
    void saveAlumno(Alumno alumno);

    void updateAlumno(Alumno alumno);

    void deleteAlumno(int id);

    List<Alumno> getAlumnos();
}
