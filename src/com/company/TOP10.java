package com.company;

import javax.swing.*;
import java.awt.*;

public class TOP10 extends JPanel {

    String[] topkaNicki;
    int[] topkaWygrane;
    JLabel[] labele;
    JLabel naglowekTekst;
    JLabel naglowekNick;
    JLabel naglowekWynik;
    RankingOgolny rankingOgolny;

    public TOP10(JPanel menu, OknoBazowe oknoBazowe) {
        this.setOpaque(true);
        this.setBackground(new Color(255,255,255,100));
        this.setBounds(1200, 100, 350, 560);
        this.setLayout(null);

        naglowekTekst = new JLabel();
        naglowekTekst.setText("TOP 10");
        naglowekTekst.setBounds(0,10, 350,80);
        naglowekTekst.setOpaque(false);
        naglowekTekst.setFont(new Font("Comic Sans MS", Font.BOLD, 45));
        naglowekTekst.setHorizontalAlignment(JLabel.CENTER);
        this.add(naglowekTekst);

        naglowekNick = new JLabel("Nazwa użytkownika");
        naglowekNick.setBounds(40,90, 200, 50);
        naglowekNick.setOpaque(false);
        naglowekNick.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        this.add(naglowekNick);

        naglowekWynik = new JLabel("Wynik");
        naglowekWynik.setBounds(240,90, 130, 50);
        naglowekWynik.setOpaque(false);
        naglowekWynik.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        this.add(naglowekWynik);


        topkaNicki = new String[10];
        topkaWygrane = new int[10];
        rankingOgolny = new RankingOgolny(oknoBazowe.odczytWyniki);
        topkaNicki = rankingOgolny.ranking;
        topkaWygrane = rankingOgolny.rankingWygrane;


        labele = new JLabel[20];
        for(int i = 0; i < 10; i++) {
            if(i==9) {
                labele[2*i] = new JLabel();
                labele[2*i].setText((i+1) + ".  " + topkaNicki[i]);
                labele[2*i].setBounds(40,140+40*i,200,40);
                labele[2*i].setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
                this.add(labele[2*i]);
            }
            else {
                labele[2 * i] = new JLabel();
                labele[2 * i].setText((i + 1) + ".   " + topkaNicki[i]);
                labele[2 * i].setBounds(40, 140 + 40 * i, 200, 40);
                labele[2 * i].setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
                this.add(labele[2 * i]);
            }

            labele[2*i+1] = new JLabel();
            labele[2*i+1].setText(String.valueOf(topkaWygrane[i]));
            labele[2*i+1].setBounds(240,140+40*i,150,40);
            labele[2*i+1].setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
            this.add(labele[2*i+1]);
        }
    }
}
