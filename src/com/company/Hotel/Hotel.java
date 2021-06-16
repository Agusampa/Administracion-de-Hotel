package com.company.Hotel;

import com.company.Persona.*;
import com.company.Sistema.ManejoArchivo;

import java.io.IOException;
import com.google.gson.Gson;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class Hotel {
        private ArrayList<Persona> personas = new ArrayList<>();
        private ArrayList<Habitacion> habitaciones;
        private ArrayList<Reserva> reservas;

        ////-----CONSTRUCTOR-----////
        public Hotel() throws IOException {
            this.personas = ManejoArchivo.leerPersonas();
            this.habitaciones = ManejoArchivo.leerHabitaciones();
            this.reservas = ManejoArchivo.leerReservas();
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

        public Persona retornarPersonaXDNI(String dni) {
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
        public ArrayList<Pasajero> reservasDelPasajero(Pasajero pasajero) {
            ArrayList reservasPasajero = new ArrayList<>();
            for (Reserva reservaAux : this.reservas) {
                if (reservaAux.getPasajero().equals(pasajero)) {
                    reservasPasajero.add(reservaAux);
                }
            }
            return reservasPasajero;
        }

        public boolean validacionPasajero(Pasajero pasajero) {
            for (Persona pasajeroAux : this.personas) {
                if (pasajeroAux instanceof Pasajero) {
                    if (pasajeroAux.equals(pasajero)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void mostrarPasajeros() {
            for (Persona personaAux : this.personas) {
                if (personaAux instanceof Pasajero) {
                    Pasajero pasajeroAux = (Pasajero) personaAux;
                    System.out.println(pasajeroAux.toString());
                }
            }
        }

        public Reserva reservaActualPasajero(Pasajero pasajero) {
            Reserva masCercana = primeraReservaCercana(pasajero);
            if (masCercana != null) {
                for (Reserva reservaAux : this.reservas) {
                    if (reservaAux.getPasajero().equals(pasajero) && !reservaAux.equals(masCercana)) {
                            if (reservaAux.getFin().isBefore(masCercana.getFin())) {
                                masCercana = reservaAux;
                            }
                    }
                }
            }
            return masCercana;
        }

        public Reserva primeraReservaCercana(Pasajero pasajero) {
            for (Reserva reservaAux : this.reservas) {
                if (reservaAux.getPasajero().equals(pasajero)) {
                    if(reservaAux.getFin().equals(LocalDate.now()) ||reservaAux.getFin().isAfter(LocalDate.now())){
                        return reservaAux;
                    }
                }
            }
            return null;
        } ///puramente anclado a la funcion anterior

        public ArrayList<Reserva> retornarReservasActivas(Pasajero pasajero){
            ArrayList<Reserva> activas = null;
            for(Reserva reservaAux : this.reservas){
                if(reservaAux.getFin().isAfter(LocalDate.now()) || reservaAux.getFin().equals(LocalDate.now())){
                    if(reservaAux.getPasajero().equals(pasajero)) {
                        activas.add(reservaAux);
                    }
                }
            }
            return activas;
        }

        public ArrayList<Reserva> retornarReservasAntiguas(Pasajero pasajero){
            ArrayList<Reserva> antiguas = null;
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
        public Reserva ReservaAleatoria(){

            Pasajero pasajero = (Pasajero) this.retornarPersonaXDNI("3");

            boolean flag = true;

            LocalDate inicio = null;

            LocalDate fin = null;

            Habitacion habitacion = null;

            int i = 0;
            while (flag) {
                System.out.println("AAAAAAAAAAAAAAAAAAAAAA");
                inicio = Reserva.fechaAleatoria();

                fin = inicio.plusDays((int) (Math.random() * 10 + 1));



                while (i < 20 || flag == true) {
                    System.out.println("sa");i++;
                    habitacion = retornarHabitacionXNumero((int) (Math.random() * 7 + 1));
                    boolean disponible = estaDisponible(habitacion, inicio, fin);
                    if (disponible) {
                        flag = false;
                    }

                }
            }
            String tipoReserva = Reserva.tipoDeReservaAleatoria();

            Float gastoTotal = (float) Reserva.gastoTotalAleatorio( tipoReserva,retornarCantidadDeDias(inicio,fin));

            Reserva reserva = new Reserva(pasajero,habitacion,gastoTotal,inicio,fin,tipoReserva);

            return reserva;
        }

        public int retornarCantidadDeDias(LocalDate inicio, LocalDate fin){
            long cantidadDeDias = ChronoUnit.DAYS.between(inicio,fin);
            return (int)cantidadDeDias;
        }

        public void mostrarReservasVigentes(){
            for(Reserva reservaAux : this.reservas){
                if(reservaAux.getFin().isAfter(LocalDate.now()) || reservaAux.getFin().equals(LocalDate.now())){
                    System.out.println(reservaAux.toString());
                }
            }
        }  ///arreglado

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

        public  boolean estaDisponible(Habitacion habitacion, LocalDate inicio, LocalDate fin){
            for (Reserva reservasAux : this.reservas) {
                if (reservasAux.getHabitacion().equals(habitacion)) {
                    if(reservasAux.getInicio().isAfter(inicio) && reservasAux.getInicio().isAfter(fin) || reservasAux.getFin().isBefore(inicio) && reservasAux.getFin().isBefore(fin)) {
                        return  false;
                    }
                }
            }
            return true;
        }

        public ArrayList<Habitacion>listHabitacionesDisponibles(LocalDate inicio, LocalDate fin) {
        ArrayList<Habitacion> habitacionesDisponibles = new ArrayList<>();
        for (Habitacion habitacionAux : this.habitaciones) {

            boolean disponible = true;

            for (Reserva reservasAux : this.reservas) {
                if (reservasAux.getHabitacion().equals(habitacionAux)) {
                    System.out.println(reservasAux.getInicio().isAfter(inicio));
                    System.out.println(reservasAux.getInicio().isAfter(fin));
                    System.out.println(reservasAux.getFin().isBefore(inicio));
                    System.out.println(reservasAux.getFin().isBefore(fin));
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

