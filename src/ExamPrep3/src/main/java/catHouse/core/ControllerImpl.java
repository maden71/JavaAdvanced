package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.BaseToy;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;
import jdk.jshell.EvalException;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl(){
        toys = new ToyRepository();
        houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        switch (type) {
            case "ShortHouse" :
                house = new ShortHouse(name);

                break;
            case "LongHouse" :
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }
        houses.add(house);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE,type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        switch (type) {
            case "Ball" :
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }
        toys.buyToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE,type);
    }

    private House findHouseByName(String name) {
        for (House house : houses) {
            if(house.getName().equals(name)){
                return house;
            }
        }
        return null;
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        House house = findHouseByName(houseName);
        Toy toy = toys.findFirst(toyType);
        if(toy == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND,toyType));
        }
        house.buyToy(toy);
        toys.removeToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE,toyType,houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        switch (catType) {
            case "LonghairCat":
                cat = new LonghairCat(catName,catBreed,price);
                break;
            case "ShorthairCat":
                cat = new ShorthairCat(catName,catBreed,price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }
        String result;
        House house = findHouseByName(houseName);
        boolean valid1 = cat.getClass().getSimpleName().startsWith("Long") && house.getClass().getSimpleName().startsWith("Long");
        boolean valid2 = cat.getClass().getSimpleName().startsWith("Short") && house.getClass().getSimpleName().startsWith("Short");;
        if(valid1 || valid2) {
            house.addCat(cat);
            result = String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE,catType,houseName);
        }else {
            result = ConstantMessages.UNSUITABLE_HOUSE;
        }
        return result;
    }

    @Override
    public String feedingCat(String houseName) {
        House house = findHouseByName(houseName);
        house.feeding();
        return String.format(ConstantMessages.FEEDING_CAT,house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = findHouseByName(houseName);
        double toysPriceSum = house.getToys().stream().mapToDouble(Toy::getPrice).sum();
        double catsPriceSum = house.getCats().stream().mapToDouble(Cat::getPrice).sum();

        return String.format(ConstantMessages.VALUE_HOUSE,houseName, toysPriceSum + catsPriceSum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (House house : houses) {
            sb.append(house.getStatistics()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
