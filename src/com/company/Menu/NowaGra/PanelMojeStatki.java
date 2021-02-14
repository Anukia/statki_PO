package com.company.Menu.NowaGra;

import com.company.Gracz;
import com.company.Menu.NowaGra.PrzygotowanieGry.OknoPrzygotowanieGry;
import com.company.Menu.NowaGra.PrzygotowanieGry.PrzyciskUmieszczenie;
import com.company.Menu.Ustawienia.OknoUstawienia;

import javax.swing.*;
import java.awt.*;

public class PanelMojeStatki extends JPanel {
    JButton[][] macierzStatkowPrzyciski;
    int rozmiar;
    Gracz gracz;
    Gracz przeciwnik;
    OknoGra oknoGra;

    public int macierzStatkow[][];     //0 - pole "puste", 1 - statek nietrafiony, 2 - strzał chybiony, 3 - statek trafiony;


    public PanelMojeStatki(OknoUstawienia oknoUstawienia, Gracz gracz, Gracz przeciwnik, OknoGra oknoGra) {
        rozmiar = oknoUstawienia.rozmiarPlanszy;
        this.oknoGra = oknoGra;

        this.gracz = gracz;
        this.przeciwnik = przeciwnik;
        this.setBounds(100, 250, 600, 600);
        this.setOpaque(false);
        this.setLayout(new GridLayout(rozmiar, rozmiar, 0, 0));

        macierzStatkow = new int[rozmiar][rozmiar];
        macierzStatkowPrzyciski = new JButton[rozmiar][rozmiar];
        this.ustawStatki(1);
    }

    public void ustawStatki(){
        for(int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                this.remove(macierzStatkowPrzyciski[i][j]);
                macierzStatkow[i][j] = gracz.ulozenieStatkow[i][j];
                macierzStatkow[i][j] += 2*przeciwnik.tablicaStrzalow[i][j];
                macierzStatkowPrzyciski[i][j] = new JButton();
                macierzStatkowPrzyciski[i][j].setEnabled(false);
                if (macierzStatkow[i][j] == 0){ //puste
                    macierzStatkowPrzyciski[i][j].setBackground(Color.black);
                }
                else if (macierzStatkow[i][j] == 1){    //statek nietrafiony
                    macierzStatkowPrzyciski[i][j].setBackground(Color.black);
                    macierzStatkowPrzyciski[i][j].setIcon(oknoGra.statek);
                }
                else if (macierzStatkow[i][j] == 2){    //pudło
                    macierzStatkowPrzyciski[i][j].setBackground(Color.black);
                    macierzStatkowPrzyciski[i][j].setIcon(oknoGra.pudlo);
                }
                else if (macierzStatkow[i][j] == 3){    //statek trafiony
                    macierzStatkowPrzyciski[i][j].setBackground(Color.black);
                    macierzStatkowPrzyciski[i][j].setIcon(oknoGra.statekTrafiony);
                }
                else if (macierzStatkow[i][j] == 9){    //statek zatopiony
                    macierzStatkowPrzyciski[i][j].setBackground(Color.black);
                    macierzStatkowPrzyciski[i][j].setIcon(oknoGra.statekTrafiony);
                }
                this.add(macierzStatkowPrzyciski[i][j]);
            }
        }
    }
    public void ustawStatki(int start){
        for(int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                macierzStatkow[i][j] = gracz.ulozenieStatkow[i][j];
                macierzStatkow[i][j] += 2*przeciwnik.tablicaStrzalow[i][j];
                macierzStatkowPrzyciski[i][j] = new JButton();
                macierzStatkowPrzyciski[i][j].setEnabled(false);
                if (macierzStatkow[i][j] == 0){
                    macierzStatkowPrzyciski[i][j].setBackground(Color.black);
                }
                else if (macierzStatkow[i][j] == 1){
                    macierzStatkowPrzyciski[i][j].setBackground(Color.black);
                    macierzStatkowPrzyciski[i][j].setIcon(oknoGra.statek);
                }
                else if (macierzStatkow[i][j] == 2){
                    macierzStatkowPrzyciski[i][j].setBackground(Color.black);
                    macierzStatkowPrzyciski[i][j].setIcon(oknoGra.pudlo);
                }
                else if (macierzStatkow[i][j] == 3){
                    macierzStatkowPrzyciski[i][j].setBackground(Color.black);
                    macierzStatkowPrzyciski[i][j].setIcon(oknoGra.statekTrafiony);
                }
                this.add(macierzStatkowPrzyciski[i][j]);
            }
        }
    }
}