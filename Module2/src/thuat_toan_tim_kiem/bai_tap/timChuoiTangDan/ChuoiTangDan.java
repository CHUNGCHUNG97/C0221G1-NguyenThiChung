package thuat_toan_tim_kiem.bai_tap.timChuoiTangDan;

import java.util.LinkedList;

public class ChuoiTangDan {
    public static void main(String[] args) {
        String str = "OKPBanQJmK";
        LinkedList<Character> list = new LinkedList<>();
        list.add(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) >list.getLast()) {
                list.add(str.charAt(i ));
            }
        }
        System.out.println(list);
    }


}
