package es.tew.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.tew.model.Alumno;

public class AlumnoDAOImpl implements AlumnoDAO {
   @Override
    public void saveAlumno(Alumno alumno) {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            try (
                Connection con = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/localDB", "sa", "");
                PreparedStatement pstmt = con.prepareStatement(
                    "INSERT INTO ALUMNO (idUser, email, nombre, apellidos) VALUES (?, ?, ?, ?)")
            ) {
                pstmt.setString(1, alumno.getIdUser());
                pstmt.setString(2, alumno.getEmail());
                pstmt.setString(3, alumno.getNombre());
                pstmt.setString(4, alumno.getApellidos());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

     @Override
    public void updateAlumno(Alumno alumno) {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            try (
                Connection con = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/localDB", "sa", "");
                PreparedStatement pstmt = con.prepareStatement(
                    "UPDATE ALUMNO SET idUser = ?, email = ?, nombre = ?, apellidos = ? WHERE id = ?")
            ) {
                pstmt.setString(1, alumno.getIdUser());
                pstmt.setString(2, alumno.getEmail());
                pstmt.setString(3, alumno.getNombre());
                pstmt.setString(4, alumno.getApellidos());
                pstmt.setInt(5, alumno.getId());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAlumno(int id) {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            try (
                Connection con = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/localDB", "sa", "");
                PreparedStatement pstmt = con.prepareStatement(
                    "DELETE FROM ALUMNO WHERE id = ?")
            ) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
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
