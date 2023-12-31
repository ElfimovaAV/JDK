package ru.gb.lecture1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WINDOW_HIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    JButton btnStart = new JButton("Start new game");
    JButton btnExit  = new JButton("EXIT");

    Map map;
    SettingsWindow settings;
    GameWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX,WINDOW_POSY);
        setSize(WINDOW_WIDTH,WINDOW_HIGHT);
        setTitle("TicTacToe");
        setResizable(false);

        map = new Map();
        settings = new SettingsWindow(this);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });


        JPanel panelBottom = new JPanel(new GridLayout(1,2));
        panelBottom.add(btnStart);
        panelBottom.add(btnExit);
        add(panelBottom,BorderLayout.SOUTH);
        add(map);
        setVisible(true);
    }
    void startNewGame(int mode, int fSzX,int fSzY, int wLen){
        map.startNewGame(mode, fSzX,fSzY,wLen);
    }
}
