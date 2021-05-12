package Vong_lap.Thuc_hanh;

import java.util.Scanner;

public class KiemTraSoNguyenTo {
    public static void main(String[] args) {
        boolean check = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số cần kiểm tra");
        int soNT = scanner.nextInt();
        if (soNT < 2) {
            check = false;
        } else if (soNT == 2) {
            check = true;
        } else {
            for (int i = 2; i < Math.sqrt(soNT); i++) {
                if (soNT % i == 0) {
                    check = false;
                    break;
                }
            }
        }
        if (check == true) {
            System.out.println("số " + soNT + " là số nguyên tố");
        } else {
            System.out.println("số " + soNT + " không phải số nguyên tố");
        }
    }

}
