package AbstractClass.colorable;


public class Rectangle extends Shape {
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
    double getArea() {
        return height * width;
    }

    @Override
    double Perimeter() {
        return 2 * (height + width);
    }


}
