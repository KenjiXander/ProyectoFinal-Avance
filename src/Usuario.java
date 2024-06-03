public class Usuario {

    private String usuario;
    private String nombre;
    private String email;
    private String direccion;
    private int telefono;


    public Usuario(String usuario, String nombre, String email, String direccion, int telefono) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }


    @Override
    public String toString() {
        return "Usuario: " + usuario+
                "Nombre Completo: " + nombre +
                "Email: " + email +
                "Direccion de domicilio: " + direccion +
                "Telefono: " + telefono;
    }
}
