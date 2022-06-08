package JavaAdvanced.SetsAndMapsAdv;

import java.util.*;

public class CitiesContinentCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Map<String,List<String>>> continents = new LinkedHashMap<>();
        while(n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String continent = data[0];
            String country = data[1];
            String city = data[2];
            continents.putIfAbsent(continent,new LinkedHashMap<>());
            continents.get(continent).putIfAbsent(country,new ArrayList<>());
            continents.get(continent).get(country).add(city);

        }
        for (Map.Entry<String, Map<String, List<String>>> entry : continents.entrySet()) {
            System.out.printf("%s:%n",entry.getKey());
            entry.getValue().entrySet().forEach(e -> {
                System.out.printf("%s -> %s%n",e.getKey(),String.join(", ",e.getValue()));
            });

        }
    }
}
