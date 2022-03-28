import lombok.Getter;


@Getter
public class Customer extends Thread {
    private final Shop shop;
    private final String customerName;
    private final String[] shoppingList;
    private final ChooseCashBoxStrategy strategy;

    public Customer(Shop shop, String customerName, String[] shoppingList, ChooseCashBoxStrategy strategy) {
        this.shop = shop;
        this.customerName = customerName;
        this.shoppingList = shoppingList;
        this.strategy = strategy;
    }

    @Override
    public void run() {
        CashBox box = strategy.chooseCashBox(customerName, shop.getCashBoxes());
        System.out.println(customerName + " will use CashBox #" + box.getId());
        box.serveCustomer(this);
    }

    public String[] getShoppingList() {
        return shoppingList;
    }

    public String getCustomerName() {
        return customerName;
    }
}
