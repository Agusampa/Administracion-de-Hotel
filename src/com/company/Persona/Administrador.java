package com.company.Persona;

import java.util.Objects;

public class Administrador extends Recepcionista{
    private String passwordAdministrador;

    public Administrador(String passwordConserje, double sueldo, String idEmpleado, String passwordAdministrador) {
        super(passwordConserje, sueldo, idEmpleado);
        this.passwordAdministrador = passwordAdministrador;
    }

    public Administrador(String nombre, String apellido, String password, String dni, String passwordConserje, double sueldo, String idEmpleado, String passwordAdministrador) {
        super(nombre, apellido, password, dni, passwordConserje, sueldo, idEmpleado);
        this.passwordAdministrador = passwordAdministrador;
    }

    public String getPasswordAdministrador() {
        return passwordAdministrador;
    }

    public void setPasswordAdministrador(String passwordAdministrador) {
        this.passwordAdministrador = passwordAdministrador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Administrador)) return false;
        if (!super.equals(o)) return false;
        Administrador that = (Administrador) o;
        return Objects.equals(getPasswordAdministrador(), that.getPasswordAdministrador());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPasswordAdministrador());
    }


    @Override
    public String toString() {
        return "Administrador{" +
                "passwordAdministrador='" + passwordAdministrador + '\'' +
                '}';
    }
}

