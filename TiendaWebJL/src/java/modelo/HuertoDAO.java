package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
