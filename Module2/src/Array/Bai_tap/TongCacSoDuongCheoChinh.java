package Array.Bai_tap;

import java.util.Scanner;

public class TongCacSoDuongCheoChinh {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập các phần tử của mảng: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    total += arr[i][j];
                    break;
                }
            }
        }
        System.out.println("Tổng đường chéo của mảng là: " + total);
    }
}
