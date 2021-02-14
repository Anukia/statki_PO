package com.company.Menu.NowaGra.PrzygotowanieGry;

import com.company.Gracz;

import javax.swing.*;
import java.awt.*;

public class PanelInfo extends JPanel {
   JLabel ktoVsKto;
   JLabel tura;
   String user1;
   String user2;

    public  PanelInfo(Gracz gracz, Gracz przeciwnik, int pozostalePrzygotowania) {
        this.setOpaque(false);
        this.setBounds(150, 50, 1300, 200);
        this.setLayout(null);
        user1 = gracz.nickname;
        user2 = przeciwnik.nickname;


        ktoVsKto = new JLabel(user1 + "  VS  " + user2);
        ktoVsKto.setBounds(0, 0, 1300, 125);
        ktoVsKto.setOpaque(false);
        ktoVsKto.setFont(new Font("Comic Sans MS", Font.PLAIN, 70));
        ktoVsKto.setHorizontalAlignment(SwingConstants.CENTER);
        ktoVsKto.setForeground(new Color(4, 48, 87));
        this.add(ktoVsKto);

        tura = new JLabel();
        tura.setBounds(50, 125, 1300, 75);
        tura.setOpaque(false);
        tura.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        this.add(tura);
        /*
        if(pozostalePrzygotowania == 1) {
            tura.setText("Tura: " + user2);
        }

        else if (pozostalePrzygotowania == 0) {
            tura.setText("Tura: " + user1);
        }
        */
        tura.setText("Tura: " + user1);
    }
}
