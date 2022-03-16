import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;



public class Main {
    public static void main(String[] args) {
/** Все задачи необходимо решать используя Stream API и выводить результат на консоль !!!
 1) Вывести список чисел, умноженных на 2. Список чисел задаем рандомно.
 */
        List<Integer> list1 = randomIntsGenerator();
//        System.out.println(list1);
        list1 = list1.stream().map(a -> a * 2).collect(Collectors.toList());
//        System.out.println(list1);

/** 2) Определение количества четных чисел в потоке данных.
 * Создаем коллекцию Set<Integer> в которую добавляем рандомно 50 чисел от 0 до 100
 */
        Set<Integer> set1 = new HashSet<>(randomIntsGenerator());
//        System.out.println(set1);
        set1 = set1.stream().filter(a -> a % 2 == 0).collect(Collectors.toSet());
//        System.out.println("Количество четных чисел в потоке данных - " + set1.stream().count());

/** 3) Вывести список имен, но с первой заглавной буквой. список имен: "john", "arya", "sansa"
 */
        List<String> names = Arrays.asList("john", "arya", "sansa");
        names.stream().map(StringUtils::capitalize).forEach(System.out::println);

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

        List<Car> cars = Arrays.asList(
                new Car("AA1111BX", 2007),
                new Car("AK5555IT", 2010),
                new Car(null, 2012),
                new Car("", 2015),
                new Car("AI3838PP", 2017));

        cars.stream()
                .filter(c -> c.getYear() > 2010)
                .map(Car::getNumber)
                .filter(s -> s != null && !s.isEmpty())
                .forEach(System.out::println);

/**
 * 5) Задан список сотрудников, которые хранятся в коллекции List<p3.Person>.
 * Объект p3.Person содержит имя и фамилию(по желанию другие данные)
 * a) написать метод, который отображает все фамилии, начинающиеся на букву "Д".
 * Внимание! метод должен вернуть объект Optional<String>.
 * b*)Со звездочкой. Написать метод, который будет выводить в столбик первую букву фамилии и рядом количество сотрудников,
 * у которых фамилия начинается с этой буквы.
 * Пример: Антонов, Петров, Сидоров, Александров...
 * на экран выведет:
 * A - 2 сотрудника
 * П - 1 сотрудник
 * С - 1 сотрудник
 */

        List<Person> persons = List.of(
                new Person("Петров", 20, Person.MALE),
                new Person("Дмитриев", 25, Person.MALE),
                new Person("Демидов", 23, Person.MALE),
                new Person("Иванов", 24, Person.MALE));

        List<String> namesPersons = persons.stream().map(person -> person.getName()).collect(Collectors.toList());
        System.out.println(namesPersons);

//                .filter(people -> people.stream().filter(person -> person.getName().startsWith("Д")))
//                .map(Optional::of)
//                .toArray(Optional<String>::new));

    }

    private static List<Integer> randomIntsGenerator() {
        return new Random().ints(50, 0, 101).boxed().collect(Collectors.toList());
    }
}
