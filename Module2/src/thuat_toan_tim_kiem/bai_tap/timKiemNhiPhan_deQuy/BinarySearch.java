package thuat_toan_tim_kiem.bai_tap.timKiemNhiPhan_deQuy;

public class BinarySearch {
    static int binarySearch(int[] arr, int left, int right, int temp) {
        if (right >= left) {
            int mid = ((right - 1) + left) / 2;
            if (temp > arr[mid]) {
                return binarySearch(arr, mid + 1, right, temp);
            } else if (temp == arr[mid]) {
                return mid;
            } else {
                return binarySearch(arr, left, mid - 1, temp);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 10, 40};
        int temp = 10;
        int result = binarySearch(arr, 0, arr.length - 1, temp);
        if (result == -1)
            System.out.println("Không tìm thấy phần tử " + temp);
        else
            System.out.println("Phần tử " + temp + " được tìm thấy tại chỉ số " +
                    result);
    }
}
