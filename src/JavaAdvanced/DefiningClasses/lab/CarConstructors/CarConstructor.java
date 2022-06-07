package JavaAdvanced.DefiningClasses.lab.CarConstructors;

import JavaAdvanced.DefiningClasses.lab.CarInfo.Car;

public class CarConstructor {
    private String brand;
    private String model;
    private int horsePower;


    public CarConstructor(String brand, String model, int horsePower) {
       this.brand = brand;
       this.model = model;
       this.horsePower = horsePower;
    }
    public CarConstructor(String brand) {
        this(brand,"unknown", -1);
    }

    String carInfo() {
        return String.format("The car is: %s %s - %d HP.",getBrand(),getModel(),getHorsePower());
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
