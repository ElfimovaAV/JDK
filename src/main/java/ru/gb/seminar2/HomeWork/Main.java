package ru.gb.seminar2.HomeWork;

import java.util.ArrayList;
import java.util.Arrays;

/*
Дописать третье задание таким образом, чтобы в идентификатор типа Developer записывался объект Frontender,
и далее вызывался метод developGUI(), не изменяя существующие интерфейсы, только код основного класса.
 */
public class Main {
    private static final ArrayList<Developer> developers = new ArrayList<>();
    public static void addFrontender() {

        developers.add(new Frontender("Vasya"));
        developers.add(new Backender("Petya"));
        developers.add(new FullStack("Kolya"));
        developers.add(new Frontender("Ivan"));

        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i) instanceof Frontender) {
                System.out.println(developers.get(i));
                (developers.get(i)).developGUI();
            }
        }
    }

    public static void main(String[] args) {
        addFrontender();
    }
}
