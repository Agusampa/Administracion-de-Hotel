package com.company.Sistema;

import com.company.Hotel.*;
import com.company.Persona.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;


public class ManejoArchivo {

                                ////-----GUARDAR-----////
        public static boolean guardarReservas(ArrayList<Reserva> reservas) throws IOException {

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("reservas"));

            try {
                Gson gson = new Gson();
                gson.toJson(reservas, new TypeToken<ArrayList<Reserva>>() {}.getType(), bufferedWriter);
            } finally {
                bufferedWriter.close();
            }

            return true;
        }

        public static boolean guardarPersonas(ArrayList<Persona> personas) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("personas"));

            try {
                Gson gson = new Gson();
                gson.toJson(personas, new TypeToken<ArrayList<Persona>>() {}.getType(), bufferedWriter);
            } finally {
                bufferedWriter.close();
            }

            return true;
        }

        public static boolean guardarHabitaciones(ArrayList<Habitacion> habitaciones) throws IOException {

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("habitaciones"));

            try {
                Gson gson = new Gson();
                gson.toJson(habitaciones, new TypeToken<ArrayList<Habitacion>>() {}.getType(), bufferedWriter);
            } finally {
                bufferedWriter.close();
            }

            return true;
        }

                                ////-----GUARDAR BACKUP-----////
        public static boolean guardarReservasBackup(ArrayList<Reserva> reservas) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("reservasBackup"));

            try {
                Gson gson = new Gson();
                gson.toJson(reservas, new TypeToken<ArrayList<Reserva>>() {}.getType(), bufferedWriter);
            } finally {
                bufferedWriter.close();
            }

            return true;
        }

        public static boolean guardarPersonasBackup(ArrayList<Persona> personas) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("personasBackup"));
            try {
                Gson gson = new Gson();
                gson.toJson(personas, new TypeToken<ArrayList<Persona>>() {
                }.getType(), bufferedWriter);
            } finally {
                bufferedWriter.close();
            }
            return true;
        }

        public static boolean guardarHabitacionesBackup(ArrayList<Habitacion> habitaciones) throws IOException {

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("habitacionesBackup"));

            try {
                Gson gson = new Gson();
                gson.toJson(habitaciones, new TypeToken<ArrayList<Habitacion>>() {}.getType(), bufferedWriter);
            } finally {
                bufferedWriter.close();
            }

            return true;
        }

        public static boolean guardarBackup(Hotel hotel) throws IOException {
            ManejoArchivo.guardarPersonasBackup(hotel.getPersonas());
            ManejoArchivo.guardarHabitacionesBackup(hotel.getHabitaciones());
            ManejoArchivo.guardarReservasBackup(hotel.getReservas());
            return true;
        }

                            ////-----LECTURAS-----////
        public static ArrayList<Reserva> leerReservas() throws IOException {
            ArrayList<Reserva> reservas = new ArrayList<Reserva>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("reservas"));

            try {
                Gson gson = new Gson();
                reservas = gson.fromJson(bufferedReader, new TypeToken<ArrayList<Reserva>>(){}.getType());
            } finally {
                bufferedReader.close();
            }

            return reservas;
        }

        public static ArrayList<Persona> leerPersonas() throws IOException {
                ArrayList<Persona> personas = new ArrayList<Persona>();
                BufferedReader bufferedReader = new BufferedReader(new FileReader("personas"));

                PersonaDeserializer deserializer = new PersonaDeserializer("className");
                deserializer.registerBarnType("Pasajero", Pasajero.class);
                deserializer.registerBarnType("Recepcion", Recepcion.class);
                deserializer.registerBarnType("Administrador", Administrador.class);
                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(Persona.class, deserializer)
                        .create();

                personas = gson.fromJson(bufferedReader, new TypeToken<ArrayList<Persona>>(){}.getType());
        return personas;
        }

        public static ArrayList<Habitacion> leerHabitaciones() throws IOException {
            ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("habitaciones"));

            try {
                Gson gson = new Gson();
                habitaciones = gson.fromJson(bufferedReader, new TypeToken<ArrayList<Habitacion>>(){}.getType());
            } finally {
                bufferedReader.close();
            }

            return habitaciones ;
        }

        public static Backup leerBackup() throws IOException {
            ArrayList<Persona> personasBackup = leerPersonas();
            ArrayList<Reserva> reservasBackup = leerReservas();
            ArrayList<Habitacion> habitacionesBackup = leerHabitaciones();
            Backup backup = new Backup(personasBackup,habitacionesBackup,reservasBackup);
            return backup ;
        }
}