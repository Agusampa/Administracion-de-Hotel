package com.company.Hotel;

import com.company.Persona.*;

public class Habitacion {
    private Estado status;
    private int num;
    private Pasajero hospedante;

    public enum Estado{
        DISPONIBLE,
        EN_LIMPIEZA,
        EN_REPARACION,
        EN_DESINFECCION,
        OCUPADO;
    }


    public Habitacion(){
        this.status = Estado.DISPONIBLE;
        this.num = 0;
        this.hospedante = new Pasajero();
    }

    public Habitacion(Estado status, int num, Pasajero hospedante) {
        this.status = status;
        this.num = num;
        this.hospedante = hospedante;
    }

    public Estado getStatus() {
        return this.status;
    }

    public void setStatus(Estado status) {
        this.status = status;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Pasajero getHospedante() {
        return this.hospedante;
    }

    public void setHospedante(Pasajero hospedante) {
        this.hospedante = hospedante;
    }

    @Override
    public String toString() {
        return "Habitacion:" +
                "\n Status=" + this.status +
                "\n Numero:" + this.num +
                "\n Hospedante=" + this.hospedante;
    }

}
