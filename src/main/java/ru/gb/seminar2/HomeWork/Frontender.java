package ru.gb.seminar2.HomeWork;

public class Frontender extends Developer implements FrontendAction{
    String name;
    Frontender(String name){
        this.name = name;
    }
    @Override
    public void front() {
        System.out.println("Sleep");
    }

    @Override
    public void developGUI() {
        System.out.println("Frontender GUI method");
    }
    @Override
    public String toString() {
        return "Frontender: " + name;
    }
}
