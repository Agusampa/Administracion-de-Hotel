package com.company.Hotel;

public class Servicio extends GastoAdicional {
    private TipoDeServicio servicio;

    public enum TipoDeServicio{
        Gimnasio,
        Pileta,
        Jacuzzi,
        Spa,
        Sauna,
        Masages
    }

    public TipoDeServicio getServicio() {
        return servicio;
    }

    public void setServicio(TipoDeServicio servicio) {
        this.servicio = servicio;
    }
}
