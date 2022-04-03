package by.teachmeskills.task2.jdbc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {
    private int id;
    private String name;
    private String surname;
    private int course;
    private String city;

    public Student(int id, String name, String surname, int course, String city) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.city = city;
    }

    public Student(int id, String name, String surname, int course) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

}
