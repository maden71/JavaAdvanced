package JavaAdvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            switch (input[0]) {
                case "1": {
                    int numberToPush = Integer.parseInt(input[1]);
                    stack.push(numberToPush);
                    break;
                }
                case "2": {
                    stack.pop();
                    break;
                }
                case "3":
                    int maxN = Integer.MIN_VALUE;
                    for (Integer num : stack) {
                        if (num > maxN) {
                            maxN = num;
                        }
                    }
                    System.out.println(maxN);
                    break;
            }
        }

    }
}
