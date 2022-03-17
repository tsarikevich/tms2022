import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
/** Все задачи необходимо решать используя Stream API и выводить результат на консоль !!!
 1) Вывести список чисел, умноженных на 2. Список чисел задаем рандомно.
 */
//Способ №1
//        List<Integer> list1 = randomIntsGenerator();
//        list1 = list1.stream().map(a -> a * 2).collect(Collectors.toList());
//        System.out.println(list1);
//Способ №2
//        List<Integer> list2 = Stream.generate(() -> (int) (Math.random() * 10))
//                .limit(10)
//                .map(a -> a * 2)
//                .collect(Collectors.toList());
//        System.out.println(list2);

/** 2) Определение количества четных чисел в потоке данных.
 * Создаем коллекцию Set<Integer> в которую добавляем рандомно 50 чисел от 0 до 100
 */
//        Set<Integer> set1 = new HashSet<>(randomIntsGenerator());
//        System.out.println(set1);
//        set1 = set1.stream()
//                .filter(a -> a % 2 == 0)
//                .collect(Collectors.toSet());
//        System.out.println("Количество четных чисел в потоке данных - " + (long) set1.size());

/** 3) Вывести список имен, но с первой заглавной буквой. список имен: "john", "arya", "sansa"
 */
//Способ №1
//        List<String> names = Arrays.asList("john", "arya", "sansa");
//        names.stream()
//                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
//                .forEach(System.out::println);
//Способ №2
//        names.stream()
//                .map(StringUtils::capitalize)
//                .forEach(System.out::println);

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

//        List<Car> cars = Arrays.asList(
//                new Car("AA1111BX", 2007),
//                new Car("AK5555IT", 2010),
//                new Car(null, 2012),
//                new Car("", 2015),
//                new Car("AI3838PP", 2017));
//
//        cars.stream()
//                .filter(c -> c.getYear() > 2010)
//                .map(Car::getNumber)
//                .filter(s -> !StringUtils.isEmpty(s))
//                .forEach(System.out::println);

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

        List<Person> persons = Arrays.asList(
                new Person("Иван", "Петров", 20, Person.MALE),
                new Person("Дмитрий", "Дмитриев", 25, Person.MALE),
                new Person("Илья", "Демидов", 23, Person.MALE),
                new Person("Вячеслав", "Дубин", 23, Person.MALE),
                new Person("Никита", "Иванов", 24, Person.MALE),
                new Person("Александр", "Детков", 23, Person.MALE));


        Optional<String> personInfo = persons.stream()
                .map(Person::getSurname)
                .filter(s -> s.startsWith("Д"))
                .reduce((s1, s2) -> s1 + "\n" + s2);
        if (personInfo.isPresent()) {
            String name = personInfo.get();
            System.out.println(name);
        }


        Map<String, Integer> map = new HashMap<>();
        List<String> firstLetters = persons.stream()
                .map(s -> s.getSurname().substring(0, 1)).toList();
//Способ 1
        for (String string : firstLetters) {
// если уже есть ключ, то прибавляем единицу
            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
// Если нет, то кладем ключ и присваиваем значение 1
            } else {
                map.put(string, 1);
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " сотрудник(-а)");
        }
//Способ 2
        Map<String, Long> result =
                firstLetters.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())
                        );
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " сотрудник(-а)");
        }
        System.out.println(result);


    }

    private static List<Integer> randomIntsGenerator() {
        return new Random().ints(50, 0, 101).boxed().collect(Collectors.toList());
    }
}
