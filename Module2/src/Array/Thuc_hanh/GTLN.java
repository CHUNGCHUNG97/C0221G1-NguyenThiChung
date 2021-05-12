package Array.Thuc_hanh;

import java.util.Scanner;

public class GTLN {
    public static void main(String[] args) {
        int[] arr=new int[5];
        Scanner scanner=new Scanner(System.in);
        int i = 0;
        while (i < arr.length) {
            System.out.print("Enter element" + (i + 1) + " : ");
            arr[i] = scanner.nextInt();
            i++;
        }
        int max=arr[0];
        for (int j = 0; j <arr.length ; j++) {
            if (max<=arr[j]){
                max=arr[j];
            }
        }
        System.out.println("max is: "+max);
    }
}
