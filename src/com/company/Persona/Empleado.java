package com.company.Persona;

import java.util.Objects;

public abstract class Empleado extends Persona{
    private double sueldo;
    private String idEmpleado;

    public Empleado(String nombre, String apellido, String password, String dni, double sueldo, String idEmpleado) {
        super(nombre, apellido, password, dni);
        this.sueldo = sueldo;
        this.idEmpleado = idEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "sueldo=" + sueldo +
                ", idEmpleado='" + idEmpleado + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empleado)) return false;
        Empleado empleado = (Empleado) o;
        return Double.compare(empleado.getSueldo(), getSueldo()) == 0 && Objects.equals(getIdEmpleado(), empleado.getIdEmpleado());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSueldo(), getIdEmpleado());
    }
}
