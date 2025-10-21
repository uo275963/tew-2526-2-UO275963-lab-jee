package es.tew.business;

import java.util.List;

import es.tew.model.Alumno;
import es.tew.infrastructure.PersistenceFactory;


public class AlumnoServiceImpl implements AlumnoService {
    @Override
    public List<Alumno> getAlumnos() {
        return PersistenceFactory.getAlumnoDAO().getAlumnos();
    }
    @Override
    public void saveAlumno(Alumno alumno) {
        PersistenceFactory.getAlumnoDAO().saveAlumno(alumno);
    }
    @Override
    public void updateAlumno(Alumno alumno) {
        PersistenceFactory.getAlumnoDAO().updateAlumno(alumno);
    }
    @Override
    public void deleteAlumno(int id) {
        PersistenceFactory.getAlumnoDAO().deleteAlumno(id);
    }

}
