import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CashBox {
    private final int nameCashBox;


    public CashBox(int numberCashBox) {
        this.nameCashBox = numberCashBox;
    }

    public void serveCustomer(Customer customer) {
        synchronized (this) {
            System.out.println("Касса №" + customer.getNumberCashBox() + " обслуживает клиента №" + customer.getNumberCostumer());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Клиент №" + customer.getNumberCostumer() + " обслужен. Совершены следующие покупки:\n" + customer.getItems());
        }

    }
}
