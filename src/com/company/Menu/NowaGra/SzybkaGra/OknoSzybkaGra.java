package com.company.Menu.NowaGra.SzybkaGra;

import com.company.Gracz;
import com.company.Menu.NowaGra.*;
import com.company.Menu.NowaGra.GraBot.PrzyciskZatwierdzStrzalBot;
import com.company.Menu.Ustawienia.OknoUstawienia;
import com.company.OknoBazowe;
import com.company.Tlo;

import javax.swing.*;
import java.awt.*;

public class OknoSzybkaGra extends OknoGra {

    public OknoSzybkaGra (OknoBazowe oknoBazowe, OknoNowaGra oknoNowaGra, OknoUstawienia oknoUstawienia, Gracz gracz, Gracz przeciwnik){
        super(oknoBazowe, oknoNowaGra, oknoUstawienia, gracz, przeciwnik);

        przyciskZatwierdzStrzal = new PrzyciskZatwierdzStrzalSzybkaGra(this);
        this.add(przyciskZatwierdzStrzal);
    }
}


