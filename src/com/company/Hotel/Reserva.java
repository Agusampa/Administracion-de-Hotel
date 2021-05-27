package com.company.Hotel;

import com.company.Persona.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private Pasajero pasajero;
    private Habitacion habitacion;
    private float pago;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private List<GastoAdicional> gastosAdicionales;


    ///CONSTRUCTORES
    public Reserva(){}
    public Reserva(Pasajero pasajero, Habitacion habitacion, float pago, LocalDateTime inicio, LocalDateTime fin) {
        this.pasajero = pasajero;
        this.habitacion = habitacion;
        this.pago = pago;
        this.inicio = inicio;
        this.fin = fin;
        this.gastosAdicionales = new ArrayList<>();
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
        return this.inicio;
    }
    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFin() {
        return this.fin;
    }
    public void setFin(LocalDateTime fin) { this.fin = fin;}

    ///METODOS

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

    @Override
    public String toString() {
        return "Reserva: " +
                "\nPasajero=" + this.pasajero +
                "\nHabitacion=" + this.habitacion +
                "\nPago: " + this.pago +
                "\nInicio: " + this.inicio +
                "\nFin: " + this.fin +
                "\nGastos Adicionales: " + this.gastosAdicionales;
    }


}
