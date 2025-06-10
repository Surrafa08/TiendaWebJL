package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import util.Conexion;

public class CorralDAO {

    public boolean insertarCorral(Corral corral) {
        boolean registrado = false;

        try {
            Connection conn = Conexion.getConnection();
            if (conn == null) {
                System.out.println("Conexión es null");
                return false;
            }

            String sql = "INSERT INTO corrales (nombre, tipo_animal) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, corral.getNombre());
            stmt.setString(2, corral.getTipoAnimal());

            int filas = stmt.executeUpdate();
            registrado = filas > 0;

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }

        return registrado;
    }

    public List<Corral> listarCorrales() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
