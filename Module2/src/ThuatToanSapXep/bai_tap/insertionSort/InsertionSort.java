package ThuatToanSapXep.bai_tap.insertionSort;

public class InsertionSort {
    public static void insertionSort(int[] mangSoNguyen) {
        for (int i = 1; i < mangSoNguyen.length; i++) {
            int key = mangSoNguyen[i];
            int j = i - 1;
            while (j >= 0 && mangSoNguyen[j] > key) {
                mangSoNguyen[j + 1] = mangSoNguyen[j];
                j--;
            }
            mangSoNguyen[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] mangSoNguyen = {2, 6, 3, 2, 1};
        insertionSort(mangSoNguyen);
        for (int i = 0; i < mangSoNguyen.length; i++) {
            System.out.println(mangSoNguyen[i]);
        }

    }
}
