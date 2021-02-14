package com.company.Menu.NowaGra.PrzygotowanieGry;

import com.company.Menu.Ustawienia.OknoUstawienia;

import javax.swing.*;
import java.awt.*;

public class PanelPrzyciskow extends JPanel {

    int rozmiar;
    OknoPrzygotowanieGry oknoPrzygotowanieGry;

    public PanelPrzyciskow(OknoPrzygotowanieGry oknPrzygotowanieGry, OknoUstawienia oknoUstawienia, PanelUmieszczania panelUmieszczania) {
        this.setBounds(0, 0, 600, 600);
        this.setOpaque(false);

        oknoPrzygotowanieGry = oknPrzygotowanieGry;
        rozmiar = oknoUstawienia.rozmiarPlanszy;

        this.setLayout(new GridLayout(rozmiar, rozmiar, 0, 0));



        for(int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                oknoPrzygotowanieGry.macierzWcisniec[i][j] = 0;
                panelUmieszczania.tablicaPrzyciskow[i][j] = new PrzyciskUmieszczenie(oknoPrzygotowanieGry, panelUmieszczania, i, j);
                this.add(panelUmieszczania.tablicaPrzyciskow[i][j]);
            }
        }
    }
}
