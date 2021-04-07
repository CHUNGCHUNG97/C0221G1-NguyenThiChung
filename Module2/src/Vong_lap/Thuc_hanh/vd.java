package Vong_lap.Thuc_hanh;

public class vd {
    static public void  main(String[] args) {
        int[] a = {50, 100};
        m(a);
        System.out.println(a[0]);
    }

    static void m(int[] x) {
        x[0] = 200;
    }
}
