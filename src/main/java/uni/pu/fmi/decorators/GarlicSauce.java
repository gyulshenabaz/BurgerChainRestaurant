package uni.pu.fmi.decorators;

import uni.pu.fmi.factory.models.Burger;

public class GarlicSauce extends BurgerDecorator {

    public GarlicSauce(Burger burger) {
        super(burger.getName(), burger.getPrice());
    }

    @Override
    public void AddSauce() {
        super.AddSauce("garlic", 1.0);
    }
}