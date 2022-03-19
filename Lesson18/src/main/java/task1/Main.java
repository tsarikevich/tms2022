package task1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Писать код с использованием Stream API
 * 1) Создать класс task1.Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
 * Создать коллекцию, содержащую объекты класса task1.Student. Перебрать всех студентов, вычислить средний балл
 * каждого студента. Если средний балл >=3, студент переводится на следующий курс, иначе отчисляется.
 * <p>
 */

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Иванов В.В.", 115, Arrays.asList(1, 2, 3, 4, 5)),
                new Student("Александров А.А.", 114, Arrays.asList(5, 5, 5, 4, 5)),
                new Student("Петров П.П.", 115, Arrays.asList(3, 5, 4, 4, 5)),
                new Student("Сидоров С.С.", 115, Arrays.asList(3, 3, 2, 4, 2)),
                new Student("Григорьев Г.Г.", 114, Arrays.asList(5, 2, 3, 4, 5)),
                new Student("Алексеев А.А.", 115, Arrays.asList(3, 3, 3, 3, 2))
        );
        Map<String, Double> averageScoresByStudents = Student.getAverageScoresByStudents(students);
        System.out.println(averageScoresByStudents);
        Student.showStudentsInfo(students);
    }
}
