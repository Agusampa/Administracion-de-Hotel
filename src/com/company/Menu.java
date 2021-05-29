package com.company;

import com.company.Hotel.Hotel;
import com.company.Persona.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {

    public void menuPrincipal() {
        Hotel hotel = new Hotel();
        Pasajero pasajero1 = new Pasajero("Peter", "Pan","PeterPan1","3","Argentina","Colon 1542");
        hotel.getPersonas().add(pasajero1);
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
                        salir = true;
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
                        pasajero = menuLogginPasajero(hotel);
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
        System.out.println("Ingrese su nombre: ");
        String nombre = scannerPasajero.nextLine();
        System.out.println("Ingrese su apellido: ");
        String apellido = scannerPasajero.nextLine();
        System.out.println("Ingrese su dni: ");
        String dni = scannerPasajero.nextLine();
        System.out.println("Ingrese su pais de origen: ");
        String paisOrigen = scannerPasajero.nextLine();
        System.out.println("Ingrese su domicilio: ");
        String domicilio = scannerPasajero.nextLine();
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

        Pasajero nuevoPasajero = new Pasajero(nombre,apellido,password,dni,paisOrigen,domicilio);

        return nuevoPasajero;
    }

    public Pasajero menuLogginPasajero(Hotel hotel){
        Pasajero pasajero = null;

        int control = 0;
        do{
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingrese su dni: ");
                String dni = scanner.nextLine();
                System.out.println("Ingrese su contraseña:");
                String password = scanner.nextLine();
                pasajero = hotel.retornarPasajeroXDNI(dni);
                if (pasajero != null) {
                    if (pasajero.getPassword().compareTo(password) == 0) {
                        return pasajero;
                    }
                    System.err.println("La contraseña es incorrecta");
                    control++;
                } else {
                    System.err.println("El dni no corresponde a ningun pasajero registrado en el sistema");
                    control++;
                }
            }catch (java.util.InputMismatchException e) {
                System.err.println("Ingreso una opcion no valida");
            }
        }while (control != 3);
        return pasajero;
    }

    ///abajo falta crear reserva
    public void menuPrincipalPasajero(Hotel hotel, Pasajero pasajero){
        boolean salir = false;
        do{
            try {
                System.out.println("MENU PRINCIPAL PASAJERO\n" +
                        "Que accion desea realizar?\n\t1_Nueva reserva\n\t2_Ver perfil\n\t3_Reserva activa\n\t4_Salir");
                Scanner scInt = new Scanner(System.in);
                int opcion = scInt.nextInt();

                switch (opcion) {
                    case 1:

                        break;
                    case 2:
                        System.out.println(pasajero.toString());
                        break;

                    case 3:
                        hotel.mostrarReservaActiva(pasajero);
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
    public void menuNuevaReserva(Hotel hotel, Pasajero pasajero){
        Scanner sc = new Scanner(System.in);
        int anio,mes,dia;
        System.out.println("Ingresar el AÑO en que desea realizar su reserva.");
        anio = sc.nextInt();
        System.out.println("Ingresar el MES en que desea realizar su reserva.");
        mes = sc.nextInt();
        System.out.println("Ingresar el DIA en que desea realizar su reserva.");
        dia = sc.nextInt();
        LocalDate inicio = LocalDate.of(anio,mes,dia);
        System.out.println("Ingresar el AÑO hasta el que se desea hospedar");
        anio = sc.nextInt();
        System.out.println("Ingresar el MES hasta el que se desea hospedar");
        mes = sc.nextInt();
        System.out.println("Ingresar el DIA hasta el que se desea hospedar");
        dia = sc.nextInt();
        LocalDate finalizacion = LocalDate.of(anio,mes,dia);
        int cantidadDeDias = hotel.retornarCantidadDeDias(inicio,finalizacion);


    }


    //////////////////////////////////////////////////////MENUS EMPLEADO//////////////
    public void menuPrimerolEmpleado(Hotel hotel){
        boolean salir = false;
        do{
            try {
                System.out.println("MENU EMPLEADO PRIMERO\nComo desea ingresar?" +
                        "\n\t1_como ADMINISTRADOR\n\t2_como RECEPCIONISTA\n\t3_Volver");


                Scanner scInt = new Scanner(System.in);
                int opcion = scInt.nextInt();

                switch (opcion) {
                    case 1:
                        Administrador adm = MenuLogginAdministrador(hotel);
                        if (adm != null) {
                            MenuPrincipalAdministrador(hotel, adm);
                        } else {
                            System.err.println("Error de loggin, intenlo nuevamente");
                        }

                        break;

                    case 2:
                        Recepcion rec = MenuLogginRecepcionista(hotel);

                        if (rec != null) {
                            MenuPrincipalRecepcionista(hotel, rec);
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

    public static Recepcion MenuLogginRecepcionista(Hotel hotel){
        Recepcion recepcion = null;

        int control = 0;
        do{
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingrese su dni: ");
                String dni = scanner.nextLine();
                System.out.println("Ingrese su contraseña:");
                String password = scanner.nextLine();
                recepcion = hotel.retornarRecepcionistaXDNI(dni);
                if (recepcion != null) {
                    if (recepcion.getPassword().compareTo(password) == 0) {
                        return recepcion;
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
            return recepcion;
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
                        Pasajero nuevo = menuPasajeroRegistro(hotel);
                        ///QUE SE HACE CON EL NUEVO???
                        break;

                    case 3:
                        hotel.mostrarUsuarios();
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

    public static Administrador MenuLogginAdministrador(Hotel hotel){
        Administrador administrador = null;
        int control = 0;
        do{
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingrese su dni: ");
                String dni = scanner.nextLine();
                System.out.println("Ingrese su contraseña:");
                String password = scanner.nextLine();
                //if(Persona instanceof )
                administrador = hotel.retornarAdministradorXDNI(dni);//return persona
                if (administrador != null) {
                    if (administrador.getPassword().compareTo(password) == 0) {
                        return administrador;
                    }
                    System.err.println("La contraseña es incorrecta");
                    control++;
                } else {
                    System.err.println("El dni no corresponde a ningun administrador registrado en el sistema");
                    control++;
                }
            }catch (java.util.InputMismatchException e){
                System.err.println("Ingreso una opcion no valida");
            }
        }while (control != 3);
        return administrador;
    }

    ///abajo falta crear reserva y ademas,cuando mostremos historia de reservas,tenemos otra lista en hotel con el backup?
    public void MenuPrincipalAdministrador(Hotel hotel, Administrador administrador){
        boolean salir = false;
        do{
            try {
                System.out.println("MENU PRINCIPAL ADMINISTRADOR\n" +
                "Que accion desea realizar?\n\t1_Nueva reserva\n\t2_Crear Pasajero\n\t3_Crear Recepcionista\n\t4_Crear Administrador" +
                "\n\t5_Ver lista de Usuarios\n\t6_Ver lista recepcionista\n\t7_Ver lista Administradores\n\t8_Ver perfil" +
                "\n\t9_Ver Reservas Vigentes\n\t10_Volver");
                Scanner scInt = new Scanner(System.in);
                int opcion = scInt.nextInt();

                switch (opcion) {
                    case 1:

                        break;

                    case 2:
                        Pasajero nuevoP = menuPasajeroRegistro(hotel);
                        ///falta ver que hacer con este nuevoP
                        break;

                    case 3:
                        Recepcion nuevoR = menuRecepcionistaRegistro(hotel);
                        ///falta ver que hacer con este nuevoR
                        break;
                    case 4:
                        Administrador nuevoA =menuAdministradorRegistro(hotel);
                        ///falta ver que hacer con este nuevoA
                        break;
                    case 5:
                        hotel.mostrarUsuarios();
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
                        System.err.println("Las opciones son 1-2-3-4-5-6-7-8-9-10-11");
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



