package Array.Thuc_hanh;

import java.util.Scanner;

public class ChuyenDoiNhietDo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Chuyển đổi nhiệt độ\n" +
                    "1.Độ C sang độ F \n" +
                    "2.Độ F sang độ C\n" +
                    "3.exit\n" +
                    "Nhập lựa chọn của bạn:");
            choice = scanner.nextInt();
            if (choice < 1 || choice > 3) {
                System.out.println("nội dung bạn chọn không phù hợp,vui lòng chọn lại:");
            }
        } while (choice < 1 || choice > 3);
        double doC;
        double doF;
        switch (choice) {
            case 1:
                System.out.println("Nhập độ C cần chuyển sang độ F");
                doC = scanner.nextFloat();
                doF = (9.0 / 5.0) * doC + 32;
                System.out.println(doC + " độ C bằng " + doF + " độ F");
                break;
            case 2:
                System.out.println("Nhập độ F cần chuyển sang độ C");
                doF = scanner.nextFloat();
                doC = (5.0 / 9.0) * (doF - 32);
                System.out.println(doF + " độ C bằng " + doC + " độ F");
                break;
            case 3:
                return;
            default:
        }

    }
}
