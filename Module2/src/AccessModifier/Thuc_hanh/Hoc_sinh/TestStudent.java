package AccessModifier.Thuc_hanh.Hoc_sinh;

public class TestStudent {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Chung");
        Student student2 = new Student(2, "Thach");
        Student.change();
        student1.display();
        student2.display();
    }
}
