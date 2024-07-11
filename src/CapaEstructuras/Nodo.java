package CapaEstructuras;

import CapaNegocio.Evento;

public class Nodo {
    private Evento evento;
    private Nodo izquierdo, derecho;

    public Nodo(Evento evento) {
        this.evento = evento;
        izquierdo = derecho = null;
    }

    public Evento getEvento() {
        return evento;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
}