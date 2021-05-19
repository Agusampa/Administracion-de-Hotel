package com.company.Hotel;

import com.company.Persona.*;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class Reserva {
    private final UUID id = UUID.randomUUID();
    private Pasajero pasajero;
    private Habitacion habitacion;
    private float pago;
    private Duracion duracion;

    public Reserva(){}
    public Reserva(Pasajero pasajero, Habitacion habitacion, float pago,Duracion duracion) {
        this.pasajero = pasajero;
        this.habitacion = habitacion;
        this.pago = pago;
        this.duracion = obtenerDur();
    }


    public UUID getId() {
        return this.id;
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

    public static Duracion obtenerDur(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la fecha de finalizacion con el siguiente formato: AÑO//MES//DIA HH/MM");
        LocalDateTime finalizacion = LocalDateTime.of(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
        LocalDateTime inicio = LocalDateTime.now();
        int dur = finalizacion.getDayOfMonth() - inicio.getDayOfMonth();
        Duracion duracion = new Duracion(inicio,finalizacion,dur);
        return  duracion;
    }
}
