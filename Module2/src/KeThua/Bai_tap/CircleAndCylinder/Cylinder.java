package KeThua.Bai_tap.CircleAndCylinder;

class Cylinder extends Circle {
    private double height = 2;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getRadius() {
        return super.getRadius();
    }

    protected double volume() {
        return this.height * Math.PI * this.getRadius();
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                ", Volume " + volume() +
                ", of class " + super.toString() +
                '}';
    }
}
