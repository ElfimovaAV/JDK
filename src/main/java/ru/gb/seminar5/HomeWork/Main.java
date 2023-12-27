package ru.gb.seminar5.HomeWork;
/*
Есть пять философов (потоки), которые могут либо обедать либо размышлять.
Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 миллисекунд
После каждого приема пищи философ должен размышлять
Не должно возникнуть общей блокировки
Философы не должны есть больше одного раза подряд
 */

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Repast repast = new Repast();
        repast.start();

    }
}
