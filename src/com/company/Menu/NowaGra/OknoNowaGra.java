package com.company.Menu.NowaGra;

import com.company.Menu.NowaGra.GraBot.OknoGraBot;
import com.company.Menu.OknoMenu;
import com.company.Menu.Ustawienia.OknoUstawienia;
import com.company.Menu.ZalogowanyUzytkownik;
import com.company.OknoBazowe;
import com.company.Powrot;
import com.company.Tlo;

import javax.swing.*;
import java.awt.*;

public class OknoNowaGra extends JPanel{
    JTextArea zasadyGry1;
    JTextArea zasadyGry2;
    public ZalogowanyUzytkownik zalogowanyUzytkownik;
    OknoBazowe oknoBazowe;
    Powrot powrot;
    OknoGraBot oknoGraBot;
    public Zegar zegar;

    public OknoNowaGra (OknoBazowe  okno, OknoMenu oknoMenu, OknoUstawienia oknoUstawienia) {
        oknoBazowe = okno;
        zegar = new Zegar();

        this.setBounds(0, 0, 1600, 900);
        this.setBackground(new Color(45, 156, 196));
        this.setLayout(null);

        powrot = new Powrot(oknoBazowe, oknoMenu);
        this.add(powrot);

        PrzyciskiNowaGra przyciskiNowaGra = new PrzyciskiNowaGra(oknoBazowe, this, oknoUstawienia);
        this.add(przyciskiNowaGra);

        zasadyGry1 = new JTextArea();
        zasadyGry1.setOpaque(true);
        zasadyGry1.setBackground(new Color(255,255,255,100));
        zasadyGry1.setMargin(new Insets(20,20,20,20));
        zasadyGry1.setBounds(50, 100, 450, 425);
        zasadyGry1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        zasadyGry1.setLineWrap(true);
        zasadyGry1.setWrapStyleWord(true);
        zasadyGry1.setEditable(false);
        zasadyGry1.setText("Przygotowanie gry:\n\n" +
                "Każdy z graczy posiada po dwie plansze. Pola oznaczone są poprzez współrzędne literami (np. od A do J) i liczbami (np. od 1 do 10).\n" +
                "Na jednym z kwadratów gracz zaznacza swoje statki, których położenie będzie odgadywał przeciwnik. Na drugim zaznacza trafione statki przeciwnika i oddane przez siebie strzały.\n" +
                "Statki ustawiane są w pionie lub poziomie, w taki sposób, aby nie stykały się one ze sobą ani bokami, ani rogami.");
        this.add(zasadyGry1);

        zasadyGry2 = new JTextArea();
        zasadyGry2.setOpaque(true);
        zasadyGry2.setBackground(new Color(255,255,255,100));
        zasadyGry2.setBounds(1050, 100, 450, 510);
        zasadyGry2.setMargin(new Insets(20,20,20,20));
        zasadyGry2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        zasadyGry2.setLineWrap(true);
        zasadyGry2.setWrapStyleWord(true);
        zasadyGry2.setEditable(false);
        zasadyGry2.setText ("Zasady gry:\n\n" +
                "Trafienie okrętu przeciwnika polega na strzale, który jest odgadnięciem położenia jakiegoś statku. Strzały oddawane są naprzemiennie, poprzez podanie współrzędnych pola (np. B5). \n" +
                "W przypadku strzału trafionego, gracz kontynuuje strzelanie (czyli swój ruch) aż do momentu chybienia.\n" +
                "Zatopienie statku ma miejsce wówczas, gdy gracz odgadnie położenie całego statku.\n" +
                "O chybieniu gracz informuje przeciwnika słowem „pudło”, o trafieniu „trafiony” lub „(trafiony) zatopiony”.\n" +
                "Wygrywa ten, kto pierwszy zatopi wszystkie statki przeciwnika.");
        this.add(zasadyGry2);

        zalogowanyUzytkownik = new ZalogowanyUzytkownik(oknoBazowe);
        this.add(zalogowanyUzytkownik);

        Tlo tlo = new Tlo(this);
    }
}
