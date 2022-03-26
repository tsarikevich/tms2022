import lombok.Getter;

import java.util.List;
import java.util.Random;

@Getter
public class Customer extends Thread {
    private final Shop shop;
    private final int numberCostumer;
    private final List<String> items;
    private int numberCashBox;

    public Customer(Shop shop, int numberCostumer, List<String> items) {
        this.shop = shop;
        this.numberCostumer = numberCostumer;
        this.items = items;
    }

    @Override
    public void run() {
        shop.getCashBox()[getRandomCashBox()].serveCustomer(this);
    }

    private Integer getRandomCashBox() {
        Random random = new Random();
        numberCashBox = random.nextInt(shop.getCashBox().length) + 1;
        return numberCashBox - 1;
    }
}
