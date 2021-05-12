package Array.Bai_tap;

import java.util.Scanner;

public class AddElementArray {
    public static void main(String[] args) {
        int[] array = new int[10];
        array[0] = 2;
        array[1] = 5;
        array[3] = 6;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số muốn chèn vào: ");
        int soMuonChen = scanner.nextInt();
        int viTri;
        do {
            System.out.println("Nhập vị trí muốn chèn vào trong mảng");
            viTri = scanner.nextInt();
            if (viTri <= 1 || viTri >= array.length - 1) {
                System.out.println("không được chèn vào vị trí này trong mảng");
            }
        } while (viTri <= 1 || viTri >= array.length - 1);
        for (int i = 0; i < array.length; i++) {
            if (viTri == i) {
                array[i + 1] = array[i];
                array[i] = soMuonChen;

            }
        }
        for (int x : array) {
            System.out.print(x+" ");
        }
    }
}
