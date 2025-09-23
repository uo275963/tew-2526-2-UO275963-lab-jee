package es.tew;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HolaMundo")
public class HolaMundoServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,
            ServletException {
        String nombre = (String) req.getParameter("NombreUsuario");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Hola Mundo!</TITLE></HEAD>");
        out.println("<BODY>");

 

        Vector<String> listado = (Vector<String>) req.getSession().getAttribute("listado");
        if (listado == null) {
            listado = new Vector<String>();
        }

        if (nombre != null) {
            out.println("<br>Hola " + nombre + "<br>");
            listado.addElement(nombre);
        }
        out.println("Bienvenido a mi primera página Web!");

        req.getSession().setAttribute("listado", listado);
        out.println("<br>");
        out.println("Contigo, hoy me han visitado:<br>");
        for (int i = 0; i < listado.size(); i++) {
            out.println("<br>" + (String) listado.elementAt(i));

        }

        out.println("</BODY></HTML>");
        
    }
}
