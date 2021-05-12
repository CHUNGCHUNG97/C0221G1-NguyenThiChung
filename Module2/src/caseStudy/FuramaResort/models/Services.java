package caseStudy.FuramaResort.models;

public abstract class Services {
    protected String id;
    protected String tenDichVu;
    protected double dienTichSuDung;
    protected double chiPhiThue;
    protected int soLuongNguoiToiDa;
    protected String kieuThue;

    public Services() {
    }

    public Services(String id, String tenDichVu, double dienTichSuDung, double chiPhiThue, int soLuongNguoiToiDa, String kieuThue) {
        this.id = id;
        this.tenDichVu = tenDichVu;
        this.dienTichSuDung = dienTichSuDung;
        this.chiPhiThue = chiPhiThue;
        this.soLuongNguoiToiDa = soLuongNguoiToiDa;
        this.kieuThue = kieuThue;
    }

    @Override
    public String toString() {
        return
                "id='" + id +
                        ", tenDichVu='" + tenDichVu +
                        ", dienTichSuDung=" + dienTichSuDung +
                        ", chiPhiThue=" + chiPhiThue +
                        ", soLuongNguoiToiDa=" + soLuongNguoiToiDa +
                        ", kieuThue='" + kieuThue + ",";
    }


    public abstract String toCSV();

    public abstract void showInfor();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public double getDienTichSuDung() {
        return dienTichSuDung;
    }

    public void setDienTichSuDung(double dienTichSuDung) {
        this.dienTichSuDung = dienTichSuDung;
    }

    public double getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(double chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public int getSoLuongNguoiToiDa() {
        return soLuongNguoiToiDa;
    }

    public void setSoLuongNguoiToiDa(int soLuongNguoiToiDa) {
        this.soLuongNguoiToiDa = soLuongNguoiToiDa;
    }

    public String getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(String kieuThue) {
        this.kieuThue = kieuThue;
    }
}
