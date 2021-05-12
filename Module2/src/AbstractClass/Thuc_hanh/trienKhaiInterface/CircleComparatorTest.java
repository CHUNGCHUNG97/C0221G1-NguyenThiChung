package AbstractClass.Thuc_hanh.trienKhaiInterface;

import KeThua.Thuc_hanh.doi_tuong_hinh_hoc.Circle;

import java.util.Arrays;
import java.util.Comparator;

public class CircleComparatorTest {

    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle();
        circles[1] = new Circle(4);
        circles[2] = new Circle("yellow", false, 3);
        for (Circle circle : circles
        ) {
            System.out.println(circle);

        }
        Comparator comparator = new CircleComparator();
        Arrays.sort(circles, comparator);
        System.out.println("After sort");
        for (Circle circle : circles
        ) {
            System.out.println(circle);
        }

    }
}
