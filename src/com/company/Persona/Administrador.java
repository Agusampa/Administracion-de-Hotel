package com.company.Persona;

import java.util.Objects;

public class Administrador extends Recepcionista {

    ///CONSTRUCTOR
    public Administrador(String nombre, String apellido, String password, String dni,float sueldo) {
        super(nombre,apellido,password,dni,sueldo);
    }

    ///METODOS
    @Override
    public String toString() {
        return super.toString();
    }
}