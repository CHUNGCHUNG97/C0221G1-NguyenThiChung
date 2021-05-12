package caseStudy.FuramaResort.models;

import caseStudy.FuramaResort.commons.Constants;

public class DichVuMienPhiDiKem {
    private String tenDichVuDiKem;
    private int donVi;
    private double giaTien;

    public DichVuMienPhiDiKem(String tenDichVuDiKem, int donVi, double giaTien) {
        this.tenDichVuDiKem = tenDichVuDiKem;
        this.donVi = donVi;
        this.giaTien = giaTien;
    }

    public String getTenDichVuDiKem() {
        return tenDichVuDiKem;
    }

    public void setTenDichVuDiKem(String tenDichVuDiKem) {
        this.tenDichVuDiKem = tenDichVuDiKem;
    }

    public int getDonVi() {
        return donVi;
    }

    public void setDonVi(int donVi) {
        this.donVi = donVi;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    @Override
    public String toString() {
        return "DichVuMienPhiDiKem{" +
                "tenDichVuDiKem='" + tenDichVuDiKem + '\'' +
                ", donVi='" + donVi + '\'' +
                ", giaTien=" + giaTien +
                '}';
    }

    public String toCSV() {
        return "DICHVUMIENPHI" + Constants.COMMAdichVu +
                this.tenDichVuDiKem + Constants.COMMAdichVu +
                this.donVi + Constants.COMMAdichVu +
                this.giaTien;
    }

}
