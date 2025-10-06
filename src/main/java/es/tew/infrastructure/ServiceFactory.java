package es.tew.infrastructure;
import es.tew.business.*;
public class ServiceFactory {
    public static AlumnoService getAlumnoService() {
        return new AlumnoServiceImpl();
    }
}
