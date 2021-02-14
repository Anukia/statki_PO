package com.company.Menu.NowaGra;

import com.company.Gracz;
import com.company.Menu.NowaGra.OknoNowaGra;
import com.company.Menu.NowaGra.PrzygotowanieGry.PanelInfo;
import com.company.Menu.NowaGra.Zegar;
import com.company.OknoBazowe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInfoGra extends PanelInfo implements ActionListener {
    JLabel czas;
    Timer timer;
    OknoNowaGra oknoNowaGra;
    OknoBazowe oknoBazowe;

    public PanelInfoGra(Gracz gracz, Gracz przeciwnik, int pozostalePrzygotowania, OknoNowaGra oknNowaGra, OknoBazowe oknBazowe) {
        super(gracz, przeciwnik, pozostalePrzygotowania);

        oknoBazowe = oknBazowe;
        oknoNowaGra = oknNowaGra;
        timer = new Timer(1000, this);
        timer.start();

        czas = new JLabel();
        czas.setBounds(950, 75, 300, 100);
        czas.setOpaque(false);
        czas.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        this.add(czas);

        czas.setText("Czas: 0s");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        czas.setText("Czas: " + String.valueOf(oknoNowaGra.zegar.getCzas())+"s");
        czas.repaint();
    }
}
