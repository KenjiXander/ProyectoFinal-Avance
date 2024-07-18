package CapaEstructuras;

import CapaNegocio.DetalleFactura;
import CapaNegocio.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ListaCarrito {

    public List<DetalleFactura> carrito;

    public ListaCarrito(){
        carrito = new ArrayList<DetalleFactura>();
    }

    public List<DetalleFactura> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<DetalleFactura> carrito) {
        this.carrito = carrito;
    }

    public void adicionarCompras(DetalleFactura c){
        carrito.add(c);
    }

    public DetalleFactura buscarCompras(String compras){
        for(DetalleFactura d:carrito){
            if(d.getBoleto().equals(compras)){
                return d;
            }
        }
        return null;
    }
}
