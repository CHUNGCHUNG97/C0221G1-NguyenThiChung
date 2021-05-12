package AbstractClass.bai_tap.Resizeable;

public class Rectangle extends Shape implements Resizeable {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double heght) {
        this.height = heght;
    }

    @Override
    public void resize(double precent) {
        height = height * (1 + precent / 100);
        width = width * (1 + precent / 100);

    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public double Perimeter() {
        return 2 * (height + width);
    }
}
