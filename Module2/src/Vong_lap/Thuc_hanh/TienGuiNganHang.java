package Vong_lap.Thuc_hanh;

import java.util.Scanner;

public class TienGuiNganHang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập số tiền muốn gửi");
        double tienGui = Float.parseFloat(scanner.nextLine());
        System.out.println("nhập lãi suất gửi ngân hàng: ");
        double laiSuat = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập số tháng gửi: ");
        int soThangGui = scanner.nextInt();
        double tienLai = 0;
        for (int i=0;i<soThangGui;i++){
            tienLai=tienGui*(laiSuat/100/12)*soThangGui;
        }
        System.out.println(tienLai);
    }

}
