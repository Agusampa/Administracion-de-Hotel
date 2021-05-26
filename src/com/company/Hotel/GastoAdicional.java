package com.company.Hotel;

public abstract class GastoAdicional {
    private double precio;
    private int cantidad; ///En  Servicio se cuenta como cantidad de horas y en Consumible como unidad // Aprovechando el polimorfismo de los objetos

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
