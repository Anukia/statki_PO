package com.company.Menu.NowaGra.Turniej;

import com.company.Menu.NowaGra.Dologowanie.OknoDologowania;
import com.company.Menu.NowaGra.GraBot.OknoPrzygotowanieGraBot;
import com.company.Menu.NowaGra.GraTurniejowa.OknoPrzygotowanieGraTurniejowa;
import com.company.Menu.NowaGra.OknoNowaGra;
import com.company.Menu.NowaGra.PrzygotowanieGry.OknoPrzygotowanieGry;
import com.company.Menu.NowaGra.SzybkaGra.OknoPrzygotowanieSzybkaGra;
import com.company.Menu.OknoMenu;
import com.company.Menu.Ustawienia.OknoUstawienia;
import com.company.OknoBazowe;
import com.company.Powrot;
import com.company.Tlo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoTurniej extends JPanel implements ActionListener {
    JButton nowyTurniej;
    JButton wczytajTurniej;
    JButton rozegrajKolejnyMeczWTurnieju;
    OknoBazowe oknoBazowe;
    OknoPrzygotowanieGry oknoPrzygotowanieGry;
    OknoNowaGra oknoNowaGra;
    OknoUstawienia oknoUstawienia;
    OknoDologowania oknoDologowania;
    OknoTworzenieTurnieju oknoTworzenieTurnieju;

    public OknoTurniej(OknoBazowe okno, OknoNowaGra oknNowaGra, OknoUstawienia oknUstawienia) {
        oknoBazowe = okno;
        oknoNowaGra = oknNowaGra;
        oknoUstawienia = oknUstawienia;

        this.setOpaque(false);
        this.setBounds(0,0, 1600, 900);
        this.setLayout(null);

        nowyTurniej = new JButton();
        nowyTurniej.setText("Nowy turniej");
        nowyTurniej.setFocusable(false);
        nowyTurniej.setBounds(600,200,400,100);
        nowyTurniej.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
        nowyTurniej.addActionListener(this);
        this.add(nowyTurniej);

        wczytajTurniej = new JButton();
        wczytajTurniej.setText("Wczytaj turniej");
        wczytajTurniej.setFocusable(false);
        wczytajTurniej.setBounds(600,350,400,100);
        wczytajTurniej.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
        wczytajTurniej.addActionListener(this);
        this.add(wczytajTurniej);

        rozegrajKolejnyMeczWTurnieju = new JButton();
        rozegrajKolejnyMeczWTurnieju.setText("Rozegraj kolejny mecz w turnieju");
        rozegrajKolejnyMeczWTurnieju.setFocusable(false);
        rozegrajKolejnyMeczWTurnieju.setBounds(600,500,400,100);
        rozegrajKolejnyMeczWTurnieju.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
        rozegrajKolejnyMeczWTurnieju.addActionListener(this);
        this.add(rozegrajKolejnyMeczWTurnieju);

        Powrot powrot = new Powrot(oknoBazowe, oknNowaGra);
        this.add(powrot);

        Tlo tlo = new Tlo(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nowyTurniej) {
            oknoBazowe.aktualnyTurniej.reset();
            oknoTworzenieTurnieju = new OknoTworzenieTurnieju(oknoBazowe, oknoNowaGra, oknoUstawienia, this);

            oknoBazowe.getContentPane().removeAll();
            oknoBazowe.getContentPane().add(oknoTworzenieTurnieju);
            oknoBazowe.revalidate();
            oknoBazowe.repaint();
        }

        else if (e.getSource() == wczytajTurniej) {
            oknoBazowe.aktualnyTurniej.wczytaj(oknoBazowe.gracz1.nickname);
            JOptionPane.showMessageDialog(null, "Udało się wczytać turniej.", "Informacja", JOptionPane.INFORMATION_MESSAGE);


        }
        if (e.getSource() == rozegrajKolejnyMeczWTurnieju) {
            if (oknoBazowe.aktualnyTurniej.nazwaTurnieju == null) {
                JOptionPane.showMessageDialog(null, "Nie jest aktualnie rozgrywany żaden turniej!\nWczytaj lub utwórz nowy.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
            else {
                if (oknoBazowe.aktualnyTurniej.rozegranychMeczy == oknoBazowe.aktualnyTurniej.tablicaMeczy.length)
                {
                    JOptionPane.showMessageDialog(null, "Turniej zakończony, zwyciężył: " + oknoBazowe.aktualnyTurniej.zwyciezca, "Informacja", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    oknoBazowe.gracz1.setNickname(oknoBazowe.aktualnyTurniej.tablicaMeczy[oknoBazowe.aktualnyTurniej.rozegranychMeczy][0]);
                    oknoBazowe.gracz2.setNickname(oknoBazowe.aktualnyTurniej.tablicaMeczy[oknoBazowe.aktualnyTurniej.rozegranychMeczy][1]);
                    oknoPrzygotowanieGry = new OknoPrzygotowanieGraTurniejowa(oknoBazowe, oknoNowaGra, oknoUstawienia, 1);
                    oknoBazowe.getContentPane().removeAll();
                    oknoBazowe.getContentPane().add(oknoPrzygotowanieGry);
                    oknoBazowe.revalidate();
                    oknoBazowe.repaint();
                }
            }
        }
    }
}