package com.company.Menu.NowaGra;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrzyciskStrzelanie extends JButton implements ActionListener {

    int wiersz, kolumna;
    boolean klikniety = false;
    boolean zblokowany = false;
    PanelStatkiPrzeciwnika panel;
    OknoGra oknoGra;

    public PrzyciskStrzelanie(int wirsz, int kolmna, PanelStatkiPrzeciwnika panl, OknoGra oknGra) {
        wiersz = wirsz;
        kolumna = kolmna;
        panel = panl;
        oknoGra = oknGra;

        this.setEnabled(true);
        this.setBackground(Color.BLACK);
        this.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            if (!klikniety) {
                Border border = BorderFactory.createLineBorder(Color.white, 5);
                this.setBorder(border);
                panel.blokada(wiersz, kolumna);
                oknoGra.gracz.punktStrzalu[0] = wiersz;
                oknoGra.gracz.punktStrzalu[1] = kolumna;
                klikniety = true;
                oknoGra.przyciskZatwierdzStrzal.odblokuj();
            }
            else {
                this.setBorder(UIManager.getBorder("Button.border"));
                panel.odblokada();
                oknoGra.gracz.punktStrzalu[0] = -1;
                oknoGra.gracz.punktStrzalu[1] = -1;
                klikniety = false;
                oknoGra.przyciskZatwierdzStrzal.blokuj();
            }
        }
    }
    public void blokuj() {
        this.setEnabled(false);
    }

    public void blokujNaAmen() {
        this.setEnabled(false);
        this.zblokowany = true;
    }
    public void odblokuj() {
        this.setEnabled(true);
    }
    public void trafienie() {
        this.blokujNaAmen();
        this.setIcon(oknoGra.statekTrafiony);
        this.setBorder(UIManager.getBorder("Button.border"));
        this.setEnabled(false);
    }
    public void pudlo() {
        this.blokujNaAmen();
        this.setIcon(oknoGra.pudlo);
        this.setBorder(UIManager.getBorder("Button.border"));
        this.setEnabled(false);
    }
    public void zatopienie() {
        this.blokujNaAmen();
        this.setIcon(oknoGra.statekTrafiony);
        this.setBorder(UIManager.getBorder("Button.border"));
        this.setEnabled(false);
    }
}
