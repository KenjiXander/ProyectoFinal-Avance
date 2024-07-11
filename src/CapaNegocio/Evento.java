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
    private boolean general;
    private int generalCantidad;
    private double generalPrecio;
    private boolean platinum;
    private int platinumCantidad;
    private double platinumPrecio;
    private boolean vip;
    private int vipCantidad;
    private double vipPrecio;
    public List<Artista> listaArtistas;
    public List<Localidad> listaLocalidades;

    public Evento() {
        this.listaArtistas= new ArrayList<>();
        this.listaLocalidades = new ArrayList<>();
    }

    public void agregarArtista(Artista artista){
        listaArtistas.add(artista);
    }

    public void agregarLocalidad(Localidad localidad){
        listaLocalidades.add(localidad);
    }

    public Evento(int idEvento, String nombreEvento, String ciudadEvento, String localidadEvento, String horaEvento, String fechaEvento, String generoMusical, int aforoEvento, String artistaEvento, boolean general, int generalCantidad, double generalPrecio, boolean platinum, int platinumCantidad, double platinumPrecio, boolean vip, int vipCantidad, double vipPrecio) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.ciudadEvento = ciudadEvento;
        this.localidadEvento = localidadEvento;
        this.horaEvento = horaEvento;
        this.fechaEvento = fechaEvento;
        this.generoMusical = generoMusical;
        this.aforoEvento = aforoEvento;
        this.artistaEvento = artistaEvento;
        this.general = general;
        this.generalCantidad = generalCantidad;
        this.generalPrecio = generalPrecio;
        this.platinum = platinum;
        this.platinumCantidad = platinumCantidad;
        this.platinumPrecio = platinumPrecio;
        this.vip = vip;
        this.vipCantidad = vipCantidad;
        this.vipPrecio = vipPrecio;
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

    public boolean isGeneral() {
        return general;
    }

    public void setGeneral(boolean general) {
        this.general = general;
    }

    public int getGeneralCantidad() {
        return generalCantidad;
    }

    public void setGeneralCantidad(int generalCantidad) {
        this.generalCantidad = generalCantidad;
    }

    public double getGeneralPrecio() {
        return generalPrecio;
    }

    public void setGeneralPrecio(double generalPrecio) {
        this.generalPrecio = generalPrecio;
    }

    public boolean isPlatinum() {
        return platinum;
    }

    public void setPlatinum(boolean platinum) {
        this.platinum = platinum;
    }

    public int getPlatinumCantidad() {
        return platinumCantidad;
    }

    public void setPlatinumCantidad(int platinumCantidad) {
        this.platinumCantidad = platinumCantidad;
    }

    public double getPlatinumPrecio() {
        return platinumPrecio;
    }

    public void setPlatinumPrecio(double platinumPrecio) {
        this.platinumPrecio = platinumPrecio;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public int getVipCantidad() {
        return vipCantidad;
    }

    public void setVipCantidad(int vipCantidad) {
        this.vipCantidad = vipCantidad;
    }

    public double getVipPrecio() {
        return vipPrecio;
    }

    public void setVipPrecio(double vipPrecio) {
        this.vipPrecio = vipPrecio;
    }

    @Override
    public String toString() {
        return nombreEvento + " - " + "Ciudad: " + ciudadEvento + " - " + "Localidad: " + localidadEvento + " - " + fechaEvento + " " + horaEvento;
    }
}