package GestionEvento;

public class Localidad {

    private String nombreLocalidad;
    private int capacidadLocalidad;

    public Localidad(String nombreLocalidad, int capacidadLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
        this.capacidadLocalidad = capacidadLocalidad;
    }

    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
    }

    public int getCapacidadLocalidad() {
        return capacidadLocalidad;
    }

    public void setCapacidadLocalidad(int capacidadLocalidad) {
        this.capacidadLocalidad = capacidadLocalidad;
    }

    @Override
    public String toString() {
        return "Localidad: " + nombreLocalidad + "\n " +
                "Capacidad: " + capacidadLocalidad;
    }
}
