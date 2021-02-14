package com.company.OknoLogowania;

import com.company.OknoBazowe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PanelRejestracji extends JPanel implements ActionListener {
    JLabel zarejestrujSie;
    JLabel nickRejestruj;
    JTextField podanyNickRejestruj;
    JLabel hasloRejestruj;
    JPasswordField podaneHasloRejestruj;
    JButton przyciskRejestruj;
    String nick;
    String haslo;
    OknoBazowe oknoBazowe;


    PanelRejestracji(OknoBazowe oknoBazowe) {
        this.setOpaque(false);
        this.setBounds(200, 480, 1000, 300);
        this.setLayout(null);
        this.oknoBazowe = oknoBazowe;

        zarejestrujSie = new JLabel();
        zarejestrujSie.setText("lub zarejestruj się");
        zarejestrujSie.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
        zarejestrujSie.setBounds(350, 0, 500, 90);
        zarejestrujSie.setHorizontalAlignment(JLabel.CENTER);
        //zalogujSie.setForeground(new Color(255,255,0));
        this.add(zarejestrujSie);

        nickRejestruj = new JLabel();
        nickRejestruj.setText("Nazwa użytkownika: ");
        nickRejestruj.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        nickRejestruj.setBounds(0, 90, 350, 70);
        nickRejestruj.setHorizontalAlignment(JLabel.RIGHT);
        this.add(nickRejestruj);

        podanyNickRejestruj = new JTextField();
        podanyNickRejestruj.setBounds(350, 90, 500, 60);
        podanyNickRejestruj.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        this.add(podanyNickRejestruj);

        hasloRejestruj = new JLabel();
        hasloRejestruj.setText("Hasło: ");
        hasloRejestruj.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        hasloRejestruj.setBounds(0, 160, 350, 60);
        hasloRejestruj.setHorizontalAlignment(JLabel.RIGHT);
        this.add(hasloRejestruj);

        podaneHasloRejestruj = new JPasswordField();
        podaneHasloRejestruj.setBounds(350, 160, 500, 60);
        podaneHasloRejestruj.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        this.add(podaneHasloRejestruj);

        przyciskRejestruj = new JButton();
        przyciskRejestruj.setBounds(650, 230, 200, 60);
        przyciskRejestruj.setText("Zarejestuj");
        przyciskRejestruj.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        przyciskRejestruj.addActionListener(this);
        this.add(przyciskRejestruj);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == przyciskRejestruj) {
            nick = podanyNickRejestruj.getText();
            haslo = String.valueOf(podaneHasloRejestruj.getPassword());

            if (nick.equals("") || haslo.equals("")) {
                JOptionPane.showMessageDialog(null, "Nie podano nazwy użytkownika lub hasła!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
            else {
                String linia;
                int licznik = 0;
                Boolean zajety = false;
                try {
                    oknoBazowe.odczytDaneLogowania.mark(10000);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    while ((linia = oknoBazowe.odczytDaneLogowania.readLine()) != null) {
                        if (linia.equals(nick) && licznik % 2 == 0) {
                            System.out.print("Nick się powtarza :D\n");
                            JOptionPane.showMessageDialog(null, "Podany login jest zajęty!", "Błąd", JOptionPane.ERROR_MESSAGE);
                            zajety = true;
                            break;
                        }
                        licznik++;
                    }
                    if (zajety == false) {
                        podanyNickRejestruj.setText("");
                        podaneHasloRejestruj.setText("");
                        try {
                            oknoBazowe.zapisDaneLogowania.write(nick + "\n");
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        try {
                            oknoBazowe.zapisDaneLogowania.write(haslo + "\n");
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        try {
                            oknoBazowe.zapisDaneLogowania.close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(null, "Zarejestrowano pomyślnie. Proszę się zalogować.", "Rejestracja", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}
