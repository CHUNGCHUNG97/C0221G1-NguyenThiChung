package caseStudy.FuramaResort.models;

import caseStudy.FuramaResort.commons.Constants;

public class House extends Services {
    private String tieuChuanPhong;
    private String moTaTienNghiKhac;
    private int soTang;

    public House() {
    }

    public House(String id, String tenDichVu, double dienTichSuDung, double chiPhiThue, int soLuongNguoiToiDa, String kieuThue, String tieuChuanPhong, String moTaTienNghiKhac, int soTang) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.soTang = soTang;
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "House{" + super.toString() +
                "tieuChuanPhong='" + tieuChuanPhong + '\'' +
                ", moTaTienNghiKhac='" + moTaTienNghiKhac + '\'' +
                ", soTang=" + soTang + '\'' +
                '}';
    }

    @Override
    public String toCSV() {
        return "HOUSE" + Constants.COMMA + this.id + Constants.COMMA +
                this.tenDichVu + Constants.COMMA +
                this.tieuChuanPhong + Constants.COMMA +
                this.kieuThue + Constants.COMMA +
                this.dienTichSuDung + Constants.COMMA +
                this.chiPhiThue + Constants.COMMA +
                this.soTang + Constants.COMMA +
                this.moTaTienNghiKhac + Constants.COMMA
                + this.soLuongNguoiToiDa;
    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public String getMoTaTienNghiKhac() {
        return moTaTienNghiKhac;
    }

    public void setMoTaTienNghiKhac(String moTaTienNghiKhac) {
        this.moTaTienNghiKhac = moTaTienNghiKhac;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }
}
