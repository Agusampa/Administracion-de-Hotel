package com.company.Sistema;

import com.company.Hotel.*;
import com.company.Persona.*;

import java.util.ArrayList;

public class Backup {
    private ArrayList<Persona> personasBackup = new ArrayList<>();
    private ArrayList<Habitacion> habitacionesBackup = new ArrayList<>();
    private ArrayList<Reserva> reservasBackup = new ArrayList<>();

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


}
