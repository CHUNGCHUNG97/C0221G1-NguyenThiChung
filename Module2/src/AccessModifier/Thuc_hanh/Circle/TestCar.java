package AccessModifier.Thuc_hanh.Circle;

import AccessModifier.Thuc_hanh.Car.Car;

public class TestCar {
    public static void main(String[] args) {
       Circle circle=new Circle();
        System.out.println(circle.getArea());
        circle.setRadius(2);
        System.out.println(circle.getArea());
    }
}
