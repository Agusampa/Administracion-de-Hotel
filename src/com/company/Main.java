package com.company;

import com.company.Hotel.Habitacion;
import com.company.Hotel.Reserva;
import com.company.Menus.MenuPrincipal;
import com.company.Persona.Administrador;
import com.company.Persona.Pasajero;
import com.company.Persona.Persona;
import com.company.Persona.Recepcion;
import com.company.Sistema.Backup;
import com.company.Sistema.ManejoArchivo;


import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        /*try {
            MenuPrincipal menu = new MenuPrincipal();
            menu.menuPrincipal();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*Backup backup = new Backup(ManejoArchivo.leerPersonas(),ManejoArchivo.leerHabitaciones(),ManejoArchivo.leerReservas());
        ManejoArchivo.guardarBackup(backup);
        Backup niu = ManejoArchivo.leerBackup();

        for(Persona uax : niu.getPersonasBackup()){
            System.out.println(uax.toString());
        }*/




        ArrayList<Persona> stap = ManejoArchivo.leerPersonas();
        for(Persona prix : stap) {
            System.out.println("\n" + prix);

        }

    }
}
