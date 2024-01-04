package ru.gb.seminar6.home;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Main класс для запуска Монти Холла в цикле
 */
public class PlayGame {

    public static void main(String[] args) {

        Player gamer1 = new Player("Рискующий игрок", true);
        int statisticWin1 = 0;
        int step1;

        for (step1 = 0; step1<1000; step1++) {
            Game game = new Game(gamer1, getDoors());

            if (game.round(0).isPrize()) statisticWin1++;
        }

        System.out.println("Из " + step1 + " игр " + gamer1.getName() + " выиграл " + statisticWin1);

        Player gamer2 = new Player("Нерискующий игрок", false);
        int statisticWin2 = 0;
        int step2;

        for (step2 = 0; step2<1000; step2++) {
            Game game = new Game(gamer2, getDoors());

            if (game.round(0).isPrize()) statisticWin2++;
        }

        System.out.println("Из " + step2 + " игр " + gamer2.getName() + " выиграл " + statisticWin2);

    }

    private static List<Door> getDoors() {
        List<Door> doors = new ArrayList<>();
        doors.add(new Door(true));
        doors.add(new Door(false));
        doors.add(new Door(false));
        Collections.shuffle(doors);
        return doors;
    }
}
