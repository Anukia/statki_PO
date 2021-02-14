package com.company.Menu.NowaGra.PrzygotowanieGry;

import com.company.Gracz;
import com.company.Menu.NowaGra.GraBot.OknoGraBot;
import com.company.Menu.NowaGra.OknoNowaGra;
import com.company.Menu.Ustawienia.OknoUstawienia;
import com.company.OknoBazowe;
import com.company.Powrot;
import com.company.Tlo;

import javax.swing.*;
import java.awt.*;

public class OknoPrzygotowanieGry extends JPanel {

    Powrot powrot;
    PanelUmieszczania panelUmieszczania;
    PanelInfo panelInfo;
    protected OknoBazowe oknoBazowe;
    int rozmiar;
    public int[][] macierzWcisniec;
    protected PrzyciskZatwierdzPrzygotowanie przyciskZatwierdzPrzygotowanie;
    public ImageIcon pudlo;
    public ImageIcon statek;
    public ImageIcon statekTrafiony;

    public OknoPrzygotowanieGry(OknoBazowe oknBazowe, OknoNowaGra oknoNowaGra, OknoUstawienia oknoUstawienia, int pozostalePrzygotowania) {
        this.setBounds(0, 0, 1600, 900);
        this.setOpaque(false);
        this.setLayout(null);
        oknoBazowe = oknBazowe;
        rozmiar = oknoUstawienia.rozmiarPlanszy;
        macierzWcisniec = new int[rozmiar][rozmiar];
        ImageIcon tmpStatek = new ImageIcon("statek.png");
        ImageIcon tmpPudlo = new ImageIcon("krzyzyk.png");
        ImageIcon tmpStatekTrafiony = new ImageIcon("statekzatopiony.png");
        Image img1 = tmpPudlo.getImage();
        Image imgScale;
        imgScale = img1.getScaledInstance(600/rozmiar, 600/rozmiar,Image.SCALE_SMOOTH);
        this.pudlo = new ImageIcon(imgScale);
        img1 = tmpStatek.getImage();
        imgScale = img1.getScaledInstance(600/rozmiar, 600/rozmiar,Image.SCALE_SMOOTH);
        this.statek = new ImageIcon(imgScale);
        img1 = tmpStatekTrafiony.getImage();
        imgScale = img1.getScaledInstance(600/rozmiar, 600/rozmiar,Image.SCALE_SMOOTH);
        this.statekTrafiony = new ImageIcon(imgScale);


        panelUmieszczania = new PanelUmieszczania(oknoUstawienia, this, pozostalePrzygotowania, oknoNowaGra);
        this.add(panelUmieszczania);

        if (pozostalePrzygotowania == 1) {
            panelInfo = new PanelInfo(oknoBazowe.gracz2, oknoBazowe.gracz1, pozostalePrzygotowania);
        }
        else {
            panelInfo = new PanelInfo(oknoBazowe.gracz1, oknoBazowe.gracz2, pozostalePrzygotowania);
        }
        this.add(panelInfo);

        powrot = new Powrot(oknoBazowe, oknoNowaGra);
        this.add(powrot);

    }

    public void odswiezOkno() {
        oknoBazowe.revalidate();
        oknoBazowe.repaint();
    }
}
