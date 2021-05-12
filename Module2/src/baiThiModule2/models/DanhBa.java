package baiThiModule2.models;

import baiThiModule2.comons.ConstantDanhBa;

public class DanhBa {
    String sđt;
    String nhomDanhBa;
    String hoTen;
    String gioiTinh;
    String diaChi;
    String ngaySinh;
    String email;

    public DanhBa(String sđt, String nhomDanhBa, String hoTen, String gioiTinh, String diaChi, String ngaySinh, String email) {
        this.sđt = sđt;
        this.nhomDanhBa = nhomDanhBa;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.email = email;
    }

    @Override
    public String toString() {
        return "DanhBa{" +
                "sđt=" + sđt +
                ", nhomDanhBa='" + nhomDanhBa + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String toCSV() {
        return "DanhBa" + ConstantDanhBa.COMMA +
                this.sđt + ConstantDanhBa.COMMA +
                this.nhomDanhBa + ConstantDanhBa.COMMA +
                this.hoTen + ConstantDanhBa.COMMA +
                this.gioiTinh + ConstantDanhBa.COMMA +
                this.diaChi + ConstantDanhBa.COMMA +
                this.ngaySinh + ConstantDanhBa.COMMA +
                this.email;
    }

    public String getSđt() {
        return sđt;
    }

    public void setSđt(String sđt) {
        this.sđt = sđt;
    }

    public String getNhomDanhBa() {
        return nhomDanhBa;
    }

    public void setNhomDanhBa(String nhomDanhBa) {
        this.nhomDanhBa = nhomDanhBa;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
