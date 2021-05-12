package transport.controllers;

public class Trucks extends Transports {
    double payload;

    public Trucks(String controlSign, String manufacturer, int yearManufacturer, String owner, double payload) {
        super(controlSign, manufacturer, yearManufacturer, owner);
        this.payload = payload;
    }

    @Override
    public String toCSV() {
        return null;
    }

    @Override
    public String toString() {
        return "Trucks{" + super.toString() +
                "payload=" + payload +
                '}';
    }

    public double getPayload() {
        return payload;
    }

    public void setPayload(double payload) {
        this.payload = payload;
    }
}
