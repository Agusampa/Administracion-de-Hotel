package com.company.Hotel.Servicios;

import com.company.Hotel.GastoAdicional;
import java.time.LocalDateTime;

public class Servicio extends GastoAdicional {

        ////-----CONSTRUCTOR-----////
        public Servicio(LocalDateTime fijo,String nombre, float costo, int cantidad) {
            super(fijo,nombre,costo, cantidad,"Servicio");
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
