package Array.Bai_tap;

import java.util.Scanner;

public class DemSoKyTuTrongChuoi {
    public static void main(String[] args) {

        dem("absifjkahsnc");

    }

    public static void dem(String str) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ký tự cần đếm");
        String kyTu = sc.next();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (kyTu.equals(String.valueOf(str.charAt(i)))) {
                count++;
            }
        }

        System.out.println(count);

    }
}
