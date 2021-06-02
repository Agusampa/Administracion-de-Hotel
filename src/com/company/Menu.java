package com.company;

import com.company.Hotel.Consumibles.*;
import com.company.Hotel.Hotel;
import com.company.Hotel.Reserva;
import com.company.Hotel.Servicios.Servicio;
import com.company.Hotel.Servicios.TiposServicios;
import com.company.Persona.*;
import com.company.Sistema.Backup;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
    Backup backup = new Backup();

    public void menuPrincipal() {
        //
        //
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
                            hotel.getPersonas().add(pasajero);
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


    ///abajo falta crear reserva
    public void menuPrincipalPasajero(Hotel hotel, Pasajero pasajero){
        boolean salir = false;
        do{
            try {
                System.out.println("MENU PRINCIPAL PASAJERO\n" +
                        "Que accion desea realizar?\n\t1_Ver Perfil\n\t2_CrearNuevaReserva" +
                        "\n\t3_MenuReserva\n\t4_Salir");
                Scanner scInt = new Scanner(System.in);
                int opcion = scInt.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println(pasajero.toString());
                        break;
                    case 2:
                        ///crear reserva
                        ////menu reserva()
                        break;

                    case 3:

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

    public void MENURESERVAPASAJERO(Hotel hotel,Pasajero pasajero){
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
                        menuReservaActual(hotel,pasajero);
                        break;
                    case 2:
                        ArrayList<Reserva> activas = hotel.RetornarReservasActiva(pasajero); //corregir y ver que hacer en caso de que no haya reservas antiguas
                        for (Reserva reservaAux : activas) {
                            System.out.println(reservaAux.toString());
                        }
                        break;

                    case 3:
                        ArrayList<Reserva> antiguos = this.backup.retornarReservasAntiguas(pasajero); ///mismo que lo mencionado anteriormente
                        for (Reserva reservaAux : antiguos) {
                            System.out.println(reservaAux.toString());
                        }
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

    public void menuReservaActual(Hotel hotel, Pasajero pasajero){
        Reserva actual = reservaActual(hotel,pasajero);
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
        hotel.actualizarReserva(actual);
    }

    ////OPERACIONES CON CONSUMIBLES
    public Reserva menuConsumibles(Reserva reserva){
        boolean salir = false;
        ArrayList<Consumible> consumibles = new ArrayList<>();
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
                        for(Consumible consumibleAux : consumibles){
                            reserva.agregarGastoAdicional(consumibleAux);
                        }
                        break;
                    case 2:
                        consumibles = seleccionSnacks();
                        for(Consumible consumibleAux : consumibles){
                            reserva.agregarGastoAdicional(consumibleAux);
                        }
                        break;

                    case 3:
                        consumibles = seleccionPlatillos();
                        for(Consumible comidaAux : consumibles){
                            reserva.agregarGastoAdicional(comidaAux);
                        }
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
            } catch (java.util.InputMismatchException e) {
                System.err.println("Ingreso una opcion no valida");
            }
            bebidas.add(consumible);
            System.out.println("Desea agregar alguna mas? --Seleccione 0 para salir,Cualquier numero para seguir");
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
                    case 11:
                        consumible = new Consumible(LocalDateTime.now(), Snack.CHICLES.name(), Snack.CHICLES.getPrecio(), cantidad);
                        break;
                    default:
                        System.err.println("Las opciones son 1-2-3-4-5-6-7-8-9-10-11");
                }
            } catch (java.util.InputMismatchException e) {
                System.err.println("Ingreso una opcion no valida");
            }
            snacks.add(consumible);
            System.out.println("Desea agregar alguna mas? --Seleccione 0 para salir,Cualquier numero para seguir");
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
            } catch (java.util.InputMismatchException e) {
                System.err.println("Ingreso una opcion no valida");
            }
            platillos.add(comida);
            System.out.println("Desea agregar alguna mas? --Seleccione 0 para salir,Cualquier numero para seguir");
            if(scInt.nextInt()==0){salir=true;}
        }while(!salir);
        return platillos;
    }


    ///OPERACIONES CON SERVICIOS
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
                        servicio = new Servicio(LocalDateTime.now(), TiposServicios.SALA_DE_REUNIONES.name(), TiposServicios.SALA_DE_REUNIONES.getPrecio(), cantidad);
                        break;
                    case 9:
                    /*sacar*/    servicio = new Servicio(LocalDateTime.now(), TiposServicios.SALA_TENIS.name(), TiposServicios.SALA_TENIS.getPrecio(), cantidad);
                        break;
                    case 10:
                        servicio = new Servicio(LocalDateTime.now(), TiposServicios.PAINTBALL.name(), TiposServicios.PAINTBALL.getPrecio(), cantidad);
                        break;
                    case 11:
                        servicio = new Servicio(LocalDateTime.now(), TiposServicios.PARQUE_ACUATICO.name(), TiposServicios.PARQUE_ACUATICO.getPrecio(), cantidad);
                        break;

                    default:
                        System.err.println("Las opciones son 1-2-3");
                }
            } catch (java.util.InputMismatchException e) {
                System.err.println("Ingreso una opcion no valida");
            }
            reserva.agregarGastoAdicional(servicio);
            System.out.println("Desea agregar alguna mas? --Seleccione 0 para salir,Cualquier numero para seguir");
            if(scInt.nextInt()==0){salir=true;}
        }while(!salir);
        return reserva;
    }



    public Reserva reservaActual(Hotel hotel,Pasajero pasajero){
        for(Reserva reservaAux : hotel.getReservas()){
            if(reservaAux.getPasajero().equals(pasajero)){
                if(reservaAux.getInicio().isAfter(LocalDate.now()) || reservaAux.getInicio().equals(LocalDate.now())){
                    return reservaAux;
                }
            }
        }
        return null;
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


    /////////////////MENUS EMPLEADO//////////////

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

                        Administrador administrador = (Administrador) menuLoggin(hotel);
                        if (administrador != null) {
                            MenuPrincipalAdministrador(hotel, administrador);
                        } else {
                            System.err.println("Error de loggin, intenlo nuevamente");
                        }

                        break;

                    case 2:
                        Recepcion recepcion = (Recepcion) menuLoggin(hotel);

                        if (recepcion != null) {
                            MenuPrincipalRecepcionista(hotel, recepcion);
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


    /*public static Persona MENULOGGINEMPLEADO(Hotel hotel){
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
    }*/

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
                    System.err.println("El dni no corresponde a ninguna Persona registrado en el sistema");
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


}



