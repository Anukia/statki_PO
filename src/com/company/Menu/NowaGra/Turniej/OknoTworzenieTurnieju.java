package com.company.Menu.NowaGra.Turniej;

import com.company.Menu.NowaGra.Dologowanie.OknoDologowania;
import com.company.Menu.NowaGra.OknoNowaGra;
import com.company.Menu.NowaGra.PrzygotowanieGry.OknoPrzygotowanieGry;
import com.company.Menu.Ustawienia.OknoUstawienia;
import com.company.OknoBazowe;
import com.company.Powrot;
import com.company.Tlo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoTworzenieTurnieju extends JPanel implements ActionListener {
    JLabel nazwa;
    JLabel liczbaGraczy;
    JTextField podanaNazwa;
    JTextField podanaLiczbaGraczy;
    JButton dalej;
    OknoBazowe oknoBazowe;
    OknoWpiszGraczy oknoWpiszGraczy;
    OknoTurniej oknoTurniej;

    public OknoTworzenieTurnieju(OknoBazowe oknoBazowe, OknoNowaGra oknNowaGra, OknoUstawienia oknUstawienia, OknoTurniej oknoTurniej) {
        this.setBounds(0, 0, 1600, 900);
        this.setOpaque(false);
        this.setLayout(null);

        this.oknoBazowe = oknoBazowe;
        this.oknoTurniej = oknoTurniej;

        nazwa = new JLabel();
        nazwa.setText("Nazwa turnieju: ");
        nazwa.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        nazwa.setBounds(200,200, 400,70);
        nazwa.setHorizontalAlignment(JLabel.RIGHT);
        this.add(nazwa);

        podanaNazwa = new JTextField();
        podanaNazwa.setBounds(600,200,500,60);
        podanaNazwa.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        this.add(podanaNazwa);

        liczbaGraczy = new JLabel();
        liczbaGraczy.setText("Liczba graczy w turnieju: ");
        liczbaGraczy.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        liczbaGraczy.setBounds(200,330, 400,70);
        liczbaGraczy.setHorizontalAlignment(JLabel.RIGHT);
        this.add(liczbaGraczy);

        podanaLiczbaGraczy = new JTextField();
        podanaLiczbaGraczy.setBounds(600,340,500,60);
        podanaLiczbaGraczy.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        this.add(podanaLiczbaGraczy);

        dalej = new JButton();
        dalej.setBounds(1000, 450, 250, 75);
        dalej.setText("Dalej");
        dalej.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        dalej.addActionListener(this);
        this.add(dalej);

        Powrot powrot = new Powrot(oknoBazowe, oknNowaGra);
        this.add(powrot);

        Tlo tlo = new Tlo(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == dalej) {
            if (podanaNazwa.getText().equals("") || podanaLiczbaGraczy.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Nie podano nazwy turnieju lub liczby graczy!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
            else {
                oknoBazowe.aktualnyTurniej.setNazwaTurnieju(podanaNazwa.getText());
                oknoBazowe.aktualnyTurniej.setLiczbaGraczy(Integer.parseInt(podanaLiczbaGraczy.getText()));

                oknoWpiszGraczy = new OknoWpiszGraczy(oknoBazowe, oknoTurniej);
                oknoBazowe.getContentPane().removeAll();
                oknoBazowe.getContentPane().add(oknoWpiszGraczy);
                oknoBazowe.revalidate();
                oknoBazowe.repaint();
            }
        }
    }
}
