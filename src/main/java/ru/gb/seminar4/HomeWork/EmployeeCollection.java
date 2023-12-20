package ru.gb.seminar4.HomeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EmployeeCollection {
    private List<Employee> list;

    public EmployeeCollection(List<Employee> list) {
        this.list = list;
    }

    Employee findByExperience(List<Employee> list, int experience) {
        return list.stream().filter(p -> p.getExperience() == experience).findAny().orElse(null);
    }

    String findPhonesByName(List<Employee> list, String name) {
        Employee employee = list.stream().filter(p -> Objects.equals(p.getName(), name)).findAny().orElse(null);
        if (employee == null)
            throw new NullPointerException();
        return employee.getPhone();
    }

    Employee findByEmployeeID(List<Employee> list, String employeeID) {
        return list.stream().filter(p -> Objects.equals(p.getEmployeeID(), employeeID)).findAny().orElse(null);
    }

    void addEmployee(String employeeID, String phone, String name, int experience) {
        List<String> ids = new ArrayList<>();
        for (Employee employee : list) {
            ids.add(employee.employeeID);
        }
        if (!ids.contains(employeeID)) {
            list.add(new Employee(employeeID, phone, name, experience));
        } else {
            System.out.println("Такой табельный номер уже существует");
        }
    }
}

