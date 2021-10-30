package net.sevecek.turtle;

import net.sevecek.turtle.engine.*;

import java.awt.*;

public class HlavniProgram {
    Turtle zofka;
    public void main(String[] args) {

        double velikostStranyC;
        double uhelMeziRamenyAB = 40;
        double velikostStranyA = 100;
        velikostStranyC = Math.abs((velikostStranyA
                * Math.sin((uhelMeziRamenyAB * Math.PI / 180.0) / 2.0))
                * 2.0);

        System.out.println("velikost strany c je " + velikostStranyC);

        zofka = new Turtle();

        Color cervenaBarva = new Color(255,0,0);
        Color zlutaBarva = new Color(255,255,0);
        Color limetkovaBarva = new Color(0,255,0);
        Color cernaBarva = new Color(0,0,0);

        // traktor

        zofka.setLocation(400,100);
        obdelnik(50,100,zlutaBarva);
        zofka.setLocation(510,100);
        obdelnik(100,80,cernaBarva);
        zofka.setLocation(400,120);
        koleckojedna(40,550,100,limetkovaBarva);
        koleckojedna(15,425,125,cervenaBarva);
        koleckojedna(15,475,125,cervenaBarva);
        zofka.setLocation(340,120);
        zofka.turnLeft(30);
        Trojuhelnikrovnoramennyjedna(50,50,70.7);
        zofka.turnRight(45);

        //zmrzlina

        zofka.setLocation(500,200);
        zofka.turnLeft(110);
        Trojuhelnikrovnoramennydva(100,100,68.4);
        koleckojedna(33,534,200,zlutaBarva);

        //snehulak

        koleckojedna(60,200,100,cernaBarva);
        koleckojedna(80,200,240,cernaBarva);
        koleckojedna(100,200,420,cernaBarva);
        koleckojedna(30,310,240,cernaBarva);
        koleckojedna(30,90,240,cernaBarva);


    }



    public void Trojuhelnikrovnoramennyjedna(double velikostStranya,
                                             double velikostStranyb,
                                             double velikostStranyc) {

        zofka.penDown();
        zofka.move(velikostStranya);
        zofka.turnLeft(90);
        zofka.move(velikostStranyb);
        zofka.turnLeft(135);
        zofka.move(velikostStranyc);
    }

    public void Trojuhelnikrovnoramennydva(double velikostStranya,
                                           double velikostStranyb,
                                           double velikostStranyc) {

        zofka.penDown();
        zofka.move(velikostStranya);
        zofka.turnLeft(140);
        zofka.move(velikostStranyb);
        zofka.turnLeft(110);
        zofka.move(velikostStranyc);

    }

    public void ctverec(double velikostStrany, Color barva) {

        for (int i = 0; i < 4; i++) {
            zofka.setPenColor(barva);
            zofka.penDown();
            zofka.move(velikostStrany);
            zofka.turnRight(90);
        }

    }

    public void obdelnik(double velikostStranya, double velikostStranyb, Color barva) {

        for (int i = 0; i < 2; i++) {
            zofka.setPenColor(barva);
            zofka.penDown();
            zofka.move(velikostStranya);
            zofka.turnRight(90);
            zofka.move(velikostStranyb);
            zofka.turnRight(90);
        }
    }

    public void koleckojedna(double velikostPolomeru, double poziceX, double poziceY, Color barva) {


        for (int i = 0; i < 400; i++) {

            zofka.setLocation(poziceX,poziceY);
            zofka.setPenColor(barva);
            zofka.penUp();
            zofka.move(velikostPolomeru);
            zofka.penDown();
            zofka.turnRight(1);
            zofka.move(1);
            zofka.penUp();
        }  }

    public void koleckodva(double velikostPolomeru, double poziceX, double poziceY, Color barva) {

        //tohle kolečko mi bohužel nefunguje správně,
        //zkousela jsem, jestli nemelo zustat v doublu, ale ani tak nefunguje.
        //pri malém obvodu se nedodělá a při velkém se přetáhne.
        //asi to bude něco naprosto logického, ale bohužel, nedochází mi to, chybí
        //pár mozkových synapsí

        double obvod = 2 * Math.PI * velikostPolomeru;
        int o = (int) obvod;

        int i; i = 0;
        while (i <= o) {

            zofka.setLocation(poziceX,poziceY);
            zofka.setPenColor(barva);
            zofka.penUp();
            zofka.move(velikostPolomeru);
            zofka.penDown();
            zofka.turnRight(1);
            zofka.move(1);
            zofka.penUp();i++;} }

}
