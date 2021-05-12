package AccessModifier.Thuc_hanh.Car;

public class Car {
    private String name;
    private String engine;
    public static int numberOfCar;


    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOfCar++;
    }


}
