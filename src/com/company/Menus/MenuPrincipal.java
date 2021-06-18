package com.company.Menus;

import com.company.Hotel.*;
import com.company.Hotel.Consumibles.*;
import com.company.Hotel.Servicios.*;

import com.company.Persona.*;

import com.company.Sistema.Backup;
import com.company.Sistema.Herramientas;
import com.company.Sistema.ManejoArchivo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MenuPrincipal {
    Hotel hotel = new Hotel();
    Backup backup = ManejoArchivo.leerBackup();

    public MenuPrincipal() throws IOException {
    }

    public void menuPrincipal() throws IOException {
        /*
    public void menuPrincipal() {
        //menuBorrarUnaReserva((Pasajero) this.hotel.retornarPersonaXDNI("11223344"));

        ////-----CARGA RESERVAS-----////
        //Pasajero pasajeroBol1 = new Pasajero("Agustin", "Sampaoli", "1", "42455244", "Argentina", "Colon 1542");

        /*Habitacion habitacion1 = new Habitacion(Habitacion.TipoHabitacion.Suite, 1 , 2, 4000);
        LocalDate inicio = LocalDate.of(2021,06,17);
        LocalDate fin = LocalDate.of(2021,06,29);
        Reserva reserva1 = new Reserva(pasajeroBol1,habitacion1,inicio,fin);
            this.hotel.getReservas().add(reserva1);
            try {
                ManejoArchivo.guardarReservas(this.hotel.getReservas());
            } catch (IOException e) {
                e.printStackTrace();
            }

            for(int i =0; i<20; i++){
                this.hotel.getReservas().add(this.hotel.ReservaAleatoria());
            }

            for(Reserva reserva : this.hotel.getReservas()){
                System.out.println(reserva);
            }
            ManejoArchivo.guardarReservas(this.hotel.getReservas());*/

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
            } catch (java.util.InputMismatchException e) {
                System.err.println("Ingreso una opcion no valida");
            }
        } while (!salir);
        System.out.println("GRACIAS POR USAR EL SISTEMA!");
    }


        ////-----MENUS PASAJERO-----////
        public void menuPrimeroPasajero() {
            boolean salir = false;
            do {
                try {
                    System.out.println("MENU PASAJERO PRIMERO" +
                            "\nQue accion desea realizar?\n\t1_Ingresar\n\t2_Registrarse\n\t3_Volver");
                    Scanner scInt = new Scanner(System.in);
                    int opcion = scInt.nextInt();
                    Pasajero pasajero = null;
                    switch (opcion) {

                        case 1:
                            pasajero = (Pasajero) menuLoggin();
                            if (pasajero != null) {
                                menuPrincipalPasajero(pasajero);
                            } else {
                                System.err.println("Error de loggin, intenlo nuevamente");
                            }
                            salir = true;
                            break;


                        case 2:
                            pasajero = menuPasajeroRegistro();
                            this.hotel.getPersonas().add(pasajero);
                            ManejoArchivo.guardarPersonasBackup(this.hotel.getPersonas());
                            menuPrincipalPasajero(pasajero);
                            salir = true;
                            break;

                        case 3:
                            salir = true;
                            break;

                        default:
                            System.err.println("Las opciones son 1-2-3");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.err.println("Ingreso una opcion no valida");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (!salir);
        }   ///chequeado

        public Pasajero menuPasajeroRegistro() {
            System.out.println("MENU REGISTRO PASAJERO");
            Pasajero pasajero = null;
            boolean aceptado = false;
            while (!aceptado) {
                pasajero = nuevoPasajero();
                aceptado = this.hotel.validacionPasajero(pasajero);
                if (aceptado) {
                    System.err.println("El usuario ya se encuentra registrado");
                } else {
                    aceptado = true;
                }
            }
            return pasajero;
        }   ///chequeado

        public Pasajero nuevoPasajero() {
            Scanner scannerPasajero = new Scanner(System.in);
            System.out.println("Nombre: ");
            String nombre = scannerPasajero.nextLine();
            System.out.println("Apellido: ");
            String apellido = scannerPasajero.nextLine();
            String dni;
            do {
                boolean control = false;
                do {
                    System.out.println("DNI: ");
                    dni = scannerPasajero.nextLine();
                    control = true;
                    if (Herramientas.controlDNIEsUnINT(dni) == false || dni.length() != 8) {
                        System.err.println("Ingreso un valor no valido");
                        control = false;
                    }
                } while (control == false);


            } while (Herramientas.controlDNIEsUnINT(dni) == false);
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
                if (password.compareTo(passwordSeguridad) == 0) {
                    aceptada = true;
                } else {
                    System.err.println("Las contraseñas no coinciden, ingresela de nuevo");
                }
            }

            Pasajero nuevoPasajero = new Pasajero(nombre, apellido, password, dni, paisOrigen, domicilio);

            return nuevoPasajero;
        }   ///chequeado

        public void menuPrincipalPasajero(Pasajero pasajero) {
            boolean salir = false;
            do {
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
                } catch (java.util.InputMismatchException e) {
                    System.err.println("Ingreso una opcion no valida");
                }
            } while (!salir);
        }   ///chequeado

        public void menuReservaPasajero(Pasajero pasajero) {
            boolean salir = false;
            do {
                try {
                    System.out.println("MENU PRINCIPAL RESERVA PASAJERO: " + pasajero.getNombre() + " " + pasajero.getApellido() +
                            "\nQue accion desea realizar?\n\t1_Menu Reserva Actual\n\t2_Ver Reservas Activas" +
                            "\n\t3_Ver historial de Reservas\n\t4_Borrar una reserva\n\t5_Salir");
                    Scanner scInt = new Scanner(System.in);
                    int opcion = scInt.nextInt();

                    switch (opcion) {
                        case 1:
                            menuReservaActualPasajero(pasajero);
                            break;

                        case 2:
                            ArrayList<Reserva> activas = this.hotel.retornarReservasActivas(pasajero);
                            if (activas.size() > 0) {
                                for (Reserva reservaAux : activas) {
                                    System.out.println(reservaAux.toString());
                                }
                            } else {
                                System.err.println("NO POSEE RESERVAS ACTIVAS");
                            }
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 3:
                            ArrayList<Reserva> antiguos = this.hotel.retornarReservasAntiguas(pasajero);
                            if (antiguos.size() > 0) {
                                for (Reserva reservaAux : antiguos) {
                                    System.out.println(reservaAux.toString());
                                }
                            } else {
                                System.err.println("NO POSEE RESERVAS ANTIGUAS");
                            }
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 4:
                            menuBorrarUnaReserva(pasajero);
                            ManejoArchivo.guardarReservas(this.hotel.getReservas());
                            break;
                        case 5:
                            salir = true;
                            break;

                        default:
                            System.err.println("Las opciones son 1-2-3");
                    }
                } catch (InputMismatchException | IOException e) {
                    System.err.println("Ingreso una opcion no valida");
                }
            } while (!salir);
        }   ///chequeado

        public void menuReservaActualPasajero(Pasajero pasajero) {
            Reserva actual = this.hotel.reservaActualPasajero(pasajero);
            boolean salir = false;
            if (actual != null) {
                do {
                    try {
                        System.out.println("MENU RESERVA ACTUAL: " + "\nQue accion desea realizar?\n\t1_Ver Reserva Actual\n\t2_Solicitar Consumible " +
                                "\n\t3_Solicitar Servicio\n\t4_Salir");
                        Scanner scInt = new Scanner(System.in);
                        int seleccion = scInt.nextInt();
                        switch (seleccion) {
                            case 1:
                                System.out.println(actual.toString());
                                actual.verGastosAdicionales();
                                System.out.println("\nPresiona cualquier tecla para continuar...");
                                new java.util.Scanner(System.in).nextLine();
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
                                System.err.println("Las opciones son del 1 al 4");
                        }
                    } catch (java.util.InputMismatchException e) {
                        System.err.println("Ingreso una opcion no valida");
                    }
                } while (!salir);
                /*this.hotel.actualizarReserva(actual);
                try {
                    ManejoArchivo.guardarReservas(this.hotel.getReservas());
                } catch (IOException e) {
                    e.printStackTrace();*/
                }
            else {
                System.err.println("Usted no posee una reserva actualmente!");
            }
        }

        public void menuPerfilPasajero(Pasajero pasajero) {
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
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 2:
                            menuEditarPerfil(pasajero);
                            ManejoArchivo.guardarPersonas(this.hotel.getPersonas());
                            ManejoArchivo.guardarReservas(this.hotel.getReservas());
                            break;

                        case 3:
                            salir = true;
                            break;

                        default:
                            System.err.println("Las opciones son 1-2-3");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.err.println("Ingreso una opcion no valida");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (!salir);
        }

        public void menuEditarPerfil(Pasajero pasajero) {
            boolean salir = false;
            do {
                try {
                    System.out.println("Perfil de " + pasajero.getNombre() + " " + pasajero.getApellido() +
                            "\nQue desea editar?\n\t1_Nombre\n\t2_Apellido\n\t3_DNI\n\t4_Contraseña\n\t5_Pais de origen\n\t6_Domicilio\n\t7_Volver");
                    Scanner scInt = new Scanner(System.in);
                    Scanner scString = new Scanner(System.in);
                    int opcion = scInt.nextInt();
                    Persona pasajeroAntes = pasajero;
                    String cambios;
                    boolean control = false;

                    switch (opcion) {
                        case 1:
                            System.out.println("Nombre actual: " + pasajero.getNombre() + "\n\tIngrese su nuevo nombre: ");
                            pasajero.setNombre(scString.nextLine());
                            System.out.println("Nombre cambiado con exito! Nuevo nombre : " + pasajero.getNombre());
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 2:
                            System.out.println("Apellido actual: " + pasajero.getApellido() + "\n\tIngrese su nuevo apellido: ");
                            pasajero.setApellido(scString.nextLine());
                            System.out.println("Apellido cambiado con exito! Nuevo apellido :" + pasajero.getApellido());
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 3:
                            do {
                                System.out.println("Dni actual: " + pasajero.getDni() + "\n\tIngrese su nuevo dni: ");
                                cambios = scString.nextLine();
                                control = true;
                                if (Herramientas.controlDNIEsUnINT(cambios) == false || cambios.length() != 8) {
                                    control = false;
                                    System.err.println("Ingreso un valor no valido");
                                }
                                if (this.hotel.existeDNI(cambios)) {
                                    System.err.println("El dni ingresado ya pertenece a un usuario registrado en el sistema");
                                    control = false;
                                } else {
                                    pasajero.setDni(cambios);
                                }
                            } while (control == false);
                            System.out.println("DNI cambiado con exito! Nuevo dni: " + pasajero.getDni());
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 4:
                            while (!control) {
                                System.out.println("Contraseña actual: " + pasajero.getPassword() + "\n\tIngrese su nueva contraseña: ");
                                cambios = scString.nextLine();
                                System.out.println("Ingrese nuevamente su contraseña: ");
                                String contraseñaComprobar = scString.nextLine();
                                if (!this.hotel.comprobarContrasenias(cambios, contraseñaComprobar)) {
                                    System.err.println("Las contraseñas no coinciden");
                                } else {
                                    if (!this.hotel.comprobarContrasenias(pasajero.getPassword(), cambios)) {
                                        System.err.println("La contraseña es igual a la anterior");
                                    } else {
                                        pasajero.setPassword(cambios);
                                        System.out.println("Contraseña modificada con exito! Nueva contraseña: " + pasajero.getPassword());
                                        System.out.println("\nPresiona cualquier tecla para continuar...");
                                        new java.util.Scanner(System.in).nextLine();
                                    }
                                    control = true;
                                }
                            }
                            break;

                        case 5:
                            System.out.println("Pais actual: " + pasajero.getOrigen() + "\n\tIngrese su nuevo pais: ");
                            pasajero.setOrigen(scString.nextLine());
                            System.out.println("Pais cambiado con exito! Nuevo Pais : " + pasajero.getOrigen());
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 6:
                            System.out.println("Domicilio actual: " + pasajero.getDomicilio() + "\n\tIngrese su nuevo domicilio: ");
                            pasajero.setDomicilio(scString.nextLine());
                            System.out.println("Domicilio cambiado con exito! Nuevo Domicilio : " + pasajero.getDomicilio());
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();

                            break;

                        case 7:
                            salir = true;
                            break;
                        default:
                            System.out.println("Las opciones son del 1 al 7");
                    }
                    this.hotel.actualizarPasajeroaEnReserva((Pasajero) pasajeroAntes, pasajero);
                    this.hotel.actualizarPersonaEnHotel(pasajeroAntes, pasajero);

                } catch (java.util.InputMismatchException e) {
                    System.err.println("Ingreso una opcion no valida");
                }
            } while (!salir);

        }


        //////-----OPERACIONES CON GASTOS GENERALES-----//////

        ////-----OPERACIONES CON CONSUMIBLES----////
        public Reserva menuConsumibles(Reserva reserva) {
            boolean salir = false;
            ArrayList<Consumible> consumibles = new ArrayList<>();
            do {
                try {
                    System.out.println("MENU CONSUMIBLES: " +
                            "\nQue categoria desea ver?\n\t1_BEBIDAS\n\t2_SNACKS" +
                            "\n\t3_PLATILLOS\n\t4_Salir");
                    Scanner scInt = new Scanner(System.in);
                    int seleccion = scInt.nextInt();

                    switch (seleccion) {

                        case 1:
                            consumibles = seleccionBebidas();
                            for (Consumible consumibleAux : consumibles) {
                                reserva.agregarGastoAdicional(consumibleAux);
                            }
                            break;

                        case 2:
                            consumibles = seleccionSnacks();
                            for (Consumible consumibleAux : consumibles) {
                                reserva.agregarGastoAdicional(consumibleAux);
                            }
                            break;

                        case 3:
                            consumibles = seleccionPlatillos();
                            for (Consumible comidaAux : consumibles) {
                                reserva.agregarGastoAdicional(comidaAux);
                            }
                            break;

                        case 4:
                            salir = true;
                            break;

                        default:
                            System.err.println("Las opciones son 1 al 4");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.err.println("Ingreso una opcion no valida");
                }
            } while (!salir);
            return reserva;
        }

        public ArrayList<Consumible> seleccionBebidas() {
            boolean salir = false;
            Scanner scInt = new Scanner(System.in);
            int i = 1, seleccion, cantidad;
            for (Bebida bebida : Bebida.values()) {
                System.out.println(i + bebida.toString());
                i++;
            }
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
                if (scInt.nextInt() == 0) {
                    salir = true;
                }
            } while (!salir);
            return bebidas;
        }

        public ArrayList<Consumible> seleccionSnacks() {
            boolean salir = false;
            Scanner scInt = new Scanner(System.in);
            int i = 1, seleccion, cantidad;
            for (Snack snack : Snack.values()) {
                System.out.println(i + snack.toString());
                i++;
            }
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
                            System.err.println("Las opciones son al 1 al 11");
                    }

                    snacks.add(consumible);

                } catch (java.util.InputMismatchException e) {
                    System.err.println("Ingreso una opcion no valida");
                }

                System.out.println("¿Desea agregar alguna mas? Seleccione 0 para salir. Cualquier numero para seguir");
                if (scInt.nextInt() == 0) {
                    salir = true;
                }
            } while (!salir);
            return snacks;
        }

        public ArrayList<Consumible> seleccionPlatillos() {
            boolean salir = false;
            Scanner scInt = new Scanner(System.in);
            int i = 1, seleccion, cantidad;
            for (Platillo platillo : Platillo.values()) {
                System.out.println(i + platillo.toString());
                i++;
            }
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
                            comida = new Consumible(LocalDateTime.now(), Platillo.MOLE.name(), Platillo.MOLE.getPrecio(), cantidad);
                            break;

                        default:
                            System.err.println("Las opciones son del 1 al 13");
                    }

                    platillos.add(comida);

                } catch (java.util.InputMismatchException e) {
                    System.err.println("Ingreso una opcion no valida");
                }
                System.out.println("Desea agregar alguna mas? --Seleccione 0 para salir,Cualquier numero para seguir");
                if (scInt.nextInt() == 0) {
                    salir = true;
                }
            } while (!salir);
            return platillos;
        }


        ////-----OPERACIONES CON SERVICIOS-----////
        public Reserva menuServicios(Reserva reserva) {
            boolean salir = false;
            Scanner scInt = new Scanner(System.in);
            int i = 1, seleccion, cantidad;
            for (TiposServicios tiposServicios : TiposServicios.values()) {
                System.out.println(i + tiposServicios.toString());
                i++;
            }
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
                if (scInt.nextInt() == 0) {
                    salir = true;
                }
            } while (!salir);
            return reserva;
        }

        ////-----METODOS GENERALES-----////
        public Persona menuLoggin() {
            Persona persona = null;
            int control = 0;
            boolean revision = false;
            String dni;
            do {
                try {
                    Scanner scanner = new Scanner(System.in);
                    do {
                        System.out.println("Ingrese su dni: ");
                        dni = scanner.nextLine();
                        revision = true;
                        if (Herramientas.controlDNIEsUnINT(dni) == false || dni.length() != 8) {
                            System.err.println("Ingreso un dni no valido");
                            revision = false;
                        }
                    } while (revision == false);
                    System.out.println("Ingrese su contraseña:");
                    String password = scanner.nextLine();
                    persona = this.hotel.retornarPersonaXDNI(dni);
                    if (persona != null) {
                        if (persona.getPassword().compareTo(password) == 0) {
                            return persona;
                        }
                        System.err.println("La contraseña es incorrecta");
                        control++;
                    } else {
                        System.err.println("El dni no corresponde a ninguna Persona registrado en el sistema");
                        control++;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.err.println("Ingreso una opcion no valida");
                }
            } while (control != 3);
            return persona;
        }   ///chequeado

        public void menuNuevaReserva(Pasajero pasajero){
                Scanner sc = new Scanner(System.in);
                int anioI = 0, mesI = 0, diaI = 0;
                int anioF = 0, mesF = 0, diaF = 0;
                boolean control = false;
                String a;
                Reserva nuevaReserva = null;
                LocalDate inicio; LocalDate finalizacion;
                do{
                    do {
                        do {
                            try {
                                System.out.println("Ingresar el AÑO en que desea realizar su reserva.");

                                anioI = sc.nextInt();
                                if (anioI <= LocalDate.now().plusYears(2).getYear()) {
                                    if (!(anioI < LocalDate.now().getYear())) {
                                        control = true;
                                        break;
                                    }
                                }
                                System.err.println("Ingreso un año no valido");
                            } catch (InputMismatchException ime) {
                                System.err.println("¡Cuidado! Solo puedes insertar números. ");
                                sc.next();
                            }
                        } while (control == false);
                        control = false;
                        do {
                            try {
                                System.out.println("Ingresar el numero de MES en que desea realizar su reserva.");
                                mesI = sc.nextInt();
                                if (mesI > 0 && mesI <= 12) {
                                    if (!(mesI < LocalDate.now().getMonthValue()) && !(anioI != LocalDate.now().getYear()) || (!(anioI <= LocalDate.now().getYear()))) {
                                        control = true;
                                        break;
                                    }
                                }
                                System.err.println("Ingreso un mes no valido");
                            } catch (InputMismatchException ime) {
                                System.err.println("¡Cuidado! Solo puedes insertar números. ");
                                sc.next();
                            }
                        } while (control == false);

                        control = false;
                        do {
                            try {
                                System.out.println("Ingresar el DIA en que desea realizar su reserva.");
                                diaI = sc.nextInt();
                                if (Herramientas.controlFecha(mesI, diaI) == true) {
                                    if ((!(diaI < LocalDate.now().getDayOfMonth()) || (!(mesI <= LocalDate.now().getMonthValue()) || (!(anioI <= LocalDate.now().getYear()))))) {
                                        control = true;
                                        break;
                                    }
                                }
                                System.err.println("Ingreso un dia no valido");
                            } catch (InputMismatchException ime) {
                                System.err.println("¡Cuidado! Solo puedes insertar números. ");
                                sc.next();
                            }
                        } while (control == false);

                        inicio = LocalDate.of(anioI, mesI, diaI);

                        control = false;
                        do {
                            try {
                                System.out.println("Ingresar el AÑO hasta el que se desea hospedar");
                                anioF = sc.nextInt();
                                if (!(anioF < anioI)) {
                                    control = true;
                                    break;
                                }
                                System.err.println("Ingreso un año no valido");
                            } catch (InputMismatchException ime) {
                                System.err.println("¡Cuidado! Solo puedes insertar números. ");
                                sc.next();
                            }
                        } while (control == false);

                        control = false;

                        do {
                            try {
                                System.out.println("Ingresar el numero de MES hasta el que se desea hospedar");
                                mesF = sc.nextInt();
                                if (mesI != mesF || mesI == mesF && Herramientas.controlMesTop(mesI, diaI) == true) {
                                    if ((mesF >= mesI) || !(anioF <= anioI)) {
                                        control = true;
                                        break;
                                    }
                                }
                                System.err.println("Ingreso un mes no valido");
                            } catch (InputMismatchException ime) {
                                System.err.println("¡Cuidado! Solo puedes insertar números. ");
                                sc.next();
                            }
                        } while (control == false);


                        control = false;

                        do {
                            try {
                                System.out.println("Ingresar el DIA hasta el que se desea hospedar");
                                diaF = sc.nextInt();
                                if (Herramientas.controlFecha(mesF, diaF) == true) {
                                    if (!(diaF <= diaI) || !(mesF <= mesI) || !(anioF <= anioI)) {
                                        control = true;
                                        break;
                                    }
                                }
                                System.err.println("Ingreso un dia no valido");
                            } catch (InputMismatchException ime) {
                                System.err.println("¡Cuidado! Solo puedes insertar números. ");
                                sc.next();
                            }
                        } while (control == false);

                        finalizacion = LocalDate.of(anioF, mesF, diaF);

                        if(this.hotel.comprobarReservaNoTransit(inicio,finalizacion,pasajero) == false){
                            System.err.println("Usted ya posee una reserva dentro de esas fechas");
                        }

                    }while(this.hotel.comprobarReservaNoTransit(inicio,finalizacion,pasajero) == false);

                ArrayList<Habitacion> habitacionesDisponibles = this.hotel.listHabitacionesDisponibles(inicio, finalizacion);

                int capacidad = 0;
                do {
                    try {
                        System.out.println("Ingrese la capacidad de la habitacion que desea alquilar (2 o 4 Personas)");
                        capacidad = sc.nextInt();
                        if (capacidad != 2 && capacidad != 4) {
                            System.err.println("Ingreso un valor no valido para la capacidad de la habitacion");
                        }
                    } catch (InputMismatchException ime) {
                        System.err.println("¡Cuidado! Solo puedes insertar números. ");
                        sc.next();
                    }
                } while (!(capacidad == 2 || capacidad == 4));

                ArrayList<Integer> numerosDisponibles = new ArrayList<>();
                System.out.println("==========================" +
                        "\nHabitaciones disponibles:");
                for (Habitacion habitacion : habitacionesDisponibles) {
                    if (habitacion.getCapacidad() == capacidad) {
                        System.out.println(habitacion.toString());
                        numerosDisponibles.add(habitacion.getNumero());
                    }
                }
                control = false;
                int numeroDeHabitacion = 0;
                do {
                    try {

                        System.out.println("Que numero de habitacion desea alquilar?" +
                                "\nLos numeros de habitaciones disponibles son : ");
                        for (int numero : numerosDisponibles) {
                            System.out.print(numero + " - ");
                        }
                        System.out.println("\n");
                        numeroDeHabitacion = sc.nextInt();
                        for (int numero : numerosDisponibles) {
                            if (numero == numeroDeHabitacion) {
                                control = true;
                            }
                        }
                        if (control == false) {
                            System.err.println("Ingreso un numero no disponible");
                        }

                    } catch (InputMismatchException ime) {
                        System.err.println("¡Cuidado! Solo puede ingresar números. ");
                        sc.next();
                    }
                } while (control == false);

                control = false;
                Habitacion habitacion1 = this.hotel.retornarHabitacionXNumero(numeroDeHabitacion);
                nuevaReserva = new Reserva(pasajero, habitacion1, inicio, finalizacion);

                System.out.println("Su reserva es la siguiente: ");
                System.out.println(nuevaReserva.toString());
                System.out.println("Desea confirmar la reserva? (s/n)");
                Scanner scannerConfirmacion = new Scanner(System.in);
                a = scannerConfirmacion.nextLine();
                if (a.compareTo("s") == 0) {
                    control = true;
                    try {
                        this.hotel.getReservas().add(nuevaReserva);
                        ManejoArchivo.guardarReservas(this.hotel.getReservas());
                        System.out.println("Su reserva quedo registrada, lo esperamos!");
                        System.out.println("\nPresiona cualquier tecla para continuar...");
                        new java.util.Scanner(System.in).nextLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (a.compareTo("s") != 0) {
                    System.out.println("Desea realizar una reserva nuevamente? (s/n)");
                    a = scannerConfirmacion.nextLine();
                    if (a.compareTo("s") != 0) {
                        control = true;
                        break;
                    }
                }
            } while (control == false);
        }

        public void menuBorrarUnaReserva(Pasajero pasajero) {
            ArrayList<Integer> numerosDisponibles = new ArrayList<>();
            int i = 1;
            int numero = 0;
            Scanner sc = new Scanner(System.in);
            boolean control = false;
            System.out.println("Estas son sus reservas, que numero desea cancelar?");
            for (Reserva reserva : this.hotel.getReservas()) {
                if (reserva.getPasajero().equals(pasajero)) {
                    System.out.println("\n" + i + ":");
                    numerosDisponibles.add(i);
                    i++;
                    System.out.println(reserva.toString());
                }
            }

            do {
                try {

                    System.out.println("Que numero de reserva desea cancelar?" +
                            "\nLos numeros de reservas son: \n 0 (para salir) -");
                    for (int numeroD : numerosDisponibles) {
                        System.out.print(numeroD + " - ");
                    }
                    numerosDisponibles.add(0);
                    System.out.println("\n");
                    numero = sc.nextInt();
                    for (int numeroDispo : numerosDisponibles) {
                        if (numeroDispo == numero) {
                            control = true;
                        }
                    }
                    if (control == false) {
                        System.err.println("Ingreso un numero no disponible");
                    }

                } catch (InputMismatchException ime) {
                    System.err.println("¡Cuidado! Solo puede ingresar números. ");
                    sc.next();
                }
            } while (control == false);
            Reserva reservaABorrar = null;
            i = 1;
            for (Reserva reservaAux : this.hotel.getReservas()) {
                if (reservaAux.getPasajero().equals(pasajero)) {
                    if (i == (numero)) {
                        reservaABorrar = reservaAux;
                    }
                    i++;
                }
            }
            this.hotel.getReservas().remove(reservaABorrar);

            System.out.println("Sus reservas vigentes son las siguientes:");
            for (Reserva reserva : this.hotel.getReservas()) {
                if (reserva.getPasajero().equals(pasajero)) {
                    System.out.println(reserva.toString());
                }
            }
        }


                    //////-----EMPLEADOS-----//////

        ////-----RECEPCIONISTA-----////
        public void menuPrimerolEmpleado() {
            boolean salir = false;
            Persona persona;
            do {
                try {
                    System.out.println("MENU EMPLEADO PRIMERO\nComo desea ingresar?" +
                            "\n\t1_como ADMINISTRADOR\n\t2_como RECEPCIONISTA\n\t3_Volver");
                    Scanner scInt = new Scanner(System.in);
                    int opcion = scInt.nextInt();

                    switch (opcion) {

                        case 1:
                            persona = menuLoggin();
                            if (persona != null) {
                                if (persona instanceof Administrador) {
                                    Administrador administrador = (Administrador) persona;
                                    MenuPrincipalAdministrador(administrador);
                                } else {
                                    System.err.println("El usuario ingresado no esta registrado como administrador");
                                }
                            } else {
                                System.err.println("Error de loggin, intenlo nuevamente");
                            }
                            break;

                        case 2:
                            persona = menuLoggin();
                            if (persona != null) {
                                if (persona instanceof Recepcion) {
                                    Recepcion recepcion = (Recepcion) persona;
                                    MenuPrincipalRecepcionista(recepcion);
                                } else {
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
                } catch (InputMismatchException e) {
                    System.err.println("Ingreso una opcion no valida");
                }
            } while (!salir);
        }   ///chequeado

        public Recepcion menuRecepcionistaRegistro() {
            System.out.println("MENU REGISTRO RECEPCIONISTA");
            Recepcion recepcion = null;
            boolean aceptado = false;
            while (!aceptado) {
                recepcion = nuevoRecepcionista();
                aceptado = this.hotel.validacionRecepcionista(recepcion);
                if (aceptado) {
                    System.err.println("El recepcionista ya se encuentra registrado");
                } else {
                    aceptado = true;
                }
            }
            return recepcion;
        }   ///chequeado

        public Recepcion nuevoRecepcionista() {
            Scanner scannerPasajero = new Scanner(System.in);
            System.out.println("Ingrese su nombre: ");
            String nombre = scannerPasajero.nextLine();
            System.out.println("Ingrese su apellido: ");
            String apellido = scannerPasajero.nextLine();
            System.out.println("Ingrese su dni: ");/////////////////////////////////////////////////////////////////////////////////
            String dni = scannerPasajero.nextLine();
            String password = null;

            boolean aceptada = false;
            while (!aceptada) {
                System.out.println("Ingrese una nueva contraseña: ");
                password = scannerPasajero.nextLine();
                System.out.println("Repita la contraseña:");
                String passwordSeguridad = scannerPasajero.nextLine();
                if (password.compareTo(passwordSeguridad) == 0) {
                    aceptada = true;
                } else {
                    System.err.println("Las contraseñas no coinciden, ingresela de nuevo");
                }
            }

            Recepcion nuevoRecepcionista = new Recepcion(nombre, apellido, password, dni);

            return nuevoRecepcionista;
        }   ///chequeado

        public void MenuPrincipalRecepcionista(Recepcion recepcion) {
            boolean salir = false;
            Scanner sc = new Scanner(System.in);
            do {
                try {
                    System.out.println("MENU PRINCIPAL RECEPCIONISTA\n" +
                            "Que accion desea realizar?\n\t1_Menu gestion pasajero\n\t2_Ver lista de usuarios" +
                            "\n\t3_Ver perfil\n\t4_Ver reservas vigentes\n\t5_Volver");
                    Scanner scInt = new Scanner(System.in);
                    int opcion = scInt.nextInt();
                    Pasajero pasajero = null;

                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese el dni del pasajero");
                            pasajero = (Pasajero) this.hotel.retornarPersonaXDNI(sc.nextLine());
                            if (pasajero != null) {
                                menuPrincipalPasajero(pasajero);
                            } else {
                                System.err.println("Error de loggin, intenlo nuevamente");
                            }
                            salir = true;
                            break;

                        case 2:
                            this.hotel.mostrarPasajeros();
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 3:
                            System.out.println(recepcion.toString());
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 4:
                            this.hotel.mostrarReservasVigentes();
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 5:
                            salir = true;
                            break;

                        default:
                            System.err.println("Las opciones son del 1 al 5");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.err.println("Ingreso una opcion no valida");
                }
            } while (!salir);
        }   ///chequeado


        ////-----ADMINISTRADOR-----////
        public Administrador menuAdministradorRegistro() {
            System.out.println("MENU REGISTRO ADMINISTRADOR");
            Administrador administrador = null;
            boolean aceptado = false;
            while (!aceptado) {
                administrador = nuevoAdministrador();
                aceptado = this.hotel.validacionAdministrador(administrador);
                if (aceptado) {
                    System.err.println("El administrador ya se encuentra registrado");
                } else {
                    aceptado = true;
                }
            }
            return administrador;
        }   ///chequeado

        public Administrador nuevoAdministrador() {
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
                if (password.compareTo(passwordSeguridad) == 0) {
                    aceptada = true;
                } else {
                    System.err.println("Las contraseñas no coinciden, ingresela de nuevo");
                }
            }

            Administrador nuevoAdministrador = new Administrador(nombre, apellido, password, dni);

            return nuevoAdministrador;
        }   ///chequeado

        public void MenuPrincipalAdministrador(Administrador administrador) {
            boolean salir = false;
            Recepcion recepcionAEditar;
            Administrador administradorAEditar;
            Pasajero pasajeroAEditar;
            boolean control = false;
            String dni;
            do {
                try {
                    System.out.println("MENU PRINCIPAL ADMINISTRADOR\n" +
                            "Que accion desea realizar?\n\t1_Menu gestion pasajero\n\t2_Crear recepcionista\n\t3_Crear administrador" +
                            "\n\t4_Ver lista de pasajeros\n\t5_Ver lista recepcionista\n\t6_Ver lista administradores\n\t7_Editar un pasajero\n\t8_Editar un empleado\n\t" +
                            "9_Ver perfil\n\t10_Menu reservas\n\t11_Crear una reserva especial\n\t12_Hacer Backup\n\t13_Volver");
                    Scanner scInt = new Scanner(System.in);
                    int opcion = scInt.nextInt();

                    switch (opcion) {
                        case 1:
                            menuPrimeroGestionPasajero();
                            break;

                        case 2:
                            Recepcion nuevoRecepcionista = menuRecepcionistaRegistro();
                            this.hotel.getPersonas().add(nuevoRecepcionista);
                            break;

                        case 3:
                            Administrador nuevoAdministrador = menuAdministradorRegistro();
                            this.hotel.getPersonas().add(nuevoAdministrador);
                            break;

                        case 4:
                            this.hotel.mostrarPasajeros();
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 5:
                            this.hotel.mostrarRecepcionistas();
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            ;
                            break;

                        case 6:
                            this.hotel.mostrarAdminstradores();
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 7:
                            do {
                                System.out.println("Ingrese el dni del pasajero que desea editar:");
                                dni = scInt.nextLine();
                                control = true;
                                if(Herramientas.controlDNIEsUnINT(dni) || dni.length()!=8){
                                    control = false;
                                    System.err.println("Ingreso un dni no valido");
                                }
                            }while (control == false);
                            if( this.hotel.retornarPersonaXDNI(dni) instanceof Pasajero){
                                pasajeroAEditar = (Pasajero) this.hotel.retornarPersonaXDNI(dni);
                                menuEditarPerfil(pasajeroAEditar);
                                    ManejoArchivo.guardarPersonas(this.hotel.getPersonas());
                            }else{
                                System.err.println("No hay ningun pasajero registrado con ese dni");
                            }

                        case 8:
                            do {
                                System.out.println("Ingrese el dni del empleado que desea editar:");
                                dni = scInt.nextLine();
                                control = true;
                                if(Herramientas.controlDNIEsUnINT(dni) || dni.length()!=8){
                                    control = false;
                                    System.err.println("Ingreso un dni no valido");
                                }
                            }while (control == false);
                            if( this.hotel.retornarPersonaXDNI(dni) instanceof Recepcion){
                                recepcionAEditar = (Recepcion) this.hotel.retornarPersonaXDNI(dni);
                                menuEditarPerfilEmpleado(recepcionAEditar);
                            }else if( this.hotel.retornarPersonaXDNI(dni) instanceof Administrador){
                                administradorAEditar = (Administrador) this.hotel.retornarPersonaXDNI(dni);
                                menuEditarPerfilEmpleado(administradorAEditar);
                            }else {
                                System.err.println("No hay ningun empleado registrado con ese dni");
                                break;
                            }

                        case 9:
                            menuPerfilEmpleado(administrador);
                            break;


                        case 10:
                            menuMostrarReservasAdm();
                            break;

                        case 11:
                            menuCrearReservaEspecial();
                        case 12:
                            try {
                                hacerBackupAministrador(this.hotel);
                                System.out.println("Se ha realizado su backup correctamente");
                            } catch (IOException e) {
                                System.err.println("El backup no se pudo realizar");
                            }
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;


                        case 13:
                            salir = true;
                            break;
                        default:
                            System.err.println("Las opciones son del 1 al 13");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.err.println("Ingreso una opcion no valida");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (!salir);
        }   ///chequeado

        public void menuMostrarReservasAdm() {
            boolean salir = false;
            do {
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Menu mostrar reservas   \n ¿Que reservas desea visualizar? " +
                            "\n\t1_Todas las reservas \n\t2_Solo reservas vigentes \n\t3_Solo reservas antiguas \n\t4_Volver");
                    int option = sc.nextInt();
                    switch (option){
                        case 1:
                            this.hotel.mostrarTodasReservas();
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;
                        case 2:
                            this.hotel.mostrarReservasVigentes();
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;
                        case 3:
                            this.hotel.mostrarReservasAntiguas();
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;
                        case 4:
                            salir = true;
                            break;
                        default:
                            System.err.println("Las opciones son del 1 al 4");
                    }


                } catch (InputMismatchException e) {
                    System.err.println("Ingreso una opcion no valida");
                }

            }while(!salir);
        }   ///chequeado

        public void menuPrimeroGestionPasajero() {
            boolean salir = false;
            Scanner sc = new Scanner(System.in);
            do {
                try {
                    System.out.println("MENU PASAJERO PRIMERO" +
                            "\nQue accion desea realizar?\n\t1_Ingresar pasajero \n\t2_Registrar pasajero nuevo\n\t3_Volver");
                    Scanner scInt = new Scanner(System.in);
                    int opcion = scInt.nextInt();
                    Pasajero pasajero = null;
                    switch (opcion) {

                        case 1:
                            System.out.println("Ingrese el dni del pasajero");
                            pasajero = (Pasajero) this.hotel.retornarPersonaXDNI(sc.nextLine());
                            if (pasajero != null) {
                                menuPrincipalPasajero(pasajero);
                            } else {
                                System.err.println("Error de loggin, intenlo nuevamente");
                            }
                            salir = true;
                            break;


                        case 2:
                            pasajero = menuPasajeroRegistro();
                            this.hotel.getPersonas().add(pasajero);
                            menuPrincipalPasajero(pasajero);
                            salir = true;
                            break;

                        case 3:
                            salir = true;
                            break;

                        default:
                            System.err.println("Las opciones son 1-2-3");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.err.println("Ingreso una opcion no valida");
                }
            } while (!salir);
        }   ///chequeado

        public void menuPerfilEmpleado(Persona persona) {
            boolean salir = false;
            do {
                try {
                    System.out.println("Perfil de " + persona.getNombre() + " " + persona.getApellido() +
                            "\nQue accion desea realizar?\n\t1_Ver perfil\n\t2_Editar perfil\n\t3_Volver");
                    Scanner scInt = new Scanner(System.in);
                    int opcion = scInt.nextInt();

                    switch (opcion) {

                        case 1:
                            System.out.println(persona.toString());
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 2:
                            menuEditarPerfilEmpleado(persona);
                            ManejoArchivo.guardarPersonas(this.hotel.getPersonas());
                            break;

                        case 3:
                            salir = true;
                            break;

                        default:
                            System.err.println("Las opciones son 1-2-3");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.err.println("Ingreso una opcion no valida");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (!salir);
        }   ///chequeado

        public void menuCrearReservaEspecial(){
            Scanner sc = new Scanner(System.in);
            int anioI = 0, mesI = 0, diaI = 0;
            int anioF = 0, mesF = 0, diaF = 0;
            boolean control = false;
            String tipoDeReserva = null;
            int i;
            String a;
            Reserva nuevaReserva = null;
            do{
                do {
                    try {
                        System.out.println("Ingresar el AÑO en que desea programar el cierre de una habitacion para un servicio especial");

                        anioI = sc.nextInt();
                        if (anioI <= LocalDate.now().plusYears(2).getYear()) {
                            if (!(anioI < LocalDate.now().getYear())) {
                                control = true;
                                break;
                            }
                        }
                        System.err.println("Ingreso un año no valido");
                    } catch (InputMismatchException ime) {
                        System.err.println("¡Cuidado! Solo puedes insertar números. ");
                        sc.next();
                    }


                } while (control == false);

                control = false;
                do {
                    try {
                        System.out.println("Ingresar el numero de MES en que desea programar el cierre de una habitacion para un servicio especial");
                        mesI = sc.nextInt();
                        if (mesI > 0 && mesI <= 12) {
                            if (!(mesI < LocalDate.now().getMonthValue()) && !(anioI != LocalDate.now().getYear()) || (!(anioI <= LocalDate.now().getYear()))) {
                                control = true;
                                break;
                            }
                        }
                        System.err.println("Ingreso un mes no valido");
                    } catch (InputMismatchException ime) {
                        System.err.println("¡Cuidado! Solo puedes insertar números. ");
                        sc.next();
                    }
                } while (control == false);

                control = false;
                do {
                    try {
                        System.out.println("Ingresar el DIA en que desea programar el cierre de una habitacion para un servicio especial");
                        diaI = sc.nextInt();
                        if (Herramientas.controlFecha(mesI, diaI) == true) {
                            if ((!(diaI < LocalDate.now().getDayOfMonth()) || (!(mesI <= LocalDate.now().getMonthValue()) || (!(anioI <= LocalDate.now().getYear()))))) {
                                control = true;
                                break;
                            }
                        }
                        System.err.println("Ingreso un dia no valido");
                    } catch (InputMismatchException ime) {
                        System.err.println("¡Cuidado! Solo puedes insertar números. ");
                        sc.next();
                    }
                } while (control == false);

                LocalDate inicio = LocalDate.of(anioI, mesI, diaI);

                control = false;
                do {
                    try {
                        System.out.println("Ingresar el AÑO hasta el que desea programar el cierre de una habitacion para un servicio especial");
                        anioF = sc.nextInt();
                        if (!(anioF < anioI)) {
                            control = true;
                            break;
                        }
                        System.err.println("Ingreso un año no valido");
                    } catch (InputMismatchException ime) {
                        System.err.println("¡Cuidado! Solo puedes insertar números. ");
                        sc.next();
                    }
                } while (control == false);

                control = false;

                do {
                    try {
                        System.out.println("Ingresar el numero de MES hasta el que desea programar el cierre de una habitacion para un servicio especial");
                        mesF = sc.nextInt();
                        if (mesI != mesF || mesI == mesF && Herramientas.controlMesTop(mesI, diaI) == true) {
                            if ((mesF >= mesI) || !(anioF <= anioI)) {
                                control = true;
                                break;
                            }
                        }
                        System.err.println("Ingreso un mes no valido");
                    } catch (InputMismatchException ime) {
                        System.err.println("¡Cuidado! Solo puedes insertar números. ");
                        sc.next();
                    }
                } while (control == false);


                control = false;

                do {
                    try {
                        System.out.println("Ingresar el DIA hasta el que desea programar el cierre de una habitacion para un servicio especial");
                        diaF = sc.nextInt();
                        if (Herramientas.controlFecha(mesF, diaF) == true) {
                            if (!(diaF <= diaI) || !(mesF <= mesI) || !(anioF <= anioI)) {
                                control = true;
                                break;
                            }
                        }
                        System.err.println("Ingreso un dia no valido");
                    } catch (InputMismatchException ime) {
                        System.err.println("¡Cuidado! Solo puedes insertar números. ");
                        sc.next();
                    }
                } while (control == false);

                LocalDate finalizacion = LocalDate.of(anioF, mesF, diaF);

                ArrayList<Habitacion> habitacionesDisponibles = this.hotel.listHabitacionesDisponiblesTodas(inicio, finalizacion);

                int capacidad = 0;
                do {
                    try {
                        System.out.println("Ingrese la capacidad de la habitacion que desea programar para un servicio especial (2 o 4 Personas)");
                        capacidad = sc.nextInt();
                        if (capacidad != 2 && capacidad != 4) {
                            System.err.println("Ingreso un valor no valido para la capacidad de la habitacion");
                        }
                    } catch (InputMismatchException ime) {
                        System.err.println("¡Cuidado! Solo puedes insertar números. ");
                        sc.next();
                    }
                } while (!(capacidad == 2 || capacidad == 4));

                ArrayList<Integer> numerosDisponibles = new ArrayList<>();
                System.out.println("=========================================================" +
                                 "\nHabitaciones sin reserva de pasajeros para esas fechas:");
                for (Habitacion habitacion : habitacionesDisponibles) {
                    if (habitacion.getCapacidad() == capacidad) {
                        System.out.println(habitacion.toString());
                        numerosDisponibles.add(habitacion.getNumero());
                    }
                }
                control = false;
                int numeroDeHabitacion = 0;
                do {
                    try {

                        System.out.println("Que numero de habitacion desea reservar?" +
                                "\nLos numeros de habitaciones disponibles son : ");
                        for (int numero : numerosDisponibles) {
                            System.out.print(numero + " - ");
                        }
                        System.out.println("\n");
                        numeroDeHabitacion = sc.nextInt();
                        for (int numero : numerosDisponibles) {
                            if (numero == numeroDeHabitacion) {
                                control = true;
                            }
                        }
                        if (control == false) {
                            System.err.println("Ingreso un numero no disponible");
                        }

                    } catch (InputMismatchException ime) {
                        System.err.println("¡Cuidado! Solo puede ingresar números. ");
                        sc.next();
                    }
                } while (control == false);

                control = false;

                do{
                    try {
                        System.out.println("Que tipo de servicio quiere agendar?\n\t1_Limpieza\n\t2_Reparacion\n\t3_Desinfeccion\n");
                        i = sc.nextInt();
                        switch (i) {
                            case 1:
                                tipoDeReserva = Reserva.TipoDeReserva.EN_LIMPIEZA.name();
                                control = true;
                                break;
                            case 2:
                                tipoDeReserva = Reserva.TipoDeReserva.EN_REPARACION.name();
                                control = true;
                                break;
                            case 3:
                                tipoDeReserva = Reserva.TipoDeReserva.EN_DESINFECCION.name();
                                control = true;
                                break;

                            default:
                                System.err.println("Las opciones son del 1 al 3");
                        }
                    }catch (InputMismatchException ime) {
                        System.err.println("¡Cuidado! Solo puedes insertar números. ");
                        sc.next();
                    }
                }while (control == false);

                Pasajero pasajeroHotel = (Pasajero) this.hotel.retornarPersonaXDNI("11111111");

                control = false;
                Habitacion habitacion1 = this.hotel.retornarHabitacionXNumero(numeroDeHabitacion);
                nuevaReserva = new Reserva(pasajeroHotel, habitacion1,0f, inicio, finalizacion,tipoDeReserva);

                System.out.println("Su reserva es la siguiente: ");
                System.out.println(nuevaReserva.toString());
                System.out.println("Desea confirmar la reserva? (s/n)");
                Scanner scannerConfirmacion = new Scanner(System.in);
                a = scannerConfirmacion.nextLine();
                if(a.compareTo("s")==0){
                    control=true;
                    System.out.println("Su reserva quedo registrada, lo esperamos!");
                    this.hotel.getReservas().add(nuevaReserva);
                    try {
                        ManejoArchivo.guardarReservas(this.hotel.getReservas());
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }

                if(a.compareTo("s")!=0){
                    System.out.println("Desea realizar una reserva nuevamente? (s/n)");
                    a = scannerConfirmacion.nextLine();
                    if(a.compareTo("s")!=0){
                        control=true;
                        break;
                    }
                }
            }while (control == false);

        }


        public void menuEditarPerfilEmpleado(Persona persona) {
            boolean salir = false;
            boolean control = false;
            do {
                try {
                    System.out.println("Perfil de " + persona.getNombre() + " " + persona.getApellido() +
                            "\nQue desea editar?\n\t1_Nombre\n\t2_Apellido\n\t3_DNI\n\t4_Contraseña\n\t5_Volver");
                    Scanner scInt = new Scanner(System.in);
                    Scanner scString = new Scanner(System.in);
                    int opcion = scInt.nextInt();
                    Persona personaAntes = persona;
                    String cambios;

                    switch (opcion) {
                        case 1:
                            System.out.println("Nombre actual: " + persona.getNombre() + "\n\tIngrese su nuevo nombre: ");
                            persona.setNombre(scString.nextLine());
                            System.out.println("Nombre cambiado con exito! Nuevo nombre : " + persona.getNombre());
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 2:
                            System.out.println("Apellido actual: " + persona.getApellido() + "\n\tIngrese su nuevo apellido: ");
                            persona.setApellido(scString.nextLine());
                            System.out.println("Apellido cambiado con exito! Nuevo apellido :" + persona.getApellido());
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 3:
                            do {
                                System.out.println("Dni actual: " + persona.getDni() + "\n\tIngrese su nuevo dni: ");
                                cambios = scString.nextLine();
                                control = true;
                                if (Herramientas.controlDNIEsUnINT(cambios) == false || cambios.length() != 8) {
                                    control = false;
                                    System.err.println("Ingreso un valor no valido");
                                }
                                if (this.hotel.existeDNI(cambios)) {
                                    System.err.println("El dni ingresado ya pertenece a un usuario registrado en el sistema");
                                    control = false;
                                } else {
                                    persona.setDni(cambios);
                                }
                            } while (control == false);
                            System.out.println("DNI cambiado con exito! Nuevo dni: " + persona.getDni());
                            System.out.println("\nPresiona cualquier tecla para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                            break;

                        case 4:
                            while (!control) {
                                System.out.println("Contraseña actual: " + persona.getPassword() + "\n\tIngrese su nueva contraseña: ");
                                cambios = scString.nextLine();
                                System.out.println("Ingrese nuevamente su contraseña: ");
                                String contraseñaComprobar = scString.nextLine();
                                if (!this.hotel.comprobarContrasenias(cambios, contraseñaComprobar)) {
                                    System.err.println("Las contraseñas no coinciden");
                                } else {
                                    if (!this.hotel.comprobarContrasenias(persona.getPassword(), cambios)) {
                                        System.err.println("La contraseña es igual a la anterior");
                                    } else {
                                        persona.setPassword(cambios);
                                        System.out.println("\nPresiona cualquier tecla para continuar...");
                                        new java.util.Scanner(System.in).nextLine();
                                        new java.util.Scanner(System.in).nextLine();
                                    }
                                    control = true;
                                }
                            }
                            break;

                        case 5:
                            salir = true;
                            break;
                        default:
                            System.out.println("Las opciones son del 1 al 5");
                    }
                    this.hotel.actualizarPersonaEnHotel(personaAntes, persona);

                } catch (java.util.InputMismatchException e) {
                    System.err.println("Ingreso una opcion no valida");
                }
            } while (!salir);
        }

        public void hacerBackupAministrador(Hotel hotel) throws IOException {
            ManejoArchivo.guardarBackup(hotel);
        }


}

