package com.company.Hotel;

public class Consumible extends GastoAdicional{
        private TipoDeProducto producto;


    public enum TipoDeProducto{
        Coca_cola,
        Sprite,
        Agua_mineral,
        Red_Bull,
        Cerveza,
        Champagne,
        Fernet,
        Vodka,
        Rocklets,
        Chocolate_Aguila,
        Sugus,
        Oreo
    }

    public TipoDeProducto getProducto() {
        return producto;
    }

    public void setProducto(TipoDeProducto producto) {
        this.producto = producto;
    }
}
