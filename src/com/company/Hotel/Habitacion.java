package com.company.Hotel;

import com.company.Persona.*;

public class Habitacion {
    private TipoHabitacion tipoHabitacion;
    private int numero;
    private int capacidad;
    private double precioPorNoche;


    public enum TipoHabitacion{
        Suite,
        Premiun,
        Estandar
    }

    ///CONSTRUCTOR
    public Habitacion(TipoHabitacion tipoHabitacion, int numero, int capacidad, double precioPorNoche) {
        this.numero = numero;
        this.tipoHabitacion = tipoHabitacion;
        this.capacidad = capacidad;
        this.precioPorNoche = precioPorNoche;
    }

    ///GETTER AND SETTER
    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }
    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }
    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    ////METODOS
    @Override
    public String toString() {
        return "\nHabitacion:" +
                "\n Numero:" + this.numero +
                "\n Tipo de habitacion:"+this.tipoHabitacion+
                "\n Precio por noche: "+ this.precioPorNoche+
                "\n Capacidad: "+ this.capacidad;
    }

}
