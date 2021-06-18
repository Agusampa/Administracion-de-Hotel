package com.company.Hotel.Consumibles;

import com.company.Hotel.GastoAdicional;
import java.time.LocalDateTime;

public class Consumible extends GastoAdicional {
        ////-----CONSTRUCTOR-----////
        public Consumible(LocalDateTime fijo,String nombre, float precio, int cantidad) {
            super(fijo,nombre,precio, cantidad,"Consumible");
        }

        ////-----GETTERS AND SETTERS-----////
        public String getNombre() {
            return this.nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public LocalDateTime getFecha() {
            return this.fecha;
        }
        public void setFecha(LocalDateTime fecha) {
            this.fecha = fecha;
        }

        public double getPrecio() {
            return this.precio;
        }
        public void setPrecio(float precio) {
            this.precio = precio;
        }

        public int getCantidad() {
            return this.cantidad;
        }
        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
}
