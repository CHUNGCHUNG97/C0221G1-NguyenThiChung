package AbstractClass.Thuc_hanh.comparable;

import KeThua.Thuc_hanh.doi_tuong_hinh_hoc.Circle;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;

class ComparableCircleTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(5);
        circles[1] = new Circle();
        circles[2] = new Circle("green", false, 2);
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}
