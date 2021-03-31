package IntroductionJava.Bai_tap;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        double rate = 23000;
        double usd;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập usd cần chuyển đổi: ");
        usd = Float.parseFloat(scanner.nextLine());
        double vnd = usd * rate;
        System.out.println("số tiền sau khi chuyển đổi là: " + vnd + " VNĐ");
    }
}
