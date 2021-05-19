package com.company.Hotel;

import java.time.LocalDateTime;

public class Duracion {
    private LocalDateTime inicio;
    private LocalDateTime finalizacion;
    private int duracionDias;

    public Duracion(LocalDateTime inicio, LocalDateTime finalizacion, int duracionDias) {
        this.inicio = inicio;
        this.finalizacion = finalizacion;
        this.duracionDias = duracionDias;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }
    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFinalizacion() {
        return finalizacion;
    }
    public void setFinalizacion(LocalDateTime finalizacion) {
        this.finalizacion = finalizacion;
    }

    public int getDuracionDias() {
        return duracionDias;
    }
    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }

    public static LocalDateTime obtenerFechaTermino(){
        System.out.println("Ingresar la fecha de egreso en el siguiente formato: ");

    }
}
