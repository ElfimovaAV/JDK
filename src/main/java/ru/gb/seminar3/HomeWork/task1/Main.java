package ru.gb.seminar3.HomeWork.task1;

public class Main {
    public static void main(String[] args) {
        MyArray<Integer>myArrayInteger = new MyArray<>();
        myArrayInteger.add(25);
        myArrayInteger.add(4);
        myArrayInteger.add(100);
        myArrayInteger.add(48);
        System.out.println(myArrayInteger.print());
        System.out.println();

        MyArray<String>myArrayString = new MyArray<>();
        myArrayString.add("25");
        myArrayString.add("4");
        myArrayString.add("100");
        myArrayString.add("48");
        System.out.println(myArrayString.print());
        System.out.println();


        while (myArrayInteger.getArrayIterator().hasNext()) {
            System.out.println(myArrayInteger.getArrayIterator().next());
        }
        System.out.println();

        while (myArrayString.getArrayIterator().hasNext()) {
            System.out.println(myArrayString.getArrayIterator().next());
        }
    }
}
