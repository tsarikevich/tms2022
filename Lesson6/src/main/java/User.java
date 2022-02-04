public class User {
    /**
     * 1) Создать класс User для хранения о обработки данных о пользователе.
     * Создать поля для хранения имени и фамилии, возраста и пола. Создать методы для:
     * - Возврата имени и фамилии полностью
     * - Увеличения возраста
     * - Вывода общей информации о пользователе
     * В Main классе в методе main создайте экземпляр класса User и вызовите все созданные методы, передав им необходимые параметры.
     * 2) Создать в классе User несколько конструкторов. Создать объект этого класса, использовав один из них.
     * В этом конструкторе сделать вызов другого конструктора этого же класса.
     * Отметьте один из методов как @Deprecated. Попробуйте на экземпляре класса вызвать этот метод.
     */
    private String firstName;
    private String secondName;
    private int age;
    private String male;

    public User() {
    }

    public User(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public User(String male) {
        this.male = male;
    }

    public User(String firstName, String secondName, int age, String male) {
        this(male);
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getFirstName() {
        this.firstName = "Петр";
        return firstName;
    }

    public String getSecondName() {
        return this.secondName = "Иванов";
    }

    @Deprecated
    public int getIncreasingAge() {
        return age;
    }

    public void setIncreasingAge(int age) {
        this.age += age;
    }


    public void commonInfoUser() {
        System.out.println("Пол пользователя - " + male + ", имя+фамилия пользователя - " + this.firstName + " " + secondName
                + ", возраст после увеличения - " + this.age);
    }
}
