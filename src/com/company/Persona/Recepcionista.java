package com.company.Persona;

public class Recepcionista extends Persona {
    private String password;
    private String passwordConserje;

    public Recepcionista(String nombre, String apellido, int dni, String password, String passwordConserje) {
        super(nombre, apellido, dni);
        this.password = password;
        this.passwordConserje = passwordConserje;


    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getpasswordConserje() {
        return passwordConserje;
    }

    public void setpasswordConserje(String passwordConserje) {
        this.passwordConserje = passwordConserje;
    }

    @Override
    public String toString() {
        return "Conserje:" +"\n"
                + super.toString()+
                "\n Password:'" + this.password  +
                "\n Password Conserje: " + this.passwordConserje ;
    }
}
