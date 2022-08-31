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

    public int getNum() {
        return num;
    }

    public List<Product> getorderedGoods() {
        return orderedGoods;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void printOrder(List<Product> order) {

        for (Product product : order) {
            System.out.println(product.getName() + "     " + product.getPrice());
        }

    }

    public void totalPriceOfOrder(List<Product> order) {
        int sum = 0;
        for (Product product : order) {
            sum += product.getPrice();
        }

        System.out.println("Сумма заказа: " + sum);
    }

}
