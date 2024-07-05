package Arboles;

import GestionEvento.Evento;
import java.util.List;

public class Arbol {
    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void insertar(Evento evento) {
        raiz = insertarRecursivo(raiz, evento);
    }

    private Nodo insertarRecursivo(Nodo nodo, Evento evento) {
        if (nodo == null) {
            nodo = new Nodo(evento);
            return nodo;
        }

        if (evento.getNombreEvento().compareTo(nodo.getEvento().getNombreEvento()) < 0) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), evento));
        } else if (evento.getNombreEvento().compareTo(nodo.getEvento().getNombreEvento()) > 0) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), evento));
        }
        return nodo;
    }

    public void inOrder(Nodo nodo, List<Evento> eventosOrdenados) {
        if (nodo != null) {
            inOrder(nodo.getIzquierdo(), eventosOrdenados);
            eventosOrdenados.add(nodo.getEvento());
            inOrder(nodo.getDerecho(), eventosOrdenados);
        }
    }
}