package com.company;

import com.company.Menu.NowaGra.Turniej.Turniej;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OknoBazowe extends JFrame{
    public Gracz gracz1;
    public Gracz gracz2;
    public String nazwaPlikDaneLogowania = "D:\\Kamila\\Studia\\statki\\DaneLogowania.txt";
    public String nazwaPlikWyniki = "D:\\Kamila\\Studia\\statki\\Wyniki.txt";
    public FileWriter zapisDaneLogowania;
    FileReader fr1;
    public BufferedReader odczytDaneLogowania;
    public FileWriter zapisWyniki;
    FileReader fr2;
    public BufferedReader odczytWyniki;
    public Turniej aktualnyTurniej;

    {
        try {
            zapisDaneLogowania = new FileWriter(nazwaPlikDaneLogowania, true);
            fr1 = new FileReader(nazwaPlikDaneLogowania);
            odczytDaneLogowania = new BufferedReader(fr1);
            zapisWyniki = new FileWriter(nazwaPlikWyniki, true);
            fr2 = new FileReader(nazwaPlikWyniki);
            odczytWyniki = new BufferedReader(fr2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public OknoBazowe() {
        gracz1 = new Gracz(this);
        gracz2 = new Gracz(this);
        aktualnyTurniej = new Turniej();
        this.setTitle("Statki");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1600,900);
        this.setLayout(null);
        //ewentualne miejsce na ikonke
        this.setVisible(true);
    }
}
