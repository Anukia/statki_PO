package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Powrot extends JButton implements ActionListener {
    Icon powrot;
    OknoBazowe oknoBazowe;
    JPanel okno;

    public Powrot(OknoBazowe oknBazowe, JPanel okn) {
        okno = okn;
        oknoBazowe = oknBazowe;
        powrot = new ImageIcon("back-arrow.png");
        this.setOpaque(true);
        this.setFocusable(false);
        this.setContentAreaFilled(false);
        //this.setBorderPainted(false);
        this.addActionListener(this);
        this.setBounds(50,700, 75,75);
        this.setIcon(powrot);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this) {
            oknoBazowe.getContentPane().removeAll();
            oknoBazowe.getContentPane().add(okno);
            oknoBazowe.revalidate();
            oknoBazowe.repaint();
        }
    }
}
