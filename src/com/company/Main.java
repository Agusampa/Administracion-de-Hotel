package com.company;

import com.company.Hotel.Habitacion;
import com.company.Hotel.Reserva;
import com.company.Menus.MenuPrincipal;
import com.company.Persona.Administrador;
import com.company.Persona.Pasajero;
import com.company.Persona.Persona;
import com.company.Persona.Recepcion;
import com.company.Sistema.ManejoArchivo;


import java.io.IOException;
import java.util.ArrayList;

import com.company.Persona.Pasajero;
import com.company.Sistema.PersonaDeserializer;
import sun.rmi.server.LoaderHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) throws IOException {





        /*
        try {
            MenuPrincipal menu = new MenuPrincipal();
            menu.menuPrincipal();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ArrayList<Persona> papu = new ArrayList<>();
        Pasajero persona = new Pasajero("ernesto","palomita","345434","4584844","Paraguay","Tristaldo 2816");
        Pasajero persona2 = new Pasajero("rivaldo","uzu","78973431","4584844","Paraguay","Tristaldo 2816");
        Administrador persona3 = new Administrador("pieto","543136","martin","7897824");
        Recepcion persona4 = new Recepcion("quista","mitra","798789","4578423");
        papu.add(persona);
        papu.add(persona2);
        papu.add(persona3);
        papu.add(persona4);

        ManejoArchivo.guardarPersonas(papu);



        ArrayList<Persona> stap = ManejoArchivo.leerPersonas();
        for(Persona prix : stap){
            System.out.println("\n" + prix);

        }
*/
        /*ArrayList<Reserva> reserva = ManejoArchivo.leerReservas();

        for(Reserva reserva1 : reserva){
            System.out.println(reserva1.toString());


            if(prix instanceof Pasajero){
                System.out.println(prix.toString());
            }
            if(prix instanceof  Administrador){
                System.out.println(prix.toString());
            }
            if(prix instanceof  Recepcion){
                System.out.println(prix.toString());
            }
        }*/



    }
}
