package Array.Bai_tap;

import java.util.Scanner;

public class RemoveElementArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size:");
        int size = scanner.nextInt();
        int[] array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.println("Number want remove:");
        int numberRemove = scanner.nextInt();
        boolean isFound = false;
        for (int j = 0; j < array.length; j++) {
            if (numberRemove == array[j]) {
                isFound = true;
                array[j]=array[j+1];
                array[array.length-1]=0;
            }
        }
        if (isFound == true) {
            for (int x : array) {

                System.out.println(x);
            }
        }else {
            System.out.println("không có số cần xóa trong mảng");
        }
    }
}
