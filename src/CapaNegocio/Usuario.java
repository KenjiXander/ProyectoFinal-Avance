package CapaNegocio;

import javax.swing.*;
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
    public List<Factura> carrito;
    public DefaultListModel<String> modeloCarrito;
    public List<Usuario> listaUsuarios = new ArrayList<>();
    public DefaultListModel<Evento> listaEventos;
    public List<Boleto> listaBoletos = new ArrayList<>();
    public int nextBoletoId = 1;

    public Usuario() {
        this.carrito = new ArrayList<>();
        this.modeloCarrito = new DefaultListModel<>();
        this.listaEventos = new DefaultListModel<>();
    }

    public void agregarCarrito(Factura carritos){
        carrito.add(carritos);
    }

    public void eliminarCarrito(int carritos){
        carrito.remove(carritos);
    }

    public void agregarModeloCarrito(String modeloCarritos){
        modeloCarrito.addElement(modeloCarritos);
    }

    public void agregarEventoGestionado(Evento evento){
        listaEventos.addElement(evento);
    }

    public void agregarBoleto(Boleto boleto){
        listaBoletos.add(boleto);
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

    public int getNextBoletoId(){
        return nextBoletoId++;
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