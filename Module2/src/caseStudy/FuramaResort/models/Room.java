package caseStudy;

public class Phong extends FuramaResort {
    String dichVuMienPhiDiKem;

    public Phong() {
    }

    public Phong(String dichVuMienPhiDiKem) {
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }

    public Phong(String tenDichVu, String dienTichSuDung, String chiPhiThue, int soLuongNguoiToiDa, String kieuThue, String dichVuMienPhiDiKem) {
        super(tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue);
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }

    public String getDichVuMienPhiDiKem() {
        return dichVuMienPhiDiKem;
    }

    public void setDichVuMienPhiDiKem(String dichVuMienPhiDiKem) {
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }

    @Override
    public String toString() {
        return "Phong{" +
                "dichVuMienPhiDiKem='" + dichVuMienPhiDiKem + '\'' +
                '}';
    }
}
