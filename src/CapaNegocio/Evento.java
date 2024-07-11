package CapaNegocio;

import CapaEstructuras.OrdenarArbol;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private int idEvento;
    private String nombreEvento;
    private String ciudadEvento;
    private String localidadEvento;
    private String horaEvento;
    private String fechaEvento;
    private String generoMusical;
    private int aforoEvento;
    private String artistaEvento;
    public List<Artista> listaArtistas;
    public List<Localidad> listaLocalidades;
    public List<Publicidad> listaPublicidades = new ArrayList<>();


    public Evento() {
        this.listaArtistas = new ArrayList<>();
        this.listaLocalidades = new ArrayList<>();
        this.listaPublicidades = new ArrayList<>();
    }

    public void agregarArtista(Artista artista) {
        listaArtistas.add(artista);
    }

    public void agregarLocalidad(Localidad localidad) {
        listaLocalidades.add(localidad);
    }

    public void agregarPublicidad(Publicidad publicidad){
        listaPublicidades.add(publicidad);
    }

    public Evento(int idEvento, String nombreEvento, String ciudadEvento, String localidadEvento, String horaEvento, String fechaEvento, String generoMusical, int aforoEvento, String artistaEvento) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.ciudadEvento = ciudadEvento;
        this.localidadEvento = localidadEvento;
        this.horaEvento = horaEvento;
        this.fechaEvento = fechaEvento;
        this.generoMusical = generoMusical;
        this.aforoEvento = aforoEvento;
        this.artistaEvento = artistaEvento;
        this.listaLocalidades = new ArrayList<>();
    }

    public void ordenarYMostrarResultados(List<Evento> resultados, JList<Evento> navList) {
        OrdenarArbol ordenarArbol = new OrdenarArbol();
        List<Evento> eventosOrdenados = ordenarArbol.ordenarPorNombre(resultados);
        mostrarResultados(eventosOrdenados, navList);
    }

    public void mostrarResultados(List<Evento> resultados, JList<Evento> navList) {
        DefaultListModel<Evento> model = new DefaultListModel<>();
        for (Evento evento : resultados) {
            model.addElement(evento);
        }
        navList.setModel(model);
    }

    public void eliminarEvento(int index, DefaultListModel<Evento> listaEventosModel) {
        if (index != -1 && index < listaEventosModel.size()) {
            listaEventosModel.remove(index);
        }
    }

    public void actualizarListaEventos(JList<Evento> list, DefaultListModel<Evento> listaEventosModel) {
        list.setModel(listaEventosModel);
    }

    public void eliminarArtista(int index, List<Artista> listaArtistas) {
        if (index != -1 && index < listaArtistas.size()) {
            listaArtistas.remove(index);
        }
    }

    public void actualizarListaArtistas(JList<Artista> list, List<Artista> listaArtistas) {
        DefaultListModel<Artista> model = new DefaultListModel<>();
        for (Artista artista : listaArtistas) {
            model.addElement(artista);
        }
        list.setModel(model);
    }

    public void eliminarLocalidad(int index, List<Localidad> listaLocalidades) {
        if (index != -1 && index < listaLocalidades.size()) {
            listaLocalidades.remove(index);
        }
    }

    public void actualizarListaLocalidades(JList<Localidad> list, List<Localidad> listaLocalidades) {
        DefaultListModel<Localidad> model = new DefaultListModel<>();
        for (Localidad localidad : listaLocalidades) {
            model.addElement(localidad);
        }
        list.setModel(model);
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getCiudadEvento() {
        return ciudadEvento;
    }

    public void setCiudadEvento(String ciudadEvento) {
        this.ciudadEvento = ciudadEvento;
    }

    public String getLocalidadEvento() {
        return localidadEvento;
    }

    public void setLocalidadEvento(String localidadEvento) {
        this.localidadEvento = localidadEvento;
    }

    public String getHoraEvento() {
        return horaEvento;
    }

    public void setHoraEvento(String horaEvento) {
        this.horaEvento = horaEvento;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public int getAforoEvento() {
        return aforoEvento;
    }

    public void setAforoEvento(int aforoEvento) {
        this.aforoEvento = aforoEvento;
    }

    public String getArtistaEvento() {
        return artistaEvento;
    }

    public void setArtistaEvento(String artista) {
        this.artistaEvento = artistaEvento;
    }

    public List<Localidad> getListaLocalidades() {
        return listaLocalidades;
    }

    public void setListaLocalidades(List<Localidad> listaLocalidades) {
        this.listaLocalidades = listaLocalidades;
    }

    public List<Publicidad> getListaPublicidades() {
        return listaPublicidades;
    }

    public void setListaPublicidades(List<Publicidad> listaPublicidades) {
        this.listaPublicidades = listaPublicidades;
    }

    @Override
    public String toString() {
        return nombreEvento + " - " +
                "Ciudad: " + ciudadEvento + " - " +
                "Localidad: " + localidadEvento + " - " +
                fechaEvento + " " + horaEvento;
    }
}
