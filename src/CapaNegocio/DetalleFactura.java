package CapaNegocio;

public class DetalleFactura {
    private Evento evento;
    private String tipoAsiento;
    private int cantidad;
    private double precio;

    public DetalleFactura(Evento evento, String tipoAsiento, int cantidad, double precio) {
        this.evento = evento;
        this.tipoAsiento = tipoAsiento;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(String tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
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
        return "Evento: " + evento.getNombreEvento() + " - " +
                "Asiento: " + tipoAsiento + " - " +
                "Cantidad: " + cantidad + " - " +
                "Precio: $" + String.format("%.2f", precio);
    }
}
