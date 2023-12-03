package ru.gb.seminar2.HomeWork;

public class Backender extends Developer implements BackendAction{
    String name;
    Backender(String name){
        this.name = name;
    }
    @Override
    public void back() {
        System.out.println("Backend working");
    }

    @Override
    public void developGUI() {
        System.out.println("Backender GUI method");
    }

    @Override
    public String toString() {
        return "Backender: " + name;
    }
}
