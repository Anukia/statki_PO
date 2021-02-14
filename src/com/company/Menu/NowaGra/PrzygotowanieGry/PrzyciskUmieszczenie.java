package com.company.Menu.NowaGra.PrzygotowanieGry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrzyciskUmieszczenie extends JButton implements ActionListener {

    public int wiersz, kolumna, blokada;
    PanelUmieszczania panelUmieszczania;
    OknoPrzygotowanieGry oknoPrzygotowanieGry;

    public PrzyciskUmieszczenie(OknoPrzygotowanieGry oknPrzygotowanieGry, PanelUmieszczania panlUmieszczania, int wirsz, int kolmna) {
        panelUmieszczania = panlUmieszczania;
        oknoPrzygotowanieGry = oknPrzygotowanieGry;
        wiersz = wirsz;
        kolumna = kolmna;
        blokada = 0;
        this.setBackground(Color.BLACK);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            if(oknoPrzygotowanieGry.macierzWcisniec[wiersz][kolumna]==0) {
                oknoPrzygotowanieGry.macierzWcisniec[wiersz][kolumna] = 1;
                this.setBackground(Color.BLACK);
                this.setIcon(oknoPrzygotowanieGry.statek);
                panelUmieszczania.odswiez(this);
            }
            else {
                oknoPrzygotowanieGry.macierzWcisniec[wiersz][kolumna] = 0;
                this.setBackground(Color.BLACK);
                this.setIcon(null);
                panelUmieszczania.odswiez(this);
            }
        }
    }
    public void blokuj() {
        if (blokada == 0) {
            this.setEnabled(false);
            this.setBackground(Color.BLACK);
            this.setIcon(null);
            this.setIcon(oknoPrzygotowanieGry.pudlo);
            blokada++;
        }
        else {
            blokada++;
        }
    }
    public void odblokuj() {
        if (blokada == 1) {
            this.setEnabled(true);
            this.setBackground(Color.BLACK);
            this.setIcon(null);
            blokada--;
        }
        else {
            blokada--;
        }
    }
}
