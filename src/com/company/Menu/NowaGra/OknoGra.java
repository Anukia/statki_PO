package com.company.Menu.NowaGra;

import com.company.Gracz;
import com.company.Menu.NowaGra.GraBot.PrzyciskZatwierdzStrzalBot;
import com.company.Menu.Ustawienia.OknoUstawienia;
import com.company.OknoBazowe;
import com.company.Tlo;

import javax.swing.*;
import java.awt.*;

public class OknoGra extends JPanel {
    PanelMojeStatki panelMojeStatki;
    PanelInfoGra panelInfoGra;
    public PanelStatkiPrzeciwnika panelStatkiPrzeciwnika;
    public int rozmiar;
    public int[] doZatopienia = new int[4];
    public Gracz gracz;
    public Gracz przeciwnik;
    protected PrzyciskZatwierdzStrzal przyciskZatwierdzStrzal;
    public OknoBazowe oknoBazowe;
    public OknoNowaGra oknoNowaGra;
    public OknoUstawienia oknoUstawienia;
    PrzyciskZaslaniajacy przyciskZaslaniajacy;
    public ImageIcon pudlo;
    public ImageIcon statek;
    public ImageIcon statekTrafiony;

    public OknoGra (OknoBazowe oknoBazowe, OknoNowaGra oknoNowaGra, OknoUstawienia oknoUstawienia, Gracz gracz, Gracz przeciwnik){
        this.oknoBazowe = oknoBazowe;
        this.oknoNowaGra = oknoNowaGra;
        this.oknoUstawienia = oknoUstawienia;

        rozmiar = oknoUstawienia.rozmiarPlanszy;

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

        this.gracz = gracz;
        this.przeciwnik = przeciwnik;
        this.setBounds(0, 0, 1600, 900);
        this.setBackground(new Color(45, 156, 196));
        this.setLayout(null);

        przyciskZaslaniajacy = new PrzyciskZaslaniajacy(this, gracz.nickname);
        this.add(przyciskZaslaniajacy);

    panelMojeStatki = new PanelMojeStatki(oknoUstawienia, gracz, przeciwnik, this);
        this.add(panelMojeStatki);

    panelStatkiPrzeciwnika = new PanelStatkiPrzeciwnika(oknoUstawienia, przeciwnik, gracz, this);
        this.add(panelStatkiPrzeciwnika);

    panelInfoGra = new PanelInfoGra(gracz, przeciwnik, 0, oknoNowaGra, oknoBazowe);
        this.add(panelInfoGra);



    Tlo tlo = new Tlo(this);
}

    public Boolean sprawdzCzyZatopiony() {
        int i = gracz.punktStrzalu[0];
        int j = gracz.punktStrzalu[1];
        int lewo, prawo, gora, dol;
        lewo = 0;
        prawo = 0;
        gora = 0;
        dol = 0;
        while(i-1-lewo >= 0 && przeciwnik.ulozenieStatkow[i-1-lewo][j] == 1){
            if(gracz.tablicaStrzalow[i-1-lewo][j] == 0 ) return false;
            lewo++;
        }
        while(i+1+prawo <= rozmiar-1 && przeciwnik.ulozenieStatkow[i+1+prawo][j] == 1){
            if(gracz.tablicaStrzalow[i+1+prawo][j] == 0 ) return false;
            prawo++;
        }
        while(j-1-gora >= 0 && przeciwnik.ulozenieStatkow[i][j-1-gora] == 1){
            if(gracz.tablicaStrzalow[i][j-1-gora] == 0 ) return false;
            gora++;
        }
        while(j+1+dol <= rozmiar-1 && przeciwnik.ulozenieStatkow[i][j+1+dol] == 1){
            if(gracz.tablicaStrzalow[i][j+1+dol] == 0 ) return false;
            dol++;
        }
        doZatopienia[0] = lewo;
        doZatopienia[1] = prawo;
        doZatopienia[2] = gora;
        doZatopienia[3] = dol;
        return true;
    }

