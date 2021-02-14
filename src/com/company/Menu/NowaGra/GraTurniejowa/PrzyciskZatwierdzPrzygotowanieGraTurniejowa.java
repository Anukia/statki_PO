package com.company.Menu.NowaGra.GraTurniejowa;

import com.company.Menu.NowaGra.OknoNowaGra;
import com.company.Menu.NowaGra.PrzygotowanieGry.OknoPrzygotowanieGry;
import com.company.Menu.NowaGra.PrzygotowanieGry.PrzyciskZatwierdzPrzygotowanie;
import com.company.Menu.NowaGra.SzybkaGra.OknoPrzygotowanieSzybkaGra;
import com.company.Menu.NowaGra.SzybkaGra.OknoSzybkaGra;
import com.company.Menu.Ustawienia.OknoUstawienia;
import com.company.OknoBazowe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrzyciskZatwierdzPrzygotowanieGraTurniejowa extends PrzyciskZatwierdzPrzygotowanie implements ActionListener {
    private OknoGraTurniejowa oknoGraTurniejowa;
    private OknoPrzygotowanieGraTurniejowa oknoPrzygotowanieGraTurniejowa;

    public PrzyciskZatwierdzPrzygotowanieGraTurniejowa(int pozostalo, OknoBazowe oknBazowe, OknoNowaGra oknNowaGra, OknoUstawienia oknUstawienia, OknoPrzygotowanieGry oknPrzygotowanieGry) {
        super(pozostalo, oknBazowe, oknNowaGra, oknUstawienia, oknPrzygotowanieGry);
        this.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            if (this.pozostalePrzygotowania == 0) {
                oknoNowaGra.zegar.wyzeruj();
                oknoBazowe.gracz1.reset(oknoUstawienia.rozmiarPlanszy, oknoUstawienia.liczbaStatkow);
                oknoBazowe.gracz1.setUlozenieStatkow(oknoPrzygotowanieGry.macierzWcisniec);
                oknoGraTurniejowa = new OknoGraTurniejowa(oknoBazowe, oknoNowaGra, oknoUstawienia, oknoBazowe.gracz1, oknoBazowe.gracz2);
                oknoBazowe.getContentPane().removeAll();
                oknoBazowe.getContentPane().add(oknoGraTurniejowa);
                oknoBazowe.revalidate();
                oknoBazowe.repaint();
            }
            else {
                oknoBazowe.gracz2.reset(oknoUstawienia.rozmiarPlanszy, oknoUstawienia.liczbaStatkow);
                oknoBazowe.gracz2.setUlozenieStatkow(oknoPrzygotowanieGry.macierzWcisniec);
                oknoPrzygotowanieGraTurniejowa = new OknoPrzygotowanieGraTurniejowa(oknoBazowe, oknoNowaGra, oknoUstawienia, pozostalePrzygotowania-1);
                oknoBazowe.getContentPane().removeAll();
                oknoBazowe.getContentPane().add(oknoPrzygotowanieGraTurniejowa);
                oknoBazowe.revalidate();
                oknoBazowe.repaint();
            }
        }
    }
}
