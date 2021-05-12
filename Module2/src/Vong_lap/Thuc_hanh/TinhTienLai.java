package Vong_lap.Thuc_hanh;

import java.util.Scanner;

public class TinhTienLai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tiền cho vay: ");
        double soTienVay = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập lãi suất cho vay theo tháng: ");
        double laiSuatThang = Float.parseFloat(scanner.nextLine()) / 100;
        System.out.println("Nhập số tháng vay: ");
        int soThangvay = scanner.nextInt();
        double tienLai = 0;
        for (int i = 0; i < soThangvay; i++) {
            tienLai += soTienVay * (laiSuatThang / 12) * soThangvay;
        }
        System.out.println("tiền lãi ngân hàng là : " + tienLai + " VNĐ");
    }

}
