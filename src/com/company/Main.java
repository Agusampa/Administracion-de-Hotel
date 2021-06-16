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


        Scanner sc = new Scanner(System.in);
        int anioI = 0, mesI = 0, diaI = 0;
        int anioF = 0, mesF = 0, diaF = 0;
        boolean control = false;


        if(anioI < anioF || diaI < diaF)
            System.out.println("soy gay");

        while (!(anioI >= LocalDate.now().getYear())){
            System.out.println("Ingresar el AÑO en que desea realizar su reserva.");
            anioI = sc.nextInt();
            if (!(anioI >= LocalDate.now().getYear())){
                System.err.println("Ingreso un año no valido");
            }
        }

        do{
            System.out.println("Ingresar el numero de MES en que desea realizar su reserva.");
            mesI = sc.nextInt();
            if (!(mesI < LocalDate.now().getMonthValue()) && !(anioI != LocalDate.now().getYear())||(!(anioI <= LocalDate.now().getYear()))) {
                control = true;
                break;
            }

            System.err.println("Ingreso un mes no valido");

        }while(control == false);

        control = false;
        do{
            System.out.println("Ingresar el DIA en que desea realizar su reserva.");
            diaI = sc.nextInt();
            if ((!(diaI < LocalDate.now().getDayOfMonth()) || (!(mesI <= LocalDate.now().getMonthValue())  || (!(anioI <= LocalDate.now().getYear()))))){
                control = true;
                break;
            }
            System.err.println("Ingreso un dia no valido");
        }while (control == false);

        control = false;

        do{
            System.out.println("Ingresar el AÑO hasta el que se desea hospedar");
            anioF = sc.nextInt();
            if (!(anioF < anioI)) {
                control = true;
                break;
            }
            System.out.println("Ingreso un año no valido");

        }while (control == false);

        control = false;

        do {
            System.out.println("Ingresar el numero de MES hasta el que se desea hospedar");
            mesF = sc.nextInt();
            if ( mesI != mesF || mesI == mesF && Reserva.controlMesTop(mesI, diaI) == true) {
                if (!(mesF < mesI) || !(anioF < anioI)) {
                    control = true;
                    break;
                }
            }
            System.err.println("Ingreso un mes no valido");

        }while (control == false);


        control = false;

        do {
            System.out.println("Ingresar el DIA hasta el que se desea hospedar");
            diaF = sc.nextInt();
            if(Reserva.controlFecha(mesF, diaF) == true) {
                if (!(diaF > diaI) || !(mesF < mesI) || !(anioI < anioF)) {
                    control = true;
                    break;
                }
            }
            System.err.println("Ingreso un dia no valido");
        }while (control == false);


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
