package com.company.Hotel;

import com.company.Persona.*;

import java.time.LocalDate;


import java.util.Date;
import java.util.List;


public class Reserva {
    private Pasajero pasajero;
    private Habitacion habitacion;
    private float pago;
    private LocalDate inicio;
    private LocalDate fin;
    private List<GastoAdicional> gastosAdicionales;
    private TipoDeReserva reserva;



    public Reserva(Pasajero pasajero, Habitacion habitacion, float pago, Date inicio, Date fin) {

    }


    ///CONSTRUCTORES
    public Reserva(){}
    public Reserva(Pasajero pasajero, Habitacion habitacion, float pago, LocalDate inicio, LocalDate fin) {

        this.pasajero = pasajero;
        this.habitacion = habitacion;
        this.pago = pago;
        this.inicio = inicio;
        this.fin = fin;
        this.gastosAdicionales = gastosAdicionales;
        this.reserva = reserva;
    }

    public enum TipoDeReserva{
        DISPONIBLE,
        EN_LIMPIEZA,
        EN_REPARACION,
        EN_DESINFECCION,
        OCUPADO
    }

    ///GETTER AND SETTER


    public Pasajero getPasajero() {
        return pasajero;
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

    public float getPago() {
        return pago;
    }

    public void setPago(float pago) {
        this.pago = pago;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFin() {
        return fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    public List<GastoAdicional> getGastosAdicionales() {
        return gastosAdicionales;
    }

    public void setGastosAdicionales(List<GastoAdicional> gastosAdicionales) {
        this.gastosAdicionales = gastosAdicionales;
    }

    public TipoDeReserva getReserva() {
        return reserva;
    }

    public void setReserva(TipoDeReserva reserva) {
        this.reserva = reserva;
    }

    ///METODOS
    public void agregarGastoAdicional(GastoAdicional gastoAdicional){
        this.gastosAdicionales.add(gastoAdicional);
    }

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
                "\n" + this.pasajero +
                "\nH" + this.habitacion +
                "\nPago: " + this.pago +
                "\nInicio: " + this.inicio +
                "\nFin: " + this.fin +
                "\nGastos Adicionales: " + this.gastosAdicionales;
    }


}
