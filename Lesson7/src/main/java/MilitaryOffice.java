import java.util.Arrays;

public class MilitaryOffice {
    //1) задача!
    /*
    Необходимо написать военкомат.
    1) Создаем класс военкомат MilitaryOffice
    2) Создать в классе MilitaryOffice конструктор, который принимает PersonRegistry
    3) PersonRegistry содержит список людей (Person), которые могут быть призваны в армию
    4) Создать класс Person, который будет содержать следующие поля имя, возраст, пол, адрес(страна, город)
    Военкомат должен уметь:
    a) вывести имена всех людей годных к военной службе на текущий момент времени, которые есть в PersonRegistry
    T.е нужно написать метод в классе MilitaryOffice, который будет отфильтровывать годных к службе призывников
    (годными считать мущин от 18 до 27 лет, проверяем пол и возраст)
    б) вывести количество годных призывников в городе Минске.
    в) вывести количество призывников от 25 до 27 лет
    г) вывести количество призывников у которых имя Александр.
    5) Создать класс Main, наполнить PersonRegistry людьми, по желанию можно создавать людей через консоль
    */
    private PersonRegistry personRegistry;

    public MilitaryOffice(PersonRegistry personRegistry) {
        this.personRegistry = personRegistry;
    }

    public Person[] getRecruits() {
        Person[] recruits = new Person[personRegistry.getPersons().length];
        int numbersOfNull = 0;
        for (int i = 0, index = 0; i < personRegistry.getPersons().length; i++) {
            Person person = personRegistry.getPersons()[i];
            if (18 <= person.getAge() && person.getAge() < 27 && person.getSex().equals(Person.MALE) && person.getAddress().getCountry().equals("Беларусь")) {
                recruits[index] = person;
                index++;
            } else {
                numbersOfNull++;
            }
        }
        Person[] allRecruits = Arrays.copyOf(recruits, recruits.length - numbersOfNull);
        return allRecruits;
    }

    public int getCountOfRecruitsByCities(String city) {
        Person[] allPersons = personRegistry.getPersons();
        int count = 0;
        for (Person recruits : allPersons) {
            if (recruits.getAddress().getCity().equals(city) && recruits.getSex().equals(Person.MALE)) {
                count++;
            }
        }
        return count;
    }

    public int getCountOfRecruitsByAge(int minAge, int maxAge) {
        Person[] allPersons = personRegistry.getPersons();
        int count = 0;
        for (Person person : allPersons) {
            int age = person.getAge();
            if (age >= minAge && age <= maxAge && person.getSex().equals(Person.MALE)) {
                count++;
            }
        }
        return count;
    }


    public int getCountOfRecruitsByName(String name) {
        Person[] allPersons = personRegistry.getPersons();
        int countName = 0;
        for (Person allName : allPersons) {
            Person person = allName;
            if (person.getName().equals(name) && 18 <= person.getAge() && person.getAge() < 27
                    && person.getSex().equals(Person.MALE)) {
                countName++;
            }
        }
        return countName;
    }

}





