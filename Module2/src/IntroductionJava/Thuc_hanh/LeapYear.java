package IntroductionJava.Thuc_hanh;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        int year;
        boolean isLeapYear = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập năm cần kiểm tra");
        year = scanner.nextInt();
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeapYear = true;
                }
            }else {
                isLeapYear=true;
            }
        }
        if (isLeapYear==true){
            System.out.printf("%d is Leap Year",year);
        }else {
            System.out.printf("%d is not Leap Year",year);
        }
    }
}
