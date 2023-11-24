package ru.gb.seminar1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Создать окно клиента чата. Окно должно содержать JtextField для ввода логина, пароля, IP-адреса сервера, порта подключения
к серверу, область ввода сообщений, JTextArea область просмотра сообщений чата и JButton подключения к серверу и отправки сообщения в чат.
Желательно сразу сгруппировать компоненты, относящиеся
к серверу сгруппировать на JPanel сверху экрана, а компоненты, относящиеся к отправке сообщения – на JPanel снизу

Выполнить все задания семинара, если они не были решены, без ограничений по времени;
Отправлять сообщения из текстового поля сообщения в лог по нажатию кнопки или по нажатию клавиши Enter на поле ввода сообщения;
Продублировать импровизированный лог (историю) чата в файле;
При запуске клиента чата заполнять поле истории из файла, если он существует. Обратите внимание, что чаще всего история сообщений
хранится на сервере и заполнение истории чата лучше делать при соединении с сервером, а не при открытии окна клиента.
 */
public class Chat extends JFrame {
    private static final int WINDOW_HEIGHT = 600;
    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    private boolean loggedIn = false;
    private boolean serverConnected = false;
    JButton btnConnect = new JButton("Соединение с сервером");
    JButton btnSend = new JButton("Отправить.");
    JButton btnLogin = new JButton("Авторизоваться");
    JLabel lblLogin = new JLabel("Введите логин");
    JLabel lblPassword = new JLabel("Введите пароль");
    JLabel lblIP = new JLabel("Введите IP-адрес сервера");
    JLabel lblMessage = new JLabel("Сообщение:");
    JLabel lblCorrespondence = new JLabel("Переписка:");
    JTextField txtFieldLogin = new JTextField();
    JPasswordField txtFieldPassword = new JPasswordField();
    JTextField txtFieldIP = new JTextField();
    JTextField txtFieldMessage = new JTextField();
    JTextArea areaMessage = new JTextArea();
    JPanel panServer = new JPanel(new GridLayout(8, 2));
    JPanel panClient = new JPanel(new GridLayout(5, 1));
    String message;
    String login;
    String password;
    private final File chatHistoryFile = new File("chat_history.txt");
    private final ArrayList<String> chatHistory = new ArrayList<>();

    Chat() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat client");
        setResizable(false);
        panServer.add(lblIP);
        panServer.add(txtFieldIP);
        panServer.add(btnConnect);
        panServer.add(lblLogin);
        panServer.add(txtFieldLogin);
        panServer.add(lblPassword);
        panServer.add(txtFieldPassword);
        panServer.add(btnLogin);
        panClient.add(lblCorrespondence);
        panClient.add(areaMessage);
        panClient.add(lblMessage);
        panClient.add(txtFieldMessage);
        panClient.add(btnSend);


        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login = txtFieldLogin.getText();
                char[] passwordChars = txtFieldPassword.getPassword();
                password = new String(passwordChars);
                if (serverConnected && !loggedIn && !login.isEmpty() && !password.isEmpty()) {
                    loggedIn = true;
                    txtFieldLogin.setEditable(false);
                    txtFieldPassword.setEditable(false);
                    btnLogin.setEnabled(false);
                    btnSend.setEnabled(true);
                    showMessage("Пользователь " + txtFieldLogin.getText() + " присоединился к чату.");
                } else if (!serverConnected) {
                    showMessage("Server is not connected. Please start the server first.");
                }
            }
        });


        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!serverConnected) {
                    serverConnected = true;
                    System.out.println("Соединение с сервером установлено");
                    loadChatHistory();
                    updateChatAreaFromHistory();
                }
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message = txtFieldLogin.getText() + ": " + txtFieldMessage.getText() + "\n";
                System.out.println("Отправлено сообщение: " + message);
                areaMessage.append(message);
                chatHistory.add(txtFieldLogin.getText() + ": " + message);
                saveChatHistory();
            }
        });

        txtFieldMessage.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    btnSend.doClick();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        setLayout(new GridLayout(2, 1));
        add(panServer);
        add(panClient);
        setVisible(true);
    }

    private void loadChatHistory() {
        if (serverConnected && chatHistoryFile.exists()) {
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(chatHistoryFile), StandardCharsets.UTF_8)
                );
                String line;
                while ((line = reader.readLine()) != null) {
                    chatHistory.add(line);
                }
                reader.close();
                areaMessage.append("Loaded chat history from file.");
            } catch (IOException e) {
                Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, "Error loading chat history", e);
            }
        }
    }

    private void saveChatHistory() {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(chatHistoryFile), StandardCharsets.UTF_8)
            );
            for (String line : chatHistory) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, "Error saving chat history", e);
        }
    }

    private void updateChatAreaFromHistory() {
        for (String message : chatHistory) {
            areaMessage.append(message + "\n");
        }
    }

    private void showMessage(String message) {
        areaMessage.append(message + "\n");
    }


    public static void main(String[] args) {
        new Chat();
    }
}
