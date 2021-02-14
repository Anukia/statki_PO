package com.company.Menu.NowaGra.Dologowanie;

import com.company.Menu.NowaGra.OknoNowaGra;
import com.company.Menu.NowaGra.PrzygotowanieGry.OknoPrzygotowanieGry;
import com.company.Menu.OknoMenu;
import com.company.Menu.Ustawienia.OknoUstawienia;
import com.company.OknoBazowe;
import com.company.TOP10;
import com.company.Tlo;
import com.company.Tytul;

import javax.swing.*;

public class OknoDologowania extends JPanel {
    TOP10 top10;
    Tytul tytul;
    PanelDologowania panelDologowaniaSzybkaGra;
    OknoMenu oknoMenu;

    public OknoDologowania(OknoBazowe oknoBazowe, int typGry, OknoNowaGra oknoNowaGra, OknoUstawienia oknoUstawienia) {

        this.setBounds(0, 0, 1600, 900);
        this.setOpaque(false);
        this.setLayout(null);

        tytul = new Tytul();
        this.add(tytul);

        top10 = new TOP10(this, oknoBazowe);
        this.add(top10);

        panelDologowaniaSzybkaGra = new PanelDologowania(oknoBazowe, typGry, oknoNowaGra, oknoUstawienia);
        this.add(panelDologowaniaSzybkaGra);

        Tlo tlo = new Tlo(this);
    }
}
