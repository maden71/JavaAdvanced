package JavaOOP.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem student = new StudentSystem();
        String[] input = scanner.nextLine().split("\\s+");
        while(!input[0].equals("Exit")) {
            switch (input[0]) {
                case "Create" :
                    String name = input[1];
                    int age = Integer.parseInt(input[2]);
                    double grade = Double.parseDouble(input[3]);
                    student.create(name,age,grade);
                    break;
                    
                case "Show" :
                    String nameShow = input[1];
                    System.out.println(student.show(nameShow));
                    break;
                
            }

            input = scanner.nextLine().split("\\s+");
        }



    }
}
