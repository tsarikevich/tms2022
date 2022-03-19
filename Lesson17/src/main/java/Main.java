import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;


public class Main {
    public static void main(String[] args) {
/** Все задачи необходимо решать используя Stream API и выводить результат на консоль !!!
 1) Вывести список чисел, умноженных на 2. Список чисел задаем рандомно.
 */
//Способ №1
        System.out.println("Task1:");
        List<Integer> list1 = randomIntsGenerator();
        list1 = list1.stream().map(a -> a * 2).collect(toList());
        System.out.println(list1);
        System.out.println("----------------------------");
//Способ №2
        List<Integer> list2 = Stream.generate(() -> (int) (Math.random() * 10))
                .limit(10)
                .map(a -> a * 2)
                .collect(toList());
        System.out.println(list2);

/** 2) Определение количества четных чисел в потоке данных.
 * Создаем коллекцию Set<Integer> в которую добавляем рандомно 50 чисел от 0 до 100
 */
        System.out.println("\nTask2:");
        Set<Integer> set1 = new HashSet<>(randomIntsGenerator());
        System.out.println(set1);
        set1 = set1.stream()
                .filter(a -> a % 2 == 0)
                .collect(toSet());
        System.out.println("Количество четных чисел в потоке данных - " + (long) set1.size());

/** 3) Вывести список имен, но с первой заглавной буквой. список имен: "john", "arya", "sansa"
 */
        System.out.println("\nTask3:");
//Способ №1
        List<String> names = Arrays.asList("john", "arya", "sansa");
        names.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .forEach(System.out::println);
        System.out.println("----------------------------");
//Способ №2
        names.stream()
                .map(StringUtils::capitalize)
                .forEach(System.out::println);

/** 4) Создаем класс Car с полями number (номер авто) и year (год выпуска).
 * List<Car> cars = Arrays.asList(
 *             new Car("AA1111BX", 2007),
 *             new Car("AK5555IT", 2010),
 *             new Car(null, 2012),
 *             new Car("", 2015),
 *             new Car("AI3838PP", 2017));
 *
 * Необходимо вывести все не пустые номера машин, выпущенных после 2010 года
 */
        System.out.println("\nTask4:");
        List<Car> cars = Arrays.asList(
                new Car("AA1111BX", 2007),
                new Car("AK5555IT", 2010),
                new Car(null, 2012),
                new Car("", 2015),
                new Car("AI3838PP", 2017));

        cars.stream()
                .filter(c -> c.getYear() > 2010)
                .map(Car::getNumber)
                .filter(StringUtils::isNotEmpty)
                .forEach(System.out::println);
    }

    private static List<Integer> randomIntsGenerator() {
        return new Random().ints(50, 0, 101).boxed().collect(toList());
    }
}
