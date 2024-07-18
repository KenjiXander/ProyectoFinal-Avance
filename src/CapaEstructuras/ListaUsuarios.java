package CapaEstructuras;

import CapaNegocio.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ListaUsuarios {

    public List<Usuario> listaUsuarios;

    public ListaUsuarios(){
        listaUsuarios = new ArrayList<Usuario>();
    }

    public List<Usuario> getListaUsuarios(){
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public void adicionarUsuarios(Usuario u){
        listaUsuarios.add(u);
    }

    public Usuario buscarUsuario(String usuario){
        for(Usuario u:listaUsuarios){
            if(u.getUsuario().equals(usuario)){
                return u;
            }
        }
        return null;
    }
}
