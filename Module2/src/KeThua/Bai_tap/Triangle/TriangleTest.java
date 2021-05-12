package KeThua.Bai_tap.Triangle;

import KeThua.Thuc_hanh.doi_tuong_hinh_hoc.Shape;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn muốn tạo hình màu gì?");
        String color = scanner.nextLine();
        System.out.println("Bạn muốn fill đối tượng?");
        String fill = scanner.nextLine();
        boolean isFill = fill.equals("yes") ? true : false;
        Shape shape = new Shape(color, isFill);
        Triangle triangle = new Triangle();
        System.out.println(triangle);
    }

}
