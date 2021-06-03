package com.company;

import com.company.Hotel.*;
import com.company.Hotel.Consumibles.*;
import com.company.Hotel.Servicios.*;

import com.company.Persona.*;

import com.company.Sistema.Backup;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
        Hotel hotel = new Hotel();
        Backup backup = new Backup();


        public void menuPrincipal() {
            Pasajero pasajero1 = new Pasajero("Peter", "Pan","P1","3","Argentina","Colon 1542");
            this.hotel.getPersonas().add(pasajero1);

                Habitacion habitacion1 = new Habitacion(Habitacion.TipoHabitacion.Suite,01,2,3000);
                Habitacion habitacion2 = new Habitacion(Habitacion.TipoHabitacion.Suite,02,4,3500);
                Habitacion habitacion3 = new Habitacion(Habitacion.TipoHabitacion.Premiun,03,2,2000);
                Habitacion habitacion4 = new Habitacion(Habitacion.TipoHabitacion.Premiun,04,4,2500);
                Habitacion habitacion5 = new Habitacion(Habitacion.TipoHabitacion.Estandar,05,2,1000);
                Habitacion habitacion6 = new Habitacion(Habitacion.TipoHabitacion.Estandar,06,4,1500);
                Habitacion habitacion7 = new Habitacion(Habitacion.TipoHabitacion.Estandar,06,4,1500);

                this.hotel.getHabitaciones().add(habitacion1);
                this.hotel.getHabitaciones().add(habitacion2);
                this.hotel.getHabitaciones().add(habitacion3);
                this.hotel.getHabitaciones().add(habitacion4);
                this.hotel.getHabitaciones().add(habitacion5);
                this.hotel.getHabitaciones().add(habitacion6);
                this.hotel.getHabitaciones().add(habitacion7);

            LocalDate inicio = LocalDate.of(2021,3,25);
            LocalDate finalizacion = LocalDate.of(2021,3,29);

            ArrayList<Habitacion> habitacionesDisponibles = this.hotel.listHabitacionesDisponibles(inicio,finalizacion);
                for(Habitacion habitacion : habitacionesDisponibles) {
                    System.out.println(habitacion.toString());
                }
            System.out.println("\nPress Any Key To Continue...");
            new java.util.Scanner(System.in).nextLine();

            boolean salir = false;
                do {
                    try {
                    System.out.println("Bienvenido al sistema del Hotel ...\n" +
                    "Como desea ingresar al sistema?\n\t1_Como PASAJERO\n\t2_Como EMPLEADO\n\t3_Salir ");
                    Scanner scInt = new Scanner(System.in);
                    int opcion = scInt.nextInt();

                        switch (opcion) {

                            case 1:
                                menuPrimeroPasajero();
                                salir = true;
                                break;

                            case 2:
                                menuPrimerolEmpleado();
                                break;

                            case 3:
                                salir = true;
                                break;
                            default:
                                System.err.println("Las opciones son 1-2-3\n\n");
                        }
                    } catch(java.util.InputMismatchException e) {
                        System.err.println("Ingreso una opcion no valida");
                    }
                }while(!salir);
        System.out.println("GRACIAS POR USAR EL SISTEMA!");
        }


        ////-----MENUS PASAJERO-----////
        public void menuPrimeroPasajero(){
            boolean salir = false;
            do {
                try {
                System.out.println("MENU PASAJERO PRIMERO" +
                "\nQue accion desea realizar?\n\t1_Registrarse\n\t2_Ingresar\n\t3_Volver");
                Scanner scInt = new Scanner(System.in);
                int opcion = scInt.nextInt();
                Pasajero pasajero = null;
                    switch (opcion) {

                        case 1:
                            pasajero = menuPasajeroRegistro();
                                this.hotel.getPersonas().add(pasajero);
                            menuPrincipalPasajero(pasajero);
                            salir = true;
                            break;

                        case 2:
                            pasajero = (Pasajero) menuLoggin();
                                if (pasajero != null) { menuPrincipalPasajero(pasajero); }
                                else { System.err.println("Error de loggin, intenlo nuevamente"); }
                            salir = true;
                            break;

                        case 3:
                            salir = true;
                            break;

                        default:
                            System.err.println("Las opciones son 1-2-3");
                    }
                }catch (java.util.InputMismatchException e){
                    System.err.println("Ingreso una opcion no valida");
                }
            }while(!salir);
        }

        public Pasajero menuPasajeroRegistro(){
            System.out.println("MENU REGISTRO PASAJERO");
            Pasajero pasajero = null;
            boolean aceptado = false;
                while (!aceptado) {
                    pasajero = nuevoPasajero();
                    aceptado = this.hotel.validacionPasajero(pasajero);
                    if(aceptado){
                        System.err.println("El usuario ya se encuentra registrado");
                    }else {
                        aceptado = true;
                    }
                }
        return pasajero;
        }

        public Pasajero nuevoPasajero(){
            Scanner scannerPasajero = new Scanner(System.in);
            System.out.println("Nombre: ");
                String nombre = scannerPasajero.nextLine();
            System.out.println("Apellido: ");
                String apellido = scannerPasajero.nextLine();
            System.out.println("DNI: ");
                String dni = scannerPasajero.nextLine();
            System.out.println("Pais de origen: ");
                String paisOrigen = scannerPasajero.nextLine();
            System.out.println("Domicilio: ");
                String domicilio = scannerPasajero.nextLine();
                String password = null;

            boolean aceptada = false;
                while (!aceptada) {
                    System.out.println("Contraseña: ");
                    password = scannerPasajero.nextLine();
                    System.out.println("Repita la contraseña:");
                    String passwordSeguridad = scannerPasajero.nextLine();
                        if(password.compareTo(passwordSeguridad)==0){ aceptada = true; }
                        else{ System.err.println("Las contraseñas no coinciden, ingresela de nuevo"); }
                }

            Pasajero nuevoPasajero = new Pasajero(nombre,apellido,password,dni,paisOrigen,domicilio);

        return nuevoPasajero;
        }

        public void menuPrincipalPasajero(Pasajero pasajero){
            boolean salir = false;
            do{
                try {
                    System.out.println("MENU PRINCIPAL PASAJERO\n" +
                    "Que accion desea realizar?\n\t1_Perfil\n\t2_Crear nueva reserva" +
                     "\n\t3_Ingresar a el menu de reserva\n\t4_Salir");

                    Scanner scInt = new Scanner(System.in);
                    int opcion = scInt.nextInt();

                    switch (opcion) {

                        case 1:
                            menuPerfilPasajero(pasajero);
                            break;

                        case 2:
                            menuNuevaReserva(pasajero);
                            break;

                        case 3:
                            menuReservaPasajero(pasajero);
                            break;

                        case 4:
                            salir = true;
                            break;

                        default:
                            System.err.println("Las opciones son 1-2-3-4");
                    }
                }catch (java.util.InputMismatchException e){
                    System.err.println("Ingreso una opcion no valida");
                }
            }while (!salir);
        }

        public void menuReservaPasajero(Pasajero pasajero){
            boolean salir = false;
            do{
                try {
                    System.out.println("MENU PRINCIPAL RESERVA PASAJERO: " + pasajero.getNombre() + pasajero.getApellido()+
                    "\nQue accion desea realizar?\n\t1_Menu Reserva Actual\n\t2_Ver Reservas Activas" +
                    "\n\t3_Ver historial de Reservas\n\t4_Salir");
                    Scanner scInt = new Scanner(System.in);
                    int opcion = scInt.nextInt();

                    switch (opcion) {
                        case 1:
                            menuReservaActualPasajero(pasajero);
                            break;

                        case 2:
                            ArrayList<Reserva> activas = this.hotel.retornarReservasActivas(pasajero);
                            for (Reserva reservaAux : activas) { System.out.println(reservaAux.toString()); }
                            break;

                        case 3:
                           ArrayList<Reserva> antiguos = this.hotel.retornarReservasAntigas(pasajero);
                            for (Reserva reservaAux : antiguos) { System.out.println(reservaAux.toString()); }
                            break;

                        case 4:
                            salir = true;
                            break;

                        default:
                            System.err.println("Las opciones son 1-2-3");
                    }
                }catch (java.util.InputMismatchException e){
                    System.err.println("Ingreso una opcion no valida");
                }
            }while (!salir);
        }

        public void menuReservaActualPasajero(Pasajero pasajero){
            Reserva actual = this.hotel.reservaActualPasajero(pasajero);
            boolean salir = false;
                if(actual != null) {
                    do {
                        try {
                            System.out.println("MENU RESERVA ACTUAL: " +
                            "\nQue accion desea realizar?\n\t1_Ver Reserva Actual\n\t2_Solicitar Consumible " +
                            "\n\t3_Solicitar Servicio\n\t4_Salir");
                            Scanner scInt = new Scanner(System.in);
                            int seleccion = scInt.nextInt();
                            switch (seleccion) {

                                case 1:
                                    System.out.println(actual.toString());
                                    break;

                                case 2:
                                    actual = menuConsumibles(actual);
                                    break;

                                case 3:
                                    actual = menuServicios(actual);
                                    break;

                                case 4:
                                    salir = true;
                                    break;

                                default:
                                    System.err.println("Las opciones son 1-2-3-4");
                            }
                        } catch (java.util.InputMismatchException e) {
                            System.err.println("Ingreso una opcion no valida");
                        }
                    } while (!salir);
                }else{
                    System.err.println("NO POSEE RESERVAS ACTUALMENTE TRANSITANDO,POR FAVOR,REALICE UNA INMEDIATAMENTE");
                }
        this.hotel.actualizarReserva(actual);
        }

        public void menuPerfilPasajero(Pasajero pasajero){
            boolean salir = false;
            do {
                try {
                    System.out.println("Perfil de " + pasajero.getNombre() + " " + pasajero.getApellido() +
                    "\nQue accion desea realizar?\n\t1_Ver perfil\n\t2_Editar perfil\n\t3_Volver");
                    Scanner scInt = new Scanner(System.in);
                    int opcion = scInt.nextInt();

                    switch (opcion) {

                        case 1:
                            System.out.println(pasajero.toString());
                            System.out.println("\nPress Any Key To Continue...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 2:
                            menuEditarPerfil(pasajero);
                            break;

                        case 3:
                            salir = true;
                            break;

                        default:
                            System.err.println("Las opciones son 1-2-3");
                    }
                }catch (java.util.InputMismatchException e) {
                    System.err.println("Ingreso una opcion no valida");
                }
            }while (!salir);
        }

        public void menuEditarPerfil(Pasajero pasajero){
            boolean salir = false;
                do {
                    try {
                        System.out.println("Perfil de " + pasajero.getNombre() + " " + pasajero.getApellido() +
                        "\nQue desea editar?\n\t1_Nombre\n\t2_Apellido\n\t3_DNI\n\t4_Contraseña\n\t5_Pais de origen\n\t6_Domicilio\n\t7_Volver");
                        Scanner scInt = new Scanner(System.in);
                        Scanner scString = new Scanner(System.in);
                        int opcion = scInt.nextInt();
                        String cambios;

                        switch (opcion) {
                            case 1:
                                System.out.println("Nombre actual: "+ pasajero.getNombre() +"\n\tIngrese su nuevo nombre: ");
                                    pasajero.setNombre(scString.nextLine());
                                System.out.println("Nombre cambiado con exito! Nuevo nombre : "+pasajero.getNombre());
                                System.out.println("\nPress Any Key To Continue...");
                                new java.util.Scanner(System.in).nextLine();
                                break;

                            case 2:
                                System.out.println("Apellido actual: "+ pasajero.getApellido() +"\n\tIngrese su nuevo apellido: ");
                                    pasajero.setApellido(scString.nextLine());
                                System.out.println("Apellido cambiado con exito! Nuevo apellido :" + pasajero.getApellido());
                                System.out.println("\nPress Any Key To Continue...");
                                new java.util.Scanner(System.in).nextLine();
                                break;

                            case 3:
                                System.out.println("Dni actual: "+ pasajero.getDni() +"\n\tIngrese su nuevo dni: ");
                                    cambios = scString.nextLine();
                                if (!this.hotel.existeDNI(cambios)){
                                    System.err.println("El dni ingresado ya pertenece a un usuario registrado en el sistema");
                                }else{
                                    pasajero.setDni(cambios);
                                }
                                System.out.println("DNI cambiado con exito! Nuevo dni: " + pasajero.getDni());
                                System.out.println("\nPress Any Key To Continue...");
                                new java.util.Scanner(System.in).nextLine();
                                break;

                            case 4:
                                boolean control = false;
                                while (!control){
                                    System.out.println("Contraseña actual: "+ pasajero.getPassword() +"\n\tIngrese su nueva contraseña: ");
                                        cambios = scString.nextLine();
                                    System.out.println("Ingrese nuevamente su contraseña: ");
                                        String contraseñaComprobar = scString.nextLine();
                                    if(!this.hotel.comprobarContrasenias(cambios,contraseñaComprobar)) {
                                        System.err.println("Las contraseñas no coinciden");
                                    }else{
                                        if(!this.hotel.comprobarContrasenias(pasajero.getPassword(), cambios)){
                                            System.err.println("La contraseña es igual a la anterior");
                                        }else {
                                            pasajero.setPassword(cambios);
                                            System.out.println("Contraseña modificada con exito! Nueva contraseña: "+ pasajero.getPassword());
                                            System.out.println("\nPress Any Key To Continue...");
                                            new java.util.Scanner(System.in).nextLine();
                                        }
                                        control = true;
                                    }
                                }
                                break;

                            case 5:
                                System.out.println("Pais actual: "+ pasajero.getNombre() +"\n\tIngrese su nuevo pais: ");
                                    pasajero.setOrigen(scString.nextLine());
                                System.out.println("Pais cambiado con exito! Nuevo Pais : "+pasajero.getOrigen());
                                System.out.println("\nPress Any Key To Continue...");
                                new java.util.Scanner(System.in).nextLine();
                                break;

                            case 6:
                                System.out.println("Domicilio actual: "+ pasajero.getNombre() +"\n\tIngrese su nuevo domicilio: ");
                                    pasajero.setDomicilio(scString.nextLine());
                                System.out.println("Domicilio cambiado con exito! Nuevo Domicilio : "+pasajero.getDomicilio());
                                System.out.println("\nPress Any Key To Continue...");
                                new java.util.Scanner(System.in).nextLine();
                                break;

                            case 7:
                                salir = true;
                                break;
                            default:
                                System.out.println("Las opciones son del 1 al 7");
                        }
                    }catch (java.util.InputMismatchException e) {
                        System.err.println("Ingreso una opcion no valida");
                    }
                }while (!salir);
        }


                    //////-----OPERACIONES CON GASTOS GENERALES-----//////

        ////-----OPERACIONES CON CONSUMIBLES----////
        public Reserva menuConsumibles(Reserva reserva){
            boolean salir = false;
            ArrayList<Consumible> consumibles;
                do{
                    try {
                        int i =0;
                        System.out.println("MENU CONSUMIBLES: "+
                        "\nQue categoria desea ver?\n\t1_BEBIDAS\n\t2_SNACKS" +
                        "\n\t3_PLATILLOS\n\t4_Salir");
                        Scanner scInt = new Scanner(System.in);
                        int seleccion = scInt.nextInt();

                        switch (seleccion) {

                            case 1:
                                consumibles = seleccionBebidas();
                                for(Consumible consumibleAux : consumibles){ reserva.agregarGastoAdicional(consumibleAux); }
                                break;

                            case 2:
                                consumibles = seleccionSnacks();
                                for(Consumible consumibleAux : consumibles){ reserva.agregarGastoAdicional(consumibleAux); }
                                break;

                            case 3:
                                consumibles = seleccionPlatillos();
                                for(Consumible comidaAux : consumibles){ reserva.agregarGastoAdicional(comidaAux); }
                                break;

                            case 4:
                                salir = true;
                                break;

                            default:
                                System.err.println("Las opciones son 1-2-3-4");
                        }
                    }catch (java.util.InputMismatchException e){
                        System.err.println("Ingreso una opcion no valida");
                    }
                }while (!salir);
        return reserva;
        }

        public ArrayList<Consumible> seleccionBebidas(){
            boolean salir = false;
            Scanner scInt = new Scanner(System.in);
            int i=1,seleccion,cantidad;
            for(Bebida bebida : Bebida.values()){ System.out.println(i + bebida.toString()); i++;}
            ArrayList<Consumible> bebidas = new ArrayList<>();
            Consumible consumible = null;
                do {
                    try {
                        System.out.println("Ingrese el numero de Bebida");
                            seleccion = scInt.nextInt();
                        System.out.println("Ingrese la cantidad");
                            cantidad = scInt.nextInt();
                        switch (seleccion) {
                            case 1:
                                consumible = new Consumible(LocalDateTime.now(), Bebida.COCA_COLA.name(), Bebida.COCA_COLA.getPrecio(), cantidad);
                                break;

                            case 2:
                                consumible = new Consumible(LocalDateTime.now(), Bebida.FANTA.name(), Bebida.FANTA.getPrecio(), cantidad);
                                break;

                            case 3:
                                consumible = new Consumible(LocalDateTime.now(), Bebida.SPRITE.name(), Bebida.SPRITE.getPrecio(), cantidad);
                                break;

                            case 4:
                                consumible = new Consumible(LocalDateTime.now(), Bebida.AGUA_MINERAL.name(), Bebida.AGUA_MINERAL.getPrecio(), cantidad);
                                break;

                            case 5:
                                consumible = new Consumible(LocalDateTime.now(), Bebida.ENERGIZANTE.name(), Bebida.ENERGIZANTE.getPrecio(), cantidad);
                                break;

                            case 6:
                                consumible = new Consumible(LocalDateTime.now(), Bebida.CERVEZA.name(), Bebida.CERVEZA.getPrecio(), cantidad);
                                break;

                            case 7:
                                consumible = new Consumible(LocalDateTime.now(), Bebida.CHAMPAGNE.name(), Bebida.CHAMPAGNE.getPrecio(), cantidad);
                                break;

                            case 8:
                                consumible = new Consumible(LocalDateTime.now(), Bebida.FERNET.name(), Bebida.FERNET.getPrecio(), cantidad);
                                break;

                            case 9:
                                consumible = new Consumible(LocalDateTime.now(), Bebida.VODKA.name(), Bebida.VODKA.getPrecio(), cantidad);
                                break;

                            case 10:
                                consumible = new Consumible(LocalDateTime.now(), Bebida.TEQUILA.name(), Bebida.TEQUILA.getPrecio(), cantidad);
                                break;

                            default:
                                System.err.println("Las opciones son 1 al 10");
                        }

                        bebidas.add(consumible);

                    } catch (java.util.InputMismatchException e) {
                        System.err.println("Ingreso una opcion no valida");
                    }

                    System.out.println("¿Desea agregar alguna mas? Seleccione 0 para salir. Cualquier numero para seguir");
                        if(scInt.nextInt()==0){salir=true;}
                }while(!salir);
        return bebidas;
        }

        public ArrayList<Consumible> seleccionSnacks(){
            boolean salir = false;
            Scanner scInt = new Scanner(System.in);
            int i=1,seleccion,cantidad;
            for(Snack snack : Snack.values()){ System.out.println(i + snack.toString()); i++;}
            ArrayList<Consumible> snacks = new ArrayList<>();
            Consumible consumible = null;
            do {
                try {
                    System.out.println("Ingrese el numero de Snack");
                        seleccion = scInt.nextInt();
                    System.out.println("Ingrese la cantidad");
                        cantidad = scInt.nextInt();
                    switch (seleccion) {

                        case 1:
                            consumible = new Consumible(LocalDateTime.now(), Snack.OREOS.name(), Snack.OREOS.getPrecio(), cantidad);
                            break;

                        case 2:
                            consumible = new Consumible(LocalDateTime.now(), Snack.OPERA.name(), Snack.OPERA.getPrecio(), cantidad);
                            break;

                        case 3:
                            consumible = new Consumible(LocalDateTime.now(), Snack.PEPITOS.name(), Snack.PEPITOS.getPrecio(), cantidad);
                            break;

                        case 4:
                            consumible = new Consumible(LocalDateTime.now(), Snack.RUMBA.name(), Snack.RUMBA.getPrecio(), cantidad);
                            break;

                        case 5:
                            consumible = new Consumible(LocalDateTime.now(), Snack.REX.name(), Snack.REX.getPrecio(), cantidad);
                            break;

                        case 6:
                            consumible = new Consumible(LocalDateTime.now(), Snack.SALADIX.name(), Snack.SALADIX.getPrecio(), cantidad);
                            break;

                        case 7:
                            consumible = new Consumible(LocalDateTime.now(), Snack.EXPRESS.name(), Snack.EXPRESS.getPrecio(), cantidad);
                            break;

                        case 8:
                            consumible = new Consumible(LocalDateTime.now(), Snack.CRIOLLITAS.name(), Snack.CRIOLLITAS.getPrecio(), cantidad);
                            break;

                        case 9:
                            consumible = new Consumible(LocalDateTime.now(), Snack.ALFAJOR.name(), Snack.ALFAJOR.getPrecio(), cantidad);
                            break;

                        case 10:
                            consumible = new Consumible(LocalDateTime.now(), Snack.BOMBON.name(), Snack.BOMBON.getPrecio(), cantidad);
                            break;

                        case 11:
                            consumible = new Consumible(LocalDateTime.now(), Snack.CHICLES.name(), Snack.CHICLES.getPrecio(), cantidad);
                            break;

                        default:
                            System.err.println("Las opciones son 1-2-3-4-5-6-7-8-9-10-11");
                    }

                    snacks.add(consumible);

                } catch (java.util.InputMismatchException e) {
                    System.err.println("Ingreso una opcion no valida");
                }

                System.out.println("¿Desea agregar alguna mas? Seleccione 0 para salir. Cualquier numero para seguir");
                if(scInt.nextInt()==0){salir=true;}
            }while(!salir);
        return snacks;
        }

        public ArrayList<Consumible> seleccionPlatillos(){
            boolean salir = false;
            Scanner scInt = new Scanner(System.in);
            int i=1,seleccion,cantidad;
            for(Platillo platillo : Platillo.values()){ System.out.println(i + platillo.toString()); i++;}
            ArrayList<Consumible> platillos = new ArrayList<>();
            Consumible comida = null;
            do {
                try {
                    System.out.println("Ingrese el numero de Platillo");
                        seleccion = scInt.nextInt();
                    System.out.println("Ingrese la cantidad");
                        cantidad = scInt.nextInt();
                    switch (seleccion) {

                        case 1:
                             comida = new Consumible(LocalDateTime.now(), Platillo.PARRILLADA.name(), Platillo.PARRILLADA.getPrecio(), cantidad);
                            break;

                        case 2:
                            comida = new Consumible(LocalDateTime.now(), Platillo.LOCRO.name(), Platillo.LOCRO.getPrecio(), cantidad);
                            break;

                        case 3:
                            comida = new Consumible(LocalDateTime.now(), Platillo.EMPANADA.name(), Platillo.EMPANADA.getPrecio(), cantidad);
                            break;

                        case 4:
                            comida = new Consumible(LocalDateTime.now(), Platillo.ARROLLADO_DE_MATAMBRE.name(), Platillo.ARROLLADO_DE_MATAMBRE.getPrecio(), cantidad);
                            break;

                        case 5:
                            comida = new Consumible(LocalDateTime.now(), Platillo.HUMITA.name(), Platillo.HUMITA.getPrecio(), cantidad);
                            break;

                        case 6:
                            comida = new Consumible(LocalDateTime.now(), Platillo.TAMALES.name(), Platillo.TAMALES.getPrecio(), cantidad);
                            break;

                        case 7:
                            comida = new Consumible(LocalDateTime.now(), Platillo.ESPAGUETI.name(), Platillo.ESPAGUETI.getPrecio(), cantidad);
                            break;

                        case 8:
                            comida = new Consumible(LocalDateTime.now(), Platillo.PIZZA.name(), Platillo.PIZZA.getPrecio(), cantidad);
                            break;

                        case 9:
                            comida = new Consumible(LocalDateTime.now(), Platillo.LASAGNA.name(), Platillo.LASAGNA.getPrecio(), cantidad);
                            break;

                        case 10:
                            comida = new Consumible(LocalDateTime.now(), Platillo.TACO.name(), Platillo.TACO.getPrecio(), cantidad);
                            break;

                        case 11:
                            comida = new Consumible(LocalDateTime.now(), Platillo.POZOLE.name(), Platillo.POZOLE.getPrecio(), cantidad);
                            break;

                        case 12:
                            comida = new Consumible(LocalDateTime.now(), Platillo.ENCHILADAS.name(), Platillo.ENCHILADAS.getPrecio(), cantidad);
                            break;

                        case 13:
                            comida = new Consumible(LocalDateTime.now(), Platillo.MOLE.name(),Platillo.MOLE.getPrecio(), cantidad);
                            break;

                        default:
                            System.err.println("Las opciones son 1-2-3-4-5-6-7-8-9-10-11-12-13");
                    }

                    platillos.add(comida);

                } catch (java.util.InputMismatchException e) {
                    System.err.println("Ingreso una opcion no valida");
                }
                System.out.println("Desea agregar alguna mas? --Seleccione 0 para salir,Cualquier numero para seguir");
                if(scInt.nextInt()==0){salir=true;}
            }while(!salir);
        return platillos;
        }


        ////-----OPERACIONES CON SERVICIOS-----////
        public Reserva menuServicios(Reserva reserva){
            boolean salir = false;
            Scanner scInt = new Scanner(System.in);
            int i=1,seleccion,cantidad;
            for(TiposServicios tiposServicios : TiposServicios.values()){ System.out.println(i + tiposServicios.toString()); i++;}
            Servicio servicio = null;
                do {
                    try {
                        System.out.println("Ingrese el numero de Servicio");
                        seleccion = scInt.nextInt();
                        System.out.println("Ingrese la cantidad de horas");
                        cantidad = scInt.nextInt();
                        switch (seleccion) {
                            case 1:
                                servicio = new Servicio(LocalDateTime.now(), TiposServicios.GIMNASIO.name(), TiposServicios.GIMNASIO.getPrecio(), cantidad);
                                break;
                            case 2:
                                servicio = new Servicio(LocalDateTime.now(), TiposServicios.PILETA.name(), TiposServicios.PILETA.getPrecio(), cantidad);
                                break;
                            case 3:
                                servicio = new Servicio(LocalDateTime.now(), TiposServicios.JACUZZI.name(), TiposServicios.JACUZZI.getPrecio(), cantidad);
                                break;
                            case 4:
                                servicio = new Servicio(LocalDateTime.now(), TiposServicios.SPA.name(), TiposServicios.SPA.getPrecio(), cantidad);
                                break;
                            case 5:
                                servicio = new Servicio(LocalDateTime.now(), TiposServicios.SAUNA.name(), TiposServicios.SAUNA.getPrecio(), cantidad);
                                break;
                            case 6:
                                servicio = new Servicio(LocalDateTime.now(), TiposServicios.MASAGE.name(), TiposServicios.MASAGE.getPrecio(), cantidad);
                                break;
                            case 7:
                                servicio = new Servicio(LocalDateTime.now(), TiposServicios.LAVANDERIA.name(), TiposServicios.LAVANDERIA.getPrecio(), cantidad);
                                break;
                            case 8:
                                servicio = new Servicio(LocalDateTime.now(), TiposServicios.PARQUE_ACUATICO.name(), TiposServicios.PARQUE_ACUATICO.getPrecio(), cantidad);
                                break;

                            default:
                                System.err.println("Las opciones son 1 a 8");
                        }

                        reserva.agregarGastoAdicional(servicio);

                    } catch (java.util.InputMismatchException e) {
                        System.err.println("Ingreso una opcion no valida");
                    }
                    System.out.println("Desea agregar alguna mas? --Seleccione 0 para salir,Cualquier numero para seguir");
                        if(scInt.nextInt()==0){salir=true;}
                }while(!salir);
        return reserva;
        }


                ////-----METODOS GENERALES-----////
        public Persona menuLoggin(){
            Persona persona = null;
            int control = 0;
                do{
                    try {
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Ingrese su dni: ");
                            String dni = scanner.nextLine();
                        System.out.println("Ingrese su contraseña:");
                            String password = scanner.nextLine();
                        persona = this.hotel.retornarPersonaXDNI(dni);
                        if(persona != null) {
                            if (persona.getPassword().compareTo(password) == 0) {
                                return persona;
                            }
                            System.err.println("La contraseña es incorrecta");
                            control++;
                        } else {
                            System.err.println("El dni no corresponde a ninguna Persona registrado en el sistema");
                            control++;
                        }
                    }catch (java.util.InputMismatchException e) {
                        System.err.println("Ingreso una opcion no valida");
                    }
                }while (control != 3);
        return persona;
        }

        public void menuNuevaReserva(Pasajero pasajero){
            Scanner sc = new Scanner(System.in);
            int anio,mes,dia;
                System.out.println("Ingresar el AÑO en que desea realizar su reserva.");
                    anio = sc.nextInt();
                System.out.println("Ingresar el numero de MES en que desea realizar su reserva.");
                    mes = sc.nextInt();
                System.out.println("Ingresar el DIA en que desea realizar su reserva.");
                    dia = sc.nextInt();
                LocalDate inicio = LocalDate.of(anio,mes,dia);
                System.out.println("Ingresar el AÑO hasta el que se desea hospedar");
                    anio = sc.nextInt();
                System.out.println("Ingresar el numero de MES hasta el que se desea hospedar");
                    mes = sc.nextInt();
                System.out.println("Ingresar el DIA hasta el que se desea hospedar");
                    dia = sc.nextInt();
            LocalDate finalizacion = LocalDate.of(anio,mes,dia);

            ArrayList<Habitacion> habitacionesDisponibles = this.hotel.listHabitacionesDisponibles(inicio,finalizacion);
                System.out.println("Ingrese la capacidad de la habitacion que desea alquilar (2 o 4 Personas)");
            int capacidad = sc.nextInt();

            for(Habitacion habitacion : habitacionesDisponibles) {
                if(habitacion.getCapacidad() == capacidad) {
                    System.out.println(habitacion.toString());
                }
            }

            System.out.println("Que numero de habitacion desea alquilar?");
            int numeroDeHabitacion = sc.nextInt();

            Habitacion habitacion1 = this.hotel.retornarHabitacionXNumero(numeroDeHabitacion);

            Reserva nuevaReserva = new Reserva(pasajero,habitacion1,0f,inicio,finalizacion);

            this.hotel.getReservas().add(nuevaReserva);
        }


                        //////-----EMPLEADOS-----//////

        ////-----RECEPCIONISTA-----////
        public void menuPrimerolEmpleado(){
                boolean salir = false;
                Persona persona;
                do{
                    try {
                        System.out.println("MENU EMPLEADO PRIMERO\nComo desea ingresar?" +
                        "\n\t1_como ADMINISTRADOR\n\t2_como RECEPCIONISTA\n\t3_Volver");
                        Scanner scInt = new Scanner(System.in);
                        int opcion = scInt.nextInt();

                        switch (opcion) {

                            case 1:
                                persona = menuLoggin();
                                if (persona != null) {
                                    if(persona instanceof Administrador){
                                        Administrador administrador = (Administrador) persona;
                                        MenuPrincipalAdministrador(administrador);
                                    }else{
                                        System.err.println("El usuario ingresado no esta registrado como administrador");
                                    }
                                } else {
                                    System.err.println("Error de loggin, intenlo nuevamente");
                                }
                                break;

                            case 2:
                                persona = menuLoggin();
                                if (persona != null) {
                                    if(persona instanceof Recepcion){
                                        Recepcion recepcion = (Recepcion) persona;
                                        MenuPrincipalRecepcionista(recepcion);
                                    }else{
                                        System.err.println("El usuario ingresado no esta registrado como recepcionista");
                                    }
                                } else {
                                    System.err.println("Error de loggin, intenlo nuevamente");
                                }
                                break;

                            case 3:
                                salir = true;
                                break;

                            default:
                                System.err.println("Las opciones son 1-2-3");
                        }
                    }catch (InputMismatchException e){
                        System.err.println("Ingreso una opcion no valida");
                    }
                }while (!salir);
        }

        public Recepcion menuRecepcionistaRegistro(){
            System.out.println("MENU REGISTRO RECEPCIONISTA");
            Recepcion recepcion = null;
            boolean aceptado = false;
            while (!aceptado) {
                recepcion = nuevoRecepcionista();
                aceptado = this.hotel.validacionRecepcionista(recepcion);
                if(aceptado){
                    System.err.println("El recepcionista ya se encuentra registrado");
                }else {
                    aceptado = true;
                }
            }
            return recepcion;
        }

        public Recepcion nuevoRecepcionista(){
                Scanner scannerPasajero = new Scanner(System.in);
                System.out.println("Ingrese su nombre: ");
                    String nombre = scannerPasajero.nextLine();
                System.out.println("Ingrese su apellido: ");
                    String apellido = scannerPasajero.nextLine();
                System.out.println("Ingrese su dni: ");
                    String dni = scannerPasajero.nextLine();
                    String password = null;

                boolean aceptada = false;
                while (!aceptada) {
                    System.out.println("Ingrese una nueva contraseña: ");
                        password = scannerPasajero.nextLine();
                    System.out.println("Repita la contraseña:");
                        String passwordSeguridad = scannerPasajero.nextLine();
                    if(password.compareTo(passwordSeguridad)==0){
                        aceptada = true;
                    }else{
                        System.err.println("Las contraseñas no coinciden, ingresela de nuevo");
                    }
                }

            Recepcion nuevoRecepcionista = new Recepcion(nombre,apellido,password,dni);

        return nuevoRecepcionista;
        }

        public void MenuPrincipalRecepcionista(Recepcion recepcion){
            boolean salir = false;
            do{
                try {
                    System.out.println("MENU PRINCIPAL RECEPCIONISTA\n" +
                    "Que accion desea realizar?\n\t1_Nueva reserva\n\t2_Crear Pasajero\n\t3_Ver lista de Usuarios" +
                    "\n\t4_Ver perfil\n\t4_Ver Reservas Vigentes\n\t5_Volver");
                    Scanner scInt = new Scanner(System.in);
                    int opcion = scInt.nextInt();

                    switch (opcion) {
                        case 1:
                            menuPrimeroPasajero();
                            break;

                        case 2:
                            Pasajero nuevoPasajero = menuPasajeroRegistro();
                            this.hotel.getPersonas().add(nuevoPasajero);
                            break;

                        case 3:
                            this.hotel.mostrarPasajeros();
                            break;

                        case 4:
                            System.out.println(recepcion.toString());
                            break;

                        case 5:
                            this.hotel.mostrarReservasVigentes();
                            break;

                        case 6:
                            salir = true;
                            break;

                        default:
                            System.err.println("Las opciones son 1-2-3-4-5-6");
                    }
                }catch (java.util.InputMismatchException e){
                    System.err.println("Ingreso una opcion no valida");
                }
            }while (!salir);
        }


        ////-----ADMINISTRADOR-----////
        public Administrador menuAdministradorRegistro(){
            System.out.println("MENU REGISTRO ADMINISTRADOR");
            Administrador administrador = null;
            boolean aceptado = false;
            while (!aceptado) {
                administrador = nuevoAdministrador();
                aceptado = this.hotel.validacionAdministrador(administrador);
                if(aceptado){
                    System.err.println("El administrador ya se encuentra registrado");
                }else {
                    aceptado = true;
                }
            }
        return administrador;
        }

        public Administrador nuevoAdministrador(){
            Scanner scannerPasajero = new Scanner(System.in);
            System.out.println("Ingrese su nombre: ");
                String nombre = scannerPasajero.nextLine();
            System.out.println("Ingrese su apellido: ");
                String apellido = scannerPasajero.nextLine();
            System.out.println("Ingrese su dni: ");
                String dni = scannerPasajero.nextLine();
                String password = null;

            boolean aceptada = false;
            while (!aceptada) {
                System.out.println("Ingrese una nueva contraseña: ");
                    password = scannerPasajero.nextLine();
                System.out.println("Repita la contraseña:");
                    String passwordSeguridad = scannerPasajero.nextLine();
                if(password.compareTo(passwordSeguridad)==0){
                    aceptada = true;
                }else{
                    System.err.println("Las contraseñas no coinciden, ingresela de nuevo");
                }
            }

            Administrador nuevoAdministrador = new Administrador(nombre,apellido,password,dni);

            return nuevoAdministrador;
        }

        public void MenuPrincipalAdministrador(Administrador administrador){
            boolean salir = false;
            do{
                try {
                    System.out.println("MENU PRINCIPAL ADMINISTRADOR\n" +
                    "Que accion desea realizar?\n\t1_Nueva reserva\n\t2_Crear Pasajero\n\t3_Crear Recepcionista\n\t4_Crear Administrador" +
                    "\n\t5_Ver lista de Pasajeros\n\t6_Ver lista recepcionista\n\t7_Ver lista Administradores\n\t8_Ver perfil" +
                    "\n\t9_Ver Reservas Vigentes\n\t10_Volver");
                    Scanner scInt = new Scanner(System.in);
                    int opcion = scInt.nextInt();

                    switch (opcion) {
                        case 1:
                            menuPrimeroPasajero();
                            break;

                        case 2:
                            Pasajero nuevoPasajero = menuPasajeroRegistro();
                            this.hotel.getPersonas().add(nuevoPasajero);
                            break;

                        case 3:
                            Recepcion nuevoRecepcionista = menuRecepcionistaRegistro();
                            this.hotel.getPersonas().add(nuevoRecepcionista);
                            break;

                        case 4:
                            Administrador nuevoAdministrador =menuAdministradorRegistro();
                            this.hotel.getPersonas().add(nuevoAdministrador);
                            break;

                        case 5:
                            this.hotel.mostrarPasajeros();
                            break;

                        case 6:
                            this.hotel.mostrarRecepcionistas();
                            break;

                        case 7:
                            this.hotel.mostrarAdminstradores();
                            break;

                        case 8:
                            System.out.println(administrador.toString());
                            break;

                        case 9:
                            this.hotel.mostrarReservasVigentes();
                            break;

                        case 10:
                            salir = true;
                            break;

                        default:
                            System.err.println("Las opciones son del 1 al 10");
                    }
                }catch (java.util.InputMismatchException e){
                    System.err.println("Ingreso una opcion no valida");
                }
            }while (!salir);
        }

}



