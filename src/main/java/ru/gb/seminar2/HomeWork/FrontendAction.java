package ru.gb.seminar2.HomeWork;

public interface FrontendAction {
    void front();
    default void cofee() {
        System.out.println("Drink");
    };
}
