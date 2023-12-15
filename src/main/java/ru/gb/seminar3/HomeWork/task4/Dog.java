package ru.gb.seminar3.HomeWork.task4;

public class Dog {
    private String name;
    public Dog(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return String.format("Dod: " + name);
    }
}
