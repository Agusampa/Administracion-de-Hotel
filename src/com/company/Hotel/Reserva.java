package com.company.Hotel;

import com.company.Persona.*;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Pasajero pasajero;
    private Habitacion habitacion;
    private float pago;
    private Date inicio;
    private Date fin;
    private List<GastoAdicional> gastosAdicionales;
    private TipoDeReserva reserva;

    public Reserva(){}

    public Reserva(Pasajero pasajero, Habitacion habitacion, float pago, Date inicio, Date fin) {
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

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getfin() {
        return fin;
    }

    public void setfin(Date fin) {
        this.fin = fin;
    }
/*
    public long retornarCantidadDeDias(DateTime inicio, DateTime fin) throws Exception{

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse(inicio);
        Date secondDate = sdf.parse(fin);

        long diferecia = firstDate.getTime() - secondDate.getTime();
        TimeUnit time = TimeUnit.DAYS;

        long cantidadDeDias = time.convert(diferecia, TimeUnit.MILLISECONDS);

        return cantidadDeDias;
    }*/


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
