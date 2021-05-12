package hoa_don_tien_dien.models;

import hoa_don_tien_dien.comons.Constants;

public class Bills {
    int idBill;
    String idCustomer;
    String billDate;
    double KW;
    double price;
    double intoMoney;

    public Bills(int idBill, String idCustomer, String billDate, double KW, double price, double intoMoney) {
        this.idBill = idBill;
        this.idCustomer = idCustomer;
        this.billDate = billDate;
        this.KW = KW;
        this.price = price;
        this.intoMoney = intoMoney;
    }

    @Override
    public String toString() {
        return "Bills{" +
                "idBill=" + idBill +
                ", idCustomer='" + idCustomer + '\'' +
                ", billDate='" + billDate + '\'' +
                ", KW=" + KW +
                ", price=" + price +
                ", intoMoney=" + intoMoney +
                '}';
    }

    public String toCSV() {
        return "Bill" + Constants.COMMA +
                this.idBill + Constants.COMMA +
                this.idCustomer + Constants.COMMA +
                this.billDate + Constants.COMMA +
                this.KW + Constants.COMMA +
                this.price + Constants.COMMA +
                this.intoMoney;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public double getKW() {
        return KW;
    }

    public void setKW(double KW) {
        this.KW = KW;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getIntoMoney() {
        return intoMoney;
    }

    public void setIntoMoney(double intoMoney) {
        this.intoMoney = intoMoney;
    }
}
