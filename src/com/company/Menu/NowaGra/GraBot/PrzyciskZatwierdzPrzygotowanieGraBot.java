package com.company.Menu.NowaGra.GraBot;

import com.company.Menu.NowaGra.OknoNowaGra;
import com.company.Menu.NowaGra.PrzygotowanieGry.OknoPrzygotowanieGry;
import com.company.Menu.NowaGra.PrzygotowanieGry.PrzyciskZatwierdzPrzygotowanie;
import com.company.Menu.NowaGra.SzybkaGra.OknoPrzygotowanieSzybkaGra;
import com.company.Menu.NowaGra.SzybkaGra.OknoSzybkaGra;
import com.company.Menu.Ustawienia.OknoUstawienia;
import com.company.OknoBazowe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrzyciskZatwierdzPrzygotowanieGraBot extends PrzyciskZatwierdzPrzygotowanie implements ActionListener {
    private OknoGraBot oknoGraBot;
    private OknoPrzygotowanieGraBot oknoPrzygotowanieGraBot;

    public PrzyciskZatwierdzPrzygotowanieGraBot(int pozostalo, OknoBazowe oknBazowe, OknoNowaGra oknNowaGra, OknoUstawienia oknUstawienia, OknoPrzygotowanieGry oknPrzygotowanieGry) {
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
                oknoGraBot = new OknoGraBot(oknoBazowe, oknoNowaGra, oknoUstawienia, oknoBazowe.gracz1, oknoBazowe.gracz2);
                oknoBazowe.getContentPane().removeAll();
                oknoBazowe.getContentPane().add(oknoGraBot);
                oknoBazowe.revalidate();
                oknoBazowe.repaint();
            }
            else {
                oknoBazowe.gracz2.reset(oknoUstawienia.rozmiarPlanszy, oknoUstawienia.liczbaStatkow);
                oknoBazowe.gracz2.setUlozenieStatkow(oknoPrzygotowanieGry.macierzWcisniec);
                oknoPrzygotowanieGraBot = new OknoPrzygotowanieGraBot(oknoBazowe, oknoNowaGra, oknoUstawienia, pozostalePrzygotowania-1);
                oknoBazowe.getContentPane().removeAll();
                oknoBazowe.getContentPane().add(oknoPrzygotowanieGraBot);
                oknoBazowe.revalidate();
                oknoBazowe.repaint();
            }
        }
    }
}
