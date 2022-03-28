

public class Shop {
    private final CashBox[] cashBoxes;

    public Shop(int cashBoxesCount) {
        cashBoxes = new CashBox[cashBoxesCount];
        for (int i = 0; i < cashBoxesCount; i++) {
            cashBoxes[i] = new CashBox();
        }
    }

    public CashBox[] getCashBoxes() {
        return cashBoxes;
    }
}
