package com.company.Hotel.Consumibles;

public enum Platillo {
    ///ARGENTINA
    PARRILLADA(2190,"Consta de asado,bife de chorizo,pechito de cerdo,chorizo vacuno y de cerdo,pollo,chinchulines y guarnicion a elegir"),
    LOCRO(650,"Especie de sopa espesa y abundante hecha de maíz, frijoles, patatas, calabaza y algún tipo de carne, condimentados con comino, laurel, ajo, perejil y otras hierbas."),
    EMPANADA(80,"Trozos de masa con relleno.Entre las variedades a elegir pueden ser de Carne,Pollo,Jamon y Queso o Maiz y salsa blanca"),
    ARROLLADO_DE_MATAMBRE(1300,"Rollo de carne relleno con verduras,huevo,jamon y queso"),
    HUMITA(300,"Masa hecha de pimiento,cebolla,queso,azucar,harina de humita y Maiz en su totalidad"),
    TAMALES(380,"Bola de masa de maiz rellena con carne,cebola,pimientos"),
    ////ITALIA
    ESPAGUETI(450,"Espagueti con salsa bolognesa y albondigas"),
    PIZZA(660,"Pizza con salsa de tomate y muzzarella"),
    LASAGNA(540,"Laminas de pasta con relleno en medio de salsa bolognesa y verduras"),
    ///MEXICO
    TACO(1500,"Tortilla con relleno a eleccion,consta de 6 unidades y la mesada para que se forme su propio taco"),
    POZOLE(780,"Caldo hecho a base de granos de maiz cacahuazintle, rábano, lechuga, cebolla, salsa picante, limón, chile piquín, orégano,palta, chicharrón y carne de pollo o cerdo,a eleccion"),
    ENCHILADAS(700,"Tortilla de maiz tortilla de maíz enrollada y bañada en salsa picante utilizando chile en su preparación,rellena con carne vacuna o polluna"),
    MOLE(500,"Varios tipos de salsa picante muy condimentadas hechas a base de chiles y diversas especies,todo espesado en con masa de maiz");

    ///SI SE GUSTA,AGREAGAR MAS
    private float precio;
    private String descripcion;

    Platillo(float precio, String descripcion){
        this.precio = precio;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "\nPlatillo: " + this.name() +
               "\nPrecio: " + this.precio +
               "\nDescripcion: " +this.descripcion;
    }

    public float getPrecio() {
        return this.precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
