package JavaAdvanced.Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //first milk value and the last cacao powder value
        double[] firstLine = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        double[] secondLine = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        ArrayDeque<Double> milks = new ArrayDeque<>();
        Arrays.stream(firstLine).forEach(milks::offer);
        ArrayDeque<Double> cacaoPowder = new ArrayDeque<>();
        Arrays.stream(secondLine).forEach(cacaoPowder::push);
        int milkCount = 0;
        int darkCount = 0;
        int bakingCount = 0;

        while(!cacaoPowder.isEmpty()) {
            double percentage;
            double milk = milks.poll(); //queue
            double cacao = cacaoPowder.pop(); //stack

            percentage = Math.round((cacao / (milk + cacao))*100);
            if(percentage == 100.0) {
                bakingCount++;
            }else if(percentage == 50.0){
                darkCount++;
            }else if(percentage == 30.0) {
                milkCount++;
            }else{
                milk+=10;
                milks.offer(milk);
            }


        }
        if(bakingCount > 0 && milkCount > 0 && darkCount > 0) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
            System.out.printf("# Baking Chocolate --> %d%n",bakingCount);
            System.out.printf("# Dark Chocolate --> %d%n",darkCount);
            System.out.printf("# Milk Chocolate --> %d",milkCount);
        }else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
            if(bakingCount > 0){System.out.printf("# Baking Chocolate --> %d%n",bakingCount);}
            if(darkCount > 0) {System.out.printf("# Dark Chocolate --> %d%n",darkCount);}
            if(milkCount > 0){System.out.printf("# Milk Chocolate --> %d",milkCount);}
        }
    }
}
