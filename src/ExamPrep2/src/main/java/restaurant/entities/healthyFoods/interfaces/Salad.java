package restaurant.entities.healthyFoods.interfaces;

public class Salad extends Food{

    public Salad(String name, double portion, double price) {
        super(name,portion - 150.0, price);
    }
}

