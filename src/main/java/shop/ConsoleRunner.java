package shop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ConsoleRunner {

    private static List<Category> clothes = new ArrayList<>();
    private static final List<Product> basket = new ArrayList<>();
    private static final List<Order> orders = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static LocalDate date = LocalDate.now();
    private static int numberOfOrder = 0;

    protected static void startConsole(List<Category> clothesGraphic) {

        clothes.addAll(clothesGraphic);
        int command;

        do {
            System.out.println("""
                Please enter a command:
                1 - show categories of clothes
                0 - exit""");
            command = scanner.nextInt();

            if (command == 1) {
                lookListOfCategories();
            } else {
                System.out.println("Please enter a valid command");
            }
        } while (command != 0);

    }

    private static void lookListOfCategories() {
        for (Category allClothes : clothes) {
            System.out.println(allClothes.getName());
        }
        System.out.println("""
                            \nchoose category:
                            1 - woman
                            2 - man
                            0 - exit
                            """);

        int command;

        do {
            command = scanner.nextInt();

            switch (command) {
                case 1 -> showCategory(clothes.get(0));
                case 2 -> showCategory(clothes.get(1));
                default -> System.out.println("Please enter a valid command");
            }
        } while (command != 0);
    }

    private static void showCategory(Category category) {
        int count = 1;
        for (Product product : category.getListOfProduct()) {
            System.out.println(count + ". " + product.getName() + " : " + product.getPrice());
            count++;
        }

        System.out.println("""
                \nchoose an action:
                1 - add to basket
                2 - delete from basket (sorry, you can just add)
                3 - show the basket
                4 - sort goods by name
                5 - sort goods by price
                6 - sort goods by rating
                7 - reverse the list
                8 - buy the basket
                9 - show orders
                0 - exit
                """);

        int command;

        do {
            command = scanner.nextInt();

            switch (command) {
                case 1 -> {
                    addToTheBasket(category.getListOfProduct());
                    showTheBasket(category.getName());
                }
                case 2 -> {
                    deleteFromBasket(category.getListOfProduct());
                    showTheBasket(category.getName());
                }
                case 3 -> showTheBasket(category.getName());
                case 4 -> sortGoods(category.getListOfProduct(), Comparator.comparing(Product::getName));
                case 5 -> sortGoods(category.getListOfProduct(), Comparator.comparing(Product::getPrice));
                case 6 -> sortGoods(category.getListOfProduct(), Comparator.comparing(Product::getRating));
                case 7 -> reverse(category);
                case 8 -> buyBasket(++numberOfOrder);
                case 9 -> showOrders();
            }
        } while (command != 0);
    }

    private static void showOrders() {
        for (Order order : orders) {
            System.out.println("?????????? ????????????: " + order.getNum());
            System.out.println();
            order.printOrder(order.getorderedGoods());
            System.out.println();
            order.totalPriceOfOrder(order.getorderedGoods());
            System.out.println("???????? ????????????????: " + order.getDeliveryDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            System.out.println("______________");
        }
    }

    private static void buyBasket(int num) {

        Order order = new Order(num, List.copyOf(basket), date.plusDays(3));

        orders.add(order);
        basket.clear();

    }

    private static void showTheBasket(String nameCategory) {

        System.out.println("????????                          " + date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.println();
        System.out.println("????????????????         ??????????????????          ????????");
        System.out.println("-----------------------------------------");
        for (Product good : basket) {
            System.out.println(good.getName()+ "       " + nameCategory + "       " + good.getPrice());
        }
        System.out.println("-----------------------------------------");
        int sum = 0;
        for (Product product : basket) {
            sum += product.getPrice();
        }
        System.out.println("??????????:                            " + sum);
    }

    private static void addToTheBasket(List<Product> goods) {
        int numOfGood;
        do {
            numOfGood = scanner.nextInt();
            switch (numOfGood) {
                case 1 -> basket.add(goods.get(0));
                case 2 -> basket.add(goods.get(1));
                case 3 -> basket.add(goods.get(2));
                case 4 -> basket.add(goods.get(3));
            }
        } while (numOfGood != 0);
    }

    private static void deleteFromBasket(List<Product> myBasket) {
        int numOfGood;
        for (int i = 0; i < myBasket.size(); i++) {
            numOfGood = scanner.nextInt();
            if (numOfGood == 0) {
                break;
            } else {
                basket.remove(numOfGood);
            }
        }
    }

    private static void sortGoods(List<Product> productList, Comparator<Product> comparator) {
        List<Product> sortedGoods = productList.stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        for (Product product : sortedGoods) {
            System.out.println(product.getName() + "  " + product.getPrice() + "   " + product.getRating());
        }
    }

    private static void reverse(Category category) {
        Collections.reverse(category.getListOfProduct());

        int count = 1;
        for (Product product : category.getListOfProduct()) {
            System.out.println(count + ". " + product.getName() + " : " + product.getPrice());
            count++;
        }
    }

}
