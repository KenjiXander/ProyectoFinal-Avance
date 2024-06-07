public class Evento {

    private int idEvento;
    private String nombreEvento;
    private String ciudadEvento;
    private int dia;
    private int mes;
    private int anio;

    public Evento(int idEvento, String nombreEvento, String ciudadEvento, int dia, int mes, int anio) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.ciudadEvento = ciudadEvento;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getCiudadEvento() {
        return ciudadEvento;
    }

    public void setCiudadEvento(String ciudadEvento) {
        this.ciudadEvento = ciudadEvento;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }


    @Override
    public String toString() {
        return nombreEvento + "\n" + ciudadEvento + "\n" + dia + "/" + mes + "/" + anio + "\n";
    }
}
