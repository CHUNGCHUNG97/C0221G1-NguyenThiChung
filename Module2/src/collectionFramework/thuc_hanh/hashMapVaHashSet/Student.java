package collectionFramework.thuc_hanh.hashMapVaHashSet;

import java.util.*;

public class Student {
    private String name;
    private int age;
    private String address;

    public Student() {
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return
                " name='" + name + '\'' +
                        ", age=" + age +
                        ", address='" + address + '\'' +
                        '}';
    }

    public static void main(String[] args) {
        Student student1 = new Student("hien", 24, "le duan");
        Student student2 = new Student("thach", 27, "nguyen tat thanh");
        Student student3 = new Student("chung", 27, "hoang van thai");
        HashMap<Integer, Student> studentList = new HashMap<>();
        studentList.put(1, student1);
        studentList.put(2, student2);
        studentList.put(3, student3);
//        Set set = studentList.entrySet();
//        Iterator i = set.iterator();
//        while (i.hasNext()) {
//            Map.Entry me = (Map.Entry) i.next();
//            System.out.println(me.toString());
//        }
        for (Map.Entry<Integer, Student> student : studentList.entrySet()
        ) {
            System.out.println(student.toString());
        }
        HashSet<Student> setStudent = new HashSet<Student>();
        Student student4 = new Student("phu", 28, "NLB");
        setStudent.add(student1);
        setStudent.add(student4);
        setStudent.add(student4);
        System.out.println(setStudent.size());
        for (Student studentSetted : setStudent
        ) {
            System.out.println(studentSetted.toString());
        }
    }
}
