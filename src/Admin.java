import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Admin {

    private List<Evento> listaEventos;
    private int idActual = 1;

    public Admin(){
        this.listaEventos = new ArrayList<>();
    }

    public String agregarEvento(String nombre, String ciudad, int dia, int mes, int anio){
        if(listaEventos.size() >= 4){
            return "La lista de eventos está llena";
        }

        Evento nuevoEvento = new Evento(idActual, nombre, ciudad, dia, mes, anio);
        listaEventos.add(nuevoEvento);
        idActual++;
        return null;
    }


    public List<Evento> getListaEventos(){
            return listaEventos;
        }

        public Evento getEventoId(int id){
            for(Evento even:listaEventos){
                if(even.getIdEvento() == id){
                    return even;
                }
            }
            return null;
        }

}
