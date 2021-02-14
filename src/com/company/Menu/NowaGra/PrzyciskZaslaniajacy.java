package com.company.Menu.NowaGra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrzyciskZaslaniajacy extends JButton implements ActionListener {

    OknoGra oknoGra;

    public PrzyciskZaslaniajacy(OknoGra oknoGra, String kogoTura)
    {
        this.oknoGra = oknoGra;
        this.setBounds(100, 250, 1250, 600);
        this.setBackground(Color.BLACK);
        this.setFont(new Font("Comic Sans MS", Font.PLAIN, 90));
        this.setForeground(Color.white);
        this.setEnabled(true);
        this.addActionListener(this);
        this.setText("Tura gracza: " + kogoTura);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        oknoGra.remove(this);
        oknoGra.revalidate();
        oknoGra.repaint();
    }
}
