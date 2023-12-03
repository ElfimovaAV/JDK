package ru.gb.seminar2.HomeWork;

public class FullStack extends Developer implements BackendAction, FrontendAction{
    String name;
    FullStack(String name){
        this.name = name;
    }
    @Override
    public void back() {

    }

    @Override
    public void front() {

    }

    @Override
    public void developGUI() {
        System.out.println("FullStack GUI method");
    }
    @Override
    public String toString() {
        return "FullStack: " + name;
    }
}
