package hoa_don_tien_dien.models;

public abstract class Customer {
    protected String idCustomer;
    protected String fullName;

    public Customer(String codeCustomer, String fullName) {
        this.idCustomer = codeCustomer;
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "idCustomer='" + idCustomer + '\'' +
                ", fullName='" + fullName;
    }

    public abstract String toCSV();

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
