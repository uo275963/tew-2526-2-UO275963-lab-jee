package es.tew.api;

import java.util.List;
import es.tew.business.AlumnoService;
import es.tew.infrastructure.ServiceFactory;
import es.tew.model.Alumno;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/alumno")
public class AlumnoApi {
    private final AlumnoService service = ServiceFactory.getAlumnoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlumnos(){
        return Response.ok(service.getAlumnos()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveAlumno(Alumno alumno){
        try {
            service.saveAlumno(alumno);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAlumno(Alumno alumno){
        try {
            service.updateAlumno(alumno);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAlumno(@PathParam("id") int id){
        try {
            service.deleteAlumno(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}