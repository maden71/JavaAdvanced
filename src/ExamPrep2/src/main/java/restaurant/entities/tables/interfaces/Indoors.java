package restaurant.entities.tables.interfaces;

public class Indoors extends BaseTable{

    public Indoors(int number, int size, double pricePerPerson) {
        super(number,size,pricePerPerson - 3.50);
    }

}
