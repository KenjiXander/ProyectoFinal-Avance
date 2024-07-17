package CapaEstructuras;

import CapaNegocio.Boleto;
import CapaNegocio.DetalleFactura;
import CapaNegocio.Usuario;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Lista {

    public List<Usuario> listaUsuarios = new ArrayList<>();
    public List<DetalleFactura> carrito = new ArrayList<>();
    public DefaultListModel<String> modeloCarrito = new DefaultListModel<>();
    public List<Boleto> listaBoletos = new ArrayList<>();

}
