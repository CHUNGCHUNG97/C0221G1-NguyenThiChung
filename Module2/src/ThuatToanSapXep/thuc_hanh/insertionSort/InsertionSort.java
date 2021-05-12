package ThuatToanSapXep.thuc_hanh.insertionSort;

public class InsertionSort {
    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            int j = i - 1;
            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] list = {5, 3, 8, 100};
        insertionSort(list);
        System.out.println("sau khi sort: ");
        for (int i = 0; i <list.length ; i++) {
            System.out.println(list[i]);
        }

    }
}
