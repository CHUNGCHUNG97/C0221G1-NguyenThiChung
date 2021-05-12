package binaryFile_Serialization.bai_tap.quan_ly_sp;


import java.io.*;
import java.util.List;


public class Product implements Serializable {
    private String maSP;
    private String name;
    private String hangSX;
    private double gia;

    public Product() {
    }

    public Product(String maSP, String name, String hangSX, double gia) {
        this.maSP = maSP;
        this.name = name;
        this.hangSX = hangSX;
        this.gia = gia;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHangSX() {
        return hangSX;
    }

    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }


    @Override
    public String toString() {
        return "Product{" +
                "maSP='" + maSP + '\'' +
                ", name='" + name + '\'' +
                ", hangSX='" + hangSX + '\'' +
                ", gia=" + gia + "VNĐ" +
                '}';
    }
}
