package com.company.Menu.NowaGra.PrzygotowanieGry;

import com.company.Menu.NowaGra.GraBot.OknoGraBot;
import com.company.Menu.NowaGra.OknoNowaGra;
import com.company.Menu.Ustawienia.OknoUstawienia;
import com.company.OknoBazowe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrzyciskZatwierdzPrzygotowanie extends JButton {

    public int pozostalePrzygotowania;
    protected OknoBazowe oknoBazowe;
    protected OknoNowaGra oknoNowaGra;
    protected OknoUstawienia oknoUstawienia;
    protected OknoPrzygotowanieGry oknoPrzygotowanieGry;

    public PrzyciskZatwierdzPrzygotowanie(int pozostalo, OknoBazowe oknBazowe, OknoNowaGra oknNowaGra, OknoUstawienia oknUstawienia, OknoPrzygotowanieGry oknPrzygotowanieGry) {
        pozostalePrzygotowania = pozostalo;
        oknoBazowe = oknBazowe;
        oknoNowaGra = oknNowaGra;
        oknoUstawienia = oknUstawienia;
        oknoPrzygotowanieGry = oknPrzygotowanieGry;

        this.setText("Zatwierdź");
        this.setEnabled(false);
        this.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        this.setBounds(1200,600,250,100);
    }


    public void blokuj() {
        this.setEnabled(false);
    }

    public void odblokuj() {
        this.setEnabled(true);
    }
}
