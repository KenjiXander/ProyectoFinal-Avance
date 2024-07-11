package CapaNegocio;

public class Artista {

    private String nombreArtista;
    private String generoArtista;

    public Artista() {
    }

    public Artista(String nombreArtista, String generoArtista) {
        this.nombreArtista = nombreArtista;
        this.generoArtista = generoArtista;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getGeneroArtista() {
        return generoArtista;
    }

    public void setGeneroArtista(String generoArtista) {
        this.generoArtista = generoArtista;
    }

    @Override
    public String toString() {
        return nombreArtista;
    }
}
