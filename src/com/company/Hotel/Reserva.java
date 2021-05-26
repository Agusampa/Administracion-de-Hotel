package com.company.Hotel;

import com.company.Persona.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Reserva {
    private Pasajero pasajero;
    private Habitacion habitacion;
    private float pago;
    private LocalDateTime inicio;
    private LocalDateTime din;
    private List<GastoAdicional>gastosAdicionales;

    public Reserva(){}

    public Reserva(Pasajero pasajero, Habitacion habitacion, float pago, LocalDateTime inicio, LocalDateTime din) {
        this.pasajero = pasajero;
        this.habitacion = habitacion;
        this.pago = pago;
        this.inicio = inicio;
        this.din = din;
        this.gastosAdicionales = new ArrayList<>();
    }

    public enum TipoDeReserva{
        DISPONIBLE,
        EN_LIMPIEZA,
        EN_REPARACION,
        EN_DESINFECCION,
        OCUPADO
    }

    public Pasajero getPasajero() {
        return this.pasajero;
    }
    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Habitacion getHabitacion() {
        return this.habitacion;
    }
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public float getPago() {
        return this.pago;
    }
    public void setPago(float pago) {
        this.pago = pago;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getDin() {
        return din;
    }

    public void setDin(LocalDateTime din) {
        this.din = din;
    }

    //public int retornarCantidadDeDias(LocalTimeDate inicio, LocalTimeDate fin){}

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
}
