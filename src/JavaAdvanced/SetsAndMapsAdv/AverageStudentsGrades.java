package JavaAdvanced.SetsAndMapsAdv;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();
        for (int i = 0; i < n ; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String student = data[0];
            double grade = Double.parseDouble(data[1]);

             students.putIfAbsent(student, new ArrayList<>());
             students.get(student).add(grade);
        }
        students.entrySet().stream().forEach(entry -> {
            List<Double> studentGrades = entry.getValue();
            double sum = 0;
            for (Double studentGrade : studentGrades) {
                sum += studentGrade;
            }
            double avgGrade = sum / entry.getValue().size();
             System.out.print(entry.getKey() + " -> ");
                               entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
                               System.out.printf("(avg: %.2f)%n", avgGrade);
        });

    }
}
