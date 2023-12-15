package ru.gb.seminar3.HomeWork.task2;

/*
Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(), multiply(), divide(), subtract().
Параметры этих методов – два
числа разного типа, над которыми должна быть произведена операция.
 */

public class MyCalc {
    public static <T extends Number, V extends Number> double sum(T t, V v) {
        return t.doubleValue() + v.doubleValue();
    }

    public static <T extends Number, V extends Number> double multiply(T t, V v) {
        return t.doubleValue() * v.doubleValue();
    }

    public static <T extends Number, V extends Number> double subtract(T t, V v) {
        return t.doubleValue() - v.doubleValue();
    }

    public static <T extends Number, V extends Number> double divide(T t, V v) {
        return t.doubleValue() / v.doubleValue();
    }
}
