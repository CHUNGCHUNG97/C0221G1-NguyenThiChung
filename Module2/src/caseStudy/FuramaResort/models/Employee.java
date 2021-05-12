package caseStudy.FuramaResort.models;

public class Employee {
    String name;
    String age;
    String adress;

    public Employee(String name, String age, String adress) {
        this.name = name;
        this.age = age;
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", adress='" + adress + '\'' +
                '}';
    }
}
