package com.company;

import javax.swing.*;
import java.awt.*;

public class Tytul extends JLabel {
    public Tytul() {
        //this.setBounds(550, 50, 500, 150);
        this.setBounds(385, 50, 700, 150);
        this.setOpaque(false);
        this.setText("S t a t k i");
        this.setFont(new Font("Comic Sans MS", Font.PLAIN, 135));
        this.setHorizontalAlignment(CENTER);
        this.setForeground(new Color(4, 48, 87));
    }
}
