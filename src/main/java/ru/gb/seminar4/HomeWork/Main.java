package ru.gb.seminar4.HomeWork;

import java.util.ArrayList;
import java.util.List;


/*
Задание 1. Создать справочник сотрудников
Необходимо:
● Создать класс справочник сотрудников, который
содержит внутри коллекцию сотрудников - каждый
сотрудник должен иметь следующие атрибуты:
○ Табельный номер
○ Номер телефона
○ Имя
○ Стаж
● Добавить метод, который ищет сотрудника по стажу
(может быть список)
● Добавить метод, который выводит номер телефона
сотрудника по имени (может быть список)
● Добавить метод, который ищет сотрудника по
табельному номеру
● Добавить метод добавление нового сотрудника в
справочник

 */
public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>(List.of(new Employee("001", "482348", "Иванов Алексей", 10),
                new Employee("002", "996124", "Горбачев Михаил", 12), new Employee("003", "324785", "Кутовой Виталий", 8),
                new Employee("004", "421457", "Петров Александр", 9), new Employee("005", "567485", "Голубева Вера", 11),
                new Employee("006", "658475", "Потапова Ангелина", 15)));

        employeeList.forEach(System.out::println);
        System.out.println();

        EmployeeCollection employeeCollection = new EmployeeCollection(employeeList);
        int exp1 = 1;
        int exp2 = 8;

        System.out.println("Сотрудник со стажем " + exp1 + " лет: " + employeeCollection.findByExperience(employeeList, exp1));
        System.out.println("Сотрудник со стажем " + exp2 + " лет: " + employeeCollection.findByExperience(employeeList, exp2));
        System.out.println();

        String name1 = "Потапова Ангелина";
        String name2 = "Борисов Борис";
        try {
            System.out.println("Телефон сотрудника с именем " + name1 + ": " + employeeCollection.findPhonesByName(employeeList, name1));
            System.out.println("Телефон сотрудника с именем " + name2 + ": " + employeeCollection.findPhonesByName(employeeList, name2));
        } catch (NullPointerException e) {
            System.out.println("Нет такого сотрудника " + e.getMessage());
        }
        System.out.println();

        String emplID1 = "005";
        String emplID2 = "000";

        System.out.println("Сотрудник с табельным номером " + emplID1 + ": " + employeeCollection.findByEmployeeID(employeeList, emplID1));
        System.out.println("Сотрудник с табельным номером " + emplID2 + ": " + employeeCollection.findByEmployeeID(employeeList, emplID2));
        System.out.println();

        employeeCollection.addEmployee("007", "512478", "Королев Иван", 3);
        employeeList.forEach(System.out::println);
        System.out.println();
        employeeCollection.addEmployee("007", "675814", "Домрачев Дмитрий", 7);
        System.out.println();
        employeeList.forEach(System.out::println);

    }
}
