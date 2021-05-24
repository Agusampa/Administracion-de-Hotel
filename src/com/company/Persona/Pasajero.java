package com.company.Persona;

public class Pasajero extends Persona{
    private String origen;
    private String domicilio;

    public Pasajero(){
    }

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
                "nombre='" + super.getNombre() + '\'' +
                ", apellido='" + super.getApellido() + '\'' +
                ", password='" + super.getPassword() + '\'' +
                ", dni='" + super.getDni() + '\'' +
                "origen='" + origen + '\'' +
                ", domicilio='" + domicilio + '\'' +
                '}';
    }
}
