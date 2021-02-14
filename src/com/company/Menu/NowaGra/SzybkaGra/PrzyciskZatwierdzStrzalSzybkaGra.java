package com.company.Menu.NowaGra.SzybkaGra;

import com.company.Menu.NowaGra.GraBot.OknoGraBot;
import com.company.Menu.NowaGra.PrzyciskStrzelanie;
import com.company.Menu.NowaGra.PrzyciskZatwierdzStrzal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrzyciskZatwierdzStrzalSzybkaGra extends PrzyciskZatwierdzStrzal implements ActionListener {
    OknoSzybkaGra oknoSzybkaGra;

    public PrzyciskZatwierdzStrzalSzybkaGra(OknoSzybkaGra oknoSzybkaGra) {
        super(oknoSzybkaGra);
        this.oknoSzybkaGra = oknoSzybkaGra;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = oknoSzybkaGra.gracz.punktStrzalu[0];
        int j = oknoSzybkaGra.gracz.punktStrzalu[1];
        oknoSzybkaGra.strzal(i,j);
        if (!oknoSzybkaGra.gracz.strzel(i, j, oknoSzybkaGra.przeciwnik)) {
            oknoSzybkaGra = new OknoSzybkaGra(oknoSzybkaGra.oknoBazowe, oknoSzybkaGra.oknoNowaGra, oknoSzybkaGra.oknoUstawienia, oknoSzybkaGra.przeciwnik, oknoSzybkaGra.gracz);
            oknoSzybkaGra.oknoBazowe.getContentPane().removeAll();
            oknoSzybkaGra.oknoBazowe.getContentPane().add(oknoSzybkaGra);
            oknoSzybkaGra.oknoBazowe.revalidate();
            oknoSzybkaGra.oknoBazowe.repaint();
        }
    }
}
