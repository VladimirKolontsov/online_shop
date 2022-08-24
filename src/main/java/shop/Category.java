package shop;

import java.util.List;

public class Category {
    private String name;
    private List<Product> listOfProduct;

    public Category(String name, List<Product> listOfProduct) {
        this.name = name;
        this.listOfProduct = listOfProduct;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }

    public List<Product> getListOfProduct() {
        return listOfProduct;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", listOfProduct=" + listOfProduct +
                '}';
    }
}
