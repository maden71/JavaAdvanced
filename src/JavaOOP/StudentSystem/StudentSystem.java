package JavaOOP.StudentSystem;

import java.util.ArrayList;
import java.util.List;

public class StudentSystem {
    List<Student> students = new ArrayList<>();
    String[] commentary = {"Very nice person","Average student","Excellent student"};

    public void create(String name, int age, double grade) {
        Student student = new Student(name,age,grade);
        students.add(student);
    }
    public String show(String name)  {
        String[] commentary = {"Very nice person","Average student","Excellent student"};
        for (Student student : students) {
            if(student.getStudentName().equals(name)) {
                return String.format("%s is %d years old. %s.",student.getStudentName(),student.getStudentAge(),student.getCommentary(student));
            }
        }
        return "";
    }
}
