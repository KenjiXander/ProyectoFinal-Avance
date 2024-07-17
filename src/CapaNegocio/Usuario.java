package CapaNegocio;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private int idUsuario;
    private String usuario;
    private String nombre;
    private String contra;
    private String direccion;
    private String telefono;
    private String genero;
    private List<CabeceraFactura> listaCabeceraFactura = new ArrayList<>();
    public DefaultListModel<Evento> listaEventos = new DefaultListModel<>();
    public int nextBoletoId = 1;
    public int nextFacturaId = 1;

    public Usuario() {
        this.listaEventos = new DefaultListModel<>();
    }

    public void agregarEventoGestionado(Evento evento){
        listaEventos.addElement(evento);
    }

    public int getNextBoletoId(){
        return nextBoletoId++;
    }

    public int getNextFacturaId(){
        return nextFacturaId++;
    }

    public void agregarFactura(CabeceraFactura factura) {
        listaCabeceraFactura.add(factura);
    }

    public List<CabeceraFactura> getListaCabeceraFactura() {
        return listaCabeceraFactura;
    }

    public List<CabeceraFactura> getFacturasPorFecha(LocalDate fecha) {
        List<CabeceraFactura> facturasPorFecha = new ArrayList<>();
        for (CabeceraFactura factura : listaCabeceraFactura) {
            if (factura.getFechaCompra().equals(fecha)) {
                facturasPorFecha.add(factura);
            }
        }
        return facturasPorFecha;
    }

    public Usuario(int idUsuario, String usuario, String nombre, String contra, String direccion, String telefono, String genero) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.nombre = nombre;
        this.contra = contra;
        this.direccion = direccion;
        this.telefono = telefono;
        this.genero = genero;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "ID: " + idUsuario + "\n" +
                "Usuario: " + usuario+ "\n" +
                "Nombre Completo: " + nombre + "\n" +
                "Contraseña: " + contra + "\n" +
                "Direccion de domicilio: " + direccion + "\n" +
                "Telefono: " + telefono + "\n" +
                "Genero: " + genero;
    }
}
