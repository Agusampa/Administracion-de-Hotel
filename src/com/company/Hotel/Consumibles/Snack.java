package com.company.Hotel.Consumibles;

public enum Snack {
        OREOS(94),
        OPERA(79),
        PEPITOS(91),
        RUMBA(50),
        REX(100),
        SALADIX(90),
        EXPRESS(60),
        CRIOLLITAS(80),
        ALFAJOR(75),
        BOMBON(40),
        CHICLES(80); ///SI SE GUSTA,AGREAGAR MAS
        private float precio;

        ////-----CONSTRUCTOR-----////
        Snack(float precio){
            this.precio = precio;
        }

        ////-----GETTER AND SETTER-----////
        public float getPrecio(){
            return this.precio;
        }
        public void setPrecio(float precio) {
            this.precio = precio;
        }

        ////-----METODOS-----////
        @Override
        public String toString(){
            return "Snack: " + this.name() + "    Precio: " + this.precio ;
        }

}
