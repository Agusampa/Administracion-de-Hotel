package com.company.Hotel;

import com.company.Persona.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

    public class Hotel {
        private List<Administrador> administradores = new LinkedList<>();
        private List<Pasajero> pasajeros = new ArrayList<>();
        private List<Recepcionista> conserjes = new LinkedList<>();
        private List<Habitacion> habitaciones = new LinkedList<>();
        private List<Reserva> reservas = new LinkedList<>();


        public void checkIn(Pasajero pasajero,Habitacion habitacion,float pago){
            this.actualizarHabitacion(habitacion);
            Reserva reserva = new Reserva(pasajero,habitacion,pago,Reserva.obtenerDur());
            this.reservas.add(reserva);
        }

        public void actualizarHabitacion(Habitacion habitacion){
            for(Habitacion habAux : this.habitaciones){
                if(habAux.equals(habitacion)) habAux.setStatus(Habitacion.Estado.OCUPADO);
            }
        }

        public void pago(Reserva reserva,float monto){
            for(Reserva aux : this.reservas){
                if(aux.equals(reserva)) aux.setPago(monto);
            }
        }

        public void chekOut(UUID id){
            Reserva aux = retResvPorId(id);
            if(aux != null)this.reservas.remove(aux);
        }

        public Reserva retResvPorId(UUID id){
            for(Reserva aux : this.reservas){
                if(aux.getId().equals(id)) return aux;
            }
            return null;
        }

    }

