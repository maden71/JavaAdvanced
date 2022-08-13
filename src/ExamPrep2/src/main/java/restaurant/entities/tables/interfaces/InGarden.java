package restaurant.entities.tables.interfaces;

public class InGarden extends BaseTable{

    public InGarden(int number, int size, double pricePerPerson) {
        super(number,size,pricePerPerson - 4.50);
    }


}
