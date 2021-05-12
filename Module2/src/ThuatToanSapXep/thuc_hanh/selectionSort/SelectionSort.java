package ThuatToanSapXep.thuc_hanh.selectionSort;

public class SelectionSort {
    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            double min = list[i];
            int indexMin = i;
            for (int j = i + 1; j < list.length ; j++) {
                if (min > list[j]) {
                    min = list[j];
                    indexMin = j;
                }
            }
            if (indexMin != i) {
                list[indexMin] = list[i];
                list[i] = min;
            }
        }
        System.out.println("sau khi sắp xếp: ");
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    public static void main(String[] args) {
        double[] list = {4,6,5,18,1,3};
        System.out.println("trước khi sắp xếp: ");
        for (int i = 0; i <list.length ; i++) {
            System.out.println(list[i]);
        }
        selectionSort(list);
    }
}
