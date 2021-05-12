package AccessModifier.Thuc_hanh.Hoc_sinh;

public class Student {
    private int rollno;
    private String name;
    private static String college = "Codegym";

    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    static void change() {
        college = "CodegymDaNang";
    }

    void display() {
        System.out.println(rollno + ": " + name + ": " + college);
    }
}
