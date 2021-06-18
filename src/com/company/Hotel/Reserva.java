package com.company.Hotel;

import com.company.Persona.*;
import com.company.Sistema.Herramientas;
import com.sun.imageio.plugins.wbmp.WBMPImageReader;

import java.time.LocalDate;
import java.util.ArrayList;



public class Reserva {
        private Pasajero pasajero;
        private Habitacion habitacion;
        private float gastoTotal;
        private LocalDate inicio;
        private LocalDate fin;
        private ArrayList<GastoAdicional> gastosAdicionales;
        private String tipoReserva;



        ////-----CONSTRUCTORES-----////
        public Reserva(Pasajero pasajero, Habitacion habitacion, LocalDate inicio, LocalDate fin) {
            this.pasajero = pasajero;
            this.habitacion = habitacion;
            this.inicio = inicio;
            this.fin = fin;
            this.gastosAdicionales = new ArrayList<>();
            this.tipoReserva =  TipoDeReserva.OCUPADO.name();
            this.gastoTotal = (float) this.habitacion.getPrecioPorNoche() * Herramientas.retornarCantidadDeDias(inicio,fin);
        }

        public Reserva(Pasajero pasajero, Habitacion habitacion, float gastoTotal, LocalDate inicio, LocalDate fin,String tipoDeReserva) {
            this.pasajero = pasajero;
            this.habitacion = habitacion;
            this.gastoTotal = gastoTotal;
            this.inicio = inicio;
            this.fin = fin;
            this.gastosAdicionales = new ArrayList<>();
            this.tipoReserva = tipoDeReserva;

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

        public ArrayList<GastoAdicional> getGastosAdicionales() {
            return this.gastosAdicionales;
        }
        public void setGastosAdicionales(ArrayList<GastoAdicional> gastosAdicionales) {
            this.gastosAdicionales = gastosAdicionales;
        }

        public String getTipoReserva() {
            return tipoReserva;
        }
        public void setTipoReserva(String tipoReserva) {
            this.tipoReserva = tipoReserva;
        }

                    ////-----METODOS-----////
        public void agregarGastoAdicional(GastoAdicional gastoAdicional){
            this.gastosAdicionales.add(gastoAdicional);
        }   ///para que esto si tenemos gett + add?

        public float calcularTotalGastosAdicionales(){
            float gastosTotales = 0;
            if(this.gastosAdicionales.size() > 0) {
                for (GastoAdicional gastosAux : this.gastosAdicionales) {
                    gastosTotales = (float) (gastosAux.getPrecio() * gastosAux.cantidad) + gastosTotales;
                }
            }
            return gastosTotales;
        }

        public float calcularGastoTotal(){
            float gastoTotalCalculado;
            if(this.tipoReserva.compareTo(TipoDeReserva.OCUPADO.name())==0) {
                gastoTotalCalculado = this.calcularTotalGastosAdicionales() + this.gastoTotal;
            }else{
                gastoTotalCalculado = this.gastoTotal * Herramientas.retornarCantidadDeDias(this.inicio,this.fin);
            }

            return gastoTotalCalculado;
        }

        public void verGastosAdicionales(){
            if(this.gastosAdicionales.size()>0) {
                for (GastoAdicional gastoAdicionalAux : this.gastosAdicionales) {
                    System.out.println(gastoAdicionalAux.toString());
                }
            }else{
                System.out.println("No posee gastos adicionales,porfa,sea buenito y compre/contrate algo");
            }
        }

        public static String tipoDeReservaAleatoria(){
        int numeroAleatorio = (int)(Math. random()*20+0);
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


        @Override
        public String toString() {
            return "\n=================================================="+
                    "\nReserva: " +
                    "\n-------------------------------------------------"+
                    "\n" + this.pasajero.toString() +
                    "\n-------------------------------------------------"+
                    this.habitacion.toString() +
                    "-------------------------------------------------"+
                    "\nGasto total en Habitacion: " + this.habitacion.getPrecioPorNoche() +
                    "\nTipo de tipoReserva: " + this.tipoReserva +
                    "\nInicio: " + this.inicio +
                    "\nFin: " + this.fin +
                    "\nTotal: " + this.calcularGastoTotal()+
                    "\n==================================================";
        }


}
