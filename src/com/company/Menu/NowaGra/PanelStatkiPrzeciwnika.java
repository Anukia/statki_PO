package com.company.Menu.NowaGra;

import com.company.Gracz;
import com.company.Menu.Ustawienia.OknoUstawienia;

import javax.swing.*;
import java.awt.*;

public class PanelStatkiPrzeciwnika extends JPanel {
    public PrzyciskStrzelanie[][] macierzStatkowPrzyciski;
    int rozmiar;
    public int macierzStatkow[][];
    OknoGra oknoGra;
    Gracz gracz;
    Gracz przeciwnik;

    public PanelStatkiPrzeciwnika(OknoUstawienia oknoUstawienia, Gracz przeciwnik, Gracz gracz, OknoGra oknoGra) {
        rozmiar = oknoUstawienia.rozmiarPlanszy;
        this.setBounds(750, 250, 600, 600);
        this.setOpaque(false);
        this.setLayout(new GridLayout(rozmiar, rozmiar, 0,0));
        this.oknoGra = oknoGra;
        this.gracz = gracz;
        this.przeciwnik = przeciwnik;

        macierzStatkow = new int[rozmiar][rozmiar];
        macierzStatkowPrzyciski = new PrzyciskStrzelanie[rozmiar][rozmiar];
        ustawStrzelnice();
    }
    public void blokada(int wiersz, int kolumna) {
        for (int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                macierzStatkowPrzyciski[i][j].blokuj();
            }
        }
        macierzStatkowPrzyciski[wiersz][kolumna].odblokuj();
    }
    public void odblokada() {
        for (int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                if (macierzStatkowPrzyciski[i][j].zblokowany == false) {
                    macierzStatkowPrzyciski[i][j].odblokuj();
                }
            }
        }
    }
    public void ustawStrzelnice() {
        for(int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                macierzStatkow[i][j] = gracz.tablicaStrzalow[i][j];
                macierzStatkow[i][j] += 2*przeciwnik.ulozenieStatkow[i][j];
                macierzStatkowPrzyciski[i][j] = new PrzyciskStrzelanie(i, j, this, oknoGra);
                if (macierzStatkow[i][j] == 1){ //jeżeli strzelam (1) i nie ma statku (0)
                    macierzStatkowPrzyciski[i][j].pudlo();
                }
                else if (macierzStatkow[i][j] == 3){ //jeżeli strzelam (1) i jest statek (2)
                    macierzStatkowPrzyciski[i][j].trafienie();
                }
                else if (macierzStatkow[i][j] == 6){ //jeżeli strzal z zatopieniem (4) i jest statek (2)
                    macierzStatkowPrzyciski[i][j].zatopienie();
                }
                this.add(macierzStatkowPrzyciski[i][j]);
            }
        }
    }
    public void ustawStrzelnice(int drugiRaz) {
        for(int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                this.remove(macierzStatkowPrzyciski[i][j]);
                macierzStatkow[i][j] = gracz.tablicaStrzalow[i][j];
                macierzStatkow[i][j] += 2*przeciwnik.ulozenieStatkow[i][j];
                macierzStatkowPrzyciski[i][j] = new PrzyciskStrzelanie(i, j, this, oknoGra);
                if (macierzStatkow[i][j] == 0){
                }
                else if (macierzStatkow[i][j] == 1){
                    macierzStatkowPrzyciski[i][j].pudlo();
                }
                else if (macierzStatkow[i][j] == 2){
                }
                else if (macierzStatkow[i][j] == 3){
                    macierzStatkowPrzyciski[i][j].trafienie();
                }
                this.add(macierzStatkowPrzyciski[i][j]);
            }
        }
    }
}