import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CashBox {
    private static int cashBoxCounter;
    private final int id;
    private Integer queueSize = 0;
    private final Object lock = new Object();

    public CashBox() {
        id = cashBoxCounter++;
    }

    public void serveCustomer(Customer customer) {
        increaseQueSize();

        synchronized (this) {
            System.out.printf("CashBox #%s serves Customer %s\n", id, customer.getCustomerName());
            for (String good : customer.getShoppingList()) {
                System.out.printf("Customer %s buys %s\n", customer.getCustomerName(), good);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
            }
            synchronized (lock) {
                queueSize--;
                System.out.println("Customer " + customer.getCustomerName() + " is served. CashBox #" + id + " has "
                        + queueSize + " Customers left in the queue");
            }
        }
    }

    private void increaseQueSize() {
        synchronized (lock) {
            //атомарность
//            Операция в общей области памяти называется атомарной, если она завершается в один шаг относительно других потоков, имеющих доступ к этой памяти.
//            Во время выполнения такой операции над переменной, ни один поток не может наблюдать изменение наполовину завершенным.
//            Атомарная загрузка гарантирует, что переменная будет загружена целиком в один момент времени. Неатомарные операции не дают такой гарантии.
            //1) считывает значение из памяти
            //2) увеличивает значение на 1
            //3) записывает значение в память
            queueSize++;
            System.out.println("CashBox #" + id + " Queue increased to size " + queueSize);
        }
    }

    public int getId() {
        return id;
    }

    public int getQueueSize() {
        return queueSize;
    }
}
