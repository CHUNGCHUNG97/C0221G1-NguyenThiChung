package Array.Bai_tap;

import java.util.Scanner;

public class GiaTriLonNhatMang2Chieu {
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
        double max = arr[0][0];
       for (int x=0;x<arr.length;x++){
           for (int y = 0; y <arr[x].length ; y++) {
               if (arr[x][y]>=max){
                   max=arr[x][y];
               }
           }
       }
        System.out.println("Giá trị lớn nhất là : "+max);
    }
}
