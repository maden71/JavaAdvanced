package JavaAdvanced.SetsAndMapsAdv;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Double> students = new TreeMap<>();
        while(n-- > 0) {
            String name = scanner.nextLine();
            double[] grades = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            double sum = 0;
            for (double grade : grades) {
                sum += grade;
            }
            double avgStudentGrade = sum / grades.length;
            students.put(name,avgStudentGrade);
        }
        students.entrySet().forEach(e -> System.out.printf("%s is graduated with %s%n",e.getKey(),e.getValue()));
    }
}
