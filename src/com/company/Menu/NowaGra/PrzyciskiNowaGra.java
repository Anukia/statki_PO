package com.company.Menu.NowaGra;

import com.company.Menu.NowaGra.Dologowanie.OknoDologowania;
import com.company.Menu.NowaGra.GraBot.OknoPrzygotowanieGraBot;
import com.company.Menu.NowaGra.PrzygotowanieGry.OknoPrzygotowanieGry;
import com.company.Menu.NowaGra.SzybkaGra.OknoPrzygotowanieSzybkaGra;
import com.company.Menu.NowaGra.Turniej.OknoTurniej;
import com.company.Menu.OknoMenu;
import com.company.Menu.Ustawienia.OknoUstawienia;
import com.company.OknoBazowe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrzyciskiNowaGra extends JPanel implements ActionListener {
    JButton szybkaGra;
    JButton graBot;
    JButton turniej;
    OknoBazowe oknoBazowe;
    OknoPrzygotowanieGry oknoPrzygotowanieGry;
    OknoNowaGra oknoNowaGra;
    OknoUstawienia oknoUstawienia;
    OknoDologowania oknoDologowania;
    OknoTurniej oknoTurniej;

    public PrzyciskiNowaGra(OknoBazowe okno, OknoNowaGra oknNowaGra, OknoUstawienia oknUstawienia) {
        oknoBazowe = okno;
        oknoNowaGra = oknNowaGra;
        oknoUstawienia = oknUstawienia;

        this.setOpaque(false);
        this.setBounds(565, 250, 400, 400);
        this.setLayout(new GridLayout(3,1,0,50));

        szybkaGra = new JButton();
        szybkaGra.setText("Szybka gra (2os.)");
        szybkaGra.setFocusable(false);
        szybkaGra.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
        szybkaGra.addActionListener(this);
        this.add(szybkaGra);

        graBot = new JButton();
        graBot.setText("Gra z botem");
        graBot.setFocusable(false);
        graBot.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
        graBot.addActionListener(this);
        this.add(graBot);

        turniej = new JButton();
        turniej.setText("Turniej");
        turniej.setFocusable(false);
        turniej.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
        turniej.addActionListener(this);
        this.add(turniej);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == szybkaGra) {
            oknoDologowania = new OknoDologowania(oknoBazowe, 1, oknoNowaGra, oknoUstawienia);

            oknoBazowe.getContentPane().removeAll();
            oknoBazowe.getContentPane().add(oknoDologowania);
            oknoBazowe.revalidate();
            oknoBazowe.repaint();
        }

        else if (e.getSource() == graBot) {
            oknoBazowe.gracz2.uczynBotem(oknoUstawienia);
            oknoPrzygotowanieGry = new OknoPrzygotowanieGraBot(oknoBazowe, oknoNowaGra, oknoUstawienia, 0);

            oknoBazowe.getContentPane().removeAll();
            oknoBazowe.getContentPane().add(oknoPrzygotowanieGry);
            oknoBazowe.revalidate();
            oknoBazowe.repaint();
        }

        else if (e.getSource() == turniej) {
            oknoTurniej = new OknoTurniej(oknoBazowe, oknoNowaGra, oknoUstawienia);
            oknoBazowe.gracz1.oknoTurniej = oknoTurniej;
            oknoBazowe.gracz2.oknoTurniej = oknoTurniej;

            oknoBazowe.getContentPane().removeAll();
            oknoBazowe.getContentPane().add(oknoTurniej);
            oknoBazowe.revalidate();
            oknoBazowe.repaint();
        }
    }
}
