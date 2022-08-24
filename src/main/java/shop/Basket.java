package shop;

import java.util.List;

public class Basket {
    String name;
    String category;
    int price;
    List<Product> listOfBoughtProduct;

    public Basket(String name, String category, int price, List<Product> listOfBoughtProduct) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.listOfBoughtProduct = listOfBoughtProduct;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public List<Product> getListOfBoughtProduct() {
        return listOfBoughtProduct;
    }
}
