package com.tms.task6;

/**
 * 6)Создать класс Employee, у которого есть переменные класса - String fullname, double salary.
 * Создать массив содержащий несколько объектов этого типа. Создать класс Report (по возможности интерфейс),
 * который будет содержать метод generateReport, в котором выводится информация о зарплате всех сотрудников.
 * Используйте форматировании строк(https://javarush.ru/quests/lectures/questmultithreading.level02.lecture06)
 * Пусть salary будет выровнено по правому краю, десятичное значение имеет 2 знака после запятой и по одной первой букве имени и отчества через точки.
 * Пример: | Л.Н. Толстой		|		200.34|
 */
public class MainTask6 {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Иванов Иван Николаевич", 544.2312);
        Employee employee2 = new Employee("Петров Петр Васильевич", 644.7841);
        Employee employee3 = new Employee("Сидоров Сергей Петрович", 741.56471);
        Employee employee4 = new Employee("Кузнецов Константин Иванович", 234.23322);
        Employee[] employees = {employee1, employee2, employee3, employee4};
        Reporting report = new Report();
        report.generateReport(employees);

    }
}
