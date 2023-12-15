package ru.gb.seminar3.HomeWork.task4;

public class Main {
    public static void main(String[] args) {
        Pair<String, Double> pair1 = new Pair("Pi", 3.14);
        Pair<Cat, Dog> pair2 = new Pair(new Cat("Barsik"), new Dog("Tuzik"));

        System.out.println(pair1.getFirst());
        System.out.println(pair1.getSecond());
        System.out.println("\n" + pair1 + "\n");

        System.out.println(pair2.getFirst());
        System.out.println(pair2.getSecond());
        System.out.println("\n" + pair2 + "\n");
    }
}
