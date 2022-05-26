package by.teachmeskills.student;

import by.teachmeskills.student.model.Sex;
import by.teachmeskills.student.model.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StudentTests {
    private static Student student1;
    private static Student student2;
    private static Student student3;

    private static List<Student> actual;
    private static List<Student> actualBySex;

    @BeforeAll
    public static void setUp() {
        student1 = new Student("Ivan", 17, Sex.MALE);
        student2 = new Student("Anna", 20, Sex.FEMALE);
        student3 = new Student("Polina", 18, Sex.FEMALE);

        actual = new ArrayList<>();
        actual.add(student1);
        actual.add(student2);
        actual.add(student3);

        actualBySex = new ArrayList<>();
        actualBySex.add(student2);
        actualBySex.add(student3);
    }

    @Test
    public void checkAllStudentsReturned() {
        List<Student> expected = Student.getAllStudents();
        assertEquals(expected, actual);
    }

    @Test
    public void checkAllStudentsReturned_NotNull() {
        List<Student> expected = Student.getAllStudents();
        assertNotNull(expected);
    }

    @Test
    public void getAllUsers_MALE() {
        List<Student> expected = Student.getAllStudentsBySex(Sex.FEMALE);
        assertEquals(expected, actualBySex);
    }

    @Test
    void getStudentsCount() {
        int expected = Student.getAllStudents().size();
        assertEquals(expected, actual.size());
    }

    @Test
    void getSumOfAllStudentsAge() {
        int actual = Student.getSumOfAllStudentsAge();
        int expected = student1.getAge() + student2.getAge() + student3.getAge();
        assertEquals(expected, actual);
    }

    @Test
    void getSumOfAllStudentsAgeBySex() {
        int actual = Student.getSumOfAllStudentsAgeBySex(Sex.FEMALE);
        int expected = student2.getAge() + student3.getAge();
        assertEquals(expected, actual);
    }

    @Test
    void getAverageAgeOfAllStudents() {
        int actualAverageAge = Student.getAverageAgeOfAllStudents();
        int expectedAverageAge = (student1.getAge() + student2.getAge() + student3.getAge()) / actual.size();
        assertEquals(expectedAverageAge, actualAverageAge);
    }

    @Test
    void getAverageOfAllStudentsBySex() {
        int actual = Student.getAverageOfAllStudentsBySex(Sex.FEMALE);
        int expected = (student2.getAge() + student3.getAge()) / actualBySex.size();
        assertEquals(expected, actual);
    }


}
