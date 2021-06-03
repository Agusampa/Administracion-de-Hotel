package com.company.Hotel.Consumibles;

import com.company.Hotel.GastoAdicional;
import java.time.LocalDateTime;

public class Consumible extends GastoAdicional {

        ////-----CONSTRUCTOR-----////
        public Consumible(LocalDateTime fijo,String nombre, float precio, int cantidad) {
            super(fijo,nombre,precio, cantidad);
        }
}
