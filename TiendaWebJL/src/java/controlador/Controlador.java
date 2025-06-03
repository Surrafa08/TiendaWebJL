package controlador;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Huerto;
import modelo.HuertoDAO;

import java.io.IOException;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String ubicacion = request.getParameter("ubicacion");

        Huerto huerto = new Huerto(nombre, ubicacion);

        HuertoDAO dao = new HuertoDAO();
        boolean registrado = dao.insertarHuerto(huerto);

        if (registrado) {
            request.setAttribute("mensaje", "Huerto registrado con éxito");
        } else {
            request.setAttribute("mensaje", "Error al registrar el huerto");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("registroHuerto.jsp");
        dispatcher.forward(request, response);
    }
}
