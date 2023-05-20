package uni.pu.fmi;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = Restaurant.getInstance();
        restaurant.TakeOrderAndServeClient();
    }
}