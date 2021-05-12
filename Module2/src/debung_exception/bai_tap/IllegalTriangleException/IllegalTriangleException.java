package debung_exception.bai_tap.IllegalTriangleException;

import org.omg.CORBA.DynAnyPackage.InvalidValue;

import java.util.InputMismatchException;
import java.util.Scanner;

class TestIllegalTriangleException1 {
    public static void validate(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0 || (a + b) <= c || (b + c) <= a || (a + c) <= b) {
            throw new IllegalArgumentException("không đúng độ dài cạnh");
        }
    }

    public static void main(String[] args) {

        double a, b, c;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("nhập cạnh a: ");
                a = Float.parseFloat(scanner.nextLine());
                System.out.println("nhập cạnh b: ");
                b = Float.parseFloat(scanner.nextLine());
                System.out.println("nhập cạnh c: ");
                c = Float.parseFloat(scanner.nextLine());
                validate(a, b, c);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("độ dài cạnh tam giác không phù hợp");
                System.out.println("hãy nhập lại: ");
            }
        }
        System.out.println("độ dài 3 cạnh phù hợp");

    }
}
