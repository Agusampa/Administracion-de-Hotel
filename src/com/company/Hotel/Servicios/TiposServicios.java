package com.company.Hotel.Servicios;

public enum TiposServicios {
    GIMNASIO(360),
    PILETA(400),
    JACUZZI(320),
    SPA(580),
    SAUNA(440),
    MASAGE(440),
    LAVANDERIA(300),
    SALA_DE_REUNIONES(600),
    SALA_TENIS(1500),
    PAINTBALL(680),
    PARQUE_ACUATICO(680); ///SI SE GUSTA,AGREAGAR MAS
    private float precio;

    TiposServicios(float precio){
        this.precio = precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public float getPrecio() {
        return this.precio;
    }

    @Override
    public String toString() {
        return "Tipo de Servicio: " + this.name() +
                "    Precio: " + this.precio ;
    }

}
