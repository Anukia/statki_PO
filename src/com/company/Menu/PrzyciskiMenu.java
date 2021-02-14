package com.company.Menu;

import com.company.Menu.NowaGra.OknoNowaGra;
import com.company.OknoBazowe;
import com.company.Menu.Ustawienia.OknoUstawienia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class PrzyciskiMenu extends JPanel implements ActionListener {

    JButton nowaGra;
    JButton ustawienia;
    JButton wyjscie;
    OknoBazowe oknoBazowe;
    OknoUstawienia oknoUstawienia;
    OknoNowaGra oknoNowaGra;

    public PrzyciskiMenu(OknoMenu oknoMenu, OknoBazowe baza, OknoNowaGra oknoNowa, OknoUstawienia usta) {

        oknoBazowe = baza;
        oknoNowaGra = oknoNowa;
        oknoUstawienia = usta;

        this.setOpaque(false);
        this.setBounds(565, 250, 400, 400);
        this.setLayout(new GridLayout(3,1,0,50));

        nowaGra = new JButton();
        nowaGra.setText("Nowa Gra");
        nowaGra.setFocusable(false);
        nowaGra.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
        nowaGra.addActionListener(this);
        this.add(nowaGra);

        ustawienia = new JButton();
        ustawienia.setText("Ustawienia");
        ustawienia.setFocusable(false);
        ustawienia.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
        ustawienia.addActionListener(this);
        this.add(ustawienia);

        wyjscie = new JButton();
        wyjscie.setText("Wyjście");
        wyjscie.setFocusable(false);
        wyjscie.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
        wyjscie.addActionListener(this);
        this.add(wyjscie);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == nowaGra) {
            oknoBazowe.getContentPane().removeAll();
            oknoBazowe.getContentPane().add(oknoNowaGra);
            oknoNowaGra.zalogowanyUzytkownik.odswiez();
            oknoBazowe.revalidate();
            oknoBazowe.repaint();
        }

        else if(e.getSource() == ustawienia) {
            oknoBazowe.getContentPane().removeAll();
            oknoBazowe.getContentPane().add(oknoUstawienia);
            oknoBazowe.revalidate();
            oknoBazowe.repaint();
        }

        else if(e.getSource() == wyjscie) {
            oknoBazowe.dispatchEvent(new WindowEvent(oknoBazowe, WindowEvent.WINDOW_CLOSING));
        }
    }
}
