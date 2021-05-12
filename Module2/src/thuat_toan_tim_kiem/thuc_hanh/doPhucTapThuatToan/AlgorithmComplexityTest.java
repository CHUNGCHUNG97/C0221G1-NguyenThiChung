package thuat_toan_tim_kiem.thuc_hanh.doPhucTapThuatToan;

import java.util.*;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a string: ");
        String str = scanner.nextLine();
        int[] frequentChar = new int[255];
        ArrayList<Character> kyTu = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            int viTri = str.charAt(i);
            frequentChar[viTri] += 1;
            if (!kyTu.contains(str.charAt(i))) {
                kyTu.add(str.charAt(i));
            }
            System.out.println(frequentChar[viTri]);
        }
        System.out.println(kyTu);
//        Map<Integer, Character> kyTu = new HashMap<>();
//        for (int i = 0; i < str.length(); i++) {
//            if (!kyTu.containsValue(str.charAt(i))) {
//                kyTu.put(i, str.charAt(i));
//
//            }
//        }

        int max = 0;
        int character = 255;

        for (int i = 0; i < 255; i++) {
            if (frequentChar[i] >= max) {
                max = frequentChar[i];
                character = i;
            }
        }
//        int dem = 0;
//        for (int i = 0; i < kyTu.size(); i++) {
//            for (int j = 0; j < str.length(); j++) {
//                if (kyTu.get(i) == str.charAt(j)) {
//                    dem++;
//                }
//                if (dem==max){
//                    character=i;
//                    System.out.println(character);
//                }
//            }
//        }

        System.out.println("max: " + max);
        System.out.println("vị trí: " + character);

    }
}
