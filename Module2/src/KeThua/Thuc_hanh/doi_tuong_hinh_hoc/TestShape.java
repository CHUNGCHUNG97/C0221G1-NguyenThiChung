package KeThua.Thuc_hanh.doi_tuong_hinh_hoc;

import AccessModifier.Thuc_hanh.Circle.Circle;

public class TestShape {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape.toString());
        Shape shape1 = new Shape("red", false);
        System.out.println(shape1.toString());

    }
}
