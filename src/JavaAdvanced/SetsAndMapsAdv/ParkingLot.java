package JavaAdvanced.SetsAndMapsAdv;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> carNumbers = new LinkedHashSet<>();

        String[] input = scanner.nextLine().split(", ");
        while(!input[0].equals("END")){
            switch (input[0]) {
                case "IN": {
                    String carNumber = input[1];
                    carNumbers.add(carNumber);
                    break;
                }
                case "OUT": {
                    if(carNumbers.isEmpty()) {
                        System.out.println("Parking Lot is Empty");
                    }else {
                        String carNumber = input[1];
                        carNumbers.remove(carNumber);
                    }
                    break;
                }
            }
            input = scanner.nextLine().split(", ");
        }
        if(carNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }else {
            for (String carNumber : carNumbers) {
                System.out.println(carNumber);
            }
        }
    }
}
