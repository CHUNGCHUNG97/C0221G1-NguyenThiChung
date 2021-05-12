package Array.Thuc_hanh;

public class GTNN_UsePhuongThuc {
    public static int minValue(int[] arr){
        int min=arr[0];
        int index=0;
        for (int i = 0; i <arr.length ; i++) {
            if (min>=arr[i]){
                min=arr[i];
                index=i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9};
        int index = minValue(arr);
        System.out.println("The smallest element in the array is: " + arr[index]);
    }
}
