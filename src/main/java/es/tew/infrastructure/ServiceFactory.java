package es.tew.infrastructure;
import es.tew.business.*;
import es.tew.persistence.*;

public class ServiceFactory {
    public static AlumnoDAO getAlumnoService() {
        return new AlumnoDAOImpl();
    }
}
