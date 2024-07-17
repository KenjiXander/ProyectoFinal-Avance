package CapaNegocio;

public class Boleto {
    private int idBoleto;
    private int idUsuario;
    private int idEvento;
    private DetalleFactura detalle;
    private boolean disponible;

    public Boleto(int idBoleto, int idUsuario, int idEvento, DetalleFactura detalle) {
        this.idBoleto = idBoleto;
        this.idUsuario = idUsuario;
        this.idEvento = idEvento;
        this.detalle = detalle;
        this.disponible = true;
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

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Evento ID: " + idEvento + ", Entrada: " + detalle.getTipoAsiento() + ", Cantidad: " + detalle.getCantidad() + ", Precio: $" + detalle.getPrecio();
    }
}
