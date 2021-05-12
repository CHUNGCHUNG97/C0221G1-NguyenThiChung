package thuat_toan_tim_kiem.thuc_hanh.timKiemNhiPhanKhongDeQuy;

public class BinarySearch {


    public static int binarySearch(int[] list, int key) {
        int left = 0;
        int right = list.length - 1;
        while (right > left) {
            int mid = (left + right) / 2;
            if (key < list[mid]) {
                right = right - 1;
            } else if (key == list[mid]) {
                return mid;
            } else {
                left = left + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        System.out.println(binarySearch(list,5));
    }
}
