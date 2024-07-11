package CapaNegocio;

public class Artista {

    private String nombreArtista;

    public Artista() {
    }

    public Artista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }


    @Override
    public String toString() {
        return "Nombre del artista: " + nombreArtista;
    }
}
