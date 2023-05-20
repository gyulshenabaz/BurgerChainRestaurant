package uni.pu.fmi.commands;

import uni.pu.fmi.OrderItem;
import uni.pu.fmi.decorators.GarlicSauce;
import uni.pu.fmi.decorators.BurgerDecorator;
import uni.pu.fmi.decorators.KetchupSauce;
import uni.pu.fmi.factory.models.Burger;
import uni.pu.fmi.factory.models.BurgerFactory;

import java.util.List;

public class Chief implements ICommand {
    private final BurgerFactory burgerFactory;
    private List<OrderItem> orderItems;
    private Double orderSum;

    public Chief(BurgerFactory burgerFactory) {
        this.burgerFactory = burgerFactory;
        this.orderSum = 0.00;
    }

    @Override
    public void ExecuteTask() {
        System.out.println("Got order in the kitchen!");

        try {
            for (OrderItem orderItem : orderItems) {
                Burger burger = burgerFactory.createBurger(orderItem.getBurgerType());
                System.out.println("Preparing "+burger.getName()+" burger");

                for (int sauceType : orderItem.getSauceTypes()) {
                    BurgerDecorator burgerDecorator = this.getBurgerDecorator(burger, sauceType);
                    burgerDecorator.AddSauce();
                    orderSum+=burgerDecorator.getPrice() - burger.getPrice();
                }

                orderSum+=burger.getPrice();

            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Order is ready!");
        System.out.println("Total sum of order: " + getTotalSum());
    }

    public void setOrder(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    private Double getTotalSum() {
        return orderSum;
    }

    private BurgerDecorator getBurgerDecorator(Burger burger, int sauceType) throws Exception {
        return switch (sauceType) {
            case 1 -> new KetchupSauce(burger);
            case 2 -> new GarlicSauce(burger);
            default -> throw new Exception("No such decorator / sauce");
        };
    }
}
