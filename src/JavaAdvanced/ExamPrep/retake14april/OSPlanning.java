package JavaAdvanced.ExamPrep.retake14april;

import java.util.Arrays;
import java.util.Scanner;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstInput = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondInput = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int thirdInput = Integer.parseInt(scanner.nextLine());

    }
}
