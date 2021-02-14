package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankingOgolny {
    Map<String, Integer> wygraneGraczy;
    public String[] ranking;
    public int[] rankingWygrane;

    public RankingOgolny(BufferedReader odczyt) {
        this.wygraneGraczy = new HashMap<String, Integer>();
        ranking = new String[10];
        rankingWygrane = new int[10];
        try {
            wczytajGraczy(odczyt);
            wczytajWygrane(odczyt);
            ustawRanking();
            wczytajWygrane(odczyt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void wczytajGraczy(BufferedReader odczyt) throws IOException {
        odczyt.mark(1000);
        String nick = odczyt.readLine();
        while(nick != null) {
            if (!(wygraneGraczy.containsKey(nick))) {
                wygraneGraczy.put(nick, 0);
            }
            nick = odczyt.readLine();
        }
        odczyt.reset();
    }

    public void wczytajWygrane(BufferedReader odczyt) throws IOException {
        odczyt.mark(1000);
        String nick = odczyt.readLine();
        odczyt.readLine();
        while(nick != null) {
            wygraneGraczy.put(nick, wygraneGraczy.get(nick)+1);
            nick = odczyt.readLine();
            odczyt.readLine();
        }
        odczyt.reset();
    }

    public String znajdzNajlepszego() {
        String najlepszy = "nie działa";
        int max = -1;
        for (Map.Entry<String, Integer> gracz : wygraneGraczy.entrySet()) {
            if (gracz.getValue() > max) {
                najlepszy = gracz.getKey();
                max = wygraneGraczy.get(najlepszy);
            }
        }
        return najlepszy;
    }

    public void ustawRanking() {
        String najlepszy;
        for (int i = 0; i < 10; i++) {
            najlepszy = this.znajdzNajlepszego();
            ranking[i] = najlepszy;
            rankingWygrane[i] = wygraneGraczy.get(najlepszy);
            wygraneGraczy.put(najlepszy, -1);
        }
    }
}
