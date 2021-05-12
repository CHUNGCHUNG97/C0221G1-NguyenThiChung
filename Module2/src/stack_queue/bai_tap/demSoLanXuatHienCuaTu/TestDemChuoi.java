package stack_queue.bai_tap.demSoLanXuatHienCuaTu;

import java.util.TreeMap;

public class TestDemChuoi {
    public static void main(String[] args) {
        String str = "jafhjjaldk sjdha";
        TreeMap<Character, Integer> stringTreeMap = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (stringTreeMap.containsKey(str.charAt(i))) {
                stringTreeMap.put(str.charAt(i), stringTreeMap.get(str.charAt(i)) + 1);
            } else {
                stringTreeMap.put(str.charAt(i),1);
            }
        }
        System.out.println(stringTreeMap);
    }
}
