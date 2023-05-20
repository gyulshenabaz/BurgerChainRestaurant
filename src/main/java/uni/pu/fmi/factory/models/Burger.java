package uni.pu.fmi.factory.models;

public abstract class Burger {
    protected String name;
    protected Double price;

    public Burger(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void AddSauce(String name, Double price) {
        this.price+=price;
        System.out.println("Added " + name + " sauce to " + getName());
    }
}
