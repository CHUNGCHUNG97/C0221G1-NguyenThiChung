package transport.models;

import caseStudy.FuramaResort.commons.Constants;
import transport.comons.ContantsTransport;

public class Trucks extends Transports {
    double payload;

    public Trucks(String controlSign, String manufacturer, int yearManufacturer, String owner, double payload) {
        super(controlSign, manufacturer, yearManufacturer, owner);
        this.payload = payload;
    }

    @Override
    public String toCSV() {
        return "Truck" + ContantsTransport.COMMA +
                this.controlSign + ContantsTransport.COMMA +
                this.manufacturer + ContantsTransport.COMMA +
                this.yearManufacturer + ContantsTransport.COMMA +
                this.owner + ContantsTransport.COMMA +
                this.payload;
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
