package CapaNegocio;

import java.util.ArrayList;
import java.util.List;

public class Localidad {
    private String nombreLocalidad;
    private String nombreButaca;
    private double precio;
    private int cantidad;
    private List<Boleto> listaBoletos;

    //agregar y varios buscar de boleto
    public Localidad(String nombreLocalidad, String nombreButaca, double precio, int cantidad) {
        this.nombreLocalidad = nombreLocalidad;
        this.nombreButaca = nombreButaca;
        this.precio = precio;
        this.cantidad = cantidad;
        this.listaBoletos = new ArrayList<>();
    }

    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
    }

    public String getNombreButaca() {
        return nombreButaca;
    }

    public void setNombreButaca(String nombreButaca) {
        this.nombreButaca = nombreButaca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<Boleto> getListaBoletos() {
        return listaBoletos;
    }

    public void setListaBoletos(List<Boleto> listaBoletos) {
        this.listaBoletos = listaBoletos;
    }
}
