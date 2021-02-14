package com.company.Menu.NowaGra.GraBot;

import com.company.Menu.NowaGra.PrzyciskZatwierdzStrzal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrzyciskZatwierdzStrzalBot extends PrzyciskZatwierdzStrzal implements ActionListener {
    OknoGraBot oknoGraBot;

    public PrzyciskZatwierdzStrzalBot(OknoGraBot oknoGraBot) {
        super(oknoGraBot);
        this.oknoGraBot = oknoGraBot;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = oknoGraBot.gracz.punktStrzalu[0];
        int j = oknoGraBot.gracz.punktStrzalu[1];
        if (!oknoGraBot.gracz.strzel(i, j, oknoGraBot.przeciwnik)) {
            oknoGraBot.przeciwnik.losowyStrzal(oknoGraBot.gracz);
        }
        oknoGraBot.strzal(i,j);
    }
}
