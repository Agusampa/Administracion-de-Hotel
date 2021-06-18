package com.company.Hotel;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class GastoAdicional {
        LocalDateTime fecha;
        protected String nombre;
        protected float precio;
        protected int cantidad; ///En  Servicio se cuenta como cantidad de horas y en Consumible como unidad // Aprovechando el polimorfismo de los objetos

        ////-----CONSTRUCTOR-----////
        public GastoAdicional(){
        }
        public GastoAdicional(LocalDateTime fecha,String nombre,float precio,int cantidad){
            this.fecha = fecha;
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
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

        ////-----METODOS-----////
        @Override
        public String toString(){
            return  "\n" + this.getClass().getSimpleName() +
                    "\nFecha: " + this.fecha +
                    "\nNombre: " + this.nombre +
                    "\nCantidad: " + this.cantidad +
                    "\nPrecio Unitario:" + this.precio +
                    "\nPrecio Total:" + this.precio * this.cantidad ;
        }
}
