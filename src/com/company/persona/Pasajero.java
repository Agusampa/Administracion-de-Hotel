package com.company.persona;

public class Pasajero extends Persona{
    private String origen;
    private String domicilio;

    public Pasajero(String nombre, String apellido, String password, String dni, String origen, String domicilio) {
        super(nombre, apellido, password, dni);
        this.origen = origen;
        this.domicilio = domicilio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Pasajero{" +
                "origen='" + origen + '\'' +
                ", domicilio='" + domicilio + '\'' +
                '}';
    }
}
