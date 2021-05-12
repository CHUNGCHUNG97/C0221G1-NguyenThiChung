package transport.comons;

import AccessModifier.Thuc_hanh.Car.Car;
import transport.models.Cars;
import transport.models.Motorbikes;
import transport.models.Trucks;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static final String fileMotorbike = "F:\\codegym\\C0221G1-NguyenThiChung\\Module2\\src\\transport\\data\\xeMay.csv";

    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;

    public static List<String> readFile(String file) throws FileNotFoundException {
        try {
            List<String> stringList = new ArrayList<>();
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
            return stringList;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static List<Motorbikes> loadMotorBike(String file) throws IOException {
        List<Motorbikes> motorbikes = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //parrt line thanh motor
                Motorbikes newMotor = parseMotor(line);
                //add motor list
                motorbikes.add(newMotor);
            }

        } catch (Exception e) {
            return null;

        }
        bufferedReader.close();
        return motorbikes;
    }

    public static List<Cars> loadCar(String file) throws IOException {
        List<Cars> cars = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //parrt line thanh motor
                Cars newCar = parseCar(line);
                //add motor list
                cars.add(newCar);
            }

        } catch (Exception e) {
            return null;

        }
        bufferedReader.close();
        return cars;
    }

    public static List<Trucks> loadTruck(String file) throws IOException {
        List<Trucks> trucks = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //parrt line thanh motor
                Trucks newTruck = parseTruck(line);
                //add motor list
                trucks.add(newTruck);
            }

        } catch (Exception e) {
            return null;

        }
        bufferedReader.close();
        return trucks;
    }

    private static Trucks parseTruck(String line) {
        String[] str = line.split(ContantsTransport.COMMA);
        String controlSign = str[1];
        String manufacturer = str[2];
        int yearManufacturer = Integer.parseInt(str[3]);
        String owner = str[4];
        double payload = Double.parseDouble(str[5]);
        Trucks truck = new Trucks(controlSign, manufacturer, yearManufacturer, owner, payload);
        return truck;
    }

    private static Cars parseCar(String line) {
        String[] str = line.split(ContantsTransport.COMMA);
        String controlSign = str[1];
        String manufacturer = str[2];
        int yearManufacturer = Integer.parseInt(str[3]);
        String owner = str[4];
        int numberSeat = Integer.parseInt(str[5]);
        String typeCar = str[6];
        Cars car = new Cars(controlSign, manufacturer, yearManufacturer, owner, numberSeat, typeCar);
        return car;
    }

    private static Motorbikes parseMotor(String line) {
        Motorbikes motor = null;
        String[] str = line.split(ContantsTransport.COMMA);
        String controlSign = str[1];
        String manufacturer = str[2];
        int yearManufacturer = Integer.parseInt(str[3]);
        String owner = str[4];
        int wattage = Integer.parseInt(str[5]);
        motor = new Motorbikes(controlSign, manufacturer, yearManufacturer, owner, wattage);
        return motor;
    }


    public static void writeFile(String string, String file, boolean append) {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, append));
            bufferedWriter.write(string);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
