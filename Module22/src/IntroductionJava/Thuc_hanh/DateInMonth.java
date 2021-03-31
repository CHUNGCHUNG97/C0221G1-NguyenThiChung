import java.util.Scanner;

public class DateInMonth {
    public static void main(String[] args) {
        int month;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tháng muốn kiểm tra");
        month = scanner.nextInt();
        switch (month) {
            case 2:
                System.out.println("tháng " + month + " có 28 hoặc 29 ngày");
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng " + month + " có 31 ngày");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("tháng " + month + " có 30 ngày");
            default:
                System.out.println("tháng không phù hợp");
        }
    }

}
