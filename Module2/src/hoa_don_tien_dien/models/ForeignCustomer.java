package hoa_don_tien_dien.models;

import hoa_don_tien_dien.comons.Constants;

public class ForeignCustomer extends Customer {
    private String country;

    public ForeignCustomer(String codeCustomer, String fullName, String country) {
        super(codeCustomer, fullName);
        this.country = country;
    }

    @Override
    public String toString() {
        return "ForeignCustomer{" +
                "codeCustomer='" + idCustomer + '\'' +
                ", fullName='" + fullName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public String toCSV() {
        return "ForeignCustomer" + Constants.COMMA +
                this.idCustomer + Constants.COMMA +
                this.fullName + Constants.COMMA +
                this.country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
