package AbstractClass.bai_tap.Resizeable;

public class Square extends Shape implements Resizeable {
    private double a;

    public Square() {
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
    public void resize(double precent) {
        a = a * (1 + precent / 100);
    }

    @Override
    public double getArea() {
        return a * a;
    }

    @Override
    public double Perimeter() {
        return 4 * a;
    }
}
