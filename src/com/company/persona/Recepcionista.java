package com.company.Persona;

public class Recepcionista extends Persona {
    private String passwordConserje;
    private double sueldo;
    private String idEmpleado;

    public Recepcionista(String passwordConserje, double sueldo, String idEmpleado) {
        this.passwordConserje = passwordConserje;
        this.sueldo = sueldo;
        this.idEmpleado = idEmpleado;
    }

    public Recepcionista(String nombre, String apellido, String password, String dni, String passwordConserje, double sueldo, String idEmpleado) {
        super(nombre, apellido, password, dni);
        this.passwordConserje = passwordConserje;
        this.sueldo = sueldo;
        this.idEmpleado = idEmpleado;
    }

    public String getpasswordConserje() {
        return passwordConserje;
    }

    public void setpasswordConserje(String passwordConserje) {
        this.passwordConserje = passwordConserje;
    }

    @Override
    public String toString() {
        return "Conserje:" +"\n"
                + super.toString()+
                "\n Password Conserje: " + this.passwordConserje+
                "\nSueldo: "+ this.sueldo+
                "\nId Empleado: "+ this.idEmpleado;
    }
}
