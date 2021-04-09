package AbstractClass.Thuc_hanh.comparable;

import KeThua.Thuc_hanh.doi_tuong_hinh_hoc.Circle;


public class Comparable extends Circle implements java.lang.Comparable<Comparable> {
    public Comparable() {
    }

    public Comparable(double radius) {
        super(radius);
    }

    public Comparable(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }

    @Override
    public int compareTo(Comparable o) {
        if (getRadius() > o.getRadius())
            return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return 1;
    }
}
