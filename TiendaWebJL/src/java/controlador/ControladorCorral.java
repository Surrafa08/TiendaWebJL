package controlador;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Corral;
import modelo.CorralDAO;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ControladorCorral", urlPatterns = {"/ControladorCorral"})
public class ControladorCorral extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("registrarCorral".equals(accion)) {
            String nombre = request.getParameter("nombreCorral");
            String ubicacion = request.getParameter("ubicacionCorral");
            String tipoAnimal = request.getParameter("tipoAnimal");

            Corral corral = new Corral(nombre, ubicacion, tipoAnimal);
            CorralDAO dao = new CorralDAO();

            boolean registrado = dao.insertarCorral(corral);

            if (registrado) {
                request.setAttribute("mensaje", "Corral registrado con éxito.");
            } else {
                request.setAttribute("mensaje", "Error al registrar el corral.");
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("corrales/registrarCorral.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("listar".equals(accion)) {
            CorralDAO dao = new CorralDAO();
            List<Corral> lista = dao.listarCorrales();
            request.setAttribute("listaCorrales", lista);

            RequestDispatcher dispatcher = request.getRequestDispatcher("corrales/listarCorrales.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
