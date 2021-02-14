package com.company.Menu.NowaGra.Turniej;

import com.company.OknoBazowe;
import com.company.Tlo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoWpiszGraczy extends JPanel implements ActionListener {
    OknoBazowe oknoBazowe;
    JLabel[] nazwy;
    PolaWpiszGraczy[] polaNazw;
    JPanel panelPrzyciskowNazwaGracza;
    JButton zatwierdz;
    OknoTurniej oknoTurniej;

    public OknoWpiszGraczy (OknoBazowe oknoBazowe, OknoTurniej oknoTurniej) {
        this.setOpaque(false);
        this.setBounds(0, 0, 1600, 900);
        this.setLayout(null);
        this.oknoBazowe = oknoBazowe;
        this.oknoTurniej = oknoTurniej;

        panelPrzyciskowNazwaGracza = new JPanel();
        panelPrzyciskowNazwaGracza.setOpaque(false);
        panelPrzyciskowNazwaGracza.setBounds(450, 50, 700, 750);
        panelPrzyciskowNazwaGracza.setLayout(new GridLayout(oknoBazowe.aktualnyTurniej.liczbaGraczy,2,20,10));
        this.add(panelPrzyciskowNazwaGracza);

        polaNazw = new PolaWpiszGraczy[oknoBazowe.aktualnyTurniej.liczbaGraczy];
        nazwy = new JLabel[oknoBazowe.aktualnyTurniej.liczbaGraczy];

        for (int i = 0; i < oknoBazowe.aktualnyTurniej.liczbaGraczy; i++) {
            nazwy[i] = new JLabel();
            nazwy[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
            nazwy[i].setHorizontalAlignment(JLabel.RIGHT);
            nazwy[i].setText("Nazwa gracza " + (i+1) + ": ");
            panelPrzyciskowNazwaGracza.add(nazwy[i]);
            polaNazw[i] = new PolaWpiszGraczy();
            panelPrzyciskowNazwaGracza.add(polaNazw[i]);
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
            boolean pusty = false;
            for (int i = 0; i < oknoBazowe.aktualnyTurniej.liczbaGraczy; i++) {
                if (polaNazw[i].getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nie podano wszystkich nazw użytkownika!", "Błąd", JOptionPane.ERROR_MESSAGE);
                    pusty = true;
                    break;
                } else {
                    oknoBazowe.aktualnyTurniej.nazwyGraczy[i] = polaNazw[i].getText();
                }
            }
            if (pusty == false) {
                oknoBazowe.aktualnyTurniej.zapisz(oknoBazowe.gracz1.nickname);
                oknoBazowe.aktualnyTurniej.wyliczMeczeDoRozegrania();
                oknoBazowe.aktualnyTurniej.setNazwaHosta(oknoBazowe.gracz1.nickname);
                oknoBazowe.getContentPane().removeAll();
                oknoBazowe.getContentPane().add(oknoTurniej);
                oknoBazowe.revalidate();
                oknoBazowe.repaint();
            }
        }
    }
}
