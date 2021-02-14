package com.company.OknoLogowania;

import com.company.Menu.OknoMenu;
import com.company.OknoBazowe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PanelLogowania extends JPanel implements ActionListener {
    JLabel zalogujSie;
    JLabel nickLoguj;
    JTextField podanyNickLoguj;
    JLabel hasloLoguj;
    JPasswordField podaneHasloLoguj;
    JButton przyciskLoguj;
    String nick;
    String haslo;
    OknoBazowe oknoBazowe;
    OknoMenu oknoMenu;

    public PanelLogowania(OknoBazowe okno, OknoMenu me) {
        oknoBazowe = okno;
        oknoMenu = me;

        this.setOpaque(false);
        this.setBounds(200, 200, 1000, 300);
        this.setLayout(null);


        zalogujSie = new JLabel();
        zalogujSie.setText("Zaloguj się:");
        zalogujSie.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
        zalogujSie.setBounds(350,0,500,90);
        zalogujSie.setHorizontalAlignment(JLabel.CENTER);
        //zalogujSie.setForeground(new Color(255,255,0));
        this.add(zalogujSie);

        nickLoguj = new JLabel();
        nickLoguj.setText("Nazwa użytkownika: ");
        nickLoguj.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        nickLoguj.setBounds(0,90, 350,70);
        nickLoguj.setHorizontalAlignment(JLabel.RIGHT);
        this.add(nickLoguj);

        podanyNickLoguj = new JTextField();
        podanyNickLoguj.setBounds(350,90,500,60);
        podanyNickLoguj.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        this.add(podanyNickLoguj);

        hasloLoguj = new JLabel();
        hasloLoguj.setText("Hasło: ");
        hasloLoguj.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        hasloLoguj.setBounds(0,160, 350,70);
        hasloLoguj.setHorizontalAlignment(JLabel.RIGHT);
        this.add(hasloLoguj);

        podaneHasloLoguj = new JPasswordField();
        podaneHasloLoguj.setBounds(350,160,500,60);
        podaneHasloLoguj.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        this.add(podaneHasloLoguj);

        przyciskLoguj = new JButton();
        przyciskLoguj.setBounds(650, 230, 200, 60);
        przyciskLoguj.setText("Zaloguj");
        przyciskLoguj.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        przyciskLoguj.addActionListener(this);
        this.add(przyciskLoguj);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == przyciskLoguj){
            nick = podanyNickLoguj.getText();
            haslo = String.valueOf(podaneHasloLoguj.getPassword());
            try {
                oknoBazowe.odczytDaneLogowania = new BufferedReader(new FileReader(oknoBazowe.nazwaPlikDaneLogowania));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }

            if(nick.equals("") || haslo.equals("")){
                JOptionPane.showMessageDialog(null, "Nie podano nazwy użytkownika lub hasła!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }

            else {
                int licznik = 0;
                String linia;
                String podaneHaslo;
                try {
                    oknoBazowe.odczytDaneLogowania.mark(10000);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    while ((linia = oknoBazowe.odczytDaneLogowania.readLine()) != null) {
                        if (linia.equals(nick) && licznik % 2 == 0) {
                            podaneHaslo = oknoBazowe.odczytDaneLogowania.readLine();
                            if (podaneHaslo.equals(haslo)) {
                                try {
                                    oknoBazowe.zapisDaneLogowania.close();
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }
                                oknoBazowe.odczytDaneLogowania.reset();
                                oknoBazowe.gracz1.setNickname(nick);
                                oknoBazowe.getContentPane().removeAll();
                                oknoBazowe.getContentPane().add(oknoMenu);
                                oknoMenu.zalogowanyUzytkownik.odswiez();
                                oknoBazowe.revalidate();
                                oknoBazowe.repaint();
                                break;
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Podano błędny login lub hasło!", "Błąd", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                        }
                        licznik++;
                    }
                    if (linia == null) {
                        JOptionPane.showMessageDialog(null, "Podano błędny login lub hasło!", "Błąd", JOptionPane.ERROR_MESSAGE);
                    }
                    oknoBazowe.odczytDaneLogowania.reset();
                    } catch(IOException ioException){
                        ioException.printStackTrace();
                    }
            }
        }
    }
}
