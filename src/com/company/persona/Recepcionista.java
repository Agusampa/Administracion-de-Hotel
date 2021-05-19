package com.company.persona;

import java.util.Objects;

public class Recepcionista {
    private String passwordRecepcionista;

    public Recepcionista(String passwordRecepcionista) {
        this.passwordRecepcionista = passwordRecepcionista;
    }

    public String getPasswordRecepcionista() {
        return passwordRecepcionista;
    }

    public void setPasswordRecepcionista(String passwordRecepcionista) {
        this.passwordRecepcionista = passwordRecepcionista;
    }

    @Override
    public String toString() {
        return "Recepcionista{" +
                "passwordRecepcionista='" + passwordRecepcionista + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recepcionista)) return false;
        Recepcionista that = (Recepcionista) o;
        return Objects.equals(getPasswordRecepcionista(), that.getPasswordRecepcionista());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPasswordRecepcionista());
    }
}
