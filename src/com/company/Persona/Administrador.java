package com.company.Persona;


public class Administrador extends Persona {
   // int type = 3;
        ////-----CONSTRUCTOR-----////
        public Administrador(String nombre, String apellido, String password, String dni) {
            super(nombre,apellido,password,dni);
            this.className = "Administrador";
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