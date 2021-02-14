package com.company.Menu.Ustawienia;

import com.company.Menu.OknoMenu;
import com.company.OknoBazowe;
import com.company.Powrot;
import com.company.Tlo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoUstawienia extends JPanel implements ActionListener {

    Powrot powrot;
    public int rozmiarPlanszy;
    public int maxDlugoscStatku = 10;
    public int[] listaStatkow = new int[maxDlugoscStatku + 1];
    public int liczbaStatkow;
    JTextField szerokoscPlanszy;
    JLabel [] napisMasztowiec;
    JTextField [] textMasztowiec;
    JButton zatwierdz;

    public OknoUstawienia(OknoBazowe oknoBazowe, OknoMenu oknoMenu) {

        this.setBounds(0, 0, 1600, 900);
        this.setLayout(null);
        for (int i = 0; i <= maxDlugoscStatku; i++) {
            this.listaStatkow[i] = 0;
        }
        this.listaStatkow[2] = 3;
        this.rozmiarPlanszy = 10;

        JLabel szerokosc = new JLabel("Rozmiar planszy: ");
        szerokosc.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        szerokosc.setHorizontalAlignment(SwingConstants.RIGHT);
        szerokosc.setBounds(450,50, 600,65);
        szerokoscPlanszy = new JTextField(String.valueOf(rozmiarPlanszy));
        szerokoscPlanszy.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        szerokoscPlanszy.setBounds(1050, 50, 100,65);
        this.add(szerokosc);
        this.add(szerokoscPlanszy);

        napisMasztowiec = new JLabel[maxDlugoscStatku + 1];
        textMasztowiec = new JTextField[maxDlugoscStatku+1];
        napisMasztowiec[0] = new JLabel("Liczba jednomasztowców: ");
        napisMasztowiec[0].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        napisMasztowiec[0].setHorizontalAlignment(SwingConstants.RIGHT);
        napisMasztowiec[0].setBounds(450,125, 600,65);
        textMasztowiec[0] = new JTextField(String.valueOf(listaStatkow[1]));
        textMasztowiec[0].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        textMasztowiec[0].setBounds(1050, 125, 100,65);
        this.add(napisMasztowiec[0]);
        this.add(textMasztowiec[0]);

        napisMasztowiec[1] = new JLabel("Liczba dwumasztowców: ");
        napisMasztowiec[1].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        napisMasztowiec[1].setHorizontalAlignment(SwingConstants.RIGHT);
        napisMasztowiec[1].setBounds(450,197, 600,65);
        textMasztowiec[1] = new JTextField(String.valueOf(listaStatkow[2]));
        textMasztowiec[1].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        textMasztowiec[1].setBounds(1050, 197, 100,65);
        this.add(napisMasztowiec[1]);
        this.add(textMasztowiec[1]);

        napisMasztowiec[2] = new JLabel("Liczba trójmasztowców: ");
        napisMasztowiec[2].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        napisMasztowiec[2].setHorizontalAlignment(SwingConstants.RIGHT);
        napisMasztowiec[2].setBounds(450,269, 600,65);
        textMasztowiec[2] = new JTextField(String.valueOf(listaStatkow[3]));
        textMasztowiec[2].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        textMasztowiec[2].setBounds(1050, 269, 100,65);
        this.add(napisMasztowiec[2]);
        this.add(textMasztowiec[2]);

        napisMasztowiec[3] = new JLabel("Liczba czteromasztowców: ");
        napisMasztowiec[3].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        napisMasztowiec[3].setHorizontalAlignment(SwingConstants.RIGHT);
        napisMasztowiec[3].setBounds(450,341, 600,65);
        textMasztowiec[3] = new JTextField(String.valueOf(listaStatkow[4]));
        textMasztowiec[3].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        textMasztowiec[3].setBounds(1050, 341, 100,65);
        this.add(napisMasztowiec[3]);
        this.add(textMasztowiec[3]);

        napisMasztowiec[4] = new JLabel("Liczba pięciomasztowców: ");
        napisMasztowiec[4].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        napisMasztowiec[4].setHorizontalAlignment(SwingConstants.RIGHT);
        napisMasztowiec[4].setBounds(450,413, 600,65);
        textMasztowiec[4] = new JTextField(String.valueOf(listaStatkow[5]));
        textMasztowiec[4].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        textMasztowiec[4].setBounds(1050, 413, 100,65);
        this.add(napisMasztowiec[4]);
        this.add(textMasztowiec[4]);

        napisMasztowiec[5] = new JLabel("Liczba sześciomasztowców: ");
        napisMasztowiec[5].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        napisMasztowiec[5].setHorizontalAlignment(SwingConstants.RIGHT);
        napisMasztowiec[5].setBounds(450,485, 600,65);
        textMasztowiec[5] = new JTextField(String.valueOf(listaStatkow[6]));
        textMasztowiec[5].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        textMasztowiec[5].setBounds(1050, 485, 100,65);
        this.add(napisMasztowiec[5]);
        this.add(textMasztowiec[5]);

        napisMasztowiec[6] = new JLabel("Liczba siedmiomasztowców: ");
        napisMasztowiec[6].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        napisMasztowiec[6].setHorizontalAlignment(SwingConstants.RIGHT);
        napisMasztowiec[6].setBounds(450,557, 600,65);
        textMasztowiec[6] = new JTextField(String.valueOf(listaStatkow[7]));
        textMasztowiec[6].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        textMasztowiec[6].setBounds(1050, 557, 100,65);
        this.add(napisMasztowiec[6]);
        this.add(textMasztowiec[6]);

        napisMasztowiec[7] = new JLabel("Liczba ośmiomasztowców: ");
        napisMasztowiec[7].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        napisMasztowiec[7].setHorizontalAlignment(SwingConstants.RIGHT);
        napisMasztowiec[7].setBounds(450,629, 600,65);
        textMasztowiec[7] = new JTextField(String.valueOf(listaStatkow[8]));
        textMasztowiec[7].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        textMasztowiec[7].setBounds(1050, 629, 100,65);
        this.add(napisMasztowiec[7]);
        this.add(textMasztowiec[7]);

        napisMasztowiec[8] = new JLabel("Liczba dziewięciomasztowców: ");
        napisMasztowiec[8].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        napisMasztowiec[8].setHorizontalAlignment(SwingConstants.RIGHT);
        napisMasztowiec[8].setBounds(450,701, 600,65);
        textMasztowiec[8] = new JTextField(String.valueOf(listaStatkow[9]));
        textMasztowiec[8].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        textMasztowiec[8].setBounds(1050, 701, 100,65);
        this.add(napisMasztowiec[8]);
        this.add(textMasztowiec[8]);

        napisMasztowiec[9] = new JLabel("Liczba dziesięciomasztowców: ");
        napisMasztowiec[9].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        napisMasztowiec[9].setHorizontalAlignment(SwingConstants.RIGHT);
        napisMasztowiec[9].setBounds(450,773, 600,65);
        textMasztowiec[9] = new JTextField(String.valueOf(listaStatkow[10]));
        textMasztowiec[9].setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        textMasztowiec[9].setBounds(1050, 773, 100,65);
        this.add(napisMasztowiec[9]);
        this.add(textMasztowiec[9]);

        zatwierdz = new JButton("Zatwierdź");
        zatwierdz.setBounds(1200,500,250,70);
        zatwierdz.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        zatwierdz.addActionListener(this);
        this.add(zatwierdz);

        liczStatki();
        oknoBazowe.gracz1.setLiczbaStatkowDoZatopienia(liczbaStatkow);
        oknoBazowe.gracz2.setLiczbaStatkowDoZatopienia(liczbaStatkow);
        oknoBazowe.gracz1.rozmiar = rozmiarPlanszy;
        oknoBazowe.gracz2.rozmiar = rozmiarPlanszy;
        oknoBazowe.gracz1.uzupelnijStrzaly(rozmiarPlanszy);
        oknoBazowe.gracz2.uzupelnijStrzaly(rozmiarPlanszy);

        powrot = new Powrot(oknoBazowe, oknoMenu);
        this.add(powrot);

        Tlo tlo = new Tlo(this);
    }
    void liczStatki(){
        liczbaStatkow = 0;
        for (int i = 1; i < listaStatkow.length; i++) {
            liczbaStatkow +=listaStatkow[i];
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == zatwierdz) {
            Boolean pusty = false;
            for (int i = 0; i < 10; i++) {
                if(textMasztowiec[i].getText().equals("")) {
                    pusty = true;
                    break;
                }
                listaStatkow[i] = Integer.parseInt(textMasztowiec[i].getText());
            }
            if (pusty == true) {
                JOptionPane.showMessageDialog(null, "Nie podano wszystkich ustawień!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "Ustawienia zmieniono!", "Informacja", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
