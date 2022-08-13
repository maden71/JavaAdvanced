package restaurant.entities.drinks.interfaces;

public class Smoothie extends BaseBeverage {

    public Smoothie(String name, int counter, double price, String brand) {
        super(name, counter, price - 4.50, brand);
    }
}
