package com.company.Menu;

import com.company.*;
import com.company.Menu.NowaGra.OknoNowaGra;
import com.company.Menu.Ustawienia.OknoUstawienia;
import com.company.OknoLogowania.OknoLogowania;

import javax.swing.*;

public class OknoMenu extends JPanel {
    TOP10 top10;
    Tytul tytul;
    PrzyciskiMenu przyciskiMenu;
    public ZalogowanyUzytkownik zalogowanyUzytkownik;
    Powrot powrot;
    OknoLogowania oknoLogowania;
    OknoUstawienia oknoUstawienia;
    OknoNowaGra oknoNowaGra;

    public OknoMenu(OknoBazowe oknoBazowe, OknoLogowania oknoLogowania) {

        oknoUstawienia = new OknoUstawienia(oknoBazowe, this);
        oknoNowaGra = new OknoNowaGra(oknoBazowe, this, oknoUstawienia);
        oknoBazowe.gracz1.menu = this;
        oknoBazowe.gracz2.menu = this;

        this.setBounds(0, 0, 1600, 900);
        this.setOpaque(false);
        this.setLayout(null);

        tytul = new Tytul();
        this.add(tytul);

        top10 = new TOP10(this, oknoBazowe);
        this.add(top10);

        zalogowanyUzytkownik = new ZalogowanyUzytkownik(oknoBazowe);
        this.add(zalogowanyUzytkownik);

        przyciskiMenu = new PrzyciskiMenu(this, oknoBazowe, oknoNowaGra, oknoUstawienia);
        this.add(przyciskiMenu);

        Tlo tlo = new Tlo(this);
    }
}
