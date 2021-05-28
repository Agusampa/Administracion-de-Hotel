package com.company.Hotel;

import com.company.Persona.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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




        ///METODOS RESERVA
       /* public List<Habitacion>listHabitacionesDisponibles(Duracion duracion, String tipoDeHabitacion){
            List<Habitacion>habitacionesDisponibles = new ArrayList<>();
            for(Reserva reservasAux : this.reservas){
            }
            return habitacionesDisponibles;
        }*/

        public void mostrarReservasVigentes(){
            for(Reserva reservaAux : this.reservas){
                LocalDate aux = reservaAux.getFin().toLocalDate();
                if(aux.isBefore(LocalDate.now()) || aux.equals(LocalDateTime.now())){
                    System.out.println(reservaAux.toString());
                }
            }
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
                LocalDate aux = reservaAux.getFin().toLocalDate();
                if(aux.isBefore(LocalDate.now()) || aux.equals(LocalDateTime.now())){
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

       public void mostrarAdminstradores(){
        for(Persona personaAux : this.personas){
            if(personaAux instanceof Administrador){
                Administrador administradorAux = (Administrador) personaAux;
                System.out.println(administradorAux.toString());
            }
        }
    }


}

