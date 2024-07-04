public class Usuario {

    private int id;
    private String usuario;
    private String nombre;
    private String contra;
    private String direccion;
    private String telefono;
    private String genero;


    public Usuario(int id, String usuario, String nombre, String contra, String direccion, String telefono, String genero) {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
        this.contra = contra;
        this.direccion = direccion;
        this.telefono = telefono;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Usuario: " + usuario+ "\n" +
                "Nombre Completo: " + nombre + "\n" +
                "Contraseña: " + contra + "\n" +
                "Direccion de domicilio: " + direccion + "\n" +
                "Telefono: " + telefono + "\n" +
                "Genero: " + genero;
    }
}