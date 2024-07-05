package Arboles;

import GestionEvento.Evento;
import java.util.ArrayList;
import java.util.List;

public class OrdenarArbol {
    public List<Evento> ordenarPorNombre(List<Evento> eventos) {
        Arbol arbol = new Arbol();
        for (Evento evento : eventos) {
            arbol.insertar(evento);
        }
        List<Evento> eventosOrdenados = new ArrayList<>();
        arbol.inOrder(arbol.getRaiz(), eventosOrdenados);
        return eventosOrdenados;
    }
}