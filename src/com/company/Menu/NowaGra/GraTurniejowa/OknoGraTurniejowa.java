package com.company.Menu.NowaGra.GraTurniejowa;

import com.company.Gracz;
import com.company.Menu.NowaGra.OknoGra;
import com.company.Menu.NowaGra.OknoNowaGra;
import com.company.Menu.NowaGra.SzybkaGra.PrzyciskZatwierdzStrzalSzybkaGra;
import com.company.Menu.Ustawienia.OknoUstawienia;
import com.company.OknoBazowe;

public class OknoGraTurniejowa extends OknoGra {
    public OknoGraTurniejowa (OknoBazowe oknoBazowe, OknoNowaGra oknoNowaGra, OknoUstawienia oknoUstawienia, Gracz gracz, Gracz przeciwnik){
        super(oknoBazowe, oknoNowaGra, oknoUstawienia, gracz, przeciwnik);

        przyciskZatwierdzStrzal = new PrzyciskZatwierdzStrzalGraTurniejowa(this);
        this.add(przyciskZatwierdzStrzal);
    }
}
