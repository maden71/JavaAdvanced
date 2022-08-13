package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;


public abstract class BaseHouse implements House{
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        int sum = 0;
        for (Toy toy : toys) {
            sum += toy.getSoftness();
        }
        return sum;
    }

    @Override
    public void addCat(Cat cat) {
        if(cats.size() >= capacity) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        cats.add(cat);

    }

    @Override
    public void removeCat(Cat cat) {
        cats.remove(cat);

    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);

    }

    @Override
    public void feeding() {
        for (Cat cat : cats) {
            cat.eating();
        }
    }

    //"{houseName} {houseType}:
    //Cats: {catName1} {catName2} {catName3} ... / Cats: none
    //Toys: {toysCount} Softness: {sumSoftness}"
    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append(" ").append(this.getClass().getSimpleName()).append(":").append(System.lineSeparator());
        String text;
        if(cats.size() == 0) {
            text = "none";
        }else {
            text = String.join(" ", cats.stream().map(Cat::getName).collect(Collectors.toList()));
        }
        sb.append("Cats: ").append(text).append(System.lineSeparator());
        sb.append("Toys: ").append(toys.size()).append(" Softness: ").append(sumSoftness()).append(System.lineSeparator());
        return sb.toString().trim();
    }
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return toys;
    }
}
