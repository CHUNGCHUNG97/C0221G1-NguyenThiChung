package Array.Bai_tap;

import java.util.Scanner;

public class GiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        double[][] arr = new double[n][m];
        int i = 0;
        while (i < arr.length) {
            for (int j = 0; j <arr[i].length ; j++) {
                arr[i][j] = sc.nextFloat();
            }
            i++;
        }
        double min = arr[0][0];
        for (int x=0;x<arr.length;x++){
            for (int y = 0; y <arr[x].length ; y++) {
                if (arr[x][y]<=min){
                    min=arr[x][y];
                }
            }
        }
        System.out.println("Giá trị nhỏ nhất là : "+min);
    }
}
