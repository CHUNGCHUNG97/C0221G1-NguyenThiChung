package thuat_toan_tim_kiem.bai_tap.timChuoiLienTiep;

import java.util.LinkedList;
import java.util.Scanner;

public class ChuoiLientiep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = scanner.nextLine();
        LinkedList<Character> list = new LinkedList<>();
        LinkedList<Character> max = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            if (list.size() > 1 && str.charAt(i) <= list.getLast() || list.contains(str.charAt(i))) {
                list.clear();

            }
                list.add(str.charAt(i));

            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
        }
        for (Character ch : max) { // single loop
            System.out.print(ch); // Simple statement
        }
        System.out.println();
    }
}
