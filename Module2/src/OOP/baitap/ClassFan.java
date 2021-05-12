package OOP.baitap;

public class ClassFan {
    final int slow = 1;
    final int medium = 2;
    final int fast = 3;
    private int speed = slow;
    boolean onFan = false;
    private double radius = 5.0;
    private String color = "blue";

    public ClassFan(int speed, boolean onFan, double radius, String color) {
        this.speed = speed;
        this.onFan = onFan;
        this.radius = radius;
        this.color = color;
    }


    public ClassFan() {

    }

    public void setOnFan(boolean onFan) {
        this.onFan = onFan;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isOnFan() {
        return onFan;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }
    public void fan(boolean status,int speed,double radius,String color){
        status=this.onFan;
        speed=this.speed;
        radius=this.radius;
        color=this.color;

    }

    @Override
    public String toString() {
        return "ClassFan{" +
                "speed=" + speed +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
