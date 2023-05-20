package uni.pu.fmi;

import uni.pu.fmi.commands.Cashier;
import uni.pu.fmi.commands.Chief;
import uni.pu.fmi.factory.models.BurgerFactory;

public class Restaurant {

    private static final Restaurant instance;

    private final BurgerFactory burgerFactory;
    private final Chief chief;
    private final Cashier cashier;

    private Restaurant(){
        this.burgerFactory = new BurgerFactory();
        this.chief = new Chief(burgerFactory);
        this.cashier = new Cashier(chief);
    }

    // static block initialization for exception handling
    static {
        try {
            instance = new Restaurant();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    public void TakeOrderAndServeClient()
    {
        cashier.ExecuteTask();
        chief.ExecuteTask();
    }

    public static Restaurant getInstance() {
        return instance;
    }
}