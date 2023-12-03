package ru.gb.seminar2.ServerRun;

import ru.gb.seminar1.Chat;
import ru.gb.seminar2.UI.MenuAvailability;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatMenu extends JFrame implements MenuAvailability {
    private static final int WINDOW_HEIGHT = 300;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POS_X = 500;
    private static final int WINDOW_POS_Y = 200;

    JButton btnChat = new JButton("Start Chat");
    JButton btnServerRun = new JButton("Start ServerRun");
    JButton btnExit = new JButton("Exit program");

    @Override
    public void menu (){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POS_X, WINDOW_POS_Y);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Seminar 1. Menu");
        setResizable(false);

        JPanel panelButton = new JPanel(new GridLayout(1, 1));
        panelButton.add(btnExit);
        add(panelButton, BorderLayout.SOUTH);

        JPanel panelTask = new JPanel(new GridLayout(2, 1));
        panelTask.add(btnChat);
        panelTask.add(btnServerRun);
        add(panelTask, BorderLayout.CENTER);
        setVisible(true);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Chat();
                setVisible(false);
            }
        });

        btnServerRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ServerRun();
                setVisible(false);
            }
        });

    }
}
