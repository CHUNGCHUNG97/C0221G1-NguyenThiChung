package OOAD_SOLID.bai_tap.classDiagram;

import java.util.ArrayList;
import java.util.List;

public class ClassDiagram {

    //        public static List<Integer> oddNumbers() {
//        List<Integer> arr = new ArrayList<>();
//        for (int i = 1; i <= 10; i++) {
//            if (i % 2 != 0) {
//                arr.add(i);
//            }
//        }
//     return arr;
//    }
    public static int[] noNeg(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = 0;
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {2, 6, 8, 5};
        noNeg(arr);

    }
}
