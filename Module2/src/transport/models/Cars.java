package transport.models;

import transport.comons.ContantsTransport;

public class Cars extends Transports {
    int numberSeat;
    String typeCar;

    public Cars(String controlSign, String manufacturer, int yearManufacturer, String owner, int numberSeat, String typeCar) {
        super(controlSign, manufacturer, yearManufacturer, owner);
        this.numberSeat = numberSeat;
        this.typeCar = typeCar;
    }

    @Override
    public String toCSV() {
        return "Car" + ContantsTransport.COMMA +
                this.controlSign + ContantsTransport.COMMA +
                this.manufacturer + ContantsTransport.COMMA +
                this.yearManufacturer + ContantsTransport.COMMA +
                this.owner + ContantsTransport.COMMA +
                this.numberSeat + ContantsTransport.COMMA +
                this.typeCar;
    }

    @Override
    public String toString() {
        return "Cars{" + super.toString() +
                "numberSeat=" + numberSeat +
                ", typeCar='" + typeCar + '\'' +
                '}';
    }

    public int getNumberSeat() {
        return numberSeat;
    }

    public void setNumberSeat(int numberSeat) {
        this.numberSeat = numberSeat;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }
}
