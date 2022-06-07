package JavaAdvanced.DefiningClasses.lab.CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Car car = new Car();
            String[] data = scanner.nextLine().split("\\s+");
            car.setBrand(data[0]);
            car.setModel(data[1]);
            car.setHorsePower(Integer.parseInt(data[2]));
            System.out.println(car.carInfo());
        }
    }
}
