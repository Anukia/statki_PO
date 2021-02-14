package com.company.OknoLogowania;

import com.company.Menu.OknoMenu;
import com.company.TOP10;
import com.company.Tlo;
import com.company.Tytul;
import com.company.OknoBazowe;

import javax.swing.*;


public class OknoLogowania extends JPanel {

    TOP10 top10;
    Tytul tytul;
    PanelLogowania panelLogowania;
    PanelRejestracji panelRejestracji;
    OknoMenu oknoMenu;

    public OknoLogowania(OknoBazowe oknoBazowe) {

        oknoMenu = new OknoMenu(oknoBazowe, this);

        this.setBounds(0, 0, 1600, 900);
        this.setOpaque(false);
        this.setLayout(null);

        tytul = new Tytul();
        this.add(tytul);

        top10 = new TOP10(this, oknoBazowe);
        this.add(top10);

        panelLogowania = new PanelLogowania(oknoBazowe, oknoMenu);
        this.add(panelLogowania);

        panelRejestracji = new PanelRejestracji(oknoBazowe);
        this.add(panelRejestracji);

        Tlo tlo = new Tlo(this);
    }
}
