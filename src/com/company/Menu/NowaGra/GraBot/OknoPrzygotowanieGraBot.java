package com.company.Menu.NowaGra.GraBot;

import com.company.Gracz;
import com.company.Menu.NowaGra.OknoNowaGra;
import com.company.Menu.NowaGra.PrzygotowanieGry.OknoPrzygotowanieGry;
import com.company.Menu.NowaGra.PrzygotowanieGry.PrzyciskZatwierdzPrzygotowanie;
import com.company.Menu.NowaGra.SzybkaGra.PrzyciskZatwierdzPrzygotowanieSzybkaGra;
import com.company.Menu.Ustawienia.OknoUstawienia;
import com.company.OknoBazowe;
import com.company.Tlo;

public class OknoPrzygotowanieGraBot extends OknoPrzygotowanieGry {

    public OknoPrzygotowanieGraBot(OknoBazowe oknBazowe, OknoNowaGra oknoNowaGra, OknoUstawienia oknoUstawienia, int pozostalePrzygotowania) {
        super(oknBazowe, oknoNowaGra, oknoUstawienia, pozostalePrzygotowania);

        przyciskZatwierdzPrzygotowanie = new PrzyciskZatwierdzPrzygotowanieGraBot(pozostalePrzygotowania, this.oknoBazowe, oknoNowaGra, oknoUstawienia, this);
        this.add(przyciskZatwierdzPrzygotowanie);

        Tlo tlo = new Tlo(this);
    }
}
