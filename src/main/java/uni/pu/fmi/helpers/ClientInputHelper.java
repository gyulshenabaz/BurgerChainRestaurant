package uni.pu.fmi.helpers;

import uni.pu.fmi.OrderItem;

import java.util.*;

public class ClientInputHelper {
    public static void DisplayMenu() {
        StringBuilder sb = new StringBuilder();

        sb.append("Welcome to the Gyulshen's delicious burgers. What would you like to order? Here is our menu:");
        sb.append(System.lineSeparator()).append("BURGERS:");
        sb.append(System.lineSeparator()).append("1. Royal burger (6.00 lvs)");
        sb.append(System.lineSeparator()).append("2. Classic burger (4.00 lvs)");
        sb.append(System.lineSeparator()).append("3. Vegetarian burger (3.80 lvs)");
        sb.append(System.lineSeparator()).append("SAUCES");
        sb.append(System.lineSeparator()).append("1. Ketchup sauce (0.60 lvs)");
        sb.append(System.lineSeparator()).append("2. Garlic sauce (1.00 lvs)");
        sb.append(System.lineSeparator()).append("INFO:");
        sb.append(System.lineSeparator()).append("If you would like to order a burger, please type in Order {burger} {sauce1} {sauce2} to place an order.");
        sb.append(System.lineSeparator()).append("Example: Order 1 1 2");
        sb.append(System.lineSeparator()).append("If you are done with your order, please type in END");

        System.out.println(sb);
    }

    public static List<OrderItem> TakeOrder() {
        Scanner scanner = new Scanner(System.in);
        List<OrderItem> orders = new ArrayList<>();
        String input = "";
        while (!input.equals("END")) {
            try {
                input = scanner.nextLine();

                String[] commands = input.split(" ");

                switch (commands[0]) {
                    case "Order":
                        int burgerType = Integer.parseInt(commands[1]);
                        List<Integer> sauceTypes = commands.length >= 3 ? Arrays.asList(commands).subList(2, commands.length).stream().map(Integer::parseInt).toList() : new ArrayList<>();
                        orders.add(CheckOrder(burgerType, sauceTypes));
                    case "END":
                        break;
                    default:
                        System.out.println("No such command exists");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Thank you for your order!");

        return orders;
    }

    private static OrderItem CheckOrder(int burgerType, List<Integer> sauceTypes) throws Exception {
        if (!(burgerType >= 1 && burgerType <= 3)) {
            throw new Exception("No such burger is available. Please choose 1, 2 or 3");
        }

        for (int s: sauceTypes) {
            if (!(s >= 1 && s <= 2)) {
                throw new Exception("No such sauce is available. Please choose 1 or 2");
            }
        }

        return new OrderItem(burgerType, sauceTypes);
    }
 }
