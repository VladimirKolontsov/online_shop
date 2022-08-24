package shop;

import java.time.LocalDate;
import java.util.List;

public class Order {

    private final int num;
    private List<Product> orderedGoods;
    private final LocalDate deliveryDate;

    public Order(int num, List<Product> orderedGoods, LocalDate deliveryDate) {
        this.num = num;
        this.orderedGoods = orderedGoods;
        this.deliveryDate = deliveryDate;
    }

    private int getNum() {
        return num;
    }

    private List<Product> getorderedGoods() {
        return orderedGoods;
    }

    private LocalDate getDeliveryDate() {
        return deliveryDate;
    }
}
