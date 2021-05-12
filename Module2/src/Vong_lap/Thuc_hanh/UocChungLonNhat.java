package Vong_lap.Thuc_hanh;

import java.util.Scanner;

public class UocChungLonNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số a: ");
        int a = scanner.nextInt();
        System.out.println("Nhập số b: ");
        int b = scanner.nextInt();
        if (a == 0 && b == 0) {
            System.out.println("không có UCLN giữa " + a + " và " + b);
        } else if (a != 0 && b == 0) {
            System.out.println("UCLN của " + a + " và " + b + " là " + Math.abs(a));
        } else if (a == 0 && b != 0) {
            System.out.println("UCLN của " + a + " và " + b + " là " + Math.abs(b));
        } else if (a != 0 && b != 0 && Math.abs(a) > Math.abs(b)) {
            for (int i = Math.abs(a) / 2; i > 0; i--) {
                if (a % i == 0 && b % i == 0) {
                    System.out.println("UCLN của " + a + " và " + b + " là: " + i);
                    break;
                }
            }
        } else {
            for (int i = Math.abs(b) / 2; i > 0; i--) {
                if (a % i == 0 && b % i == 0) {
                    System.out.println("UCLN của " + a + " và " + b + " là: " + i);
                    break;
                }
            }
        }
    }
}
