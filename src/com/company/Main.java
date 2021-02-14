package com.company;

import com.company.Menu.OknoMenu;
import com.company.Menu.NowaGra.OknoNowaGra;
import com.company.OknoLogowania.OknoLogowania;
import com.company.Menu.Ustawienia.OknoUstawienia;

public class Main {
    public static void main(String[] args) {
        /*OknoBazowe oknoBazowe = new OknoBazowe();
        OknoUstawienia oknoUstawienia = new OknoUstawienia(oknoBazowe);
        OknoNowaGra oknoNowaGra = new OknoNowaGra(oknoBazowe);
        OknoMenu oknoMenu = new OknoMenu(oknoBazowe, oknoNowaGra, oknoUstawienia);
        OknoLogowania oknoLogowania = new OknoLogowania(oknoBazowe, oknoMenu);
        oknoMenu.setOknoLogin(oknoLogowania);*/

        OknoBazowe oknoBazowe;
        OknoLogowania oknoLogowania = null;

        oknoBazowe = new OknoBazowe();
        oknoLogowania = new OknoLogowania(oknoBazowe);

        oknoBazowe.getContentPane().add(oknoLogowania);
        oknoBazowe.revalidate();
        oknoBazowe.repaint();
    }
}
