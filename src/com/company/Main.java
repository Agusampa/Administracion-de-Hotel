package com.company;

import com.company.Hotel.Habitacion;
import com.company.Hotel.Reserva;
import com.company.Menus.MenuPrincipal;
import com.company.Persona.Administrador;
import com.company.Persona.Pasajero;
import com.company.Persona.Persona;
import com.company.Persona.Recepcion;
import com.company.Sistema.Herramientas;
import com.company.Sistema.ManejoArchivo;


import java.io.IOException;
import java.time.chrono.HijrahEra;
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


        try {
            MenuPrincipal menu = new MenuPrincipal();
            menu.menuPrincipal();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
