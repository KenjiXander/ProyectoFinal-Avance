package GestionEvento;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Navegar {
    private DefaultListModel<Evento> listaEventos;

    public Navegar(DefaultListModel<Evento> listaEventos) {
        this.listaEventos = listaEventos;
    }

    public List<Evento> buscarPorNombre(String nombre) {
        List<Evento> resultado = new ArrayList<>();
        for (int i = 0; i < listaEventos.getSize(); i++) {
            Evento evento = listaEventos.getElementAt(i);
            if (evento.getNombreEvento().equalsIgnoreCase(nombre)) {
                resultado.add(evento);
            }
        }
        return resultado;
    }


    public List<Evento> buscarPorFecha(String fecha) {
        List<Evento> resultado = new ArrayList<>();
        for (int i = 0; i < listaEventos.getSize(); i++) {
            Evento evento = listaEventos.getElementAt(i);
            if (evento.getFechaEvento().equals(fecha)) {
                resultado.add(evento);
            }
        }
        return resultado;
    }


    public List<Evento> buscarPorGenero(String genero) {
        List<Evento> resultado = new ArrayList<>();
        for (int i = 0; i < listaEventos.getSize(); i++) {
            Evento evento = listaEventos.getElementAt(i);
            if (evento.getGeneroMusical().equalsIgnoreCase(genero)) {
                resultado.add(evento);
            }
        }
        return resultado;
    }


    public List<Evento> buscarPorLocalidad(String localidad) {
        List<Evento> resultado = new ArrayList<>();
        for (int i = 0; i < listaEventos.getSize(); i++) {
            Evento evento = listaEventos.getElementAt(i);
            if (evento.getLocalidadEvento().equalsIgnoreCase(localidad)) {
                resultado.add(evento);
            }
        }
        return resultado;
    }

    public List<Evento> buscarPorCiudad(String ciudad) {
        List<Evento> resultado = new ArrayList<>();
        for (int i = 0; i < listaEventos.getSize(); i++) {
            Evento evento = listaEventos.getElementAt(i);
            if (evento.getCiudadEvento().equalsIgnoreCase(ciudad)) {
                resultado.add(evento);
            }
        }
        return resultado;
    }

    public List<Evento> buscarPorArtista(String artista) {
        List<Evento> resultado = new ArrayList<>();
        for (int i = 0; i < listaEventos.getSize(); i++) {
            Evento evento = listaEventos.getElementAt(i);
            if (evento.getArtista().equalsIgnoreCase(artista)) {
                resultado.add(evento);
            }
        }
        return resultado;
    }

}