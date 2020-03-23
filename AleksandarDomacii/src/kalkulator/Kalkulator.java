package kalkulator;

import java.util.Scanner;

public class Kalkulator {

    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void pokreni() {
        System.out.println("Izaberite koju operaciju zelite da uradite:");
        System.out.println("1 za zbir");
        System.out.println("2 za razliku");
        System.out.println("3 za proizvod");
        System.out.println("4 za kolicnik.");
        System.out.println("Vas izbor:");

        Scanner skener = new Scanner(System.in);
        String izbor = skener.nextLine();  // ucitavamo korisnikov unos sa tastature

        System.out.println(racunaj(izbor));

    }

    private String racunaj(String i) {
        switch (i) { 
            case "1": 
                System.out.println("Izabrali ste zbir.");
                if (unos() == 1) { // metoda unos ima povratnu vrednost 0 ili 1. 1 je kada je sve ok a 0 ako nije.
                    return "Zbir je " + (x + y);
                } else {
                    return "";
                }

            case "2":
                System.out.println("Izabrali ste razliku.");
                if (unos() == 1) {
                    return "Razlika je " + (x - y);
                } else {
                    return "";
                }

            case "3":
                System.out.println("Izabrali ste proizvod.");
                if (unos() == 1) {
                    return "Proizvod je " + (x * y);
                } else {
                    return "";
                }

            case "4":
                System.out.println("Izabrali ste kolicnik.");
                if (unos() == 1) {
                    if (y == 0) {
                        System.out.println("Ne mozete deliti nulom.");
                        return "";
                    }
                    return "Kolicnik je " + (x / y);
                } else {
                    return "";
                }

        }
        return "niste uneli ni jednu od opcija";
    }

    public int unos() {
        System.out.println("Unesite prvi broj:");
        Scanner skener = new Scanner(System.in);
        String xStr = skener.nextLine();

        System.out.println("Unesite drugi broj:");
        String yStr = skener.nextLine();
        
        
        
        
        try {
            setX(Double.parseDouble(xStr));
            setY(Double.parseDouble(yStr));

            return 1;

        } catch (NumberFormatException e) {
            System.out.println("Niste lepo uneli neki od brojeva. Pokusajte ponovo.");
            return 0;
        }
    }
}

