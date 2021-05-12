package AbstractClass.colorable;

import AbstractClass.bai_tap.Resizeable.Resizeable;

public class Square extends Shape implements Colorable {
    private double a;
    private String color;
    public Square() {
    }

    public Square(double a, String color) {
        this.a = a;
        this.color = color;
    }

    public Square(double a) {
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    @Override
    double getArea() {
        return a * a;
    }

    @Override
    double Perimeter() {
        return 4 * a;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides : " + color);
    }
}
