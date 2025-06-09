package controlador;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Huerto;
import modelo.HuertoDAO;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombreHuerto");
        String ubicacion = request.getParameter("ubicacionHuerto");

        Huerto huerto = new Huerto(nombre, ubicacion);

        HuertoDAO dao = new HuertoDAO();
        boolean registrado = dao.insertarHuerto(huerto);

        if (registrado) {
            request.setAttribute("mensaje", "Huerto registrado con éxito");
        } else {
            request.setAttribute("mensaje", "Error al registrar el huerto");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("huertos/registrarHuerto.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("listar".equals(accion)) {
            HuertoDAO dao = new HuertoDAO();
            List<Huerto> lista = dao.listarHuertos();
            request.setAttribute("listaHuertos", lista);

            RequestDispatcher dispatcher = request.getRequestDispatcher("listarHuertos.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
