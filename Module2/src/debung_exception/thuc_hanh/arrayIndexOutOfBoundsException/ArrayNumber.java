package debung_exception.thuc_hanh.arrayIndexOutOfBoundsException;

import java.util.Random;
import java.util.Scanner;

public class ArrayNumber {
    public static void main(String[] args) {
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(100);
        }
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("nhập index : ");
                int index = scanner.nextInt();
                System.out.println("Giá trị phần tử tương ứng với chỉ số index " + index + " là: " + arr[index]);
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("chỉ số vượt quá danh sách");
            }
        }
        System.out.println("success!!");
    }
}
