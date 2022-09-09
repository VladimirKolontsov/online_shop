package shop;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import static shop.Run.clothesGraphic;

public class Graphic extends JFrame implements ActionListener {

    private JButton addToBasket = new JButton("add");
    private JButton buy = new JButton("buy");
    private JComboBox<Product> listOfClothes = new JComboBox<>(getClothes());
    private JComboBox<Product> myBasket = new JComboBox<>();
    private Product selectAddProduct;
    private Product selectBasketProduct;

    public Graphic() {
        super("Your online shop");
        this.setBounds(100, 100, 500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        listOfClothes.setSize(100, 20);
        myBasket.setSize(100, 20);
        this.add(listOfClothes);
        this.add(addToBasket);
        this.add(buy);
        this.add(myBasket);
        listOfClothes.addActionListener(this);
        addToBasket.addActionListener(this);
        buy.addActionListener(this);
        myBasket.addActionListener(this);

    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == listOfClothes) {
            if (listOfClothes.getSelectedItem() != null) {
                selectAddProduct = (Product) listOfClothes.getSelectedItem();
            }
        } else if (e.getSource() == myBasket) {
            if (myBasket.getSelectedItem() != null) {
                selectBasketProduct = (Product) myBasket.getSelectedItem();
            }
        } else if (e.getSource() == addToBasket) {
            myBasket.addItem((Product) listOfClothes.getSelectedItem());
        } else if (e.getSource() == buy) {
            String message = "";
            int sum = 0;
            int itemcount = myBasket.getItemCount();
            List<Product> basketList = new ArrayList<>();
            for (int i = 0; i < itemcount; i++) {
                basketList.add(myBasket.getItemAt(i));
            }
            for (Product product : basketList) {
                message += product + "\n";
                sum += product.getPrice();
            }
            message += "-------------------\n";
            message += "Итого: " + sum;
            JOptionPane.showMessageDialog(null, message, "My order", JOptionPane.PLAIN_MESSAGE);
            basketList.clear();
            myBasket.removeAllItems();
        }
    }

    public static Product [] getClothes() {
        List<Product> listProduct = clothesGraphic.stream()
                .flatMap(category -> category.getListOfProduct().stream())
                .toList();
        Product[] products = listProduct.toArray(p -> new Product[listProduct.size()]);
        return products;
    }

}
