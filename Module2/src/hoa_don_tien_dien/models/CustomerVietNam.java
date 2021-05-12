package hoa_don_tien_dien.models;

import hoa_don_tien_dien.comons.Constants;

public class CustomerVietNam extends Customer {
    public String typeCustomer;
    public double usedKW;

    public CustomerVietNam(String codeCustomer, String fullName, String typeCustomer, double usedKW) {
        super(codeCustomer, fullName);
        this.typeCustomer = typeCustomer;
        this.usedKW = usedKW;
    }

    @Override
    public String toCSV() {
        return "CustomerVietNam" + Constants.COMMA +
                this.idCustomer + Constants.COMMA +
                this.fullName + Constants.COMMA +
                this.typeCustomer + Constants.COMMA +
                this.usedKW;
    }

    @Override
    public String toString() {
        return "CustomerVietNam{" + super.toString() +
                ", typeCustomer='" + typeCustomer + '\'' +
                ", usedKW=" + usedKW + "}";
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public double getUsedKW() {
        return usedKW;
    }

    public void setUsedKW(double usedKW) {
        this.usedKW = usedKW;
    }
}
