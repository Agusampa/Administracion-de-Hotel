package com.company.Persona;

import java.util.Objects;

public abstract class Persona {
        protected String nombre;
        protected String apellido;
        protected String password;
        protected String dni;
        protected String className = "Persona";

            ////-----CONSTRUCTOR-----////
            public Persona(){}
            public Persona(String nombre, String apellido, String password, String dni) {
                this.nombre = nombre;
                this.apellido = apellido;
                this.password = password;
                this.dni = dni;
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
                return this.getClass().getSimpleName()+
                       "\nNombre: " + this.nombre +
                       "\nApellido: " + this.apellido +
                       "\nPassword: " + this.password +
                       "\nDni: " + this.dni;
            }

}
