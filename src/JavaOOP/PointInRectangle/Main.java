package JavaOOP.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] cordinates = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Rectangle rectangle = new Rectangle(cordinates[0], cordinates[1],cordinates[2],cordinates[3]);
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < n; i++) {
            int[] pointC = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Point point = new Point(pointC[0],pointC[1]);
            System.out.println(rectangle.contains1(point));
        }
    }
}
