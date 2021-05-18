package com.company.persona;

import java.util.Objects;

public class Administrador extends Empleado{
    private String passwordAdministrador;

    public Administrador(String nombre, String apellido, String password, String dni, double sueldo, String idEmpleado, String passwordAdministrador) {
        super(nombre, apellido, password, dni, sueldo, idEmpleado);
        this.passwordAdministrador = passwordAdministrador;
    }

    public String getPasswordAdministrador() {
        return passwordAdministrador;
    }

    public void setPasswordAdministrador(String passwordAdministrador) {
        this.passwordAdministrador = passwordAdministrador;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "passwordAdministrador='" + passwordAdministrador + '\'' +
                '}';
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
}
