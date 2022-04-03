package by.teachmeskills.task2.jdbc;

import by.teachmeskills.task2.jdbc.model.CityStudent;
import by.teachmeskills.task2.jdbc.model.Student;
import by.teachmeskills.task2.jdbc.utils.CRUDUtils;

public class Application {
    public static void main(String[] args) {
        Student student = new Student("Ivan", "Ivanov", 5);
        System.out.println("Show students with cities:");
        CRUDUtils.getAllStudentsWithCities().forEach(System.out::println);
        System.out.println("---------------------------------------------------");
        System.out.println("Add city");
        CRUDUtils.addCity(new CityStudent(5, "BREST")).forEach(System.out::println);
        System.out.println("---------------------------------------------------");
        System.out.println("Add student:");
        CRUDUtils.addStudent(student).forEach(System.out::println);
        System.out.println("---------------------------------------------------");
        System.out.println("Add city");
        CRUDUtils.addCity(new CityStudent(6, "BREST")).forEach(System.out::println);
        System.out.println("---------------------------------------------------");
        System.out.println("Delete student");
        CRUDUtils.deleteStudent(1).forEach(System.out::println);
        System.out.println("---------------------------------------------------");
        System.out.println("Delete city");
        CRUDUtils.deleteCityStudent("BREST").forEach(System.out::println);
        System.out.println("---------------------------------------------------");
        System.out.println("Update student:");
        CRUDUtils.updateStudent(3, 4).forEach(System.out::println);
    }
}
