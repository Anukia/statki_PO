package com.company.Menu.NowaGra.PrzygotowanieGry;

import com.company.Menu.NowaGra.OknoNowaGra;
import com.company.Menu.Ustawienia.OknoUstawienia;

import javax.swing.*;

public class PanelUmieszczania extends JPanel {

    PanelPrzyciskow panelPrzyciskow;
    JTextArea statkiInfo;
    public int[] listaStatkowNadmiarowych;
    public int[] listaStatkowNaPlanszy;
    public int[] listaStatkowDoUmieszczenia;
    PrzyciskUmieszczenie[][] tablicaPrzyciskow;
    String statkiDoUmieszczenia, statkiNaPlanszy, statkiNadmiarowe;
    int rozmiar;
    OknoUstawienia oknoUstawienia;
    OknoPrzygotowanieGry oknoPrzygotowanieGry;
    OknoNowaGra oknoNowaGra;


    public PanelUmieszczania(OknoUstawienia oknUstawienia, OknoPrzygotowanieGry oknPrzygotowanieGry, int pozostalePrzygotowania, OknoNowaGra oknNowaGra) {
        this.setBounds(150, 250, 1300, 600);
        this.setOpaque(false);
        this.setLayout(null);

        oknoUstawienia = oknUstawienia;
        oknoPrzygotowanieGry = oknPrzygotowanieGry;
        oknoNowaGra = oknNowaGra;
        rozmiar = oknoUstawienia.rozmiarPlanszy;
        tablicaPrzyciskow = new PrzyciskUmieszczenie[rozmiar][rozmiar];


        panelPrzyciskow = new PanelPrzyciskow(oknoPrzygotowanieGry ,oknoUstawienia, this);
        this.add(panelPrzyciskow);

        listaStatkowNadmiarowych = new int[oknoUstawienia.maxDlugoscStatku];
        listaStatkowNaPlanszy = new int[oknoUstawienia.maxDlugoscStatku];
        listaStatkowDoUmieszczenia = new int[oknoUstawienia.maxDlugoscStatku];

        statkiDoUmieszczenia = "Statki do umieszczenia:\n";
        //statkiNaPlanszy = "Statki na planszy:\n";
        statkiNadmiarowe = "Statki nadmiarowe:\n";


        for (int i = 0; i < oknoUstawienia.maxDlugoscStatku; i++) {
            listaStatkowDoUmieszczenia[i] = 0;
            listaStatkowNaPlanszy[i] = 0;
            listaStatkowNadmiarowych[i] = 0;
            for (int j = 0; j < oknoUstawienia.listaStatkow[i]; j++) {
                listaStatkowDoUmieszczenia[i]++;
                statkiDoUmieszczenia += przerob(i) + "masztowiec\n";
            }


        }
        statkiDoUmieszczenia += "\n";
        statkiInfo = new StatkiInfo(statkiDoUmieszczenia + statkiNadmiarowe);
        this.add(statkiInfo);

    }

    String przerob(int liczba) {
        if (liczba == 1) {
            return "Jedno";
        }
        if (liczba == 2) {
            return "Dwu";
        }
        if (liczba == 3) {
            return "Trój";
        }
        if (liczba == 4) {
            return "Cztero";
        }
        if (liczba == 5) {
            return "Pięcio";
        }
        if (liczba == 6) {
            return "Sześcio";
        }
        if (liczba == 7) {
            return "Siedmio";
        }
        if (liczba == 8) {
            return "Ośmio";
        }
        if (liczba == 9) {
            return "Dziewięcio";
        }
        if (liczba == 10) {
            return "Dziesięcio";
        }
        else return "Zadużo";
    }

