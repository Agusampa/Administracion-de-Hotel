package com.company.Persona;

import java.util.Objects;

public class Pasajero extends Persona{
        private String origen;
        private String domicilio;

        ////-----CONSTRUCTOR-----////
        public Pasajero(String nombre, String apellido, String password, String dni, String origen, String domicilio) {
            super(nombre, apellido, password, dni);
            this.className = "Pasajero";
            this.origen = origen;
            this.domicilio = domicilio;
        }

                     ////-----GETTER AND SETTER-----////
            public String getNombre() {
                return nombre;
            }
            public void setNombre(String nombre) {
                this.nombre = nombre;
            }

            public String getApellido() {
                return apellido;
            }
            public void setApellido(String apellido) {
                this.apellido = apellido;
            }

            public String getPassword() {
                return password;
            }
            public void setPassword(String password) {
                this.password = password;
            }

            public String getDni() {
                return dni;
            }
            public void setDni(String dni) {
                this.dni = dni;
            }

            public String getOrigen() {
                return origen;
            }
            public void setOrigen(String origen) {
                this.origen = origen;
            }

            public String getDomicilio() {
                return domicilio;
            }
            public void setDomicilio(String domicilio) {
                this.domicilio = domicilio;
            }

            ////-----METODOS-----////
            @Override
            public String toString() {
                return super.toString() +
                       "\nOrigen: " + this.origen +
                       "\nDomicilio: " + this.domicilio;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Pasajero)) return false;
                if (!super.equals(o)) return false;
                Pasajero pasajero = (Pasajero) o;
                return Objects.equals(origen, pasajero.origen) && Objects.equals(domicilio, pasajero.domicilio);
            }

            @Override
            public int hashCode() {
                return Objects.hash(super.hashCode(), origen, domicilio);
            }
}
