package task1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@ToString
@AllArgsConstructor
public class Student {
    private String name;
    private int numberGroup;
    private List<Integer> scores;

    public static Map<String, Double> getAverageScoresByStudents(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getName,
                        Collectors.averagingDouble(student -> student.getScores()
                                .stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(Double.NaN))));
    }

    public static void showStudentsInfo(List<Student> students) {
        Map<String, Double> map = getAverageScoresByStudents(students);
        System.out.println("Студенты, переведенные на следующий курс:");
        map.entrySet().stream()
                .filter(s -> s.getValue() >= 3.0)
                .forEach(s -> System.out.println(s.getKey() + " со средним баллом " + s.getValue()));
        System.out.println("---------------------------");
        System.out.println("Отчисленные студенты:");
        map.entrySet().stream()
                .filter(s -> s.getValue() < 3.0)
                .forEach(s -> System.out.println(s.getKey() + " со средним баллом " + s.getValue()));
    }
}
