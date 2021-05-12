package transport.controllers;

public abstract class Transports {
    protected String controlSign;
    protected String manufacturer;
    protected int yearManufacturer;
    protected String owner;

    public Transports(String controlSign, String manufacturer, int yearManufacturer, String owner) {
        this.controlSign = controlSign;
        this.manufacturer = manufacturer;
        this.yearManufacturer = yearManufacturer;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Transports{" +
                "controlSign='" + controlSign + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearManufacturer=" + yearManufacturer +
                ", owner='" + owner + '\'' +
                '}';
    }

    public abstract String toCSV();

    public String getControlSign() {
        return controlSign;
    }

    public void setControlSign(String controlSign) {
        this.controlSign = controlSign;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearManufacturer() {
        return yearManufacturer;
    }

    public void setYearManufacturer(int yearManufacturer) {
        this.yearManufacturer = yearManufacturer;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
