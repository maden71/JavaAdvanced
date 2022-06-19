package JavaAdvanced.ExamPrep.retake14april;

import com.sun.jdi.ArrayReference;

import java.util.ArrayDeque;
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

        //task - stack thread - queue
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        ArrayDeque<Integer> threads = new ArrayDeque<>();

        Arrays.stream(firstInput).forEach(tasks::push);
        Arrays.stream(secondInput).forEach(threads::offer);

        while(!threads.isEmpty()) {
            int task = tasks.peek();
            int thread = threads.peek();
            if(task == thirdInput) {
                System.out.printf("Thread with value %d killed task %d%n",thread,task);
                threads.stream().forEach(e -> System.out.printf("%d ",e));
                return;
            } else if(thread >= task) {
                tasks.pop();
                threads.poll();
            }else if(thread < task) {
                threads.poll();
            }
        }

    }
}
