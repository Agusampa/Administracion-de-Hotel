package com.company.Hotel;

import com.company.Persona.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class Hotel {
        private ArrayList<Persona> personas;
        private ArrayList<Habitacion> habitaciones;
        private ArrayList<Reserva> reservas;

        ////-----CONSTRUCTOR-----////
        public Hotel(){
            this.personas = new ArrayList<>();
            this.habitaciones = new ArrayList<>();
            this.reservas = new ArrayList<>();
        }

        ////-----GETTER AND SETTER-----////
        public ArrayList<Persona> getPersonas() {
            return personas;
        }
        public void setPersonas(ArrayList<Persona> personas) {
            this.personas = personas;
        }

        public ArrayList<Habitacion> getHabitaciones() {
            return habitaciones;
        }
        public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
            this.habitaciones = habitaciones;
        }

        public ArrayList<Reserva> getReservas() {
            return reservas;
        }
        public void setReservas(ArrayList<Reserva> reservas) {
            this.reservas = reservas;
        }


        //////-----METODOS PERSONA-----//////
        public Persona retornarPersonaXDNI(String dni){
            for (Persona personaAux : this.personas) {
                if (personaAux.getDni().compareToIgnoreCase(dni) == 0) {
                          return personaAux;
                }
            }
            return null;
        }

        public void  actualizarPersonaEnHotel(Persona personaAntes, Persona personaNueva){
           for(Persona personaAux : this.personas){
               if(personaAux.equals(personaAntes)){
                   personaAux = personaNueva;
               }
           }

        }

        ////-----METODOS PASAJERO-----////
        public ArrayList<Pasajero> reservasDelPasajero(Pasajero pasajero){
            ArrayList reservasPasajero = new ArrayList<>();
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

        public void mostrarPasajeros(){
            for(Persona personaAux : this.personas){
                if(personaAux instanceof Pasajero){
                    Pasajero pasajeroAux = (Pasajero) personaAux;
                    System.out.println(pasajeroAux.toString());
                }
            }
        }

        public Reserva reservaActualPasajero(Pasajero pasajero) {
            for (Reserva reservaAux : this.reservas) {
                if (reservaAux.getPasajero().equals(pasajero)) {
                    if (reservaAux.getInicio().isAfter(LocalDate.now()) || reservaAux.getInicio().equals(LocalDate.now())) {
                        return reservaAux;
                    }
                }
            }
        return null;
        }

        public ArrayList<Reserva> retornarReservasActivas(Pasajero pasajero){
            ArrayList<Reserva> activas = new ArrayList<>();
            for(Reserva reservaAux : this.reservas){
                if(reservaAux.getFin().isAfter(LocalDate.now()) | reservaAux.getFin().equals(LocalDate.now())){
                    if(reservaAux.getPasajero().equals(pasajero)) {
                        activas.add(reservaAux);
                    }
                }
            }
            return activas;
        }

        public ArrayList<Reserva> retornarReservasAntigas(Pasajero pasajero){
            ArrayList<Reserva> antiguas = new ArrayList<>();
            for(Reserva reservaAux : this.reservas){
                if(reservaAux.getFin().isBefore(LocalDate.now())){
                    if(reservaAux.getPasajero().equals(pasajero)) {
                        antiguas.add(reservaAux);
                    }
                }
            }
            return antiguas;
        }

        ////-----METODOS RECEPCIONISTA-----////
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


        ////-----METODOS ADMINISTRADOR-----////
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


        ////-----METODOS GENERALES-----////
        public boolean existeDNI(String dni){
            for(Persona persona : this.personas){
                if(persona.getDni().compareTo(dni) == 0){
                    return true;
                }
            }
            return false;
        }

        public boolean comprobarContrasenias(String a, String b){
            if(a.compareTo(b)==0){
                return true;
            }
            return false;
        }

        ////-----METODOS RESERVA-----////
        public int retornarCantidadDeDias(LocalDate inicio, LocalDate fin){
            long cantidadDeDias = ChronoUnit.DAYS.between(inicio,fin);
            return (int)cantidadDeDias;
        }

        public void mostrarReservasVigentes(){
            for(Reserva reservaAux : this.reservas){
                if(reservaAux.getFin().isBefore(LocalDate.now()) || reservaAux.getFin().equals(LocalDate.now())){
                    System.out.println(reservaAux.toString());
                }
            }
        }

        public void actualizarReserva(Reserva reserva){
            for(Reserva reservaAux : this.reservas){
                if(reservaAux.getInicio().equals(reserva.getInicio()) && reservaAux.getFin().equals(reserva.getFin())){
                    if(reservaAux.getPasajero().equals(reserva.getPasajero())){
                        reservaAux = reserva;
                    }
                }
            }
        }


        ////-----METODOS HABITACION-----////
        public Habitacion retornarHabitacionXNumero(int numero){
            for(Habitacion habitacionAux : this.habitaciones){
                if(habitacionAux.getNumero() == numero)  {
                    return habitacionAux;
                }
            }
            return null;
        }

        public ArrayList<Habitacion>listHabitacionesDisponibles(LocalDate inicio, LocalDate fin) {
        ArrayList<Habitacion> habitacionesDisponibles = new ArrayList<>();
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
                if(habitacionAux2.getTipoHabitacion() == habitacionAux.getTipoHabitacion() && habitacionAux2.getCapacidad() == habitacionAux.getCapacidad()){
                    disponible = false;
                    break;
                }
            }
            if (disponible){
                habitacionesDisponibles.add(habitacionAux);
            }
        }
        return habitacionesDisponibles;
    }

        public void actualizarHabitacion(Habitacion habitacion){
        for(Habitacion habAux : this.habitaciones){
            if(habAux.equals(habitacion)){
                habAux = habitacion;
            }
        }
    }


}

