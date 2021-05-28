package com.company.Persona;

import java.util.Objects;

public abstract class Persona {             ///SE DEBE AGREGAR UNA CLASE TRABAJADOR? EMPLEA MAYORIA DE ENUMS
    private String nombre;
    private String apellido;
    private String password;
    private String dni;

    public Persona(){}

    public Persona(String nombre, String apellido, String password, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.dni = dni;
    }

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

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", password='" + password + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona persona = (Persona) o;
        return Objects.equals(getNombre(), persona.getNombre()) && Objects.equals(getApellido(), persona.getApellido()) && Objects.equals(getPassword(), persona.getPassword()) && Objects.equals(getDni(), persona.getDni());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getApellido(), getPassword(), getDni());
    }
}
