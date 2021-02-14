package com.company.Menu.NowaGra.GraBot;

import com.company.Gracz;
import com.company.Menu.NowaGra.OknoGra;
import com.company.Menu.NowaGra.OknoNowaGra;

import com.company.Menu.NowaGra.PrzyciskZatwierdzStrzal;
import com.company.Menu.NowaGra.PrzygotowanieGry.PanelInfo;
import com.company.Menu.NowaGra.PrzygotowanieGry.StatkiInfo;
import com.company.Menu.Ustawienia.OknoUstawienia;
import com.company.OknoBazowe;
import com.company.Tlo;

import javax.swing.*;
import java.awt.*;
import java.time.temporal.JulianFields;

public class OknoGraBot extends OknoGra {

    public OknoGraBot (OknoBazowe oknoBazowe, OknoNowaGra oknoNowaGra, OknoUstawienia oknoUstawienia, Gracz gracz, Gracz przeciwnik) {
        super(oknoBazowe, oknoNowaGra, oknoUstawienia, gracz, przeciwnik);

        przyciskZatwierdzStrzal = new PrzyciskZatwierdzStrzalBot(this);
        this.add(przyciskZatwierdzStrzal);
    }

}
