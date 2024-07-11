package CapaNegocio;

public class Boleto {
    private int idBoleto;
    private int idUsuario;
    private int idEvento;
    private String tipoEntrada;
    private int cantidad;
    private double precio;

    public Boleto(int idBoleto, int idUsuario, int idEvento, String tipoEntrada, int cantidad, double precio) {
        this.idBoleto = idBoleto;
        this.idUsuario = idUsuario;
        this.idEvento = idEvento;
        this.tipoEntrada = tipoEntrada;
        this.cantidad = cantidad;
        this.precio = precio;
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
        return "idBoleto: " + idBoleto + "\n" +
                "Nombre de Usuario: " + idUsuario + "\n" +
                "Evento: " + idEvento + "\n" +
                "Tipo de entrada: " + tipoEntrada + "\n" +
                "Cantidad: " + cantidad + "\n" +
                "Precio: " + precio;
    }
}
