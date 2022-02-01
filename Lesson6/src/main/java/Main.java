public class Main {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setMale("мужской");
        System.out.println(user1.getFirstName());
        System.out.println(user1.getSecondName());
        user1.setIncreasingAge(30);
        System.out.println(user1.getIncreasingAge());
        user1.commonInfoUser();
        User user2 = new User("Игорь", "Петров", 25, "мужской");
        user2.commonInfoUser();
        user2.getIncreasingAge();

    }
}
