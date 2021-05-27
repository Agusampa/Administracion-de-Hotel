package com.company.Hotel.Consumibles;

public enum Bebida {
    COCA_COLA(75),
    FANTA(68),
    SPRITE(72),
    AGUA_MINERAL(60),
    ENERGIZANTE(131),
    CERVEZA(80),
    CHAMPAGNE(3000),
    FERNET(600),
    VODKA(5200),
    TEQUILA(5000); ///SI SE GUSTA,AGREAGAR MAS
    private float precio;

    Bebida(float precio){
        this.precio = precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Bebida: " + this.name() +
               "    Precio: " + this.precio ;
    }

}
