package Vong_lap.Bai_tap;

import java.util.Scanner;

public class HienThiSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        int x = 2;
        while (x < 100) {
            boolean isSNT = true;
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) {
                    isSNT = false;
                    break;
                }
            }
            if (isSNT == true) {
                System.out.println(x);
            }
            x++;
        }

    }
}
