package CapaEstructuras;

import CapaNegocio.Evento;
import CapaNegocio.Usuario;

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
            Evento eventoLista = listaEventos.getElementAt(i);
            if (eventoLista.getNombreEvento().equalsIgnoreCase(nombre)) {
                resultado.add(eventoLista);
            }
        }
        return resultado;
    }


    public List<Evento> buscarPorFecha(String fecha) {
        List<Evento> resultado = new ArrayList<>();
        for (int i = 0; i < listaEventos.getSize(); i++) {
            Evento eventoLista = listaEventos.getElementAt(i);
            if (eventoLista.getFechaEvento().equals(fecha)) {
                resultado.add(eventoLista);
            }
        }
        return resultado;
    }


    public List<Evento> buscarPorGenero(String genero) {
        List<Evento> resultado = new ArrayList<>();
        for (int i = 0; i < listaEventos.getSize(); i++) {
            Evento eventoLista = listaEventos.getElementAt(i);
            if (eventoLista.getGeneroMusical().equalsIgnoreCase(genero)) {
                resultado.add(eventoLista);
            }
        }
        return resultado;
    }


    public List<Evento> buscarPorLocalidad(String localidad) {
        List<Evento> resultado = new ArrayList<>();
        for (int i = 0; i < listaEventos.getSize(); i++) {
            Evento eventoLista = listaEventos.getElementAt(i);
            if (eventoLista.getLocalidadEvento().equalsIgnoreCase(localidad)) {
                resultado.add(eventoLista);
            }
        }
        return resultado;
    }

    public List<Evento> buscarPorCiudad(String ciudad) {
        List<Evento> resultado = new ArrayList<>();
        for (int i = 0; i < listaEventos.getSize(); i++) {
            Evento eventoLista = listaEventos.getElementAt(i);
            if (eventoLista.getCiudadEvento().equalsIgnoreCase(ciudad)) {
                resultado.add(eventoLista);
            }
        }
        return resultado;
    }

    public List<Evento> buscarPorArtista(String artista) {
        List<Evento> resultado = new ArrayList<>();
        for (int i = 0; i < listaEventos.getSize(); i++) {
            Evento eventoLista = listaEventos.getElementAt(i);
            if (eventoLista.getArtistaEvento().equalsIgnoreCase(artista)) {
                resultado.add(eventoLista);
            }
        }
        return resultado;
    }

}