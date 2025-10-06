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


public class AlumnoServiceImpl implements AlumnoService {
    public List<Alumno> getAlumnos() {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            try (
                    Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/localDB", "sa", "");
                    Statement stmt = con.createStatement();) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM ALUMNO");
                List<Alumno> alumnos = new ArrayList<>();
                while (rs.next()) {
                    alumnos.add(new Alumno(rs.getInt("id"), rs.getString("idUser"),
                            rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos")));
                }
                return alumnos;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
