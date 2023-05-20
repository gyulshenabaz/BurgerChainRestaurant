package uni.pu.fmi;

import java.util.List;

public class OrderItem {
    private final int burgerType;
    private final List<Integer> sauceTypes;

    public OrderItem(int burgerType, List<Integer> sauceTypes) {
        this.burgerType = burgerType;
        this.sauceTypes = sauceTypes;
    }

    public int getBurgerType() {
        return burgerType;
    }

    public List<Integer> getSauceTypes() {
        return sauceTypes;
    }
}
