package CapaNegocio;

public class Boleto {
    private int idBoleto;
    private int idUsuario;
    private int idEvento;
    private Factura factura;

    public Boleto(int idBoleto, int idUsuario, int idEvento, Factura factura) {
        this.idBoleto = idBoleto;
        this.idUsuario = idUsuario;
        this.idEvento = idEvento;
        this.factura = factura;
    }

    public int getIdBoleto() {
        return idBoleto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public Factura getFactura() {
        return factura;
    }

    @Override
    public String toString() {
        return "Evento ID: " + idEvento + ", Entrada: " + factura.getTipoEntrada() + ", Cantidad: " + factura.getCantidad() + ", Precio: $" + factura.getPrecio();
    }
}
