package com.company.Menu;

import com.company.Menu.NowaGra.Turniej.OknoTurniej;
import com.company.OknoBazowe;

import javax.swing.*;
import java.awt.*;

public class ZalogowanyUzytkownik extends JLabel {

    OknoBazowe oknoBazowe;

    public ZalogowanyUzytkownik(OknoBazowe oknoBazowe) {

        this.oknoBazowe = oknoBazowe;
        this.setBounds(190, 740, 800, 100);
        this.setText("Zalogowany: " + oknoBazowe.gracz1.nickname);
        this.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        this.setForeground(new Color(253,211,125));
    }

    public void odswiez() {
        this.setText("Zalogowany: " + oknoBazowe.gracz1.nickname);
    }
}
