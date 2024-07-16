package CapaNegocio;

public class Boleto {
    private int idBoleto;
    private int idUsuario;
    private int idEvento;
    private DetalleFactura detalle;

    public Boleto(int idBoleto, int idUsuario, int idEvento, DetalleFactura detalle) {
        this.idBoleto = idBoleto;
        this.idUsuario = idUsuario;
        this.idEvento = idEvento;
        this.detalle = detalle;
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

    public DetalleFactura getDetalle() {
        return detalle;
    }

    @Override
    public String toString() {
        return "Evento ID: " + idEvento + ", Entrada: " + detalle.getTipoAsiento() + ", Cantidad: " + detalle.getCantidad() + ", Precio: $" + detalle.getPrecio();
    }
}
