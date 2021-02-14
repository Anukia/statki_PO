package com.company.Menu.NowaGra;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zegar implements ActionListener {
    Timer czasownik;
    int czas = 0;

    public Zegar () {
        czasownik = new Timer(1000,this);
        czasownik.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        czas++;
    }

    public void wyzeruj() {
        czas = 0;
    }

    public int getCzas() {
        return czas;
    }
}
