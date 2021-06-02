package com.company;

import com.company.Hotel.Habitacion;
import com.company.Hotel.Hotel;
import com.company.Hotel.Reserva;
import com.company.Persona.*;
import com.sun.xml.internal.ws.server.ServerRtException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {

    public void menuPrincipal() {
        Hotel hotel = new Hotel();
        Pasajero pasajero1 = new Pasajero("Peter", "Pan","P1","3","Argentina","Colon 1542");
        hotel.getPersonas().add(pasajero1);

        Habitacion habitacion1 = new Habitacion(Habitacion.TipoHabitacion.Suite,01,2,3000);
        Habitacion habitacion2 = new Habitacion(Habitacion.TipoHabitacion.Suite,02,4,3500);
        Habitacion habitacion3 = new Habitacion(Habitacion.TipoHabitacion.Premiun,03,2,2000);
        Habitacion habitacion4 = new Habitacion(Habitacion.TipoHabitacion.Premiun,04,4,2500);
        Habitacion habitacion5 = new Habitacion(Habitacion.TipoHabitacion.Estandar,05,2,1000);
        Habitacion habitacion6 = new Habitacion(Habitacion.TipoHabitacion.Estandar,06,4,1500);
        Habitacion habitacion7 = new Habitacion(Habitacion.TipoHabitacion.Estandar,06,4,1500);

        hotel.getHabitaciones().add(habitacion1);
        hotel.getHabitaciones().add(habitacion2);
        hotel.getHabitaciones().add(habitacion3);
        hotel.getHabitaciones().add(habitacion4);
        hotel.getHabitaciones().add(habitacion5);
        hotel.getHabitaciones().add(habitacion6);
        hotel.getHabitaciones().add(habitacion7);

        LocalDate inicio = LocalDate.of(2021,3,25);
        LocalDate finalizacion = LocalDate.of(2021,3,29);

        ArrayList<Habitacion> habitacionesDisponibles = hotel.listHabitacionesDisponibles(inicio,finalizacion);

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
                        menuPrimeroPasajero(hotel);
                        salir = true;
                        break;

                    case 2:
                        menuPrimerolEmpleado(hotel);
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


    //////////////////////////////////////////////////////MENUS PASAJERO//////////////
    public void menuPrimeroPasajero(Hotel hotel){
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
                        pasajero = menuPasajeroRegistro(hotel);
                        menuPrincipalPasajero(hotel, pasajero);
                        salir = true;
                        break;

                    case 2:
                        pasajero = (Pasajero) menuLoggin(hotel);
                        if (pasajero != null) {
                            menuPrincipalPasajero(hotel, pasajero);
                        } else {
                            System.err.println("Error de loggin, intenlo nuevamente");
                        }
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

    public Pasajero menuPasajeroRegistro(Hotel hotel){
        System.out.println("MENU REGISTRO PASAJERO");
        Pasajero pasajero = null;
        boolean aceptado = false;
        while (!aceptado) {
            pasajero = nuevoPasajero();
            aceptado = hotel.validacionPasajero(pasajero);
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
            if(password.compareTo(passwordSeguridad)==0){
                aceptada = true;
            }else{
                System.err.println("Las contraseñas no coinciden, ingresela de nuevo");
            }
        }

        Pasajero nuevoPasajero = new Pasajero(nombre,apellido,password,dni,paisOrigen,domicilio);

        return nuevoPasajero;
    }


    ///abajo falta crear reserva
    public void menuPrincipalPasajero(Hotel hotel, Pasajero pasajero){
        boolean salir = false;
        do{
            try {
                System.out.println("MENU PRINCIPAL PASAJERO\n" +
                        "Que accion desea realizar?\n\t1_Nueva reserva\n\t2_Perfil\n\t3_Reserva activa\n\t4_Salir");
                Scanner scInt = new Scanner(System.in);
                int opcion = scInt.nextInt();

                switch (opcion) {
                    case 1:
                        menuNuevaReserva(hotel, pasajero);
                        break;
                    case 2:
                        menuPerfilPasajero(hotel, pasajero);

                        break;

                    case 3:
                        hotel.mostrarReservaActiva(pasajero);
                        System.out.println("\nPress Any Key To Continue...");
                        new java.util.Scanner(System.in).nextLine();
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
    public void menuPerfilPasajero(Hotel hotel,Pasajero pasajero){
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
                        menuEditarPerfil(hotel,pasajero);
                        break;
                    case 3:
                        salir = true;
                        break;
                }
            }catch (java.util.InputMismatchException e) {
                System.err.println("Ingreso una opcion no valida");
            }
        }while (!salir);
    }
    public void menuEditarPerfil(Hotel hotel,Pasajero pasajero){
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
                        if (!hotel.existeDNI(cambios)){
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
                            if(!hotel.comprobarContrasenias(cambios,contraseñaComprobar)) {
                                System.err.println("Las contraseñas no coinciden");
                            }else{
                                if(!hotel.comprobarContrasenias(pasajero.getPassword(), cambios)){
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

    public void menuNuevaReserva(Hotel hotel, Pasajero pasajero){
        Scanner sc = new Scanner(System.in);
        int anio,mes,dia;
        //try
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
        int cantidadDeDias = hotel.retornarCantidadDeDias(inicio,finalizacion);
        ArrayList<Habitacion> habitacionesDisponibles = hotel.listHabitacionesDisponibles(inicio,finalizacion);
        //try
        System.out.println("Ingrese la capacidad de la habitacion que desea alquilar (2 o 4 Personas)");
        int capacidad = sc.nextInt();

        for(Habitacion habitacion : habitacionesDisponibles) {
            if(habitacion.getCapacidad() == capacidad) {
                System.out.println(habitacion.toString());
            }
        }

        System.out.println("Que numero de habitacion desea alquilar?");
        int numeroDeHabitacion = sc.nextInt();

        Habitacion habitacion1 = hotel.retornarHabitacionXNumero(numeroDeHabitacion);

        Reserva nuevaReserva = new Reserva(pasajero,habitacion1,0f,inicio,finalizacion);

        hotel.getReservas().add(nuevaReserva);

    }


    //////////////////////////////////////////////////////MENUS EMPLEADO//////////////

    public void menuPrimerolEmpleado(Hotel hotel){
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
                        persona = menuLoggin(hotel);
                        if (persona != null) {
                            if(persona instanceof Administrador){
                                Administrador administrador = (Administrador) persona;
                                MenuPrincipalAdministrador(hotel, administrador);
                            }else{
                                System.err.println("El usuario ingresado no esta registrado como administrador");
                            }

                        } else {
                            System.err.println("Error de loggin, intenlo nuevamente");
                        }

                        break;

                    case 2:
                        persona = menuLoggin(hotel);
                        if (persona != null) {
                            if(persona instanceof Recepcion){
                                Recepcion recepcion = (Recepcion) persona;
                                MenuPrincipalRecepcionista(hotel, recepcion);
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




    public Recepcion menuRecepcionistaRegistro(Hotel hotel){
        System.out.println("MENU REGISTRO RECEPCIONISTA");
        Recepcion recepcion = null;
        boolean aceptado = false;
        while (!aceptado) {
            recepcion = nuevoRecepcionista();
            aceptado = hotel.validacionRecepcionista(recepcion);
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

    public static Persona menuLoggin(Hotel hotel){
        Persona persona = null;

        int control = 0;
        do{
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingrese su dni: ");
                String dni = scanner.nextLine();
                System.out.println("Ingrese su contraseña:");
                String password = scanner.nextLine();
                persona = hotel.retornarPersonaXDNI(dni);
                if (persona != null) {
                    if (persona.getPassword().compareTo(password) == 0) {
                        return persona;
                    }
                    System.err.println("La contraseña es incorrecta");
                    control++;
                } else {
                    System.err.println("El dni no corresponde a ningun recepcionista registrado en el sistema");
                    control++;
                }
            }catch (java.util.InputMismatchException e) {
                System.err.println("Ingreso una opcion no valida");
            }
        }while (control != 3);
            return persona;
    }

    ///abajo falta crear reserva y ademas,cuando mostremos historia de reservas,tenemos otra lista en hotel con el backup?
    public void MenuPrincipalRecepcionista(Hotel hotel, Recepcion recepcion){
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
                        break;

                    case 2:
                        Pasajero nuevoPasajero = menuPasajeroRegistro(hotel);
                        hotel.getPersonas().add(nuevoPasajero);
                        break;

                    case 3:
                        hotel.mostrarPasajeros();
                        break;

                    case 4:
                        System.out.println(recepcion.toString());
                        break;
                    case 5:
                        //hotel.mostrarReservasVigentes();
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





    public Administrador menuAdministradorRegistro(Hotel hotel){
        System.out.println("MENU REGISTRO ADMINISTRADOR");
        Administrador administrador = null;
        boolean aceptado = false;
        while (!aceptado) {
            administrador = nuevoAdministrador();
            aceptado = hotel.validacionAdministrador(administrador);
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



    ///abajo falta crear reserva y ademas,cuando mostremos historia de reservas,tenemos otra lista en hotel con el backup?
    public void MenuPrincipalAdministrador(Hotel hotel, Administrador administrador){
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

                        break;

                    case 2:
                        Pasajero nuevoPasajero = menuPasajeroRegistro(hotel);
                        hotel.getPersonas().add(nuevoPasajero);
                        break;

                    case 3:
                        Recepcion nuevoRecepcionista = menuRecepcionistaRegistro(hotel);
                        hotel.getPersonas().add(nuevoRecepcionista);
                        break;
                    case 4:
                        Administrador nuevoAdministrador =menuAdministradorRegistro(hotel);
                        hotel.getPersonas().add(nuevoAdministrador);
                        break;
                    case 5:
                        hotel.mostrarPasajeros();
                        break;
                    case 6:
                        hotel.mostrarRecepcionistas();
                        break;
                    case 7:
                        hotel.mostrarAdminstradores();
                        break;
                    case 8:
                        System.out.println(administrador.toString());
                    case 9:
                        hotel.mostrarReservasVigentes();

                        break;
                    case 10:
                        salir = true;
                        break;

                    default:
                        System.err.println("Las opciones son del 1 al 11");
                }
            }catch (java.util.InputMismatchException e){
                System.err.println("Ingreso una opcion no valida");
            }
        }while (!salir);
    }





    /*
    public static boolean Cuestion(){
        Scanner sc = new Scanner(System.in);
        char option = '0';
        do {
                System.out.println("Desea realizar otra operacion? s/n");
                option = sc.nextLine().charAt(0);
                if (Character.compare(option, 's') == 0){ return false;}
                if (Character.compare(option, 's') != 0 || Character.compare(option, 'n') !=0 )
                    System.err.println("INGRESO UNA OPCION NO VALIDA");

        }while(option != 's' || option != 'n');
        return true;

    }*/
}



