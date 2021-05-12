package Array.Thuc_hanh;

import java.util.Scanner;

public class DemSoLuongSinhVienThiDo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int soLuongSinhVien;
        do {
            System.out.println("Nhập số lượng sinh viên : ");
            soLuongSinhVien = sc.nextInt();
            if (soLuongSinhVien > 30) {
                System.out.println("số lượng sinh viên tối đa là 30");
            }
        } while (soLuongSinhVien > 30);
        double[] diem = new double[soLuongSinhVien];
        int count=0;

        for (int i = 0; i < diem.length; i++) {
            System.out.println("Nhập điểm của từng sinh viên thứ : "+i);
            diem[i] = sc.nextFloat();
           do {
               if (diem[i]<0){
                   System.out.println("điểm không được nhỏ hơn 0");
                   System.out.println("Nhập lại điểm của sinh viên thứ: "+i);
                   diem[i] = sc.nextFloat();
               }
           }while (diem[i]<0);

            if (diem[i]>=5){
                count++;
            }
        }
        System.out.println("số lượng sinh viên đỗ là: "+count);
    }
}
