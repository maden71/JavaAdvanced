package JavaAdvanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int countToPush = input[0];
        int countToPop = input[1];
        int elementToSearch = input[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < countToPush; i++) {
            stack.push(numbers[i]);
        }
        for (int i = 0; i < countToPop; i++) {
            stack.pop();
        }
        if(stack.contains(elementToSearch)) {
            System.out.println("true");
        }else {
            if(stack.isEmpty()) {
                System.out.println("0");
            }else {
                int minNumber = Integer.MAX_VALUE;
                for (Integer num : stack) {
                    if(num < minNumber) {
                        minNumber = num;
                    }
                }
                System.out.println(minNumber);
            }
        }
    }
}
