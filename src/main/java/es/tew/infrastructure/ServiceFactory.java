package es.tew.infrastructure;
import es.tew.business.*;
import es.tew.persistence.*;

public class ServiceFactory {
    public static AlumnoService getAlumnoService() {
        return new AlumnoServiceImpl();
    }
}
