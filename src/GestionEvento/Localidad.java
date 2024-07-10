package GestionEvento;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Localidad {

    private String nombreLocalidad;
    private int capacidadLocalidad;
    public List<Localidad> listaLocalidades = new ArrayList<>();

    public Localidad() {
    }

    public Localidad(String nombreLocalidad, int capacidadLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
        this.capacidadLocalidad = capacidadLocalidad;
    }

    public void actualizarListaLocalidades(JList listaLocalidad){
        DefaultListModel<Localidad> model = new DefaultListModel<>();
        for(Localidad localidad:listaLocalidades){
            model.addElement(localidad);
        }
        listaLocalidad.setModel(model);
    }

    public int obtenerCapacidadEvento(String nombreEvento){
        for(Localidad localidad:listaLocalidades){
            if(localidad.getNombreLocalidad().equals(nombreEvento)){
                return localidad.getCapacidadLocalidad();
            }
        }
        return 0;
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
