package ThuatToanSapXep.thuc_hanh.bubbleSort;

import java.util.Scanner;

public class BubbleSort {
    public static void bubbleSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            for (int j = 0; j < list.length - i; j++) {
                if (list[j] >= list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so luong phan tu: ");
        int size = scanner.nextInt();

        do {
            if (size <= 0) {
                System.out.println("mảng có số lượng phần tử không hợp lệ");
                System.out.println("nhập lại số lượng phần tử");
                size = scanner.nextInt();
            }

        } while (size <= 0);
        int[] listSoNguyen = new int[size];
        System.out.println("nhập từng phần tử vào mảng: ");
        for (int i = 0; i < listSoNguyen.length; i++) {
            System.out.println("phần tử thứ " + (i + 1) + " là: ");
            listSoNguyen[i] = scanner.nextInt();
        }
        System.out.println("trước khi sắp xếp");
        for (int i = 0; i < listSoNguyen.length; i++) {
            System.out.println(listSoNguyen[i]);
        }
        System.out.println("sau khi sắp xếp");
        bubbleSort(listSoNguyen);

    }
}
