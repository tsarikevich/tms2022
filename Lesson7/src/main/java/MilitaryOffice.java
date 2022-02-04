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
    private int countCity = 0;
    private Person[] people;


    public MilitaryOffice(Person[] people) {
        this.people = people;
    }


    public void findFitPeople() {
        for (int i = 0; i < people.length; i++) {
            Person person = people[i];
            if (18 <= person.getAge() && person.getAge() <= 27 && person.getSex() == Person.MALE) {
                System.out.println(person);
            }

        }
    }

    public void countByAge() {
        int countAge = 0;
        for (int i = 0; i < people.length; i++) {
            Person person = people[i];
            if (25 <= person.getAge() && person.getAge() <= 27 && person.getSex() == Person.MALE) {
                countAge++;
            }

        }
        System.out.println("Количество призывников от 25 до 27 лет - " + countAge);
    }

    public void countByName() {
        int countNAme = 0;
        for (int i = 0; i < people.length; i++) {
            Person person = people[i];
            if (person.getName().equals("Александр")) {
                countNAme++;
            }

        }
        System.out.println("Количество призывников с именем Александр - " + countNAme);
    }

    public Person[] findByCity(String city) {
        Person[] result = new Person[people.length];
        for (int i = 0; i < people.length; i++) {
            Person person = people[i];
            if (person.getAddress().getCity().equals(city) && person.getSex() == Person.MALE) {
                result[i] = person;
                countCity++;
            }
        }
        return result;
    }

    public int getCountCity() {
        return countCity;
    }

    public void setCountCity(int countCity) {
        this.countCity = countCity;
    }
}



