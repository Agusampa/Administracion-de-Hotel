package com.company.Persona;


public class Administrador extends Recepcion {

    ///CONSTRUCTOR
    public Administrador(String nombre, String apellido, String password, String dni,float sueldo) {
        super(nombre,apellido,password,dni,sueldo);
    }
    public Administrador(String nombre, String apellido, String password, String dni) {
        super(nombre,apellido,password,dni);
    }

    ///METODOS
    @Override
    public String toString() {
        return super.toString();
    }
}