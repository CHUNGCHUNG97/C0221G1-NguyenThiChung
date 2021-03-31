package IntroductionJava.Thuc_hanh;

import java.util.Scanner;

public class LinearEquationSolver {
    public static void main(String[] args) {
        float a;
        float b;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số a: ");
        a = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập số b: ");
        b = Float.parseFloat(scanner.nextLine());
        if (a != 0) {
            double x = -b / a;
            System.out.println("Phương trình bậc nhất có nghiệm là : " + x);
        } else {
            if (b == 0) {
                System.out.println("Phương trình có vô số nghiệm");
            } else {
                System.out.println("Phương trình vô nghiệm");
            }
        }

    }
}
