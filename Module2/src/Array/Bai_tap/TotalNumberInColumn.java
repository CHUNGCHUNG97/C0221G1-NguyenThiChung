package Array.Bai_tap;

import java.util.Scanner;

public class TotalNumberInColumn {
    public static void main(String[] args) {
        int[][] arr = new int[2][3];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập các phần tử của mảng: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Nhập cột cần tính tổng");
        int cot=scanner.nextInt();
        int total=0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                if (cot==j){
                    total+=arr[i][j];
                    break;
                }
            }
        }
        System.out.println(total);
    }
}
