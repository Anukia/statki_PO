package com.company.Menu.NowaGra.Turniej;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Turniej {
    int liczbaGraczy;
    String nazwaTurnieju;
    String [] nazwyGraczy;
    public String[][] tablicaMeczy;
    public String[][] rozegraneMecze;
    public int rozegranychMeczy;
    public int[] ranking;
    String nazwaHosta;
    Map<String, Integer> indeksyGraczy;
    public String zwyciezca = "";
    public String[][] rankingPosortowany;

    public Turniej() {
        rozegranychMeczy = 0;
        this.wyliczMeczeDoRozegrania();
    }

    public void setIndeksyGraczy() {
        this.indeksyGraczy = new HashMap<String, Integer>();
        for (int i = 0; i < liczbaGraczy; i++) {
            indeksyGraczy.put(nazwyGraczy[i], i);
        }
    }

    public void reset() {
        this.rozegranychMeczy = 0;
    }

    public void setLiczbaGraczy(int liczbaGraczy) {

        this.liczbaGraczy = liczbaGraczy;
        nazwyGraczy = new String[liczbaGraczy];
    }

    public void setNazwaTurnieju(String nazwaTurnieju) {
        this.nazwaTurnieju = nazwaTurnieju;
    }

    public void setNazwaHosta(String nazwaHosta) {
        this.nazwaHosta = nazwaHosta;
    }

    public String getNazwaHosta() {
        return nazwaHosta;
    }

    public String[] getNazwyGraczy() {
        return nazwyGraczy;
    }

    public void setRozegranychMeczy(int rozegranychMeczy) {
        this.rozegranychMeczy = rozegranychMeczy;
    }

    public void wyliczMeczeDoRozegrania() {
        this.tablicaMeczy = new String[(liczbaGraczy*(liczbaGraczy-1))/2][2];
        this.rozegraneMecze = new String[(liczbaGraczy*(liczbaGraczy-1))/2][2];
        int licznikMeczy = 0;
        for (int i = 0; i < this.liczbaGraczy; i++) {
            for (int j = i+1; j < this.liczbaGraczy; j++) {
                tablicaMeczy[licznikMeczy][0] = nazwyGraczy[i];
                tablicaMeczy[licznikMeczy][1] = nazwyGraczy[j];
                licznikMeczy++;
            }
        }
    }

    public void koniec() {

    }

    public void wczytaj(String nazwaHosta) {
        this.reset();
        FileReader f1;
        BufferedReader odczytTurnieju;
        {
            try {
                f1 = new FileReader(nazwaHosta + ".txt");
                odczytTurnieju = new BufferedReader(f1);
                this.nazwaTurnieju = odczytTurnieju.readLine();
                this.liczbaGraczy = Integer.parseInt(odczytTurnieju.readLine());
                this.nazwyGraczy = new String[this.liczbaGraczy];
                for (int i = 0; i < this.liczbaGraczy; i++) {
                    this.nazwyGraczy[i] = odczytTurnieju.readLine();
                }
                this.wyliczMeczeDoRozegrania();
                this.rozegranychMeczy = Integer.parseInt(odczytTurnieju.readLine( ));
                for (int i = 0; i < rozegranychMeczy; i++) {
                    this.rozegraneMecze[i][0] = odczytTurnieju.readLine();
                    this.rozegraneMecze[i][1] = odczytTurnieju.readLine();
                }
                this.rankingPosortowany = new String[liczbaGraczy][2];
                for (int i = 0; i < liczbaGraczy; i++) {
                    this.rankingPosortowany[i][0] = odczytTurnieju.readLine();
                    this.rankingPosortowany[i][1] = odczytTurnieju.readLine();
                }
                f1.close();
                odczytTurnieju.close();
                this.setNazwaHosta(nazwaHosta);
                this.setIndeksyGraczy();
                this.setRankingPosortowany();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void ranking() {
        setIndeksyGraczy();
        ranking = new int[liczbaGraczy];
        String zwyciezca;
        for (int i = 0; i < rozegranychMeczy; i++) {
            zwyciezca = rozegraneMecze[i][0];
            ranking[indeksyGraczy.get(zwyciezca)]++;
        }
    }

    public void setRankingPosortowany() {
        this.ranking();
        this.rankingPosortowany = new String[liczbaGraczy][liczbaGraczy];
        for (int i = 0; i < liczbaGraczy; i++) {
            int max = -1;
            String nick = "";
            for (int j = 0; j < liczbaGraczy; j++) {
                if(ranking[j] > max) {
                    max = ranking[j];
                    nick = nazwyGraczy[j];
                }
            }
            rankingPosortowany[i][0] = nick;
            rankingPosortowany[i][1] = String.valueOf(max);
            ranking[indeksyGraczy.get(nick)] = -1;
        }
        this.zwyciezca = rankingPosortowany[0][0];
    }

    public void zapisz(String nazwaHosta) {
        FileWriter zapisTurnieju;
        {
            try {
                zapisTurnieju = new FileWriter(nazwaHosta + ".txt", false);
                zapisTurnieju.write(this.nazwaTurnieju + "\n");
                zapisTurnieju.write(this.liczbaGraczy + "\n");
                for (int i = 0; i < this.liczbaGraczy; i++) {
                    zapisTurnieju.write(this.nazwyGraczy[i] + "\n");
                }
                zapisTurnieju.write(this.rozegranychMeczy + "\n");
                for (int i = 0; i < rozegranychMeczy; i++) {
                    zapisTurnieju.write(this.rozegraneMecze[i][0] + "\n");
                    zapisTurnieju.write(this.rozegraneMecze[i][1] + "\n");
                }
                this.setRankingPosortowany();
                for (int i = 0; i < liczbaGraczy; i++) {
                    zapisTurnieju.write(this.rankingPosortowany[i][0] + "\n");
                    zapisTurnieju.write(this.rankingPosortowany[i][1] + "\n");
                }
                zapisTurnieju.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
