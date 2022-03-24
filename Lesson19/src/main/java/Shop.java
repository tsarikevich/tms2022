import lombok.Getter;

@Getter
public class Shop {
    private final CashBox[] cashBox;

    public Shop(int numberCashBox) {
        cashBox = new CashBox[numberCashBox];
        for (int i = 0; i < numberCashBox; i++) {
            cashBox[i] = new CashBox(i + 1);
        }
    }
}
