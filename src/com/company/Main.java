package com.company;
import com.company.Menus.MenuPrincipal;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        try {
            MenuPrincipal menu = new MenuPrincipal();
            menu.menuPrincipal();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
