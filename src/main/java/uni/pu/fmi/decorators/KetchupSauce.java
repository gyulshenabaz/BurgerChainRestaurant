package uni.pu.fmi.decorators;

import uni.pu.fmi.factory.models.Burger;

public class KetchupSauce extends BurgerDecorator {
    public KetchupSauce(Burger burger) {
        super(burger.getName(), burger.getPrice());
    }
    @Override
    public void AddSauce() {
        super.AddSauce("ketchup", 0.60);
    }
}
