package CapaEstructuras;

import CapaNegocio.Boleto;
import CapaNegocio.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ListaBoleto {

    public List<Boleto> listaBoletos;

    public ListaBoleto(){
        listaBoletos = new ArrayList<Boleto>();
    }

    public List<Boleto> getListaBoletos() {
        return listaBoletos;
    }

    public void setListaBoletos(List<Boleto> listaBoletos) {
        this.listaBoletos = listaBoletos;
    }

    public void adicionarBoleto(Boleto b){
        listaBoletos.add(b);
    }

    public Boleto buscarBoleto(int boleto){
        for(Boleto b:listaBoletos){
            if(b.getIdBoleto() == boleto){
                return b;
            }
        }
        return null;
    }

}
