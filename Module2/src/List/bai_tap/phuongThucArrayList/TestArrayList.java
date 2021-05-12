package List.bai_tap.phuongThucArrayList;

import java.util.Arrays;

public class TestArrayList {
    public static void main(String[] args) {
        MyList<String> myList = new MyList();
        myList.add(0, "thach");
        myList.add(1, "phu");
        myList.add(3, "c");
        MyList<String> cloneList = myList.clone();


        myList.clear();
        System.out.println(Arrays.toString(myList.getElement()));

    }
}
