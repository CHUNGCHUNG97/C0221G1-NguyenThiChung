package transport.models;

import transport.comons.ContantsTransport;

public class Motorbikes extends Transports {
    int wattage;

    public Motorbikes(String controlSign, String manufacturer, int yearManufacturer, String owner, int wattage) {
        super(controlSign, manufacturer, yearManufacturer, owner);
        this.wattage = wattage;
    }

    @Override
    public String toCSV() {
        return "Motorbike" + ContantsTransport.COMMA +
                this.controlSign + ContantsTransport.COMMA +
                this.manufacturer + ContantsTransport.COMMA +
                this.yearManufacturer + ContantsTransport.COMMA +
                this.owner + ContantsTransport.COMMA +
                this.wattage;
    }

    @Override
    public String toString() {
        return "Motorbikes{" + super.toString() +
                "wattage=" + wattage +
                '}';
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }
}
