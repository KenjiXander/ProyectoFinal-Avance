import java.util.ArrayList;
import java.util.List;

public class Admin {

    private List<Evento> listaEventos;

    public Admin(){
        this.listaEventos = new ArrayList<>();
    }

    public void agregarEvento(String nombre, String ciudad, int dia, int mes, int anio){
        Evento nuevoEvento = new Evento(nombre,ciudad,dia,mes,anio);
        listaEventos.add(nuevoEvento);
    }

        public List<Evento> getListaEventos(){
            return listaEventos;
        }

}
