package com.company;

import com.company.Menu.NowaGra.Turniej.OknoRanking;
import com.company.Menu.NowaGra.Turniej.OknoTurniej;
import com.company.Menu.OknoMenu;
import com.company.Menu.Ustawienia.OknoUstawienia;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class Gracz {
    public int[][] ulozenieStatkow;
    public String nickname;
    public int[][] tablicaStrzalow;
    public int liczbaStatkowDoZatopienia;
    public int[] punktStrzalu = new int[2];
    public int[] doZatopienia = new int[4];
    public int rozmiar;
    public OknoMenu menu;
    public OknoTurniej oknoTurniej;
    public OknoBazowe oknoBazowe;

    public Gracz(OknoBazowe oknoBazowe) {
        punktStrzalu[0] = -1;
        punktStrzalu[1] = -1;
        this.oknoBazowe = oknoBazowe;
    }

    public void reset(int rozmiar, int liczbaStatkowDoZatopienia){
        this.ulozenieStatkow = new int[rozmiar][rozmiar];
        this.tablicaStrzalow = new int[rozmiar][rozmiar];
        this.liczbaStatkowDoZatopienia = liczbaStatkowDoZatopienia;
    }

    public void setUlozenieStatkow(int[][] ulozenieStatkow) {
        this.ulozenieStatkow = ulozenieStatkow;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void wyprintujUlozenieStatkow() {
        for (int i = 0; i < this.ulozenieStatkow.length; i++) {
            for (int j = 0; j < this.ulozenieStatkow[i].length; j++) {
                System.out.print(this.ulozenieStatkow[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public void setLiczbaStatkowDoZatopienia(int liczbaStatkowDoZatopienia) {
        this.liczbaStatkowDoZatopienia = liczbaStatkowDoZatopienia;
    }

    public void uzupelnijStatki(int[][] macierzStatkow, int[] listaStatkowDoUlozenia) {
        int liczbaStatkow = 0;
        int[] nieUlozoneStatki;
        for (int i = 0; i < listaStatkowDoUlozenia.length; i++) {
            liczbaStatkow += listaStatkowDoUlozenia[i];
        }
        nieUlozoneStatki = new int[liczbaStatkow];
        int licznik = 0;
        for (int i = 0; i < listaStatkowDoUlozenia.length; i++) {
            for (int j = 0; j < listaStatkowDoUlozenia[i]; j++) {
                nieUlozoneStatki[licznik] = i;
                licznik++;
            }
        }

        if (liczbaStatkow <= Math.ceil((double)macierzStatkow.length/2)) {
            for (int i = 0; i < liczbaStatkow; i++) {
                for (int j = 0; j < nieUlozoneStatki[i]; j++) {
                    macierzStatkow[2 * i][j] = 1;
                }
            }
        }
    }

    public void uczynBotem(OknoUstawienia oknoUstawienia) {
        this.ulozenieStatkow = new int[oknoUstawienia.rozmiarPlanszy][oknoUstawienia.rozmiarPlanszy];
        for (int i = 0; i < oknoUstawienia.rozmiarPlanszy; i++) {
            for (int j = 0; j < oknoUstawienia.rozmiarPlanszy; j++) {
                this.ulozenieStatkow[i][j] = 0;
            }
        }
        this.uzupelnijStatki(this.ulozenieStatkow, oknoUstawienia.listaStatkow);
        setNickname("Bot");
        //this.wyprintujUlozenieStatkow();
    }
    public void uzupelnijStrzaly(int rozmiar) {
        this.tablicaStrzalow = new int[rozmiar][rozmiar];
        for (int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                this.tablicaStrzalow[i][j] = 0;
            }
        }
    }

    public void losowyStrzal(Gracz przeciwnik) {
        int wiersz;
        int kolumna;
        do {
            wiersz = (int)(Math.random()*rozmiar);
            kolumna = (int)(Math.random()*rozmiar);
        } while(tablicaStrzalow[wiersz][kolumna] > 0);
        punktStrzalu[0] = wiersz;
        punktStrzalu[1] = kolumna;
        if (this.strzel(wiersz, kolumna, przeciwnik)) {
            losowyStrzal(przeciwnik);
        };
    }

    public Boolean sprawdzCzyZatopiony(Gracz przeciwnik) {
        int i = this.punktStrzalu[0];
        int j = this.punktStrzalu[1];
        int lewo, prawo, gora, dol;
        lewo = 0;
        prawo = 0;
        gora = 0;
        dol = 0;
        while(i-1-lewo >= 0 && przeciwnik.ulozenieStatkow[i-1-lewo][j] == 1){
            if(this.tablicaStrzalow[i-1-lewo][j] == 0 ) return false;
            lewo++;
        }
        while(i+1+prawo <= rozmiar-1 && przeciwnik.ulozenieStatkow[i+1+prawo][j] == 1){
            if(this.tablicaStrzalow[i+1+prawo][j] == 0 ) return false;
            prawo++;
        }
        while(j-1-gora >= 0 && przeciwnik.ulozenieStatkow[i][j-1-gora] == 1){
            if(this.tablicaStrzalow[i][j-1-gora] == 0 ) return false;
            gora++;
        }
        while(j+1+dol <= rozmiar-1 && przeciwnik.ulozenieStatkow[i][j+1+dol] == 1){
            if(this.tablicaStrzalow[i][j+1+dol] == 0 ) return false;
            dol++;
        }
        doZatopienia[0] = lewo;
        doZatopienia[1] = prawo;
        doZatopienia[2] = gora;
        doZatopienia[3] = dol;
        this.liczbaStatkowDoZatopienia--;
        return true;
    }

    public void topienie(Gracz przeciwnik) {
        int i = this.punktStrzalu[0];
        int j = this.punktStrzalu[1];
        if(this.sprawdzCzyZatopiony(przeciwnik) == true) {
            this.tablicaStrzalow[i][j] = 4; // strzal z zatopieniem
            for (int k = 1; k < this.doZatopienia[0]+1; k++) {
                this.tablicaStrzalow[i-k][j] = 4;
            }
            for (int k = 1; k < this.doZatopienia[1]+1; k++) {
                this.tablicaStrzalow[i+k][j] = 4;
            }
            for (int k = 1; k < this.doZatopienia[2]+1; k++) {
                this.tablicaStrzalow[i][j-k] = 4;
            }
            for (int k = 1; k < this.doZatopienia[3]+1; k++) {
                this.tablicaStrzalow[i][j+k] = 4;
            }
            int jNad = j-this.doZatopienia[2]-1;
            int jPod = j+this.doZatopienia[3]+1;
            int iPrawo = i+this.doZatopienia[1]+1;
            int iLewo = i-this.doZatopienia[0]-1;

            if(jNad >= 0) {     //pudlo na górze
                for (int m = iLewo+1; m <= iPrawo-1; m++) {
                    this.strzel(m, jNad);
                }
            }
            if(jPod <= rozmiar - 1) {     //pudło na dole
                for (int m = iLewo+1; m <= iPrawo-1; m++) {
                    this.strzel(m, jPod);
                }
            }
            if(iLewo >= 0) {     //pudło na lewo
                for (int m = jNad+1; m <= jPod-1; m++) {
                    this.strzel(iLewo, m);
                }
            }
            if(iPrawo <= rozmiar - 1) {     //pudło na prawo
                for (int m = jNad+1; m <= jPod-1; m++) {
                    this.strzel(iPrawo, m);
                }
            }
            if(iLewo >=0 && jNad >= 0) {
                this.strzel(iLewo, jNad);
            }
            if(iLewo >= 0 && jPod <= rozmiar - 1) {
                this.strzel(iLewo, jPod);
            }
            if(iPrawo <= rozmiar-1 && jPod <= rozmiar-1) {
                this.strzel(iPrawo, jPod);
            }
            if(iPrawo <= rozmiar-1 && jNad >= 0) {
                this.strzel(iPrawo, jNad);
            }
            if(this.liczbaStatkowDoZatopienia == 0) {
                this.wygral(przeciwnik);
            }
        }
    }

    public void topienie(Gracz przeciwnik, int turniejowe) {
        int i = this.punktStrzalu[0];
        int j = this.punktStrzalu[1];
        if(this.sprawdzCzyZatopiony(przeciwnik) == true) {
            this.tablicaStrzalow[i][j] = 4; // strzal z zatopieniem
            for (int k = 1; k < this.doZatopienia[0]+1; k++) {
                this.tablicaStrzalow[i-k][j] = 4;
            }
            for (int k = 1; k < this.doZatopienia[1]+1; k++) {
                this.tablicaStrzalow[i+k][j] = 4;
            }
            for (int k = 1; k < this.doZatopienia[2]+1; k++) {
                this.tablicaStrzalow[i][j-k] = 4;
            }
            for (int k = 1; k < this.doZatopienia[3]+1; k++) {
                this.tablicaStrzalow[i][j+k] = 4;
            }
            int jNad = j-this.doZatopienia[2]-1;
            int jPod = j+this.doZatopienia[3]+1;
            int iPrawo = i+this.doZatopienia[1]+1;
            int iLewo = i-this.doZatopienia[0]-1;

            if(jNad >= 0) {     //pudlo na górze
                for (int m = iLewo+1; m <= iPrawo-1; m++) {
                    this.strzel(m, jNad);
                }
            }
            if(jPod <= rozmiar - 1) {     //pudło na dole
                for (int m = iLewo+1; m <= iPrawo-1; m++) {
                    this.strzel(m, jPod);
                }
            }
            if(iLewo >= 0) {     //pudło na lewo
                for (int m = jNad+1; m <= jPod-1; m++) {
                    this.strzel(iLewo, m);
                }
            }
            if(iPrawo <= rozmiar - 1) {     //pudło na prawo
                for (int m = jNad+1; m <= jPod-1; m++) {
                    this.strzel(iPrawo, m);
                }
            }
            if(iLewo >=0 && jNad >= 0) {
                this.strzel(iLewo, jNad);
            }
            if(iLewo >= 0 && jPod <= rozmiar - 1) {
                this.strzel(iLewo, jPod);
            }
            if(iPrawo <= rozmiar-1 && jPod <= rozmiar-1) {
                this.strzel(iPrawo, jPod);
            }
            if(iPrawo <= rozmiar-1 && jNad >= 0) {
                this.strzel(iPrawo, jNad);
            }
            if(this.liczbaStatkowDoZatopienia == 0) {
                this.wygral(przeciwnik, turniejowe);
            }
        }
    }

    public void strzel(int wiersz, int kolumna) {
        tablicaStrzalow[wiersz][kolumna] = 1;
    }

    public boolean strzel(int wiersz, int kolumna, Gracz przeciwnik) {
        tablicaStrzalow[wiersz][kolumna] = 1;
        if (przeciwnik.ulozenieStatkow[wiersz][kolumna] == 1) {
            this.topienie(przeciwnik);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean strzel(int wiersz, int kolumna, Gracz przeciwnik, int turniejowe) {
        tablicaStrzalow[wiersz][kolumna] = 1;
        if (przeciwnik.ulozenieStatkow[wiersz][kolumna] == 1) {
            this.topienie(przeciwnik, turniejowe);
            return true;
        }
        else {
            return false;
        }
    }

    public void wygral(Gracz przeciwnik) {
        JOptionPane.showMessageDialog(null, "Wygrał " + this.nickname + "!", "Wygrana", JOptionPane.INFORMATION_MESSAGE);

        try {
            oknoBazowe.zapisWyniki.write(this.nickname + "\n" + przeciwnik.nickname + "\n");
            oknoBazowe.zapisWyniki.close();
            oknoBazowe.zapisWyniki = new FileWriter(oknoBazowe.nazwaPlikWyniki, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        oknoBazowe.getContentPane().removeAll();
        oknoBazowe.getContentPane().add(menu);
        oknoBazowe.revalidate();
        oknoBazowe.repaint();
    }

    public void wygral(Gracz przeciwnik, int turniejowe) {
        JOptionPane.showMessageDialog(null, "Wygrał " + this.nickname + "!", "Wygrana", JOptionPane.INFORMATION_MESSAGE);

        oknoBazowe.aktualnyTurniej.rozegraneMecze[oknoBazowe.aktualnyTurniej.rozegranychMeczy][0] = this.nickname;
        oknoBazowe.aktualnyTurniej.rozegraneMecze[oknoBazowe.aktualnyTurniej.rozegranychMeczy][1] = przeciwnik.nickname;
        oknoBazowe.aktualnyTurniej.rozegranychMeczy++;
        oknoBazowe.aktualnyTurniej.zapisz(oknoBazowe.aktualnyTurniej.getNazwaHosta());
        oknoBazowe.aktualnyTurniej.setRankingPosortowany();
        OknoRanking oknoRanking = new OknoRanking(oknoBazowe, oknoTurniej);
        oknoBazowe.getContentPane().removeAll();
        oknoBazowe.getContentPane().add(oknoRanking);
        oknoBazowe.revalidate();
        oknoBazowe.repaint();
    }
}