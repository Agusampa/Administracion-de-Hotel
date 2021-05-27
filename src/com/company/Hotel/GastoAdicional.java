package com.company.Hotel;

public abstract class GastoAdicional {
    protected String detalle;
    protected float precio;
    protected int cantidad; ///En  Servicio se cuenta como cantidad de horas y en Consumible como unidad // Aprovechando el polimorfismo de los objetos

    public GastoAdicional(String detalle,float precio,int cantidad){
        this.detalle = detalle;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
