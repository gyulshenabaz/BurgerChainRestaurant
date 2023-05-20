package uni.pu.fmi.decorators;

import uni.pu.fmi.factory.models.Burger;

public abstract class BurgerDecorator extends Burger {
    public BurgerDecorator(String name, Double price) {
        super(name, price);
    }

    public abstract void AddSauce();
}
