package com.company.Persona;

public class Recepcion extends Persona{
    private float sueldo;

    //CONSTRUCTOR
    public Recepcion(String nombre, String apellido, String password, String dni,float sueldo) {
        super(nombre,apellido,password,dni);
        this.sueldo = sueldo;
    }
    public Recepcion(String nombre, String apellido, String password, String dni) {
        super(nombre,apellido,password,dni);
    }

    ///GETTER AND SETTER
    public float getSueldo() {
        return this.sueldo;
    }
    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    ///METODOS
    @Override
    public String toString() {
        return  this.getClass().getSimpleName()
                + super.toString()+
                "\nSueldo: "+ this.sueldo;
    }
}
