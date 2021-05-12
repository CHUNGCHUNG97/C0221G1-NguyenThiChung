package Vong_lap.Bai_tap;

import java.util.Scanner;

public class HienThiSNTDauTien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập số lượng số nguyên tố đầu tiên cần hiển thị");
        int soLuong = scanner.nextInt();
        int count = 0;
        int x = 2;
        while (count < soLuong) {
            boolean isSNT = true;
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) {
                    isSNT = false;
                    break;
                }
            }
            if (isSNT == true) {
                System.out.println(x);
                count++;
            }
            x++;
        }

    }
}