    public void topienie(PanelStatkiPrzeciwnika panelStatkiPrzeciwnika, int rozmiar) {
        int i = gracz.punktStrzalu[0];
        int j = gracz.punktStrzalu[1];
        if(this.sprawdzCzyZatopiony() == true) {
            panelStatkiPrzeciwnika.macierzStatkowPrzyciski[i][j].zatopienie();
            for (int k = 1; k < this.doZatopienia[0]+1; k++) {
                panelStatkiPrzeciwnika.macierzStatkowPrzyciski[i-k][j].zatopienie();
            }
            for (int k = 1; k < this.doZatopienia[1]+1; k++) {
                panelStatkiPrzeciwnika.macierzStatkowPrzyciski[i+k][j].zatopienie();
            }
            for (int k = 1; k < this.doZatopienia[2]+1; k++) {
                panelStatkiPrzeciwnika.macierzStatkowPrzyciski[i][j-k].zatopienie();
            }
            for (int k = 1; k < this.doZatopienia[3]+1; k++) {
                panelStatkiPrzeciwnika.macierzStatkowPrzyciski[i][j+k].zatopienie();
            }
            int jNad = j-this.doZatopienia[2]-1;
            int jPod = j+this.doZatopienia[3]+1;
            int iPrawo = i+this.doZatopienia[1]+1;
            int iLewo = i-this.doZatopienia[0]-1;

            if(jNad >= 0) {     //pudlo na górze
                for (int m = iLewo+1; m <= iPrawo-1; m++) {
                    panelStatkiPrzeciwnika.macierzStatkowPrzyciski[m][jNad].pudlo();
                }
            }
            if(jPod <= rozmiar - 1) {     //pudło na dole
                for (int m = iLewo+1; m <= iPrawo-1; m++) {
                    panelStatkiPrzeciwnika.macierzStatkowPrzyciski[m][jPod].pudlo();
                }
            }
            if(iLewo >= 0) {     //pudło na lewo
                for (int m = jNad+1; m <= jPod-1; m++) {
                    panelStatkiPrzeciwnika.macierzStatkowPrzyciski[iLewo][m].pudlo();
                }
            }
            if(iPrawo <= rozmiar - 1) {     //pudło na prawo
                for (int m = jNad+1; m <= jPod-1; m++) {
                    panelStatkiPrzeciwnika.macierzStatkowPrzyciski[iPrawo][m].pudlo();
                }
            }
            if(iLewo >=0 && jNad >= 0) {
                panelStatkiPrzeciwnika.macierzStatkowPrzyciski[iLewo][jNad].pudlo();
            }
            if(iLewo >= 0 && jPod <= rozmiar - 1) {
                panelStatkiPrzeciwnika.macierzStatkowPrzyciski[iLewo][jPod].pudlo();
            }
            if(iPrawo <= rozmiar-1 && jPod <= rozmiar-1) {
                panelStatkiPrzeciwnika.macierzStatkowPrzyciski[iPrawo][jPod].pudlo();
            }
            if(iPrawo <= rozmiar-1 && jNad >= 0) {
                panelStatkiPrzeciwnika.macierzStatkowPrzyciski[iPrawo][jNad].pudlo();
            }
        }
    }

    public void strzal(int wiersz, int kolumna) {
        if (this.przeciwnik.ulozenieStatkow[wiersz][kolumna] == 1) {
            this.panelStatkiPrzeciwnika.macierzStatkowPrzyciski[wiersz][kolumna].trafienie();
            this.panelStatkiPrzeciwnika.odblokada();
            this.topienie(panelStatkiPrzeciwnika, rozmiar);
            this.panelMojeStatki.ustawStatki();
        }
        else {
            this.panelStatkiPrzeciwnika.macierzStatkowPrzyciski[wiersz][kolumna].pudlo();
            this.panelStatkiPrzeciwnika.odblokada();
            this.panelMojeStatki.ustawStatki();
        }
    }
}
