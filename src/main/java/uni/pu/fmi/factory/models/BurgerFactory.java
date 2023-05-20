package uni.pu.fmi.factory.models;

public class BurgerFactory {
    public Burger createBurger(int type) throws Exception {
        return switch (type) {
            case 1 -> new RoyalBurger();
            case 2 -> new ClassicBurger();
            case 3 -> new VegetarianBurger();
            default -> throw new Exception("Invalid burger type");
        };
    }
}
