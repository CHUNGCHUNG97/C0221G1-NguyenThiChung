package baiThiModule2.comons;

import baiThiModule2.models.DanhBa;
import hoa_don_tien_dien.models.Bills;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static BufferedWriter bufferedWriter;
    private static BufferedReader bufferedReader;

    public static void writeFile(String string, String file, boolean append) {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, append));
            bufferedWriter.write(string);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<DanhBa> readDanhBa(String file) {
        List<DanhBa> danhBaList = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                danhBaList.add(ParseDanhBa(line));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return danhBaList;
    }

    private static DanhBa ParseDanhBa(String line) {
        try {
            String[] str = line.split(ConstantDanhBa.COMMA);
            String sdt = str[1];
            String nhomDanhBa = str[2];
            String hoTen = str[3];
            String gioiTinh = str[4];
            String diaChi = str[5];
            String ngaySinh = str[6];
            String email = str[7];
            return new DanhBa(sdt, nhomDanhBa, hoTen, gioiTinh, diaChi, ngaySinh, email);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

}
