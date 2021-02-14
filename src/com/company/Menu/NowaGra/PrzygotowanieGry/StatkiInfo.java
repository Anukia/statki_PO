package com.company.Menu.NowaGra.PrzygotowanieGry;

import javax.swing.*;
import java.awt.*;

public class StatkiInfo extends JTextArea {
    public StatkiInfo(String text) {
        this.setOpaque(true);
        this.setBackground(new Color(255,255,255,100));
        this.setMargin(new Insets(20,20,20,20));
        this.setBounds(650, 0, 350, 600);
        this.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        this.setEditable(false);
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setText(text);
    }
}
