package restaurant.entities.healthyFoods.interfaces;

public class VeganBiscuits extends Food{

    public VeganBiscuits(String name, double portion, double price) {
        super(name,portion - 205.0,price);
    }

}
