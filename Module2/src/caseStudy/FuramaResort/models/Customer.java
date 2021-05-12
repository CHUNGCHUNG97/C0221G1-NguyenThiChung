package caseStudy.FuramaResort.models;

import caseStudy.FuramaResort.commons.Constants;

public class Customer implements Comparable<Customer> {
    private String hoTen;
    private String ngaySinh;
    private String gioiTinh;
    private String cmnd;
    private int sdt;
    private String email;
    private String loaiKhach;
    private String diaChi;
    private Services services;

    public Customer(String hoTen, String ngaySinh, String gioiTinh, String cmnd, int sdt, String email,
                    String loaiKhach, String diaChi, Services services) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.cmnd = cmnd;
        this.sdt = sdt;
        this.email = email;
        this.loaiKhach = loaiKhach;
        this.diaChi = diaChi;
        this.services = services;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    @Override
    public String toString() {
        String service;
        if (this.services == null) {
            service = "null";
        } else {
            service = this.services.toString();
        }
        return "Customer{" +
                "hoTen='" + hoTen + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", cmnd=" + cmnd +
                ", sdt=" + sdt +
                ", email='" + email + '\'' +
                ", loaiKhach='" + loaiKhach + '\'' +
                ", diaChi='" + diaChi + '\n' +
                ", services=" + service +
                '}';
    }

    public void showInfor() {
        System.out.println(this.toString());
    }

    public String toCSV() {
        String idService;
        if (this.services == null) {
            idService = "null";
        } else {
            idService = this.services.getId();
        }
        return "CUSTOMER" + Constants.COMMACustomer +
                this.hoTen + Constants.COMMACustomer +
                this.ngaySinh + Constants.COMMACustomer +
                this.gioiTinh + Constants.COMMACustomer +
                this.cmnd + Constants.COMMACustomer +
                this.sdt + Constants.COMMACustomer +
                this.email + Constants.COMMACustomer +
                this.loaiKhach + Constants.COMMACustomer +
                this.diaChi + Constants.COMMACustomer +
                idService;
    }

    @Override
    public int compareTo(Customer o) {
        return this.getHoTen().compareTo(o.getHoTen());
    }
}
