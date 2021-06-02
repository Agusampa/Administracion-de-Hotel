package com.company.Hotel;

import com.company.Persona.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Hotel {
        private ArrayList<Persona> personas;
        private ArrayList<Habitacion> habitaciones;
        private ArrayList<Reserva> reservas;

        //Constructor
        public Hotel(){
            this.personas = new ArrayList<>();
            this.habitaciones = new ArrayList<>();
            this.reservas = new ArrayList<>();
        }

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

        public void actualizarReserva(Reserva reserva){
            for(Reserva reservaAux : this.reservas){
                if(reservaAux.getInicio().equals(reserva.getInicio()) && reservaAux.getFin().equals(reserva.getFin())){
                    if(reservaAux.getPasajero().equals(reserva.getPasajero())){
                        reservaAux = reserva;
                    }
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

        public ArrayList<Reserva> RetornarReservasActiva(Pasajero pasajero){
            ArrayList<Reserva> activas = new ArrayList<>();
            for(Reserva reservaAux : this.reservas){
                if(reservaAux.getFin().isAfter(LocalDate.now()) || reservaAux.getFin().equals(LocalDate.now())){
                    if(reservaAux.getPasajero().equals(pasajero)) {
                        activas.add(reservaAux);
                    }
                }
            }
            return activas;
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

