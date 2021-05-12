package AccessModifier.Thuc_hanh.Car;

public class TestCar {
    public static void main(String[] args) {
        Car car1 = new Car("Audi", "V7");
        System.out.println(Car.numberOfCar);
        Car car2 = new Car("Mec", "V3");
        System.out.println(Car.numberOfCar);
    }
}
