package CapaNegocio;

public class Boleto {
    private int idBoleto;
    private DetalleFactura detalle;
    private boolean disponible;

    public Boleto(int idBoleto, int idUsuario, int idEvento, DetalleFactura detalle) {
        this.idBoleto = idBoleto;
        this.detalle = detalle;
        this.disponible = true;
    }

    public int getIdBoleto() {
        return idBoleto;
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
        return "Boleto ID: " + idBoleto + ", Entrada: " + detalle.getTipoAsiento() + ", Cantidad: " + detalle.getCantidad() + ", Precio: $" + detalle.getPrecio();
    }
}
