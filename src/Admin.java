import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Admin {

    private List<Evento> listaEventos;
    private int idActual = 1;

    public Admin(){
        this.listaEventos = new ArrayList<>();
    }

    public String agregarEvento(String nombre, String ciudad, String localidad, String hora, String fecha, String genero, int aforo, String artista, boolean general, int generalCantidad, double generalPrecio, boolean platinum, int platinumCantidad, double platinumPrecio, boolean vip, int vipCantidad, double vipPrecio) {
        Evento nuevoEvento = new Evento(idActual, nombre, ciudad, localidad, hora, fecha, genero, aforo, artista, general, generalCantidad, generalPrecio, platinum, platinumCantidad, platinumPrecio, vip, vipCantidad, vipPrecio);
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