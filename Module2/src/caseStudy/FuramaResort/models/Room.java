package caseStudy.FuramaResort.models;

import caseStudy.FuramaResort.commons.Constants;

import java.util.ArrayList;
import java.util.List;

public class Room extends Services {
    private DichVuMienPhiDiKem dichVuMienPhiDiKem;

    public Room(String id, String tenDichVu, double dienTichSuDung, double chiPhiThue, int soLuongNguoiToiDa, String kieuThue, DichVuMienPhiDiKem dichVuMienPhiDiKem) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue);
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }


    @Override
    public String toString() {
        return "Room{" + super.toString() + dichVuMienPhiDiKem
                + "}";
    }

    @Override
    public String toCSV() {
        return "ROOM" + Constants.COMMA + this.id + Constants.COMMA +
                this.tenDichVu + Constants.COMMA +
                this.kieuThue + Constants.COMMA +
                this.dienTichSuDung + Constants.COMMA +
                this.chiPhiThue + Constants.COMMA +
                this.soLuongNguoiToiDa + Constants.COMMA +
                this.dichVuMienPhiDiKem.toCSV();
    }

    public DichVuMienPhiDiKem getDichVuMienPhiDiKem() {
        return dichVuMienPhiDiKem;
    }

    public void setDichVuMienPhiDiKem(DichVuMienPhiDiKem dichVuMienPhiDiKem) {
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }
}
