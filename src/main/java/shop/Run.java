package shop;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

import static shop.ConsoleRunner.startConsole;

public class Run {

    private static List<Category> clothesGraphic = new ArrayList<>();

    public static void main(String[] args) {

        fillProducts();
        startShopping();

    }

    private static void startShopping() {

        Scanner scanner = new Scanner(System.in);

        int menu;
        do {
            System.out.println("""
            Choose an interface:
            1 - console
            2 - graphic
            0 - exit
            """);
            menu = scanner.nextInt();

            switch (menu) {
                case 1 -> startConsole(clothesGraphic);
                case 2 -> {
                    Graphic graphic = new Graphic(clothesGraphic);
                    graphic.setVisible(true);
                }
            }
        } while (menu != 0);
    }

    private static void fillProducts() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            clothesGraphic = objectMapper.readValue(new FileInputStream("categories.json"),
                    new TypeReference<List<Category>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
