package com.company;

import javax.swing.*;

public class Tlo extends JLabel {
    ImageIcon tloObraz;

    public Tlo(JPanel okno) {
        this.setBounds(0, 0, 1600, 900);
        tloObraz = new ImageIcon("tlo.jpg");
        this.setIcon(tloObraz);
        okno.add(this);
    }
}
