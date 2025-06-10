package modelo;

public class Corral {
    private int id;
    private String nombre;
    private String tipoAnimal;

    // Constructor vacío
    public Corral(String nombre1, String ubicacion, String tipoAnimal1) {}

    // Constructor con nombre y tipoAnimal
    public Corral(String nombre, String tipoAnimal) {
        this.nombre = nombre;
        this.tipoAnimal = tipoAnimal;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }
}
