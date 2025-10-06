package es.tew.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.tew.model.Alumno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import es.tew.business.AlumnoService; 
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
