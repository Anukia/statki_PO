package com.company.Menu.NowaGra;

import com.company.Menu.NowaGra.GraBot.OknoGraBot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrzyciskZatwierdzStrzal extends JButton {
    OknoGra oknoGra;

    public PrzyciskZatwierdzStrzal(OknoGra oknGra) {
        oknoGra = oknGra;
        this.setText("Zatwierdź");
        this.setEnabled(false);
        this.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        this.setBounds(1375,750,175,75);
    }

    public void blokuj() {
        this.setEnabled(false);
    }
    public void odblokuj() {
        this.setEnabled(true);
    }
}
