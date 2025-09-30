package es.tew.model;

public class Alumno {
    private int id;
    private String idUser;
    private String email;
    private String nombre;
    private String apellidos;
    public Alumno(int id, String idUser, String email, String nombre, String apellidos) {
    this.id = id;
    this.idUser = idUser;
    this.email = email;
    this.nombre = nombre;
    this.apellidos = apellidos;
    }
    public int getId() {
    return id;
    }

    public String getIdUser() {
        return idUser;
    }
    
    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    

    

}
    