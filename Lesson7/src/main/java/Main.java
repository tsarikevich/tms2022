import java.util.Arrays;

public class Main {
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
    public static void main(String[] args) {
        Address kirillAddress = new Address("Минск", "Беларусь");
        Person kirill = new Person(kirillAddress, "Кирилл", 25, Person.MALE);
        Address olegAddress = new Address("Москва", "Россия");
        Person oleg = new Person(olegAddress, "Олег", 31, Person.MALE);
        Address vyacheslavAddress = new Address("Минск", "Беларусь");
        Person vyacheslav = new Person(vyacheslavAddress, "Вячеслав", 25, Person.MALE);
        Address ivanAddress = new Address("Екатеринбург", "Россия");
        Person ivan = new Person(ivanAddress, "Иван", 22, Person.MALE);
        Address alexanderAddress = new Address("Вильнюс", "Литва");
        Person alexander = new Person(alexanderAddress, "Александр", 24, Person.MALE);
        Address nikitaAddress = new Address("Жлобин", "Беларусь");
        Person nikita = new Person(nikitaAddress, "Никита", 38, Person.MALE);
        Address alexander2Address = new Address("Клецк", "Беларусь");
        Person alexander2 = new Person(alexander2Address, "Александр", 20, Person.MALE);
        Address nikolayAddress = new Address("Минск", "Беларусь");
        Person nikolay = new Person(nikolayAddress, "Николай", 27, Person.MALE);
        Address glebAddress = new Address("Витебск", "Беларусь");
        Person gleb = new Person(glebAddress, "Глеб", 17, Person.MALE);
        Address victorAddress = new Address("Минск", "Беларусь");
        Person victor = new Person(victorAddress, "Виктор", 19, Person.MALE);
        Address olgaAddress = new Address("Минск", "Беларусь");
        Person olga = new Person(olgaAddress, "Ольга", 26, Person.FEMALE);
        Person[] people = {kirill, oleg, vyacheslav, ivan, alexander, nikita, alexander2, nikolay, gleb, victor, olga};

        PersonRegistry personRegistry = new PersonRegistry(people);
        MilitaryOffice militaryOffice = new MilitaryOffice(personRegistry);
        System.out.println(Arrays.toString(militaryOffice.getRecruits()));
        System.out.println(militaryOffice.getCountOfRecruitsByCities("Минск") + " - количество призывников из города Минск");
        System.out.println(militaryOffice.getCountOfRecruitsByAge(25, 27) + " - количество призывников возраста от 25 до 27");
        System.out.println(militaryOffice.getCountOfRecruitsByName("Александр") + " - количество призывников с именем Александр");
    }
}
