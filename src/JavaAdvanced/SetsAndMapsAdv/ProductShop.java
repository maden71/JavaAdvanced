package JavaAdvanced.SetsAndMapsAdv;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String,Double>> storesWithProducts = new TreeMap<>();
        String[] data = scanner.nextLine().split(", ");
        while(!data[0].equals("Revision")) {
            String store = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);
            storesWithProducts.putIfAbsent(store,new LinkedHashMap<>());
            storesWithProducts.get(store).put(product,price);

            data = scanner.nextLine().split(", ");
        }
        for (Map.Entry<String, Map<String, Double>> entry : storesWithProducts.entrySet()) {
            System.out.printf("%s->%n",entry.getKey());
            entry.getValue().entrySet().forEach(e -> {
                System.out.printf("Product: %s, Price: %.1f%n",e.getKey(),e.getValue());
            });
        }
    }
}
