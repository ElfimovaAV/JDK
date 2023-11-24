package ru.gb.lecture1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*Первое задание – добавить на экран компоновщик-сетку с одним столбцом и добавить над существующей кнопкой
следующие компоненты в заданном порядке: JLabel с заголовком «Выберите режим игры», сгруппированные в ButtonGroup
переключаемые JRadioButton с указанием режимов «Человек против компьютера» и «Человек против человека», JLabel с
заголовком «Выберите размеры поля», JLabel с заголовком «Установленный размер поля:», JSlider со значениями 3..10,
JLabel с заголовком «Выберите длину для победы», JLabel с заголовком «Установленная длина:», JSlider со значениями 3..10.

Добавить компонентам интерактивности,
а именно, при перемещении ползунка слайдера
в соответствующих лейблах должны появляться текущие значения слайдеров. Для этого необходимо добавить
к слайдеру слушателя изменений (как это было сделано для действия кнопки).

В методе обработчика нажатия кнопки необходимо заменить константы в аргументе вызова метода старта игры
на текущие показания компонентов (какая радио-кнопка активна, значение слайдера размеров поля, значение
слайдера выигрышной длины).
 */

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT =    230;
    private static final int WINDOW_WIDTH =    350;

    JButton btnStart = new JButton("Start new game");
    JPanel panBottom;
    JLabel gameMode = new JLabel("Выберите режим игры");
    JRadioButton humanVsAI = new JRadioButton("Человек против компьютера");
    JRadioButton humanVsHuman = new JRadioButton("Человек против человека");
    ButtonGroup gameModeButtonGroup = new ButtonGroup();
    JLabel gameField = new JLabel("Выберите размеры поля");
    JLabel gameFieldSize = new JLabel("Установленный размер поля:");
    JSlider fieldSlider = new JSlider(3, 10);
    JLabel gameWin = new JLabel("Выберите длину для победы");
    JLabel gameWinCount = new JLabel("Установленная длина:");
    JSlider winCountSlider = new JSlider(3, 10);

    SettingsWindow(final GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        panBottom = new JPanel(new GridLayout(10, 1));
        gameModeButtonGroup.add(humanVsAI);
        gameModeButtonGroup.add(humanVsHuman);
        panBottom.add(gameMode);
        panBottom.add(humanVsAI);
        panBottom.add(humanVsHuman);
        humanVsAI.setSelected(true);
        panBottom.add(gameField);
        panBottom.add(gameFieldSize);
        panBottom.add(fieldSlider);
        fieldSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameFieldSize.setText("Установленный размер поля: " + fieldSlider.getValue());
            }
        });
        panBottom.add(gameWin);
        panBottom.add(gameWinCount);
        panBottom.add(winCountSlider);
        winCountSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameWinCount.setText("Установленная длина: " + winCountSlider.getValue());
            }
        });
        panBottom.add(btnStart);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(humanVsAI.isSelected()?0:1,
                        fieldSlider.getValue(),
                        fieldSlider.getValue(),
                        winCountSlider.getValue());
                setVisible(false);
            }
        });
        add(panBottom);
    }

}