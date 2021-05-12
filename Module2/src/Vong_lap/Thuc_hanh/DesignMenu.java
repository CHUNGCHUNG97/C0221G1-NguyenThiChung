package Vong_lap.Thuc_hanh;

import java.util.Scanner;

public class DesignMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("MENU\n" +
                    "1.Draw the triangle\n" +
                    "2.Draw the square\n" +
                    "3.Draw the rectangle\n" +
                    "4.Exit\n" +
                    "Enter your choice:");
            choice = scanner.nextInt();
            if (choice <= 0 || choice > 4) {
                System.out.println("lựa chọn của bạn không phù hợp,vui lòng chọn lại");
            }
        } while (choice <= 0 || choice > 4);
        switch (choice) {
            case 1:
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (j < 5 - i) {
                            System.out.print("*");
                        }
                    }
                    System.out.print("\n");
                }
                break;
            case 2:
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print("*");
                    }
                    System.out.print("\n");
                }
                break;
            case 3:
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (i==0 || i==4) {
                            System.out.print("*");
                        } else if (j==0 || j==4){
                            System.out.print("*");
                        }else {
                            System.out.print(" ");
                        }
                    }
                    System.out.print("\n");

                }
            default:
        }
    }
}

