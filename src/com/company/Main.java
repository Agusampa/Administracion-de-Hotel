package com.company;


import com.company.Persona.Pasajero;
import sun.rmi.server.LoaderHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) throws IOException {


        Menu menu = new Menu();

        menu.menuPrincipal();


    }
}
