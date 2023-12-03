package ru.gb.lecture2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainWindow extends JFrame implements CanvasRepaintListener, MouseListener {
    private static final int WINDOW_HIGHT = 600;
    private static final int WINDOW_WIDTH = 800;
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private final Interactable[] interactables = new Interactable[15];

    int objectsCount;
    private Background background;

    private MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HIGHT);
        setTitle("Circles");

        background = new Background();
        for (int i = 0; i < interactables.length; i++) {
            interactables[i] = new Ball();
        }

        MainCanvas canvas = new MainCanvas(this);

        add(canvas);
        setVisible(true);
        canvas.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            interactables[objectsCount++] = new Ball(e.getX(), e.getY());
        } else if (e.getButton() == MouseEvent.BUTTON2) {
            if (objectsCount == 1) return;
            objectsCount--;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Clicked!");
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime){
        update(canvas, deltaTime);
        render(canvas, g);
    }
    private void update(MainCanvas canvas, float deltaTime){
        background.update(canvas, deltaTime);
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].update(canvas, deltaTime);
        }
    }
    private void render(MainCanvas canvas, Graphics g){
        background.render(canvas, g);
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].render(canvas, g);
        }
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
