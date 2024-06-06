public class Evento {

    private String nombreEvento;
    private String ciudadEvento;
    private int dia;
    private int mes;
    private int anio;

    public Evento(String nombreEvento, String ciudadEvento, int dia, int mes, int anio) {
        this.nombreEvento = nombreEvento;
        this.ciudadEvento = ciudadEvento;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    @Override
    public String toString() {
        return nombreEvento + "-" + ciudadEvento + "-" + dia + "/" + mes + "/" + anio;
    }
}
