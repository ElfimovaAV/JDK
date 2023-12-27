package ru.gb.seminar5.HomeWork;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Thinker extends Thread {
    private String name;
    private Semaphore table;
    private int eatingCount = 0;

    public Thinker(String name, Semaphore table) {
        this.name = name;
        this.table = table;
    }

    public int getEatingCount() {
        return eatingCount;
    }

    @Override
    public void run() {
        while (eatingCount < 3) {
            try {
                think();
                table.acquire(); // Садится за стол, если за столом не более 3-х философов
                eat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                table.release(); // Встает из-за стола
            }
        }
        System.out.println(name + " пообедал 3 раза и откланялся");
        System.out.println();
    }



            private void eat () throws InterruptedException {
                System.out.println(name + " обедает");
                System.out.println();
                sleep(500);
                System.out.println(name + " пообедал!");
                System.out.println();
                eatingCount++;
            }

            private void think () throws InterruptedException {
                System.out.println(name + " размышляет.....");
                System.out.println();
                sleep(1000);
            }
        }
