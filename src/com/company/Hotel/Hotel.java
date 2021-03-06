package com.company.Hotel;

import com.company.Persona.*;
import com.company.Sistema.Herramientas;
import com.company.Sistema.ManejoArchivo;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Hotel {
        private ArrayList<Persona> personas = new ArrayList<>();
        private ArrayList<Habitacion> habitaciones = new ArrayList<>();
        private ArrayList<Reserva> reservas = new ArrayList<>();

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
                        //System.out.println(personaAux.toString());
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
                    if(masCercana.getInicio().equals(LocalDate.now())|| masCercana.getInicio().isBefore(LocalDate.now())) {
                        return masCercana;
                    }
                    return null;
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

                public ArrayList<Reserva> retornarReservasAntiguas(Pasajero pasajero){
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
                public void mostrarTodasReservas(){
                    for(Reserva reservaAux : this.getReservas()){
                        System.out.println(reservaAux.toString());
                    }
                }

                public void mostrarReservasVigentes () {
                    for (Reserva reservaAux : this.reservas) {
                        if (reservaAux.getFin().isAfter(LocalDate.now()) || reservaAux.getFin().equals(LocalDate.now())) {
                            System.out.println(reservaAux.toString());
                        }
                    }
                }

                public void mostrarReservasAntiguas () {
                        int i=0;
                        for (Reserva reservaAux : this.reservas) {
                            if (reservaAux.getFin().isBefore(LocalDate.now())) {
                                System.out.println(reservaAux.toString());
                                i++;
                            }
                        }
                        if(i==0){System.err.println("No hay reservas Antigas");}
                    }

                public boolean comprobarReservaNoTransit(LocalDate inicio,LocalDate fin,Pasajero pasajero) {
                    boolean control = true;
                    for (Reserva reservaAux : this.reservas) {
                        if (pasajero.equals(reservaAux.getPasajero())) {
                            if (fin.isBefore(reservaAux.getInicio()) || inicio.isAfter(reservaAux.getFin())) {
                                control = true;
                            }else{
                                return false;
                            }
                        }
                    }
                    return control;
                }

                public Reserva ReservaAleatoria() {
                    Pasajero pasajero = (Pasajero) this.retornarPersonaXDNI(dniAleatorioPasajeros());
                    Pasajero pHotel = (Pasajero) this.retornarPersonaXDNI("11111111");
                    boolean flag = true;
                    LocalDate inicio = null;
                    LocalDate fin = null;
                    Habitacion habitacion = null;
                    boolean disponible = true;

                        while (flag == true) {
                            inicio = Herramientas.fechaAleatoria();
                            fin = inicio.plusDays((int) (Math.random() * 10 + 1));
                            disponible = true;
                            if (disponible) {
                                habitacion = retornarHabitacionXNumero((int) (Math.random() * 7 + 1));
                                disponible = estaDisponible(habitacion, inicio, fin);
                                if (disponible) {
                                    flag = false;
                                }
                            }
                        }
                        Reserva reserva;
                        flag = false;
                        String tipoReserva;
                        float gastoTotal;
                        do {
                            flag=true;
                            tipoReserva = Reserva.tipoDeReservaAleatoria();
                            if(pasajero.getDni().compareTo("11111111")==0 && tipoReserva.compareTo(Reserva.TipoDeReserva.OCUPADO.name()) == 0){
                                flag = false;
                            }
                        }while(flag ==false);

                    if (tipoReserva.compareTo(Reserva.TipoDeReserva.OCUPADO.name()) == 0) {
                        reserva = new Reserva(pasajero, habitacion, inicio, fin);
                    } else {
                        gastoTotal = (float) Reserva.gastoTotalAleatorio(tipoReserva, Herramientas.retornarCantidadDeDias(inicio, fin));
                        reserva = new Reserva(pHotel, habitacion, gastoTotal, inicio, fin, tipoReserva);
                    }

                    return reserva;
                    }

                public String dniAleatorioPasajeros(){
                    ArrayList<String> dniPasajeros = new ArrayList<>();
                    for(Persona personaAux : this.personas){
                        if(personaAux instanceof Pasajero){
                            dniPasajeros.add(personaAux.getDni());
                        }
                    }
                    Collections.shuffle(dniPasajeros);
                return dniPasajeros.remove(0);

                }

                public void actualizarReserva (Reserva reserva){
                    for (Reserva reservaAux : this.reservas) {
                        if (reservaAux.getInicio().equals(reserva.getInicio()) && reservaAux.getFin().equals(reserva.getFin())) {
                            if (reservaAux.getPasajero().equals(reserva.getPasajero())) {
                                reservaAux = reserva;
                            }
                        }
                    }
                }


                ////-----METODOS HABITACION-----////
                public Habitacion retornarHabitacionXNumero ( int numero){
                    for (Habitacion habitacionAux : this.habitaciones) {
                        if (habitacionAux.getNumero() == numero) {
                            return habitacionAux;
                        }
                    }
                    return null;
                }

                public boolean estaDisponible (Habitacion habitacion, LocalDate inicio, LocalDate fin){
                    for (Reserva reservasAux : this.reservas) {
                        if (reservasAux.getHabitacion().equals(habitacion)) {
                            if (reservasAux.getInicio().isAfter(inicio) && reservasAux.getInicio().isAfter(fin) || reservasAux.getFin().isBefore(inicio) && reservasAux.getFin().isBefore(fin)) {
                                return false;
                            }
                        }
                    }
                    return true;
                }

                public void actualizarPasajeroaEnReserva(Pasajero nuevo, Pasajero antiguo){
                    for(Reserva reservaAux : this.reservas){
                        if(reservaAux.getPasajero().getDni().compareTo(antiguo.getDni())==0){
                            reservaAux.setPasajero(nuevo);
                        }
                    }
                }

                public ArrayList<Habitacion>listHabitacionesDisponibles(LocalDate inicio, LocalDate fin) {

                    ArrayList<Habitacion> habitacionesDisponibles = new ArrayList<>();

                    ArrayList<Habitacion> habitacionesNODisponibles = new ArrayList<>();

                    for (Habitacion habitacionAux : this.habitaciones) {
                        boolean disponible = false;
                        for (Reserva reservasAux : this.reservas) {
                            if (reservasAux.getHabitacion().equals(habitacionAux)) {
                                if(inicio.isBefore(reservasAux.getInicio()) && fin.isBefore(reservasAux.getInicio())  || inicio.isAfter(reservasAux.getFin()) && fin.isAfter(reservasAux.getFin())) {
                                    disponible = true;
                                }else{
                                    habitacionesNODisponibles.add(habitacionAux);
                                }
                            }else{
                                disponible = true;
                            }
                        }
                        for(Habitacion habitacion : habitacionesNODisponibles){
                            if(habitacion.equals(habitacionAux)){
                                disponible = false;
                            }
                        }

                        for(Habitacion habitacionAux2: habitacionesDisponibles){
                            if(habitacionAux2.getTipoHabitacion() == habitacionAux.getTipoHabitacion() && habitacionAux2.getCapacidad() == habitacionAux.getCapacidad()){
                                disponible = false;
                                break;
                            }
                        }
                        if (disponible == true){
                            habitacionesDisponibles.add(habitacionAux);
                        }
                    }
                    habitacionesDisponibles.removeAll(habitacionesNODisponibles);

                    return habitacionesDisponibles;
                }

                public ArrayList<Habitacion>listHabitacionesDisponiblesTodas(LocalDate inicio, LocalDate fin) {

                    ArrayList<Habitacion> habitacionesDisponibles = new ArrayList<>();

                    ArrayList<Habitacion> habitacionesNODisponibles = new ArrayList<>();

                    for (Habitacion habitacionAux : this.habitaciones) {

                        boolean disponible = false;

                        for (Reserva reservasAux : this.reservas) {
                            if (reservasAux.getHabitacion().equals(habitacionAux)) {
                                if(inicio.isBefore(reservasAux.getInicio()) && fin.isBefore(reservasAux.getInicio())  || inicio.isAfter(reservasAux.getFin()) && fin.isAfter(reservasAux.getFin())) {
                                    disponible = true;
                                }else{
                                    habitacionesNODisponibles.add(habitacionAux);
                                }
                            }else{
                                disponible = true;
                            }
                        }
                        for(Habitacion habitacion : habitacionesNODisponibles){
                            if(habitacion.equals(habitacionAux)){
                                disponible = false;
                            }
                        }


                        if (disponible == true){
                            habitacionesDisponibles.add(habitacionAux);
                        }
                    }
                    habitacionesDisponibles.removeAll(habitacionesNODisponibles);

                    return habitacionesDisponibles;
                }

}