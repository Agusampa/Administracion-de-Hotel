package com.company.Hotel;

import com.company.Persona.*;
import org.joda.time.DateTime;
import org.joda.time.Interval;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Hotel {
        private List<Persona> personas;
        private List<Habitacion> habitaciones;
        private List<Reserva> reservas;

        //Constructor
        public Hotel(){
            this.personas = new ArrayList<>();
            this.habitaciones = new ArrayList<>();
            this.reservas = new ArrayList<>();
        }

        public List<Persona> getPersonas() {
            return personas;
        }
        public void setPersonas(List<Persona> personas) {
            this.personas = personas;
        }

        public List<Habitacion> getHabitaciones() {
            return habitaciones;
        }
        public void setHabitaciones(List<Habitacion> habitaciones) {
            this.habitaciones = habitaciones;
        }

        public List<Reserva> getReservas() {
            return reservas;
        }
        public void setReservas(List<Reserva> reservas) {
            this.reservas = reservas;
        }


        ///Metodos
       /* public void checkIn(Pasajero pasajero,Habitacion habitacion,float pago){
            this.actualizarHabitacion(habitacion);
            Reserva reserva = new Reserva(pasajero,habitacion,pago,Duracion.obtenerDur());
            this.reservas.add(reserva);
        }*/

        public void actualizarHabitacion(Habitacion habitacion){
            for(Habitacion habAux : this.habitaciones){
                //if(habAux.equals(habitacion)) habAux.setStatus();
            }
        }
/*
        public void pago(Reserva reserva,float monto){
            for(Reserva aux : this.reservas){
                if(aux.equals(reserva)) aux.setPago(monto);
            }
        }

        public void chekOut(UUID id){
            Reserva aux = retResvPorId(id);
            if(aux != null)this.reservas.remove(aux);
        }*/




        ///Metodos Reserva
        public int retornarCantidadDeDias(LocalDate inicio, LocalDate fin){
            long cantidadDeDias = ChronoUnit.DAYS.between(inicio,fin);
            return (int)cantidadDeDias;
        }

       public List<Habitacion>listHabitacionesDisponibles(LocalDate inicio, LocalDate fin) {
           List<Habitacion> habitacionesDisponibles = new ArrayList<>();
           for (Habitacion habitacionAux : this.habitaciones) {

               boolean disponible = true;

               for (Reserva reservasAux : this.reservas) {
                    if (reservasAux.getHabitacion().equals(habitacionAux)) {
                        if(reservasAux.getInicio().isAfter(inicio) && reservasAux.getInicio().isAfter(fin) || reservasAux.getFin().isBefore(inicio) && reservasAux.getFin().isBefore(fin)) {

                            disponible = false;
                            break;
                        }
                    }
               }
               for(Habitacion habitacionAux2: habitacionesDisponibles){
                   if(habitacionAux2.equals(habitacionAux)){
                       disponible = false;
                   }
               }
               if (disponible){
                    habitacionesDisponibles.add(habitacionAux);
               }
            }
            return habitacionesDisponibles;
        }


        public void mostrarReservasVigentes(){
            for(Reserva reservaAux : this.reservas){
                if(reservaAux.getFin().isBefore(LocalDate.now()) || reservaAux.getFin().equals(LocalDate.now())){
                    System.out.println(reservaAux.toString());
                }
            }
        }

        //////////METODO PRUEBA
        public Persona retornarPersonaXDNI(String dni){
            for (Persona personaAux : this.personas) {
                    if (personaAux.getDni().compareToIgnoreCase(dni) == 0) {
                        return personaAux;
                    }
            }
            return null;
        }
        ///METODOS PASAJERO
        public List<Pasajero> reservasDelPasajero(Pasajero pasajero){
            List reservasPasajero = new ArrayList<>();
            for(Reserva reservaAux : this.reservas){
                if(reservaAux.getPasajero().equals(pasajero)){
                    reservasPasajero.add(reservaAux);
                }
            }
            return reservasPasajero;
        }

        public boolean validacionPasajero(Pasajero pasajero){
            for(Persona pasajeroAux : this.personas) {
                if (pasajeroAux instanceof Pasajero) {
                    if (pasajeroAux.equals(pasajero)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public Pasajero retornarPasajeroXDNI(String dni){
            for (Persona personasAux : this.personas) {
                if (personasAux instanceof Pasajero) {
                    if (personasAux.getDni().compareToIgnoreCase(dni) == 0) {
                        Pasajero pasajeroAux = (Pasajero) personasAux;
                        return pasajeroAux;
                    }
                }
            }
            return null;
        }

        public void mostrarUsuarios(){
            for(Persona personaAux : this.personas){
                if(personaAux instanceof Pasajero){
                    Pasajero pasajeroAux = (Pasajero) personaAux;
                    System.out.println(pasajeroAux.toString());
                }
            }
        }

        public void mostrarReservaActiva(Pasajero pasajero){
            for(Reserva reservaAux : this.reservas){
                if(reservaAux.getFin().isBefore(LocalDate.now()) || reservaAux.getFin().equals(LocalDate.now())){
                    if(reservaAux.getPasajero().equals(pasajero)) {
                        System.out.println(reservaAux.toString());
                    }
                }
            }
        }

        ///METODOS RECEPCIONISTA
       public Recepcion retornarRecepcionistaXDNI(String dni){
           for (Persona personasAux : this.personas) {
               if (personasAux instanceof Recepcion) {
                   if (personasAux.getDni().compareToIgnoreCase(dni) == 0) {
                       Recepcion recepcionAux = (Recepcion) personasAux;
                       return recepcionAux;
                   }
               }
           }
           return null;
       }

       public boolean validacionRecepcionista(Recepcion recepcionista){
           for(Persona pasajeroAux : this.personas) {
               if (pasajeroAux instanceof Recepcion) {
                   if (pasajeroAux.equals(recepcionista)) {
                       return true;
                   }
               }
           }
           return false;
       }

       public void mostrarRecepcionistas(){
        for(Persona personaAux : this.personas){
            if(personaAux instanceof Recepcion){
                Recepcion recepcionistaAux = (Recepcion) personaAux;
                System.out.println(recepcionistaAux.toString());
            }
        }
    }


    ///METODOS ADMINISTRADOR
       public Administrador retornarAdministradorXDNI(String dni){
           for (Persona personasAux : this.personas) {
               if (personasAux instanceof Administrador) {
                   if (personasAux.getDni().compareToIgnoreCase(dni) == 0) {
                       Administrador administradorAux = (Administrador) personasAux;
                       return administradorAux;
                   }
               }
           }
           return null;
       }

    public boolean validacionAdministrador(Administrador administrador){
        for(Persona pasajeroAux : this.personas) {
            if (pasajeroAux instanceof Administrador) {
                if (pasajeroAux.equals(administrador)) {
                    return true;
                }
            }
        }
        return false;
    }

       public void mostrarAdminstradores(){
        for(Persona personaAux : this.personas){
            if(personaAux instanceof Administrador){
                Administrador administradorAux = (Administrador) personaAux;
                System.out.println(administradorAux.toString());
            }
        }
    }


}

