package modelo;

public class Huerto {
    private String nombre;
    private String ubicacion;

    public Huerto(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }
}
