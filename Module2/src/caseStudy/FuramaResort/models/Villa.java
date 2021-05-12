package caseStudy.FuramaResort.models;

import caseStudy.FuramaResort.commons.Constants;

public class Villa extends Services {
    private String tieuChuanPhong;
    private String moTaTienNghiKhac;
    private double dienTichHoBoi;
    private int soTang;

    public Villa() {
    }

    public Villa(String id, String tenDichVu, double dienTichSuDung, double chiPhiThue, int soLuongNguoiToiDa, String kieuThue, String tieuChuanPhong, String moTaTienNghiKhac, double dienTichHoBoi, int soTang) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());

    }

    @Override
    public String toString() {
        return "Villa{" + super.toString() +
                "tieuChuanPhong='" + tieuChuanPhong + '\'' +
                ", moTaTienNghiKhac='" + moTaTienNghiKhac + '\'' +
                ", dienTichHoBoi=" + dienTichHoBoi + '\'' +
                ", soTang=" + soTang + '\'' +
                '}';
    }


    @Override
    public String toCSV() {
        return "VILLA" + Constants.COMMA + this.id + Constants.COMMA +
                this.tenDichVu + Constants.COMMA +
                this.tieuChuanPhong + Constants.COMMA +
                this.kieuThue + Constants.COMMA +
                this.dienTichSuDung + Constants.COMMA +
                this.dienTichHoBoi + Constants.COMMA +
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

    public double getDienTichHoBoi() {
        return dienTichHoBoi;
    }

    public void setDienTichHoBoi(double dienTichHoBoi) {
        this.dienTichHoBoi = dienTichHoBoi;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }
}
