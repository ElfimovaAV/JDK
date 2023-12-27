package ru.gb.seminar5.HomeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Repast extends Thread {
    private List<Thinker> thinkers;
    private Semaphore table;
    int countOfThikers;
    public Repast() {
        countOfThikers = 5;
        thinkers = new ArrayList<>(countOfThikers);
        table = new Semaphore(countOfThikers-1);

        thinkers.add(new Thinker("Аристотель", table));
        thinkers.add(new Thinker("Платон", table));
        thinkers.add(new Thinker("Сократ", table));
        thinkers.add(new Thinker("Декарт", table));
        thinkers.add(new Thinker("Кант", table));
    }

    @Override
    public void run() {
        try {
            repastTime();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void repastTime() throws InterruptedException {
        System.out.println("Философы собираются");
        sleep(1000);
        System.out.println("Начинается трапеза");
        System.out.println("------------------");
        sleep(1000);
        for (Thinker thinker : thinkers){
            thinker.start();
        }
    }

}
