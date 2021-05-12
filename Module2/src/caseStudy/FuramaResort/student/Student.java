package caseStudy.FuramaResort.student;

public class Student extends People {
    private String className;

    public Student(String id, int age, String name) {
        super(id, age, name);
    }

    public Student(String id, int age, String name, String className) {
        super(id, age, name);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public void showInfo() {
        System.out.println("Student");
    }

    @Override
    public String toCSV() {
        return "STUDENT~" + this.id + "~" + this.name + "~" + this.age + "~" + this.className;
    }
}
