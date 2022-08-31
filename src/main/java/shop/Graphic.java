package shop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Graphic extends JFrame {

    private JButton categories = new JButton("show categories");
    private JButton exit = new JButton("exit");
    private JButton woman = new JButton("woman");
    private JButton man = new JButton("man");
    private JButton previous = new JButton("go back");

    public Graphic() {
        super("Your online shop");
        this.setBounds(100, 100, 500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2, 2, 2, 2));
        categories.addActionListener(new ShowAllCategories());
        container.add(categories);
        container.add(exit);//TODO надо понять как на exit закрывать окно
    }

    class ShowAllCategories implements ActionListener {
//TODO все - тут я совсем закопался, куча вопросов касаемо того, как вывести именно список, а вообще должно быть так
//TODO что нажимая на кнопку ты берешь и обнуляешь то окно и у тебя выползают новые кнопки с новыми функциями, и как
//TODO это внедрить - даже близко не понятно по тому видео) там все сильно примитивно, а чтобы это понять надо уйму
//TODO времени что весь функционал перелопатить...
        @Override
        public void actionPerformed(ActionEvent e) {
            String message = "";
            for (Category category : Run.clothes) {
                message += category.getName();
                System.out.println();
            }
            JOptionPane.showMessageDialog(null, message,
                    "Categories", JOptionPane.PLAIN_MESSAGE);
        }
    }

}
