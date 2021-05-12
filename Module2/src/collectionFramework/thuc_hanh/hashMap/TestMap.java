package collectionFramework.thuc_hanh.hashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("chung", 24);
        hashMap.put("thach", 27);
        hashMap.put("phu", 28);
        System.out.println(hashMap);
        TreeMap<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println(treeMap);
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(treeMap);
        linkedHashMap.put("hien",20);
        System.out.println(linkedHashMap);
    }

}
