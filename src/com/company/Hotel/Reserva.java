package com.company.Hotel;

import com.company.Persona.*;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Reserva {
        private Pasajero pasajero;
        private Habitacion habitacion;
        private float gastoTotal;
        private LocalDate inicio;
        private LocalDate fin;
        private List<GastoAdicional> gastosAdicionales;
        private String reserva;


        ////-----CONSTRUCTORES-----////
        public Reserva(Pasajero pasajero, Habitacion habitacion, float gastoTotal, LocalDate inicio, LocalDate fin) {
            this.pasajero = pasajero;
            this.habitacion = habitacion;
            this.gastoTotal = gastoTotal;
            this.inicio = inicio;
            this.fin = fin;
            this.gastosAdicionales = new ArrayList<>();
            this.reserva =  TipoDeReserva.OCUPADO.name();
        }

        public Reserva(Pasajero pasajero, Habitacion habitacion, float gastoTotal, LocalDate inicio, LocalDate fin,String tipoDeReserva) {
            this.pasajero = pasajero;
            this.habitacion = habitacion;
            this.gastoTotal = gastoTotal;
            this.inicio = inicio;
            this.fin = fin;
            this.gastosAdicionales = new ArrayList<>();
        }

        public Reserva(Pasajero pasajero) { }

        public static LocalDate fechaAleatoria(){
            LocalDate startDate = LocalDate.of(2021, 7, 1);
            long start = startDate.toEpochDay();

            LocalDate endDate = LocalDate.of(2022, 1, 1);
            long end = endDate.toEpochDay();

            long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();

            LocalDate aleatorio = (LocalDate.ofEpochDay(randomEpochDay));

            return aleatorio;
        }
        public static String tipoDeReservaAleatoria(){
            int numeroAleatorio = (int)(Math. random()*4+0);
            if(numeroAleatorio == 0){
                return TipoDeReserva.EN_LIMPIEZA.name();
            }else if(numeroAleatorio == 1){
                return TipoDeReserva.EN_REPARACION.name();
            }else if(numeroAleatorio == 2){
                return TipoDeReserva.EN_DESINFECCION.name();
            }
            return TipoDeReserva.OCUPADO.name();
        }
        public static int gastoTotalAleatorio(String tipoDeReserva, int cantDias){
            if(tipoDeReserva.compareTo(TipoDeReserva.EN_LIMPIEZA.name())==0){
                return 1000*cantDias;
            }else if(tipoDeReserva.compareTo(TipoDeReserva.EN_REPARACION.name())==0){
                return 3000*cantDias;
            }else if(tipoDeReserva.compareTo(TipoDeReserva.EN_DESINFECCION.name())==0){
                return 1500*cantDias;
            }
            return 2000*cantDias;
        }


        public enum TipoDeReserva{
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

        public List<GastoAdicional> getGastosAdicionales() {
            return this.gastosAdicionales;
        }
        public void setGastosAdicionales(List<GastoAdicional> gastosAdicionales) {
            this.gastosAdicionales = gastosAdicionales;
        }

        public String getReserva() {
            return reserva;
        }
        public void setReserva(String reserva) {
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
            return "\nReserva: " +
                    "\n" + this.pasajero.toString() +
                    "\n" + this.habitacion.toString() +
                    "\nPago: " + this.gastoTotal +
                    "\nTipo de reserva: " + this.reserva +
                    "\nInicio: " + this.inicio +
                    "\nFin: " + this.fin +
                    "\nGastos adicionales: " + this.gastosAdicionales.toString() +
                    "\nTotal: " + this.gastoTotal;
        }


}
