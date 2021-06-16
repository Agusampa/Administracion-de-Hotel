package com.company.Persona;

public class Recepcion extends Persona{
        ////-----CONSTRUCTOR-----////
        public Recepcion(String nombre, String apellido, String password, String dni) {
            super(nombre,apellido,password,dni);
            this.className = "Recepcion";
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

        ////-----METODOS-----////
        @Override
        public String toString() {
            return super.toString();
        }
}
