package CapaNegocio;

import java.util.List;
import java.time.LocalDate;

public class CabeceraFactura {
    private int idFactura;
    private Usuario usuario;
    private LocalDate fechaCompra;
    private double total;
    private List<DetalleFactura> detalles;

    public CabeceraFactura(int idFactura, Usuario usuario, LocalDate fechaCompra, double total, List<DetalleFactura> detalles) {
        this.idFactura = idFactura;
        this.usuario = usuario;
        this.fechaCompra = fechaCompra;
        this.total = total;
        this.detalles = detalles;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        StringBuilder facturaString = new StringBuilder();
        facturaString.append("***** FACTURA *****\n\n");

        facturaString.append("Informacion del Comprador:\n");
        facturaString.append("Nombre: ").append(usuario.getNombre()).append("\n");
        facturaString.append("Cedula: ").append(usuario.getIdUsuario()).append("\n");
        facturaString.append("Fecha de Compra: ").append(fechaCompra).append("\n\n");

        facturaString.append("Detalles de la Compra:\n");
        for (DetalleFactura detalle : detalles) {
            facturaString.append(detalle.toString()).append("\n");
        }

        facturaString.append("\nTotal a Pagar: $").append(String.format("%.2f", total)).append("\n");
        return facturaString.toString();
    }
}
