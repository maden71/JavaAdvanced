package JavaAdvanced.DefiningClasses.lab.CarInfo;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    void setBrand (String brand) {
        this.brand = brand;
    }
    void setModel(String model) {
        this.model = model;
    }
    void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    String getBrand() {
        return this.brand;
    }
    String getModel() {
        return this.model;
    }

    int getHorsePower() {
        return this.horsePower;
    }

    String carInfo() {
       return String.format("The car is: %s %s - %d HP.",getBrand(),getModel(),getHorsePower());
    }

}
