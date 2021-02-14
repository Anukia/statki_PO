package com.company.Menu.NowaGra.GraTurniejowa;

import com.company.Menu.NowaGra.PrzyciskZatwierdzStrzal;
import com.company.Menu.NowaGra.SzybkaGra.OknoSzybkaGra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrzyciskZatwierdzStrzalGraTurniejowa extends PrzyciskZatwierdzStrzal implements ActionListener {
    OknoGraTurniejowa oknoGraTurniejowa;

    public PrzyciskZatwierdzStrzalGraTurniejowa(OknoGraTurniejowa oknoGraTurniejowa) {
        super(oknoGraTurniejowa);
        this.oknoGraTurniejowa = oknoGraTurniejowa;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = oknoGraTurniejowa.gracz.punktStrzalu[0];
        int j = oknoGraTurniejowa.gracz.punktStrzalu[1];
        oknoGraTurniejowa.strzal(i,j);
        if (!oknoGraTurniejowa.gracz.strzel(i, j, oknoGraTurniejowa.przeciwnik, 1)) {
            oknoGraTurniejowa = new OknoGraTurniejowa(oknoGraTurniejowa.oknoBazowe, oknoGraTurniejowa.oknoNowaGra, oknoGraTurniejowa.oknoUstawienia, oknoGraTurniejowa.przeciwnik, oknoGraTurniejowa.gracz);
            oknoGraTurniejowa.oknoBazowe.getContentPane().removeAll();
            oknoGraTurniejowa.oknoBazowe.getContentPane().add(oknoGraTurniejowa);
            oknoGraTurniejowa.oknoBazowe.revalidate();
            oknoGraTurniejowa.oknoBazowe.repaint();
        }
    }
}
