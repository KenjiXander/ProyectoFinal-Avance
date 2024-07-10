package Ingreso;


public class Factura {

    private String tipoEntrada;
    private int cantidad;
    private double precio;

    public Factura() {
    }

    public Factura(String tipoEntrada, int cantidad, double precio) {
        this.tipoEntrada = tipoEntrada;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

}
