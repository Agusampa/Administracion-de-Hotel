package com.company.Hotel;

import com.company.Persona.*;

import java.time.LocalDate;
import java.util.ArrayList;



public class Reserva {
        private Pasajero pasajero;
        private Habitacion habitacion;
        private float gastoTotal;
        private LocalDate inicio;
        private LocalDate fin;
        private ArrayList<GastoAdicional> gastosAdicionales;
        private TipoDeReserva reserva;

        ////-----CONSTRUCTORES-----////
        public Reserva(Pasajero pasajero, Habitacion habitacion, float pago, LocalDate inicio, LocalDate fin) {
            this.pasajero = pasajero;
            this.habitacion = habitacion;
            this.gastoTotal = pago;
            this.inicio = inicio;
            this.fin = fin;
            this.gastosAdicionales = new ArrayList<>();
        }


    public Reserva(Pasajero pasajero) {
    }

    public enum TipoDeReserva{
            DISPONIBLE,
            EN_LIMPIEZA,
            EN_REPARACION,
            EN_DESINFECCION,
            OCUPADO
        }


        ////-----GETTERS AND SETTERS-----////
        public Pasajero getPasajero() {
            return this.pasajero;
        }
        public void setPasajero(Pasajero pasajero) {
            this.pasajero = pasajero;
        }

        public Habitacion getHabitacion() {
            return habitacion;
        }
        public void setHabitacion(Habitacion habitacion) {
            this.habitacion = habitacion;
        }

        public float getGastoTotal() {
            return this.gastoTotal;
        }
        public void setGastoTotal(float gastoTotal) {
            this.gastoTotal = gastoTotal;
        }

        public LocalDate getInicio() {
            return this.inicio;
        }
        public void setInicio(LocalDate inicio) {
            this.inicio = inicio;
        }

        public LocalDate getFin() {
            return this.fin;
        }
        public void setFin(LocalDate fin) {
            this.fin = fin;
        }

        public ArrayList<GastoAdicional> getGastosAdicionales() {
            return this.gastosAdicionales;
        }
        public void setGastosAdicionales(ArrayList<GastoAdicional> gastosAdicionales) {
            this.gastosAdicionales = gastosAdicionales;
        }

        public TipoDeReserva getReserva() {
            return reserva;
        }
        public void setReserva(TipoDeReserva reserva) {
            this.reserva = reserva;
        }

        ////-----METODOS-----////
        public void agregarGastoAdicional(GastoAdicional gastoAdicional){
            this.gastosAdicionales.add(gastoAdicional);
        }   ///para que esto si tenemos gett + add?

        public double calcularTotalGastosAdicionales(){
            double gastosTotales = 0;
            for(GastoAdicional gastosAux : this.gastosAdicionales) {
                gastosTotales = gastosAux.getPrecio() + gastosTotales;
            }
            return gastosTotales;
        }


        @Override
        public String toString() {
            return "Reserva: " +
                    "\n" + this.pasajero.toString() +
                    "\n" + this.habitacion.toString() +
                    "\nPago: " + this.gastoTotal +
                    "\nInicio: " + this.inicio +
                    "\nFin: " + this.fin +
                    "\nGastos Adicionales: " + this.gastosAdicionales.toString() +
                    "\nTotal: " + this.gastoTotal;
        }


}