    public void sprawdzStatki() {
        for (int i = 0; i < oknoUstawienia.maxDlugoscStatku; i++) {
            listaStatkowNaPlanszy[i] = 0;
        }
        int dlugoscStatku;
        int[][] macierzOdwiedzonych;
        rozmiar = oknoUstawienia.rozmiarPlanszy;
        macierzOdwiedzonych = new int[rozmiar][rozmiar];
        for(int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                macierzOdwiedzonych[i][j] = 0;
            }
        }
        int k, l;
        for(int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                if (macierzOdwiedzonych[i][j] == 0) {
                    macierzOdwiedzonych[i][j] = 1;
                    if (oknoPrzygotowanieGry.macierzWcisniec[i][j] == 1) {
                        dlugoscStatku = 1;
                        k = i+1;
                        l = j+1;
                        while(k < rozmiar) {
                            macierzOdwiedzonych[k][j] = 1;
                            if (oknoPrzygotowanieGry.macierzWcisniec[k][j] == 1) {
                                dlugoscStatku++;
                                k++;
                            }
                            else {
                                break;
                            }
                        }
                        while(l < rozmiar) {
                            macierzOdwiedzonych[i][l] = 1;
                            if (oknoPrzygotowanieGry.macierzWcisniec[i][l] == 1) {
                                dlugoscStatku++;
                                l++;
                            }
                            else {
                                break;
                            }
                        }
                        listaStatkowNaPlanszy[dlugoscStatku]++;
                    }
                }
            }
        }
        for (int i = 0; i < oknoUstawienia.maxDlugoscStatku; i++) {
            listaStatkowNadmiarowych[i] = listaStatkowNaPlanszy[i] - listaStatkowDoUmieszczenia[i];
        }

        /*
        statkiNaPlanszy = "Statki na planszy:\n";
        for (int i = 0; i < oknoUstawienia.liczbaStatkow; i++) {
            for (int j = 0; j < listaStatkowNaPlanszy[i]; j++) {
                statkiNaPlanszy += przerob(i) + "masztowiec\n";
            }
        }
        */
        statkiNadmiarowe = "Statki nadmiarowe:\n";
        for (int i = 0; i < oknoUstawienia.maxDlugoscStatku; i++) {
            for (int j = 0; j < listaStatkowNadmiarowych[i]; j++) {
                statkiNadmiarowe += przerob(i) + "masztowiec\n";
            }
        }

        statkiDoUmieszczenia = "Statki do umieszczenia:\n";
        for (int i = 0; i < oknoUstawienia.maxDlugoscStatku; i++) {
            for (int j = listaStatkowNadmiarowych[i]; j < 0; j++) {
                statkiDoUmieszczenia += przerob(i) + "masztowiec\n";
            }
        }
        statkiDoUmieszczenia += "\n";

        this.remove(statkiInfo);
        statkiInfo = new StatkiInfo(statkiDoUmieszczenia + statkiNadmiarowe);
        this.add(statkiInfo);
        oknoPrzygotowanieGry.odswiezOkno();
        for (int i = 0; i < listaStatkowNadmiarowych.length; i++){
            if (listaStatkowNadmiarowych[i] != 0) {
                oknoPrzygotowanieGry.przyciskZatwierdzPrzygotowanie.blokuj();
                break;
            }
            oknoPrzygotowanieGry.przyciskZatwierdzPrzygotowanie.odblokuj();
        }
    }

    public void blokowanie(PrzyciskUmieszczenie przyciskUmieszczenie) {
        if (przyciskUmieszczenie.wiersz+1 < rozmiar && przyciskUmieszczenie.kolumna+1 < rozmiar) {
            tablicaPrzyciskow[przyciskUmieszczenie.wiersz+1][przyciskUmieszczenie.kolumna+1].blokuj();
        }
        if (przyciskUmieszczenie.wiersz+1 < rozmiar && przyciskUmieszczenie.kolumna-1 >= 0) {
            tablicaPrzyciskow[przyciskUmieszczenie.wiersz+1][przyciskUmieszczenie.kolumna-1].blokuj();
        }
        if (przyciskUmieszczenie.wiersz-1 >= 0 && przyciskUmieszczenie.kolumna+1 < rozmiar) {
            tablicaPrzyciskow[przyciskUmieszczenie.wiersz-1][przyciskUmieszczenie.kolumna+1].blokuj();
        }
        if (przyciskUmieszczenie.wiersz-1 >= 0 && przyciskUmieszczenie.kolumna-1 >= 0) {
            tablicaPrzyciskow[przyciskUmieszczenie.wiersz-1][przyciskUmieszczenie.kolumna-1].blokuj();
        }
    }

    public void odblokowanie(PrzyciskUmieszczenie przyciskUmieszczenie) {
        if (przyciskUmieszczenie.wiersz+1 < rozmiar && przyciskUmieszczenie.kolumna+1 < rozmiar) {
            tablicaPrzyciskow[przyciskUmieszczenie.wiersz+1][przyciskUmieszczenie.kolumna+1].odblokuj();
        }
        if (przyciskUmieszczenie.wiersz+1 < rozmiar && przyciskUmieszczenie.kolumna-1 >= 0) {
            tablicaPrzyciskow[przyciskUmieszczenie.wiersz+1][przyciskUmieszczenie.kolumna-1].odblokuj();
        }
        if (przyciskUmieszczenie.wiersz-1 >= 0 && przyciskUmieszczenie.kolumna+1 < rozmiar) {
            tablicaPrzyciskow[przyciskUmieszczenie.wiersz-1][przyciskUmieszczenie.kolumna+1].odblokuj();
        }
        if (przyciskUmieszczenie.wiersz-1 >= 0 && przyciskUmieszczenie.kolumna-1 >= 0) {
            tablicaPrzyciskow[przyciskUmieszczenie.wiersz-1][przyciskUmieszczenie.kolumna-1].odblokuj();
        }
    }

    public void odswiez(PrzyciskUmieszczenie przyciskUmieszczenie) {
        if (oknoPrzygotowanieGry.macierzWcisniec[przyciskUmieszczenie.wiersz][przyciskUmieszczenie.kolumna]==1) {
            blokowanie(przyciskUmieszczenie);
            sprawdzStatki();
        }
        else {
            odblokowanie(przyciskUmieszczenie);
            sprawdzStatki();
        }
    }
}