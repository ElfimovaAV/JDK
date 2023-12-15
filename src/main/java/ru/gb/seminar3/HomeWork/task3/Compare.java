package ru.gb.seminar3.HomeWork.task3;

/*
Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они одинаковые,
и false в противном случае. Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
 */
public class Compare {
    public static <T> boolean compareArrays(T[] t, T[] t1) {
        if (t.length == t1.length && t.getClass().getName().equals(t1.getClass().getName())) {
            return true;
        }
        return false;
    }
}

