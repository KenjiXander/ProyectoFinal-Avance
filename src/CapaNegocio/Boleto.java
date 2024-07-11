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

    public void setIdBoleto(int idBoleto) {
        this.idBoleto = idBoleto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public String toString() {
        return "idBoleto: " + idBoleto + "\n" +
                "Nombre de Usuario: " + idUsuario + "\n" +
                "Evento: " + idEvento + "\n" +
                "Factura: " + factura;
    }
}
