package JavaAdvanced.DefiningClasses.lab.CarConstructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            CarConstructor car;
            String brand = data[0];
            if (data.length > 1) {
                String model = data[1];
                int horsePower = Integer.parseInt(data[2]);
                car = new CarConstructor(brand, model, horsePower);
            } else {
                car = new CarConstructor(brand);
            }
            System.out.println(car.carInfo());
        }
    }
}
