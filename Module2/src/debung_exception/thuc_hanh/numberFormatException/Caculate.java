package debung_exception.thuc_hanh.numberFormatException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Caculate {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {

                System.out.println("nhập số thứ nhất: ");
                int x = scanner.nextInt();
                System.out.println("nhập số thứ hai: ");
                int y = scanner.nextInt();
                int total = x + y;
                int subtraction = x - y;
                int division = x / y;
                int multiplication = x * y;
                System.out.println("total = " + total + ", subtraction= " + subtraction
                        + ", division= " + division + ", multiplication= " + multiplication);
                break;
            } catch (ArithmeticException e) {
                System.out.println("phép chia mẫu số không được bằng 0" + e.getMessage());
                System.out.println("hãy nhập lại");
            }catch (InputMismatchException m){
                System.out.println("Nhập số không hợp lệ");
                System.out.println("hãy nhập lại");
            }
        }
        System.out.println("success!!");
    }
}
