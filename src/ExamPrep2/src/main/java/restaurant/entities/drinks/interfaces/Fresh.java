package restaurant.entities.drinks.interfaces;

public class Fresh extends BaseBeverage {

    public Fresh(String name, int counter, double price, String brand) {
        super(name, counter, price - 3.50, brand);
    }
}
