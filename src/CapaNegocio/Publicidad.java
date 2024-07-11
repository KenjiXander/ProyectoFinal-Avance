package CapaNegocio;

public class Publicidad {
    private int idEvento;
    private String plataforma;
    private int presupuesto;
    private String fechaInicio;
    private String fechaCulminacion;

    public Publicidad(int idEvento, String plataforma, int presupuesto, String fechaInicio, String fechaCulminacion) {
        this.idEvento = idEvento;
        this.plataforma = plataforma;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.fechaCulminacion = fechaCulminacion;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaCulminacion() {
        return fechaCulminacion;
    }

    public void setFechaCulminacion(String fechaCulminacion) {
        this.fechaCulminacion = fechaCulminacion;
    }

    @Override
    public String toString() {
        return "Evento: " + idEvento + "\n" +
                "Plataforma: " + plataforma + "\n" +
                "Presupuesto: " + presupuesto + "\n" +
                "Fecha de inicio: " + fechaInicio + "\n" +
                "Fecha de culminacion: " + fechaCulminacion;
    }
}
