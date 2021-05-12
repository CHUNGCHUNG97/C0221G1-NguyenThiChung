package Vong_lap.Bai_tap;

import java.util.Scanner;

public class HienThiHinh {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("height");
        int height=scanner.nextInt();
        System.out.println("width");
        int width=scanner.nextInt();
        for (int i = 0; i < height; i++) {
           for (int j=0;j<width;j++){
               System.out.print("*");
           }
            System.out.print("\n");
        }
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                if (j<=i){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++){

                if (j>=width-i-1){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }
}
