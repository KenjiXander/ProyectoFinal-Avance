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
