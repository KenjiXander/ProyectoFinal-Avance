package CapaNegocio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Localidad {
    private String nombreLocalidad;
    private int capacidadLocalidad;
    private boolean general;
    private int generalCantidad;
    private double generalPrecio;
    private boolean platinum;
    private int platinumCantidad;
    private double platinumPrecio;
    private boolean vip;
    private int vipCantidad;
    private double vipPrecio;

    public Localidad() {
    }

    public Localidad(String nombreLocalidad, int capacidadLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
        this.capacidadLocalidad = capacidadLocalidad;
    }

    public Localidad(String nombreLocalidad, int capacidadLocalidad, boolean general, int generalCantidad, double generalPrecio, boolean platinum, int platinumCantidad, double platinumPrecio, boolean vip, int vipCantidad, double vipPrecio) {
        this.nombreLocalidad = nombreLocalidad;
        this.capacidadLocalidad = capacidadLocalidad;
        this.general = general;
        this.generalCantidad = generalCantidad;
        this.generalPrecio = generalPrecio;
        this.platinum = platinum;
        this.platinumCantidad = platinumCantidad;
        this.platinumPrecio = platinumPrecio;
        this.vip = vip;
        this.vipCantidad = vipCantidad;
        this.vipPrecio = vipPrecio;
    }

    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
    }

    public int getCapacidadLocalidad() {
        return capacidadLocalidad;
    }

    public void setCapacidadLocalidad(int capacidadLocalidad) {
        this.capacidadLocalidad = capacidadLocalidad;
    }

    public boolean isGeneral() {
        return general;
    }

    public void setGeneral(boolean general) {
        this.general = general;
    }

    public int getGeneralCantidad() {
        return generalCantidad;
    }

    public void setGeneralCantidad(int generalCantidad) {
        this.generalCantidad = generalCantidad;
    }

    public double getGeneralPrecio() {
        return generalPrecio;
    }

    public void setGeneralPrecio(double generalPrecio) {
        this.generalPrecio = generalPrecio;
    }

    public boolean isPlatinum() {
        return platinum;
    }

    public void setPlatinum(boolean platinum) {
        this.platinum = platinum;
    }

    public int getPlatinumCantidad() {
        return platinumCantidad;
    }

    public void setPlatinumCantidad(int platinumCantidad) {
        this.platinumCantidad = platinumCantidad;
    }

    public double getPlatinumPrecio() {
        return platinumPrecio;
    }

    public void setPlatinumPrecio(double platinumPrecio) {
        this.platinumPrecio = platinumPrecio;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public int getVipCantidad() {
        return vipCantidad;
    }

    public void setVipCantidad(int vipCantidad) {
        this.vipCantidad = vipCantidad;
    }

    public double getVipPrecio() {
        return vipPrecio;
    }

    public void setVipPrecio(double vipPrecio) {
        this.vipPrecio = vipPrecio;
    }

    @Override
    public String toString() {
        return "Localidad: " + nombreLocalidad + "\n " +
                "Capacidad: " + capacidadLocalidad + "\n" +
                "General: " + generalCantidad + "\n" +
                "Platinum: " + platinumCantidad + "\n" +
                "VIP: " + vipCantidad;
    }
}
