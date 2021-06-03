package com.company.Hotel;

public class Habitacion {
        private TipoHabitacion tipoHabitacion;
        private int numero;
        private int capacidad;
        private double precioPorNoche;


        public enum TipoHabitacion{
            Suite,
            Premiun,
            Estandar
        }

        ////-----CONSTRUCTOR-----////
        public Habitacion(TipoHabitacion tipoHabitacion, int numero, int capacidad, double precioPorNoche) {
            this.numero = numero;
            this.tipoHabitacion = tipoHabitacion;
            this.capacidad = capacidad;
            this.precioPorNoche = precioPorNoche;
        }

        ////-----GETTERS AND SETTERS-----////
        public TipoHabitacion getTipoHabitacion() {
            return this.tipoHabitacion;
        }
        public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
            this.tipoHabitacion = tipoHabitacion;
        }

        public int getNumero() {
            return this.numero;
        }
        public void setNumero(int numero) {
            this.numero = numero;
        }

        public int getCapacidad() {
            return this.capacidad;
        }
        public void setCapacidad(int capacidad) {
            this.capacidad = capacidad;
        }

        public double getPrecioPorNoche() {
            return this.precioPorNoche;
        }
        public void setPrecioPorNoche(double precioPorNoche) {
            this.precioPorNoche = precioPorNoche;
        }

        ////METODOS
        @Override
        public String toString() {
            return "\nHabitacion:" +
                    "\nNumero:" + this.numero +
                    "\nTipo de habitacion:"+this.tipoHabitacion +
                    "\nPrecio por noche: "+ this.precioPorNoche +
                    "\nCapacidad: "+ this.capacidad;
        }

}
