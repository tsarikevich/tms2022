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
        PersonRegistry personRegistry = new PersonRegistry();
        MilitaryOffice militaryOffice = new MilitaryOffice(personRegistry.getPeople());
        militaryOffice.findFitPeople();
        System.out.println(militaryOffice.countFromCity("Минск") + " - количество призывников в городе " + militaryOffice.getCity());
        militaryOffice.countByAge();
        militaryOffice.countByName();

    }
}
