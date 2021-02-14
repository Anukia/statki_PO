package com.company.Menu.NowaGra.SzybkaGra;

import com.company.Gracz;
import com.company.Menu.NowaGra.OknoNowaGra;
import com.company.Menu.NowaGra.PrzygotowanieGry.OknoPrzygotowanieGry;
import com.company.Menu.NowaGra.PrzygotowanieGry.PrzyciskZatwierdzPrzygotowanie;
import com.company.Menu.Ustawienia.OknoUstawienia;
import com.company.OknoBazowe;
import com.company.Tlo;

public class OknoPrzygotowanieSzybkaGra extends OknoPrzygotowanieGry {


    public OknoPrzygotowanieSzybkaGra(OknoBazowe oknBazowe, OknoNowaGra oknoNowaGra, OknoUstawienia oknoUstawienia, int pozostalePrzygotowania) {
        super(oknBazowe, oknoNowaGra, oknoUstawienia, pozostalePrzygotowania);

        przyciskZatwierdzPrzygotowanie = new PrzyciskZatwierdzPrzygotowanieSzybkaGra(pozostalePrzygotowania, this.oknoBazowe, oknoNowaGra, oknoUstawienia, this);
        this.add(przyciskZatwierdzPrzygotowanie);

        Tlo tlo = new Tlo(this);
    }
}
