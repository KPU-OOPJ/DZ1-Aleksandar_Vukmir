package kalkulator;

import java.util.Scanner;

public class Kalkulator {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
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
        switch (i) { // ovo switch nzm jel ste radili ali to ti je isto kao da pises if vise puta za istu stvar
            case "1": // vidis ovde se pitamo da li je i 1, pa dole da li je 2 itd
                System.out.println("Izabrali ste zbir.");
                if (unos() == 1) { // metoda unos ima povratnu vrednost 0 ili 1. 1 je kada je sve ok a 0 ako nije. idi dole imas objasnjenje sto sam to stavio tako
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
                    return "Kolicnik je " + (double) (x / (double) y); // ovde smo pisali ovo double u zagradama jer u javi ako delis dva integera (sto su celi brojevi) dobijes ceo broj, a to nije tacno matematicki
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
        /* 
        prilikom unosa sa tastature on sve tretira kao da je string, ali posto nama trebaju brojevi d bi mogli da ih saberemo 
        stavljam ovaj deo Integer.parseInt dole sto vidis
        taj deo koda pretvara string u int ali ako je normalan broj unet u string. ako je uneto neko slobo ili nesto drugo sto on ne zna da 
        pretvori u broj, onda baci izuzetak. tome sluze ovi try catch delovi. kao sto vidis u ovom catch delu, ako ne uspemo da pretvorimo stirng
        u broj kako treba, nasa metoda vraca 0 kao nije u redu nesto uneto, nemoj da racunas
        */
        
        
        
        try {
            setX(Integer.parseInt(xStr));
            setY(Integer.parseInt(yStr));

            return 1;

        } catch (NumberFormatException e) {
            System.out.println("Niste lepo uneli neki od brojeva. Pokusajte ponovo.");
            return 0;
        }
    }
}
