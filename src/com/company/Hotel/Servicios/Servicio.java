package com.company.Hotel.Servicios;

import com.company.Hotel.GastoAdicional;
import java.time.LocalDateTime;

public class Servicio extends GastoAdicional {

        ////-----CONSTRUCTOR-----////
        public Servicio(LocalDateTime fijo,String nombre, float costo, int cantidad) {
            super(fijo,nombre,costo, cantidad);
        }

}
