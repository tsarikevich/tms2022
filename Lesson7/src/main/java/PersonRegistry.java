public class PersonRegistry {
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

    Address kirillAdress = new Address("Минск", "Беларусь");
    Person kirill = new Person(kirillAdress, "Кирилл", 25, Person.MALE);
    Address olegAdress = new Address("Москва", "Россия");
    Person oleg = new Person(olegAdress, "Олег", 31, Person.MALE);
    Address vyacheslavAdress = new Address("Минск", "Беларусь");
    Person vyacheslav = new Person(vyacheslavAdress, "Вячеслав", 25, Person.MALE);
    Address ivanAdress = new Address("Екатеринбург", "Россия");
    Person ivan = new Person(ivanAdress, "Иван", 22, Person.MALE);
    Address alexanderAdress = new Address("Вильнюс", "Литва");
    Person alexander = new Person(alexanderAdress, "Александр", 24, Person.MALE);
    Address nikitaAdress = new Address("Жлобин", "Беларусь");
    Person nikita = new Person(nikitaAdress, "Никита", 38, Person.MALE);
    Address stepanAdress = new Address("Клецк", "Беларусь");
    Person stepan = new Person(stepanAdress, "Степан", 20, Person.MALE);
    Address nikolayAdress = new Address("Минск", "Беларусь");
    Person nikolay = new Person(nikolayAdress, "Николай", 27, Person.MALE);
    Address glebAdress = new Address("Витебск", "Беларусь");
    Person gleb = new Person(glebAdress, "Глеб", 17, Person.MALE);
    Address victorAdress = new Address("Минск", "Беларусь");
    Person victor = new Person(victorAdress, "Виктор", 19, Person.MALE);
    Address olgaAdress = new Address("Минск", "Беларусь");
    Person olga = new Person(olgaAdress, "Ольга", 23, Person.FEMALE);

    public Person[] people = {kirill, oleg, vyacheslav, ivan, alexander, nikita, stepan, nikolay, gleb, victor, olga};

    public PersonRegistry() {

    }

    public Person[] getPeople() {
        return people;
    }


}

