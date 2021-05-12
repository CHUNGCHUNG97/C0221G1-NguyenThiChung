package collectionFramework.thuc_hanh.comparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestComparable_Comparator {
    public static void main(String[] args) {
        Student student1 = new Student("hien", 24, "le duan");
        Student student2 = new Student("thach", 27, "nguyen tat thanh");
        Student student3 = new Student("chung", 27, "hoang van thai");
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        Collections.sort(students);
        for (Student student : students
        ) {
            System.out.println(student.toString());
        }
        Student_comparator student = new Student_comparator();
        Collections.sort(students, student);
        for (Student student_comparator : students) {
            System.out.println(student_comparator);
        }
    }
}
