package com.company.Menu.NowaGra.Turniej;

import com.company.OknoBazowe;
import com.company.Tlo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoRanking extends JPanel implements ActionListener {
    OknoBazowe oknoBazowe;
    JLabel[] nick;
    JLabel[] liczbaZwyciestw;
    JPanel panelRanking;
    JButton zatwierdz;
    OknoTurniej oknoTurniej;
    public OknoRanking(OknoBazowe oknoBazowe, OknoTurniej oknoTurniej) {
        this.setOpaque(false);
        this.setBounds(0, 0, 1600, 900);
        this.setLayout(null);
        this.oknoBazowe = oknoBazowe;
        this.oknoTurniej = oknoTurniej;

        panelRanking = new JPanel();
        panelRanking.setOpaque(false);
        panelRanking.setBounds(450, 100, 700, 700);
        panelRanking.setLayout(new GridLayout(oknoBazowe.aktualnyTurniej.liczbaGraczy,2,10,10));
        this.add(panelRanking);

        nick = new JLabel[oknoBazowe.aktualnyTurniej.liczbaGraczy];
        liczbaZwyciestw = new JLabel[oknoBazowe.aktualnyTurniej.liczbaGraczy];
        oknoBazowe.aktualnyTurniej.setRankingPosortowany();

        for (int i = 0; i < oknoBazowe.aktualnyTurniej.liczbaGraczy; i++) {
            nick[i] = new JLabel();
            nick[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
            nick[i].setHorizontalAlignment(JLabel.LEFT);
            nick[i].setText((i+1) + ".  " + oknoBazowe.aktualnyTurniej.rankingPosortowany[i][0]);
            panelRanking.add(nick[i]);
            liczbaZwyciestw[i] = new JLabel();
            liczbaZwyciestw[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
            liczbaZwyciestw[i].setHorizontalAlignment(JLabel.RIGHT);
            liczbaZwyciestw[i].setText(oknoBazowe.aktualnyTurniej.rankingPosortowany[i][1] + " zwycięstw");
            panelRanking.add(liczbaZwyciestw[i]);
        }

        zatwierdz = new JButton();
        zatwierdz.setBounds(1300, 500, 200, 70);
        zatwierdz.setText("Dalej");
        zatwierdz.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        zatwierdz.addActionListener(this);
        this.add(zatwierdz);

        Tlo tlo = new Tlo(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == zatwierdz) {
            oknoBazowe.getContentPane().removeAll();
            oknoBazowe.getContentPane().add(oknoTurniej);
            oknoBazowe.revalidate();
            oknoBazowe.repaint();
        }
    }
}
