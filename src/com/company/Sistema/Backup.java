package com.company.Sistema;

import com.company.Hotel.*;
import com.company.Persona.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Backup {
    private ArrayList<Persona> personasBackup;
    private ArrayList<Habitacion> habitacionesBackup;
    private ArrayList<Reserva> reservasBackup;

    public Backup(){}
    public Backup(ArrayList<Persona> personasBackup, ArrayList<Habitacion> habitacionesBackup, ArrayList<Reserva> reservasBackup) {
        this.personasBackup = personasBackup;
        this.habitacionesBackup = habitacionesBackup;
        this.reservasBackup = reservasBackup;
    }

    public ArrayList<Persona> getPersonasBackup() {
        return personasBackup;
    }
    public void setPersonasBackup(ArrayList<Persona> personasBackup) {
        this.personasBackup = personasBackup;
    }

    public ArrayList<Habitacion> getHabitacionesBackup() {
        return habitacionesBackup;
    }
    public void setHabitacionesBackup(ArrayList<Habitacion> habitacionesBackup) {
        this.habitacionesBackup = habitacionesBackup;
    }

    public ArrayList<Reserva> getReservasBackup() {
        return reservasBackup;
    }
    public void setReservasBackup(ArrayList<Reserva> reservasBackup) {
        this.reservasBackup = reservasBackup;
    }


    public ArrayList<Reserva> retornarReservasAntiguas(Pasajero pasajero){
        ArrayList<Reserva> antiguos = new ArrayList<>();
        for(Reserva reservaAux : this.reservasBackup){
            if(reservaAux.getFin().isBefore(LocalDate.now())) {
                if (reservaAux.getPasajero().equals(pasajero)) {
                    antiguos.add(reservaAux);
                }
            }
        }
        return antiguos;
    }
}
