package CapaNegocio;

public class Factura {
    private String tipoEntrada;
    private int cantidad;
    private double precio;

    public Factura(String tipoEntrada, int cantidad, double precio) {
        this.tipoEntrada = tipoEntrada;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return tipoEntrada + " x" + cantidad + " - $" + precio;
    }
}
