package shop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Graphic extends JFrame implements ActionListener {

    private JButton categories = new JButton("show categories");
    private JButton exit = new JButton("exit");
    private JComboBox<Product> listOfClothes = new JComboBox<>(Run.getClothes());
    private JButton woman = new JButton("woman");
    private JButton man = new JButton("man");
    private JButton previous = new JButton("go back");
    private Product selectAddProduct;

    public Graphic() {
        super("Your online shop");
        this.setBounds(100, 100, 500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        categories.addActionListener(this);
        listOfClothes.setSize(100, 20);
        this.add(listOfClothes);
        this.add(categories);
        this.add(exit);
        listOfClothes.addActionListener(this);

    }

    @Override
    public void actionPerformed (ActionEvent e){
        if (e.getSource() == listOfClothes) {
            if (listOfClothes.getSelectedItem() != null) {
                selectAddProduct = (Product) listOfClothes.getSelectedItem();
            }
        }
    }

}
