package restaurant.entities.tables.interfaces;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

public abstract class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood = new ArrayList<>();
    private Collection<Beverages> beverages = new ArrayList<>();
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private Boolean isReservedTable;
    private double allPeople;


    public BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        setSize(size);
        this.pricePerPerson = pricePerPerson;
    }

    public void setSize(int size) {
        if(size <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    @Override
    public int getTableNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int numberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return numberOfPeople * 1.0 * pricePerPerson;
    }

    @Override
    public void reserve(int numberOfPeople) {
        if(numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
        this.isReservedTable = true;

    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);

    }

    @Override
    public double bill() {
        double healthyFoodBill = 0;
        double beveragesBill = 0;
        for (HealthyFood food : healthyFood) {
            healthyFoodBill += food.getPrice();
        }
        for (Beverages beverage : beverages) {
            beveragesBill += beverage.getPrice();
        }
        return healthyFoodBill + beveragesBill;
    }

    @Override
    public void clear() {
        healthyFood.clear();
        beverages.clear();
        number = 0;
        size = 0;
        numberOfPeople = 0;
        pricePerPerson = 0.0;
        isReservedTable = false;
        allPeople = 0.0;

    }
     //"Table - {table number}
     //Size - {table size}
     //Type - {table type}
     //All price - {price per person for the current table}"
    @Override
    public String tableInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Table - ").append(number).append(System.lineSeparator());
        sb.append("Size - ").append(size).append(System.lineSeparator());
        sb.append("Type - ").append(this.getClass().getSimpleName()).append(System.lineSeparator());
        sb.append("All price - ").append(pricePerPerson).append(System.lineSeparator());
        return sb.toString().trim();
    }
}
