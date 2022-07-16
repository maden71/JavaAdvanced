package JavaOOP.StudentSystem;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentName;
    private int studentAge;
    private double studentGrade;

    public Student(String name, int age, double grade) {
        this.studentName = name;
        this.studentAge = age;
        this.studentGrade = grade;
    }


    public String getStudentName() {
        return studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public double getStudentGrade() {
        return studentGrade;
    }
    public String getCommentary(Student student) {
        if(student.getStudentGrade() >= 5.00) {
            return "Excellent student";
        }else if (student.getStudentGrade() >= 3.50) {
            return "Avarage student";
        }else {
            return "Very nice person";
        }
    }

}
