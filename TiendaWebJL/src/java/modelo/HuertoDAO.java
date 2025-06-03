package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;

public class HuertoDAO {

    public boolean insertarHuerto(Huerto huerto) {
        boolean registrado = false;

        try {
            Connection conn = Conexion.getConnection();
            String sql = "INSERT INTO huertos (nombre, ubicacion) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, huerto.getNombre());
            stmt.setString(2, huerto.getUbicacion());

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                registrado = true;
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registrado;
    }

    public List<Huerto> listarHuertos() {
        List<Huerto> lista = new ArrayList<>();
        String sql = "SELECT * FROM huertos";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Huerto h = new Huerto();
                h.setId(rs.getInt("id"));
                h.setNombre(rs.getString("nombre"));
                h.setUbicacion(rs.getString("ubicacion"));
                lista.add(h);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
