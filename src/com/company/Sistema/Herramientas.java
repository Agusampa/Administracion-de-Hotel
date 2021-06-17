package com.company.Sistema;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Herramientas {


    public static LocalDate fechaAleatoria(){
        LocalDate startDate = LocalDate.of(2021, 7, 1);
        long start = startDate.toEpochDay();

        LocalDate endDate = LocalDate.of(2022, 1, 1);
        long end = endDate.toEpochDay();

        long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();

        LocalDate aleatorio = (LocalDate.ofEpochDay(randomEpochDay));

        return aleatorio;
    }
    public static boolean controlFecha(int mes,int dia){
        boolean rt = true;
        switch (mes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(dia > 31 || dia <= 0){
                    rt = false;
                }
                break;
            case 2:
                if(dia > 28  || dia <= 0){
                    rt = false;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if(dia > 30  || dia <= 0){
                    rt = false;
                }
                break;
        }
        return rt;

    }

    public static boolean controlMesTop(int mes,int dia){
        boolean rt = true;
        switch (mes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(dia == 31){
                    rt = false;
                }
                break;
            case 2:
                if(dia == 28){
                    rt = false;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if(dia == 30){
                    rt = false;
                }
                break;
        }
        return rt;
    }


    public static boolean controlDNIEsUnINT(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }



}
