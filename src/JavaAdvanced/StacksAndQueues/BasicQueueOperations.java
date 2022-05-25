package JavaAdvanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int countToAdd = input[0];
        int countToPoll = input[1];
        int elementToSearch = input[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < countToAdd; i++) {
            queue.add(numbers[i]);
        }
        for (int i = 0; i < countToPoll; i++) {
            queue.poll();
        }
        if(queue.contains(elementToSearch)) {
            System.out.println("true");
        }else {
            if(queue.isEmpty()) {
                System.out.println("0");
            }else {
                int minNumber = Integer.MAX_VALUE;
                for (Integer num : queue) {
                    if(num < minNumber) {
                        minNumber = num;
                    }
                }
                System.out.println(minNumber);
            }
        }
    }
}
