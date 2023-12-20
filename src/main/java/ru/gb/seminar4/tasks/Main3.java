package ru.gb.seminar4.tasks;
/*
В рамках выполнения задачи необходимо:
● Создайте телефонный справочник с помощью Map - телефон это ключ, а имя
значение
● Найдите человека с самым маленьким номером телефона
● Найдите номер телефона человека чье имя самое большое в алфавитном порядке

 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main3 {
    public static void main(String[] args) {

        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("123", "Константин");
        phoneBook.put("123123", "Мария");
        phoneBook.put("12311", "Вячеслав");
        phoneBook.put("12", "Кирилл");
        phoneBook.put("911", "Юлия");

        //entry - пара "ключ - значение" из мапы.
        System.out.println(phoneBook.entrySet()
                .stream().min(Map.Entry.comparingByKey()).get().getValue());

        System.out.println(phoneBook.entrySet()
                .stream().max(Map.Entry.comparingByValue()).get().getKey());

    }

}
