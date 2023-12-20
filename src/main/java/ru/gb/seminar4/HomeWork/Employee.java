package ru.gb.seminar4.HomeWork;

class Employee {
    String employeeID;
    String phone;
    String name;
    int experience;

    public Employee(String employeeID, String phone, String name, int experience) {
        this.employeeID= employeeID;
        this.phone = phone;
        this.name = name;
        this.experience = experience;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return String.format("Табельный номер: %s, Имя: %s, Телефон: %s, Стаж: %d", employeeID, name, phone, experience);
    }
}
