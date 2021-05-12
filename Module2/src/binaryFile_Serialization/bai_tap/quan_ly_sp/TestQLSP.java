package binaryFile_Serialization.bai_tap.quan_ly_sp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestQLSP {
    public static void main(String[] args) throws IOException {
        QuanLySanPham quanLySanPham = new QuanLySanPham();
        quanLySanPham.loadFile();
        quanLySanPham.select();

    }
}
