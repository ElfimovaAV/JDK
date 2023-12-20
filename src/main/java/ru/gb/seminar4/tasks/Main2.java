package ru.gb.seminar4.tasks;

import java.util.*;

/*
В рамках выполнения задачи необходимо:
● Создайте коллекцию мужских и женских имен с помощью интерфейса List -
добавьте повторяющиеся значения
● Получите уникальный список Set на основании List
● Определите наименьший элемент (алфавитный порядок)
● Определите наибольший элемент (по количеству букв в слове но в обратном
порядке)
● Удалите все элементы содержащие букву ‘A’
 */
public class Main2 {

    public static void main(String[] args) {
        List<String> list = generateList();
        Set<String> set = new HashSet<>(list);
        System.out.println(set);
        System.out.println(getMinByAlphabet(set));
        System.out.println(getMaxByLength(set));
        removeByChar(set);
        System.out.println(set);
    }

    static void removeByChar(Set<String> set){
        set.removeIf(s -> s.contains("А"));
    }

    static String getMaxByLength(Set<String> set){
        return set.stream().max(Comparator.comparingInt(String::length)).get();
    }

    static String getMinByAlphabet(Set<String> set) {
        Set<String> set1 = new TreeSet<>(set);
        //set1.stream().min(String::compareTo); - через стримы
        Iterator<String> iterator = set1.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }

    static List<String> generateList() {
        List<String> list = new ArrayList<>();
        list.add("Константин");
        list.add("Константин");
        list.add("Константин");
        list.add("Василий");
        list.add("Анна");
        list.add("Анна");
        list.add("Анна");
        list.add("Светлана");
        list.add("Иван");
        list.add("Семен");
        list.add("Семен");
        return list;
    }
}
