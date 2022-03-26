import java.util.Arrays;

/**
 * Напишите программу, моделирующую кассы в магазине.
 * Существует несколько касс, работающих одновременно.
 * Каждый покупатель — отдельный поток.
 * Общее количество покупателей может быть больше, чем количество касс,
 * но одновременно не может обрабатываться больше покупателей, чем имеется рабочих касс.
 * У каждого покупателя есть набор товаров, которые должны быть выведены на консоль в процессе обслуживания.
 */
public class Main {
    public static void main(String[] args) {
        Shop store = new Shop(5);
        Thread costumer1 = new Customer(store, 1, Arrays.asList("колбаса", "сметана"));
        Thread costumer2 = new Customer(store, 2, Arrays.asList("яйца", "молоко"));
        Thread costumer3 = new Customer(store, 3, Arrays.asList("тетрадь", "бананы"));
        Thread costumer4 = new Customer(store, 4, Arrays.asList("ветчина", "апельсины"));
        costumer1.start();
        costumer2.start();
        costumer3.start();
        costumer4.start();


    }
}
