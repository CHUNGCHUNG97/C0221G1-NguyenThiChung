package KeThua.Thuc_hanh.doi_tuong_hinh_hoc;


class Square extends Rectangle {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(String color, boolean filled, double width, double length) {
        super(color, filled, width, length);
    }

    public double getSide() {
        return this.getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public String toString() {
        return "Square{ side= " +getSide()+
                ", which is a subclass of"+super.toString()+
                "}";
    }
}
