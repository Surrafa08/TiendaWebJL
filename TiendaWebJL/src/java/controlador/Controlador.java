package controlador;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import util.Conexion;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "registrarHuerto":
                String nombreHuerto = request.getParameter("nombreHuerto");
                String ubicacionHuerto = request.getParameter("ubicacionHuerto");

                try (Connection con = Conexion.getConnection()) {
                    String sql = "INSERT INTO huertos (nombre, ubicacion) VALUES (?, ?)";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, nombreHuerto);
                    ps.setString(2, ubicacionHuerto);
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Puedes cambiar esto luego por un mensaje o redirección
                response.sendRedirect("huertos/registrarHuerto.jsp");
                break;

            case "mostrarDatos":  // Este es tu formulario anterior
                String nombre = request.getParameter("nombre");
                String producto = request.getParameter("producto");

                request.setAttribute("nombre", nombre);
                request.setAttribute("producto", producto);

                RequestDispatcher dispatcher = request.getRequestDispatcher("mostrarDatos.jsp");
                dispatcher.forward(request, response);
                break;

            default:
                response.getWriter().println("Acción no reconocida: " + accion);
                break;
        }
    }
}
