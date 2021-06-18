package com.company;
import com.company.Hotel.Habitacion;
import com.company.Hotel.Hotel;
import com.company.Hotel.Reserva;
import com.company.Menus.MenuPrincipal;
import com.company.Persona.Administrador;
import com.company.Persona.Pasajero;
import com.company.Persona.Persona;
import com.company.Persona.Recepcion;
import com.company.Sistema.ManejoArchivo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {

        MenuPrincipal menu = new MenuPrincipal();
        menu.menuPrincipal();



        ////-----CARGA PASAJEROS-----////

       /* ArrayList<Persona> personas = new ArrayList<>();
        Pasajero pasajeroBol1 = new Pasajero("Agustin", "Sampaoli", "1", "11223344", "Argentina", "Colon 1542");
        personas.add(pasajeroBol1);
        Pasajero pasajeroBol2 = new Pasajero("Misael", "Flores", "1", "22334455", "Argentina", "Henrique Peña 1542");
        personas.add(pasajeroBol2);
        Pasajero pHotel = new Pasajero("ADMINISTRACION","HOTEL","1","11111111","HOTEL","GOMORRA");
        personas.add(pHotel);

        Recepcion recepcionBol1 = new Recepcion("Isaias","Patomero","1","33445566");  personas.add(recepcionBol1);
        Recepcion recepcionBol2 = new Recepcion("Leonardo","Da Vinci","1","55667788");    personas.add(recepcionBol2);

        Administrador administrador1 = new Administrador("James", "Sunderland", "1", "10111213");   personas.add(administrador1);
        Administrador administrador2 = new Administrador("Ethan", "Winters", "1", "13141516");    personas.add(administrador2);

        ManejoArchivo.guardarPersonas(personas);

        ArrayList<Persona> respaldo1 = ManejoArchivo.leerPersonas();
        for(Persona personaAux : respaldo1){
            System.out.println(personaAux.toString());
        }*/

/*
        ////-----CARGA HABITACIONES-----////

                ArrayList<Habitacion> habitacions = new ArrayList<>();
                Habitacion habitacion1 = new Habitacion(Habitacion.TipoHabitacion.Suite, 1 , 2, 5000);  habitacions.add(habitacion1);
                Habitacion habitacion2 = new Habitacion(Habitacion.TipoHabitacion.Suite, 2 , 4, 7000);  habitacions.add(habitacion2);
                Habitacion habitacion3 = new Habitacion(Habitacion.TipoHabitacion.Suite, 3 , 2, 5000);  habitacions.add(habitacion3);
                Habitacion habitacion4 = new Habitacion(Habitacion.TipoHabitacion.Suite, 4 , 4, 7000);  habitacions.add(habitacion4);
                Habitacion habitacion5 = new Habitacion(Habitacion.TipoHabitacion.Suite, 5 , 2, 5000);  habitacions.add(habitacion5);

                Habitacion habitacion6 = new Habitacion(Habitacion.TipoHabitacion.Premiun, 6, 2, 3500); habitacions.add(habitacion6);
                Habitacion habitacion7 = new Habitacion(Habitacion.TipoHabitacion.Premiun, 7, 4, 5500); habitacions.add(habitacion7);
                Habitacion habitacion8 = new Habitacion(Habitacion.TipoHabitacion.Premiun, 8, 2, 3500); habitacions.add(habitacion8);
                Habitacion habitacion9 = new Habitacion(Habitacion.TipoHabitacion.Premiun, 9, 4, 5500); habitacions.add(habitacion9);
                Habitacion habitacion10 = new Habitacion(Habitacion.TipoHabitacion.Premiun, 10, 2, 3500);   habitacions.add(habitacion10);

                Habitacion habitacion11 = new Habitacion(Habitacion.TipoHabitacion.Estandar, 11, 4, 4000);  habitacions.add(habitacion11);
                Habitacion habitacion12 = new Habitacion(Habitacion.TipoHabitacion.Estandar, 12, 2, 3000);  habitacions.add(habitacion12);
                Habitacion habitacion13 = new Habitacion(Habitacion.TipoHabitacion.Estandar, 13, 4, 4000);  habitacions.add(habitacion13);
                Habitacion habitacion14 = new Habitacion(Habitacion.TipoHabitacion.Estandar, 14, 2, 3000);  habitacions.add(habitacion14);
                Habitacion habitacion15 = new Habitacion(Habitacion.TipoHabitacion.Estandar, 15, 4, 4000);  habitacions.add(habitacion15);

                ManejoArchivo.guardarHabitaciones(habitacions);

                ArrayList<Habitacion> respaldo = ManejoArchivo.leerHabitaciones();
                for (Habitacion habitacion : respaldo){
                    System.out.println(habitacion.toString());
                }
*/

    }
}
