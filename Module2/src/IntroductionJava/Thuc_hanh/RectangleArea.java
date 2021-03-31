package IntroductionJava.Thuc_hanh;

import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        float height;
        float width;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chiều cao: ");
        height = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập chiều rộng: ");
        width = Float.parseFloat(scanner.nextLine());
        float area = height * width;
        System.out.println("Diện tích hình chữ nhật là : " + area);
    }
}
