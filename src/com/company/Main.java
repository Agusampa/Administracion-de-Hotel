package com.company;

import com.company.Hotel.Consumibles.Consumible;
import com.company.Hotel.Consumibles.Platillo;
import org.joda.time.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception  {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

        Date firstDate = sdf.parse("04/22/2020");
        Date secondDate = sdf.parse("04/24/2022");

        long diferecia = firstDate.getTime() - secondDate.getTime();
        TimeUnit time = TimeUnit.DAYS;

        long cantidadDeDias = time.convert(diferecia, TimeUnit.MILLISECONDS);

        System.out.println(cantidadDeDias);

        //Menu menu = new Menu();

        //menu.menuPrincipal();
/*
        System.out.println("TODAS LAS BEBIDAS ");
        for(Platillo b : Platillo.values()){
            System.out.println(b.toString());
        }
*/


    }
}
