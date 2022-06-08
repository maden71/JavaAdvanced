package JavaAdvanced.SetsAndMapsAdv;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String,Double>> storesWithProducts = new LinkedHashMap<>();
        String[] data = scanner.nextLine().split(", ");
        while(!data[0].equals("Revision")) {
            String store = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);
            storesWithProducts.putIfAbsent(store,new LinkedHashMap<>());
            

            data = scanner.nextLine().split(", ");
        }

    }
}
