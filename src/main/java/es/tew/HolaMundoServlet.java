package es.tew;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HolaMundo")
public class HolaMundoServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,
            ServletException {
        RequestDispatcher dispatcher = getServletContext().getNamedDispatcher("HolaMundoVista");
        dispatcher.forward(req, resp);

    }
}
